package designPatterns.memento.badSolution;

public class Document {

    public static void main(String[] args) {

        var editor=new Editor();
        editor.setContent("a");
        editor.setContent("b");
        editor.setContent("c");
        System.out.println(editor.getContent()) ;
        editor.undo();

        System.out.println(editor.getContent());

    }
}
