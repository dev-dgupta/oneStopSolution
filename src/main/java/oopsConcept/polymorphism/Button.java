package oopsConcept.polymorphism;

public class Button extends UIControl {

    public String focus(){
        return new StringBuilder().append("Button is ").append(super.focus()).toString();
    }

    @Override
    public void draw() {
        System.out.println("Button is drawn");
    }
}
