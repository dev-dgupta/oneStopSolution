package designPatterns.state.abuse;

public class StopWatch {
    //had we planned a state pattern here, then it would be unnecessary addition of lots of code,
    // when we already know that the to funtionality of stop watch is to either start or stop
    private boolean isRunning;

    public void click() {
        if (isRunning) {
            isRunning = false;
            System.out.println("Stopped");
        } else {
            isRunning = true;
            System.out.println("Running");
        }
    }
}
