package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    public int id;
    public String name;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();

    }
}
