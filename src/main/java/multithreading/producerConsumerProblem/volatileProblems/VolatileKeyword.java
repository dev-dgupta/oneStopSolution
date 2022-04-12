package multithreading.producerConsumerProblem.volatileProblems;

public class VolatileKeyword {

    static class Message implements Runnable{
        volatile String msg;

        public Message(String msg) {
            this.msg = msg;
        }

        @Override
        public void run() {
            printMsg();
        }

        public void printMsg(){
            for(int i=0;i<msg.length();i++){
                System.out.println(msg.charAt(i));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Message m1=new Message("Welcome");
        Message m2=new Message("Java");

        Thread t1=new Thread(m1);
        Thread t2=new Thread(m2);
        t1.start();
        t2.start();

    }

}
