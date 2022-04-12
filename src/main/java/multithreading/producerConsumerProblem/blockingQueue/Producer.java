package multithreading.producerConsumerProblem.blockingQueue;


import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue<String> queue;

    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1024; i++) {
                queue.put("Java" + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
