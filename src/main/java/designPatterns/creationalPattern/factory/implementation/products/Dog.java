package designPatterns.creationalPattern.factory.implementation.products;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void moveAround() {
        System.out.println(getName() + ", nice dog catching the ball.");
    }

    @Override
    public void makeSound() {
        System.out.println("Woof woof...");
    }
}
