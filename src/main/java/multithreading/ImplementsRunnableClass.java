package multithreading;

// if you do not extend the thread class, then your class is not treated as a thread object
// hence, you need to explicitly create a thread class object and pass your class object through it
public class ImplementsRunnableClass implements Runnable{

    // the method gets executed in the calling thread
    // no new thread gets created
    @Override
    public void run() {
        System.out.println();
    }

    public static void main(String[] args) {
        // runnable instance needs to be passes to thread instance for thread to be started
        Thread t=new Thread(new MyThread());
        t.start();

    }

    static class MyThread implements Runnable{

        @Override
        public void run() {
            System.out.println("Thread is running");
        }
    }
}
