package designPatterns.creationalPattern.factory.badSolution.products;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void moveAround() {
        System.out.println(getName() + ", nice cat looking for milk." );
    }

    @Override
    public void makeSound() {
        System.out.println("Meow Meow...");
    }
}
