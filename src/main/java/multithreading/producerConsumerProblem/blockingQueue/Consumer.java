package multithreading.producerConsumerProblem.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            for (int i = 0; i < queue.size(); i++) {
                System.out.println(queue.take());
            }
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }
}
