package multithreading.producerConsumerProblem.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

    public static void main(String[] args) {
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}
