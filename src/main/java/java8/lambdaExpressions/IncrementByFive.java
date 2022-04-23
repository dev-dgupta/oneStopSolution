package java8.lambdaExpressions;


// interfaces with only 1 abstract method
// any number of default methods can be there
@FunctionalInterface
public interface IncrementByFive {

    int increment(int a);

}
