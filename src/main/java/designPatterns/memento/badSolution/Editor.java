package designPatterns.memento.badSolution;

import java.util.ArrayDeque;
import java.util.Deque;

public class Editor {

    Deque<String> stack = new ArrayDeque<>();

    public String getContent() {
        return stack.toString();
    }

    public void setContent(String content) {
        stack.push(content);
    }

    public void undo() {
        stack.pop();
    }

}
