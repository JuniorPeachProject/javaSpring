package org.example.streamAPI;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 3, 2, 1);
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);

        // Collection 인터페이스를 가지진 않지만 컬렉션 프레임워크 번외로 사용 예제 추가
        // stream api를 활용한 map 출력
        Map<String, Integer> map = new HashMap<>();
        map.put("mine", 50);
        map.put("mine-it", 100);
        map.put("mine-it-record", 200);

        map.entrySet().stream()
                .filter(e -> e.getKey().contains("it"))
                .filter(e -> e.getValue() > 150)
                .forEach(e -> System.out.println(e.getKey() + " : " + e.getValue()));

        //가변 매개변수.
        Stream<Double> stream3 = Stream.of(4.2, 2.5, 3.1, 1.9);
        stream3.forEach(System.out::println);

        IntStream intStream = IntStream.range(1, 10);
        intStream.forEach(System.out::println);
        System.out.println();

        IntStream closedIntStream = IntStream.rangeClosed(1, 10);
        closedIntStream.forEach(e -> System.out.print(e + " "));
        System.out.println();

        IntStream intstrm = new Random().ints(5);
        intstrm.forEach(System.out::println);

        // 홀수만 출력하는 무한 스트림.
        //Stream<Integer> integerStream = Stream.iterate(2, n -> n + 2);
//        integerStream.forEach(System.out::println);
    }
    int plus(int x, int y) {
        return x+y;
    }

//    (int x, int y) -> {return x+y;}
//
//    (int x, int y) -> x+y
//
//            (x, y) -> x+y
}
