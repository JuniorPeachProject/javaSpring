package wad.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Component
public class Calculator {
    public int add(int a, int b) {
        List<Integer> list = List.of(a, b);
        log.info("a = " + a);
        log.info("b = " + b);
        return list.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}

