package designPatterns.state.solution;

public class Context {

    private State state;

    public void request() {
        state.handle();
    }
}
