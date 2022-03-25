package oopsConcept.inheritance;

public class Button extends UIControl{

    public String focus(){
        return new StringBuilder().append("Button is ").append(super.focus()).toString();
    }
}
