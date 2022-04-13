package designPatterns.creationalPattern.factory.badSolution.client;

import designPatterns.creationalPattern.factory.AnimalType;
import designPatterns.creationalPattern.factory.implementation.factory.AnimalFactory;
import designPatterns.creationalPattern.factory.implementation.factory.PetStoreFactory;
import designPatterns.creationalPattern.factory.implementation.products.Animal;
import designPatterns.creationalPattern.factory.implementation.products.Cat;
import designPatterns.creationalPattern.factory.implementation.products.Dog;

public class PetStore {

    public static void main(String[] args) {
        PetStore petStore = new PetStore();
        Animal pet = petStore.orderPet(AnimalType.DOG, "Dollor");
        pet.makeSound();
        pet.moveAround();
        pet = petStore.orderPet(AnimalType.CAT, "Kitty");
        pet.makeSound();
        pet.moveAround();

    }

    private Animal orderPet(AnimalType petType, String petName) {
        return switch (petType) {
            case DOG -> new Dog(petName);
            case CAT -> new Cat(petName);
            default -> throw new IllegalArgumentException("Pet not found.");
        };
    }
}
