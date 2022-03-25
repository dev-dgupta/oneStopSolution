package designPatterns.state.implementation;

public class Photoshop {

    public static void main(String[] args) {
        var canvas = new Canvas();
        canvas.setCurrentTool(new Selection());
        canvas.mouseDown();
        canvas.mouseUp();

        canvas.setCurrentTool(new Eraser());
        canvas.mouseDown();
        canvas.mouseUp();
    }
}
