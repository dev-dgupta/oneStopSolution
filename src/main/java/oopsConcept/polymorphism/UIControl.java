package oopsConcept.polymorphism;

public abstract class UIControl {

    public void enable() {
        System.out.println("Enabled");
    }

    public String focus() {
        return "focussed";
    }

    public void setPosition() {
        System.out.println("Position is set");
    }

    public abstract void draw();
}
