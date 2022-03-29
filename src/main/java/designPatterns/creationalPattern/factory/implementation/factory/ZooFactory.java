package designPatterns.creationalPattern.factory.implementation.factory;

import designPatterns.creationalPattern.factory.AnimalType;
import designPatterns.creationalPattern.factory.implementation.products.Animal;
import designPatterns.creationalPattern.factory.implementation.products.Tiger;

import java.util.Optional;

// this factory only takes care of the wild animals
public class ZooFactory implements AnimalFactory {
    @Override
    public Animal createAnimal(AnimalType animalType, Optional<String> animalName) {
        switch (animalType) {
            case TIGER:
                return new Tiger();
            default:
                throw new IllegalArgumentException(animalType+ " is not an animal");
        }
    }
}
