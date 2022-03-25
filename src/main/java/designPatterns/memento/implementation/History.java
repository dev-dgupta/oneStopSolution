package designPatterns.memento.implementation;

import java.util.*;

public class History {

    private Stack<EditorState> states = new Stack<>();

    public void push(EditorState state) {
        states.push(state);
    }

    public EditorState pop() {
        return states.pop();
    }


}
