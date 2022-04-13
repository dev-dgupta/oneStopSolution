package java8.traditional;

import java8.ConcatenateStr;
import java8.IncrementByFive;
import java8.Message;

public class TraditionalExample implements ConcatenateStr, IncrementByFive, Message {
    @Override
    public String concat(String str, String str1) {
        return str + " " + str1;
    }

    @Override
    public int increment(int a) {
        return a + 5;
    }

    public static void main(String[] args) {
        TraditionalExample traditionalExample = new TraditionalExample();
        System.out.println(traditionalExample.concat("Hello", "World"));
        System.out.println(traditionalExample.increment(5));
        System.out.println(traditionalExample.print());
    }

    @Override
    public String print() {
        return "Hello world";
    }
}
