import Model.Animal;
import Model.Cat;
import Model.Dog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelterService {
    private long timestampCounter = 0;
    private final Queue<Cat> catQueue = new LinkedList<>();
    private final Queue<Dog> dogQueue = new LinkedList<>();

    public AnimalShelterService() {

    }

    public void enqueueAnimal(Animal animal) {
        switch (animal) {
            case null -> {
                System.out.println("\nNo animal to add.");
            }
            case Cat cat -> {
                cat.setTimestamp(timestampCounter);
                catQueue.add(cat);
                timestampCounter++;
                System.out.println("\nCat successfully added!");
            }
            case Dog dog -> {
                dog.setTimestamp(timestampCounter);
                dogQueue.add(dog);
                timestampCounter++;
                System.out.println("\nDog successfully added!");
            }
            default -> System.out.println("\nInvalid animal type.");
        }
    }

    public Animal dequeueAny() {
        if (this.isEmpty()) {
            System.out.println("\nNo animals available.");
            return null;
        }

        if (catQueue.isEmpty())
            return dequeueDog();
        if (dogQueue.isEmpty())
            return dequeueCat();

        // Compare timestamps to get oldest overall
        return (catQueue.peek().getTimestamp() < dogQueue.peek().getTimestamp())
                ? dequeueCat()
                : dequeueDog();
    }

    public Dog dequeueDog() {
        if (dogQueue.isEmpty()) {
            System.out.println("\nNo dogs available.");
            return null;
        }

        return dogQueue.poll();
    }

    public Cat dequeueCat() {
        if (catQueue.isEmpty()) {
            System.out.println("\nNo cats available.");
            return null;
        }

        return catQueue.poll();
    }

    public static void adoptAnimal(Animal animal) {
        if (animal != null) {
            System.out.println("\nYou have adopted a " + animal.getType() + " named '" + animal.getName() + "'.");
        }
    }

    public void showAllAnimals() {
        if (this.isEmpty())
            System.out.println("* No animals available for adoption *");
        else
            printAnimals();
    }

    private void printAnimals() {
        for (Animal animal: catQueue) {
            System.out.printf("Arrival position: %d\nType: %s\nName: %s\n\n", animal.getTimestamp(), animal.getType(), animal.getName());
        }

        for (Animal animal: dogQueue) {
            System.out.printf("Arrival position: %d\nType: %s\nName: %s\n\n", animal.getTimestamp(), animal.getType(), animal.getName());
        }
    }

    public boolean isEmpty() {
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }
}
