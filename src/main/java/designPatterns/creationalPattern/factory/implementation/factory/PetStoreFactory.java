package designPatterns.creationalPattern.factory.implementation.factory;

import designPatterns.creationalPattern.factory.AnimalType;
import designPatterns.creationalPattern.factory.implementation.products.Animal;
import designPatterns.creationalPattern.factory.implementation.products.Cat;
import designPatterns.creationalPattern.factory.implementation.products.Dog;

import java.util.Objects;
import java.util.Optional;


// this factory only takes care of the pet animals
public class PetStoreFactory implements AnimalFactory {
    @Override
    public Animal createAnimal(AnimalType petType, String petName) {
        return switch (petType) {
            case DOG -> new Dog(Objects.isNull(petName) ? "To be decided" : petName);
            case CAT -> new Cat(Objects.isNull(petName) ? "To be decided" : petName);
            default -> throw new IllegalArgumentException(petType + " is not a valid pet category.");
        };
    }
}
