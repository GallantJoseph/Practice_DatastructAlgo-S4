import Model.Animal;
import Model.Cat;
import Model.Dog;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelterService {
    private final Queue<Animal> animalQueue = new LinkedList<>();

    public AnimalShelterService() {

    }

    public void enqueueAnimal(Animal animal) {
        switch (animal) {
            case null -> {
                System.out.println("No animal to add to the queue.");
            }
            case Cat cat -> {
                animalQueue.add(cat);
                System.out.println("Cat successfully added to the queue!");
            }
            case Dog dog -> {
                animalQueue.add(dog);
                System.out.println("Dog successfully added to the queue!");
            }
            default -> System.out.println("Invalid animal type.");
        }
    }

    public Animal dequeueAny() {
        if (animalQueue.isEmpty()) {
            System.out.println("No animals available.");
            return null;
        } else
            return animalQueue.poll();
    }

    public Dog dequeueDog() {
        for (Animal animal: animalQueue) {
            if (animal instanceof Dog) {
                animalQueue.remove(animal);
                return (Dog) animal;
            }
        }

        System.out.println("No dogs available");
        return null;
    }

    public Cat dequeueCat() {
        for (Animal animal: animalQueue) {
            if (animal instanceof Cat) {
                animalQueue.remove(animal);
                return (Cat) animal;
            }
        }

        System.out.println("No cats available");
        return null;
    }

    public void showAllAnimals() {
        if (animalQueue.isEmpty())
            System.out.println("* No animals available for adoption *");
        for (Animal animal: animalQueue) {
            System.out.printf("Type: %s\nName: %s\n\n", animal.getType(), animal.getName());
        }
    }
}
