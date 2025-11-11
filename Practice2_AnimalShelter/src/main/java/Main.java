import Model.Animal;
import Model.Cat;
import Model.Dog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        final int ADOPT_ANIMAL_OPTION = 1;
        final int ADOPT_CAT_OPTION = 2;
        final int ADOPT_DOG_OPTION = 3;
        final int SHELTER_CAT_OPTION = 4;
        final int SHELTER_DOG_OPTION = 5;
        final int QUIT_OPTION = 6;

        Animal animal;
        Cat cat;
        Dog dog;

        String animalName = "";

        AnimalShelterService animalShelterService = new AnimalShelterService();

        animalShelterService.enqueueAnimal(new Cat("Poe"));

        do {
            System.out.println("\nWelcome to the Animal Shelter Adoption Program");
            System.out.println("----------------------------------------------");
            System.out.println("1. Adopt an animal");
            System.out.println("2. Adopt a cat");
            System.out.println("3. Adopt a dog");
            System.out.println("4. Shelter a cat");
            System.out.println("5. Shelter a dog");
            System.out.println("6. Quit");
            System.out.println("----------------------------------------------");

            System.out.println("Make a selection: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case ADOPT_ANIMAL_OPTION -> {
                    animal = animalShelterService.dequeueAny();
                    System.out.println("You have adopted a " + animal.getType() + " named '" + animal.getName() + "'.");
                }
                case ADOPT_CAT_OPTION -> {
                    cat = animalShelterService.dequeueCat();

                    if (cat != null) {
                        System.out.println("You have adopted a " + cat.getType() + " named '" + cat.getName() + "'.");
                    }
                }
                case ADOPT_DOG_OPTION -> {
                    dog = animalShelterService.dequeueDog();

                    if (dog != null) {
                        System.out.println("You have adopted a " + dog.getType() + " named '" + dog.getName() + "'.");
                    }
                }
                case SHELTER_CAT_OPTION -> {
                    System.out.println("Enter the cat's name: ");
                    animalName = scanner.nextLine();

                    animalShelterService.enqueueAnimal(new Cat(animalName));
                }
                case SHELTER_DOG_OPTION -> {
                    System.out.println("Enter the dog's name: ");
                    animalName = scanner.nextLine();

                    animalShelterService.enqueueAnimal(new Dog(animalName));
                }
                case QUIT_OPTION -> {
                    System.out.println("\nThank you for using the Animal Shelter Service program!");
                }
                default -> {
                    System.out.println("Invalid option. Please try again.");
                }
            }
        } while (option != QUIT_OPTION);

    }
}
