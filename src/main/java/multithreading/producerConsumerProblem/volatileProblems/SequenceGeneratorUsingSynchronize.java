package multithreading.producerConsumerProblem.volatileProblems;
/*
 * You have 3 threads.
 *
 * You need to print 10 integers in sequence using 3 threads
 *
 * T1-->1
 * T2-->2
 * T3-->3
 * T1-->4
 * T2-->5
 * T3-->6
 * T1-->7
 * T2-->8
 * T3-->9
 * T1-->10
 *
 *
 * */
public class SequenceGeneratorUsingSynchronize {

    private static int threadIdToRun = 1;
    private static final Object object = new Object();
    private static int number = 1;
    public static void main(String[] args) {

        Thread t1 = new Thread(new Print(1));
        Thread t2 = new Thread(new Print(2));
        Thread t3 = new Thread(new Print(3));

        t1.start();
        t2.start();
        t3.start();

    }

    static class Print implements Runnable {

        private final int threadId;

        public Print(int threadId) {
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (number != 10) {
                synchronized (object) {
                    if (threadId != threadIdToRun) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        switch (threadId) {
                            case 1 -> {
                                System.out.println("T" + threadId + ": " + number);
                                threadIdToRun = 2;
                                number += 1;
                            }
                            case 2 -> {
                                System.out.println("T" + threadId + ": " + number);
                                threadIdToRun = 3;
                                number += 1;
                            }
                            case 3 -> {
                                System.out.println("T" + threadId + ": " + number);
                                threadIdToRun = 1;
                                number += 1;
                            }
                        }

                        object.notifyAll();
                    }

                }
            }
        }
    }

}
