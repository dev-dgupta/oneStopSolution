package multithreading.producerConsumerProblem.volatileProblems;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VolatileKeyword {

    private static final Logger LOGGER = Logger.getAnonymousLogger();
    private static volatile int CURR_VAL = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {

        public void run() {
            int localVal = CURR_VAL;
            while (localVal < 5) {
                if (localVal != CURR_VAL) {
                    LOGGER.log(Level.INFO, "Got change for volatile var: " + CURR_VAL);
                    localVal = CURR_VAL;
                }
            }
        }

    }

    // every time the thread changeMaker makes any change to volatile variable
    // CURR_VAL, the changes is listened by ChangeListener
    static class ChangeMaker extends Thread {
        public void run() {

            int localVal = CURR_VAL;
            while (CURR_VAL < 5) {
                CURR_VAL = ++localVal;
                LOGGER.log(Level.INFO, "Incremented the CURR_VAL: " + CURR_VAL);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
