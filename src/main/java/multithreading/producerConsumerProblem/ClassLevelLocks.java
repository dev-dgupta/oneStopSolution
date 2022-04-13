package multithreading.producerConsumerProblem;

public class ClassLevelLocks {

    static class Message implements Runnable {

        final String msg;

        public Message(String msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            printMsg();
        }

        // for synchronization we can add synchronized keyword
        // but that would only make the calling object synchronized and not the object we are working on.
        // so, it cannot stop 2 different threads to enter the different method at the same time
        // here the two objects have their own set of methods
/*        synchronized public void printMsg() {
            for (int i = 0; i < msg.length(); i++) {
                System.out.print(msg.charAt(i));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/

        // for synchronization we can add synchronized keyword
        // but that would only make the calling object synchronized and not the object we are working on.
        public void printMsg() {
            // here the two objects have their own set of methods and msg variable
            // to synchronize that the two threads run one after the another, we can take up CLass level
            // locking instead of locking on the msg (String) object
            // since the object is different for both the threads
            // but the method they need to access is in the same class
            synchronized (Message.class) {
                for (int i = 0; i < msg.length(); i++) {
                    System.out.print(msg.charAt(i));
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Message m1 = new Message("Welcome");
        Message m2 = new Message("Java");

        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);
        // by default threads are asynchronous in nature
        // so they can print the msg in any way
        t1.start();
        t2.start();

    }


}
