package designPatterns.creationalPattern.factory.implementation.factory;

import designPatterns.creationalPattern.factory.AnimalType;
import designPatterns.creationalPattern.factory.implementation.products.Animal;
import designPatterns.creationalPattern.factory.implementation.products.Tiger;

// this factory only takes care of the wild animals
public class ZooFactory implements AnimalFactory {
    @Override
    public Animal createAnimal(AnimalType animalType, String animalName) {
        if (animalType == AnimalType.TIGER) {
            return new Tiger();
        }
        throw new IllegalArgumentException(animalType + " is not an animal");
    }
}
