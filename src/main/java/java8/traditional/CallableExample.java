package java8.traditional;

import java.util.*;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class CallableExample {

    // creates an array of integers from 1 to 40
    public static int[] arr = IntStream.rangeClosed(1, 40).toArray();
    // used only for verifying the result later
    public static int total = IntStream.rangeClosed(1, 40).sum();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Callable callable1 = () -> {
            int sum = 0;
            for (int i = 0; i < arr.length / 2; i++) {
                sum = sum + arr[i];
            }
            return sum;
        };
        Callable callable2 = () -> {
            int sum = 0;
            for (int i = arr.length / 2; i < arr.length; i++) {
                sum = sum + arr[i];
            }
            return sum;
        };


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Callable<Integer>> taskList = Arrays.asList(callable1, callable2);
        List<Future<Integer>> results = executorService.invokeAll(taskList);

        int k = 0, sum = 0;
        for (Future<Integer> result : results) {
            sum = sum + result.get();
            System.out.println("Sum of " + ++k + " is: " + result.get());
        }

        System.out.println("Sum from the Callable is: " + sum);
        System.out.println("Correct sum: " + total);
    }


}
