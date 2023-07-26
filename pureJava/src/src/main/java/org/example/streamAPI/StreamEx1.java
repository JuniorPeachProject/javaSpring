package org.example.streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String[] args) {
        // 중복을 제거하고(distinct) 홀수만을 골라낸다(filter)
        IntStream streamFilter = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        streamFilter.distinct().filter(n -> n % 2 != 0).forEach(System.out::println);
        // 7 5 1 3

        // 배열의 각 요소를 변환하여 다시 하나로 합쳐 새로운 스트림으로 반환 (map)
        Stream<String> streamMap = Stream.of("Int", "Double", "Long");
        streamMap.map(s -> s.concat("Stream")).forEach(System.out::println);
        // IntStream DoubleStream LongStream

        // 여러 문자열이 저장된 배열을 각 문자열에 포함된 단어로 이루어진 스트림으로 변환후 반환(flatMap)
        // flatMap의 매개변수 타입을 보면 Stream타입인것을 명심하자.
        String[] arr = {"I study hard", "You study JAVA", "I am hungry"};
        Stream<String> streamFlatmap = Arrays.stream(arr);
        streamFlatmap.flatMap(s -> Stream.of(s.split(" "))).forEach(System.out::println);
        // I study hard You study JAVA I am hungry

        // 첫번째 요소부터 3개를 제외하고 (skip) 첫 번째 요소부터 5개의 요소만으로 이루어진 (limit) 스트림 반환
        IntStream streamLimit = IntStream.range(0, 10); // 0 1 2 3 4 5 6 7 8 9
        streamLimit.skip(3).limit(5).forEach(n -> System.out.print(n + " "));
        // 3 4 5 6 7

        // 오름차순과 내림차순 정렬 (sort)
        Stream<String> streamSort1 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");
        Stream<String> streamSort2 = Stream.of("JAVA", "HTML", "JAVASCRIPT", "CSS");

        streamSort1.sorted().forEach(s -> System.out.print(s + " ")); // CSS HTML JAVA JAVASCRIPT
        streamSort2.sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));
        // JAVASCRIPT JAVA HTML CSS

        // 연산과 연산 사이의 결과 확인 (peek)
        IntStream streamPeek = IntStream.of(7, 5, 5, 2, 1, 2, 3, 5, 4, 6);
        streamPeek.peek(s -> System.out.println("원본 스트림 : " + s))
                .skip(2)
                .peek(s -> System.out.println("skip(2) 실행 후 : " + s))
                .sorted()
                .peek(s -> System.out.println("sorted() 실행 후 : " + s))
                .forEach(System.out::println);
    }
}
