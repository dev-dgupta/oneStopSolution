package designPatterns.state.badSolution;

public class Canvas {

    private ToolType currentTool;

    public void mouseDown() {
        if (currentTool == ToolType.SELECTION)
            System.out.println("Selection icon");
        else if (currentTool == ToolType.ERASER)
            System.out.println("Eraser icon");
        else if (currentTool == ToolType.BRUSH)
            System.out.println("Brush icon");
    }

    public void mouseUp() {
        if (currentTool == ToolType.SELECTION)
            System.out.println("A dashed rectangle");
        else if (currentTool == ToolType.ERASER)
            System.out.println("Eraser something");
        else if (currentTool == ToolType.BRUSH)
            System.out.println("Draw a line");
    }

}
