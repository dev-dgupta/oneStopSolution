package designPatterns.creationalPattern.factory.implementation.factory;

import designPatterns.creationalPattern.factory.AnimalType;
import designPatterns.creationalPattern.factory.implementation.products.Animal;
import designPatterns.creationalPattern.factory.implementation.products.Cat;
import designPatterns.creationalPattern.factory.implementation.products.Dog;

import java.util.Optional;


// this factory only takes care of the pet animals
public class PetStoreFactory implements AnimalFactory {
    @Override
    public Animal createAnimal(AnimalType petType, Optional<String> petName) {
        switch (petType) {
            case DOG:
                return new Dog(petName.isPresent() ? petName.get() : "To be decided");
            case CAT:
                return new Cat(petName.isPresent() ? petName.get() : "To be decided");
            default:
                throw new IllegalArgumentException(petType + " is not a valid pet category.");
        }
    }
}
