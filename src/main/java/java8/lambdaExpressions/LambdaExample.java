package java8.lambdaExpressions;


// reduces the lines of code
public class LambdaExample {

    public static void main(String[] args) {

        ConcatenateStr concatenateStr = (a, b) -> a + " " + b;
        IncrementByFive incrementByFive = (x) -> x + 5;
        Message msg = () -> "Hello world";

        System.out.println(concatenateStr.concat("Hello", "World"));
        System.out.println(incrementByFive.increment(2));
        System.out.println(msg.print());
    }
}
