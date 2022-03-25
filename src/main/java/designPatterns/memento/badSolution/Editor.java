package designPatterns.memento.badSolution;

import java.util.Stack;

public class Editor {

    Stack stack = new Stack<String>();


    public String getContent() {
        return stack.toString();
    }

    public void setContent(String content) {
        stack.push(content);
    }

    private String content;

    public void undo() {
        stack.pop();
    }

}
