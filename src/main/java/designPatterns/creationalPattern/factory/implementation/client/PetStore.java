package designPatterns.creationalPattern.factory.implementation.client;

import designPatterns.creationalPattern.factory.AnimalType;
import designPatterns.creationalPattern.factory.implementation.factory.AnimalFactory;
import designPatterns.creationalPattern.factory.implementation.factory.PetStoreFactory;
import designPatterns.creationalPattern.factory.implementation.products.Animal;

import java.util.Optional;

public class PetStore {

    private AnimalFactory factory;

    public PetStore(AnimalFactory factory) {
        this.factory = factory;
    }

    public static void main(String[] args) {
        PetStore petStore = new PetStore(LoadProperties.getFactoryFromPropertiesFile("petstore.factory.type"));
        Animal pet = petStore.orderPet(AnimalType.DOG, Optional.of("Dollor"));
        pet.makeSound();
        pet.moveAround();
        pet = petStore.orderPet(AnimalType.CAT, Optional.of("Kitty"));
        pet.makeSound();
        pet.moveAround();

    }

    private Animal orderPet(AnimalType petType, Optional<String> petName) {
        return factory.createAnimal(petType, petName);
    }


}
