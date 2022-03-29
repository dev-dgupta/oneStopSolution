package designPatterns.creationalPattern.factory.implementation.products;

public abstract class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
    }

    public abstract void moveAround();

    public abstract void makeSound();

    public String getName() {
        return name;
    }


}
