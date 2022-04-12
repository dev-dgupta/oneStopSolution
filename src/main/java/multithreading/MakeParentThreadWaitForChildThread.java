package multithreading;

public class MakeParentThreadWaitForChildThread {

    static class ChildThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("child thread executing.." + i);
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ChildThread childThread = new ChildThread();
        Thread t1 = new Thread(childThread);

        for (int i = 0; i < 300; i++) {
            if(i==100) {
                t1.start();
                // parent thread waits for the child thread
                // calling thread should call the join method to make the main thread wait
                t1.join();
            }
            System.out.println("Main executing" + i);
        }




    }

}
