package oopsConcept.polymorphism;

public class LearnAboutPolymorphism {

    public static void main(String[] args) {
        drawUIControl(new Button());
        drawUIControl(new Textbox());
    }

    private static void drawUIControl(UIControl uiControl) {
        uiControl.draw();
    }
}
