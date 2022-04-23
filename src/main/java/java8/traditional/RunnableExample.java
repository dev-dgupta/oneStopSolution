package java8.traditional;

public class RunnableExample {

    public static void main(String[] args) {

        // traditional way
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i < 10; i++)
                    sum += i;
                System.out.println("Traditional: " + sum);
            }
        };

        new Thread(runnable).start();

        //lambda way
        Runnable runnable1 = () -> {
            int sum = 0;
            for (int i = 1; i < 10; i++)
                sum += i;
            System.out.println("Lambda: " + sum);
        };

        new Thread(runnable1).start();

        // another way
        new Thread(() -> {
            int sum = 0;
            for (int i = 1; i < 10; i++)
                sum += i;
            System.out.println("Lambda1: " + sum);
        }).start();

    }
}
