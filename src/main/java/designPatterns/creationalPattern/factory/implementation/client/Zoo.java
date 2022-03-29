package designPatterns.creationalPattern.factory.implementation.client;

import designPatterns.creationalPattern.factory.AnimalType;
import designPatterns.creationalPattern.factory.implementation.factory.AnimalFactory;
import designPatterns.creationalPattern.factory.implementation.products.Animal;

public class Zoo {

    private AnimalFactory factory;

    public Zoo(AnimalFactory factory) {
        this.factory = factory;
    }

    public static void main(String[] args) {
        Zoo zoo = new Zoo(LoadProperties.getFactoryFromPropertiesFile("zoo.factory.type"));
        Animal pet = zoo.orderAnimal(AnimalType.TIGER);
        pet.makeSound();
        pet.moveAround();

    }

    private Animal orderAnimal(AnimalType petType) {
        return factory.createAnimal(petType, null);
    }
}
