package org.example.streamAPI;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void main(String[] args) {
        // 각 요소를 소모하여 명시된 동작을 수행한다. (forEach)
        IntStream streamEach = IntStream.of(1, 2, 4, 3);
        streamEach.forEach(System.out::println);
        // 1 2 4 3

        // 첫번째와 두번째 요소를 가지고 연산 후 세번째 네번째 등 연속으로 수행 (reduce)
        Stream<String> streamReduce1 = Stream.of("넷", "둘", "셋", "하나");
        Optional<String> reduce1 = streamReduce1.reduce((s1, s2) -> s1 + "! " + s2);
        reduce1.ifPresent(System.out::println);
        // 넷! 둘! 셋! 하나

        // reduce의 연산 수행에 초깃값 부여
        Stream<String> streamReduce2 = Stream.of("넷", "둘", "셋", "하나");
        String reduce2 = streamReduce2.reduce("시작", (s1, s2) -> s1 + "! " + s2);
        System.out.println(reduce2);
        // 시작! 넷! 둘! 셋! 하나

        // 모든 요소를 정렬한 후 첫 번째에 위치한 요소를 출력 (findFirst)
        // 여기서 findAny()를 써도 동일한 결과가 나오나
        // findAny() 메서드는 병렬 스트림인 경우에 사용해야만 정확한 연산 결과를 반환한다.
        IntStream streamFind = IntStream.of(4, 2, 7, 3, 5, 1, 6);
        OptionalInt findResult = streamFind.sorted().findFirst();
        // OptionalInt findResult = streamFind.sorted().findAny();
        System.out.println(findResult.getAsInt());
        // 1

        // 특정 요소를 만족하거나 만족하지 못하거나 (anyMatch, allMatch, noneMatch)
        IntStream streamMatch = IntStream.of(30, 90, 70, 10);
        System.out.println(streamMatch.anyMatch(n -> n > 80)); // true
        // System.out.println(streamMatch.allMatch(n -> n > 80)); // false
        // System.out.println(streamMatch.noneMatch(n -> n > 90)); // true

        // 요소의 통계를 뽑아낸다. (개수 : count / 최댓값 : max / 최솟값 : min)
        IntStream streamStat = IntStream.of(30, 90, 70, 10);
        System.out.println(streamStat.count()); // 4
        // System.out.println(streamStat.max().getAsInt()); // 90
        // System.out.println(streamStat.min().getAsInt()); // 10

        // 요소의 합을 구한다. (sum)
        IntStream streamSum = IntStream.of(30, 90, 70, 10);
        System.out.println(streamSum.sum()); // 200

        // 요소의 평균을 구한다. (average)
        DoubleStream streamAvg = DoubleStream.of(30.3, 90.9, 70.7, 10.1);
        System.out.println(streamAvg.average().getAsDouble()); // 50.5

        // 스트림을 리스트로 수집한다. (collect)
        Stream<String> stream = Stream.of("넷", "둘", "하나", "셋");
        List<String> list = stream.collect(Collectors.toList());
        Iterator<String> iter = list.iterator();
        while(iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
    }
}
