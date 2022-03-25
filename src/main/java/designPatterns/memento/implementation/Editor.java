package designPatterns.memento.implementation;


public class Editor {

    private String content;

    public void setContent(String newContent) {
        content += (" ") + newContent;
    }

    public String getContent() {
        return content;
    }

    public EditorState createState() {
        return new EditorState(content);
    }

    public void restore(EditorState state) {
        content = state.getContent();
    }


}
