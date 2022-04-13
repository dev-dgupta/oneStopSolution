package oopsConcept.polymorphism;

public class Button extends UIControl {

    public String focus(){
        return "Button is " + super.focus();
    }

    @Override
    public void draw() {
        System.out.println("Button is drawn");
    }
}
