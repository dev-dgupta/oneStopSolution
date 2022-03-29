package designPatterns.creationalPattern.factory.implementation.factory;

import designPatterns.creationalPattern.factory.AnimalType;
import designPatterns.creationalPattern.factory.implementation.products.Animal;

import java.util.Optional;

// an abstract implementation given for the creation of objects
public interface AnimalFactory {

    Animal createAnimal(AnimalType petType, Optional<String> animalName);
}
