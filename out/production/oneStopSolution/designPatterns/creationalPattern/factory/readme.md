When you don't the objects at compile time and only at runtime you would know which objects/classes will be instantiated, we should go for factory pattern

The factory key is passed to remove the dependency on the factory instance.
You don't need to recompile the java class if the factory gets changed.

Special case for abstract factory pattern

Follows:

1. Single Responsibilty Principle
2. Open-closed principle
3. Dependency Inversion Principle (creation takes place in the animal factory which itself is an abstract)
4. All the creational logic is astracted out, and available in the single place



Disadvantages:
1. Any change in createAnimal method, affects the PetStore class


Code Smells for factory could be a good approach:
1. Product 