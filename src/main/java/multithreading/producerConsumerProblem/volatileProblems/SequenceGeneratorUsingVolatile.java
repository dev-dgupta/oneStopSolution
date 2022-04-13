package multithreading.producerConsumerProblem.volatileProblems;

public class SequenceGeneratorUsingVolatile {

    private static volatile int number = 1;

    public static void main(String[] args) {

        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
        new Thread(new Thread3()).start();
    }

    static class Thread1 implements Runnable {

        @Override
        public void run() {
            while (number < 10) {
                if (number % 3 == 1) {
                    System.out.println(number);
                    number += 1;
                }
            }
        }
    }

    static class Thread2 implements Runnable {

        @Override
        public void run() {
            while (number < 10) {
                if (number % 3 == 2) {
                    System.out.println(number);
                    number += 1;
                }
            }
        }
    }

    static class Thread3 implements Runnable {

        @Override
        public void run() {
            while (number < 10) {
                if (number % 3 == 0) {
                    System.out.println(number);
                    number += 1;
                }
            }
        }
    }
}
