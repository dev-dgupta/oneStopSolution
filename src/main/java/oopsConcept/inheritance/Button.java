package oopsConcept.inheritance;

public class Button extends UIControl{

    public String focus(){
        return "Button is " + super.focus();
    }
}
