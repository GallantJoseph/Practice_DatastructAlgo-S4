import Model.Animal;
import Model.Cat;
import Model.Dog;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelterService {
    private final Queue<Cat> catQueue = new LinkedList<>();
    private final Queue<Dog> dogQueue = new LinkedList<>();

    public AnimalShelterService() {

    }

    public void enqueueAnimal(Animal animal) {
        switch (animal) {
            case null -> {
                System.out.println("No animal to add to the queue.");
            }
            case Cat cat -> {
                catQueue.add(cat);
                System.out.println("Cat successfully added to the queue!");
            }
            case Dog dog -> {
                dogQueue.add(dog);
                System.out.println("Dog successfully added to the queue!");
            }
            default -> System.out.println("Invalid animal type.");
        }
    }

    public Animal dequeueAny() {
        if (catQueue.isEmpty()) {
            return dogQueue.poll();
        }

        if (dogQueue.isEmpty()) {
            return catQueue.poll();
        }

        if (Math.random() < 0.5) {
            return dequeueCat();
        } else {
            return dequeueDog();
        }
    }

    public Dog dequeueDog() {
        if (dogQueue.isEmpty()) {
            System.out.println("No dogs available");
            return null;
        }

        return dogQueue.poll();
    }

    public Cat dequeueCat() {
        if (catQueue.isEmpty()) {
            System.out.println("No cats available");
            return null;
        }

        return catQueue.poll();
    }
}
