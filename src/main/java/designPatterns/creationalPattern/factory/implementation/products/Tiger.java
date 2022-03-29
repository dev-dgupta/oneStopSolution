package designPatterns.creationalPattern.factory.implementation.products;

public class Tiger extends Animal {

    public Tiger() {
    }

    @Override
    public void moveAround() {
        System.out.println("Tiger is strolling in the zoo");
    }

    @Override
    public void makeSound() {
        System.out.println("Rooooarrrrrr..");
    }
}
