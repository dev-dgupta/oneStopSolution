package multithreading;

public class ExtendsThreadClass {

    // should be used only when you need to override the default methods like
    // setPriority, getName, etc
    // all methods are executed in the calling thread
    // only start() creates a new thread with separate lifecycle
    // here, currently 2 threads will be running, only thread class start() method creates new thread
    static class MyThread extends Thread {

        Thread thread;

        public MyThread(String name) {
            this.thread = new Thread(name);
            thread.start();
        }

        @Override
        public void run() {
            System.out.println("A new thread is running::" + thread.getName());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        // starts a thread in the calling thread
        MyThread newThread = new MyThread("java");
        // a new thread gets started in main method
        //newThread.start();
        Thread.sleep(1000);
        System.out.println("Main thread is running:");
    }

}
