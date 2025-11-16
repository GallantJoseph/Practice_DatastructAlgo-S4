import Model.Animal;
import Model.Cat;
import Model.Dog;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        mainMenu();
        System.out.println("\nThank you for using the Animal Shelter Service program!");
    }

    private static void mainMenu(){
        Scanner scanner = new Scanner(System.in);
        int option;

        final int ADOPT_ANIMAL_OPTION = 1;
        final int ADOPT_CAT_OPTION = 2;
        final int ADOPT_DOG_OPTION = 3;
        final int SHELTER_CAT_OPTION = 4;
        final int SHELTER_DOG_OPTION = 5;
        final int SHOW_ANIMALS_OPTION = 6;
        final int QUIT_OPTION = 7;

        AnimalShelterService animalShelterService = new AnimalShelterService();

        do {
            System.out.println("\nWelcome to the Animal Shelter Adoption Program");
            System.out.println("----------------------------------------------");
            System.out.println("1. Adopt an animal");
            System.out.println("2. Adopt a cat");
            System.out.println("3. Adopt a dog");
            System.out.println("4. Shelter a cat");
            System.out.println("5. Shelter a dog");
            System.out.println("6. Show animals available for adoption");
            System.out.println("7. Quit");
            System.out.println("----------------------------------------------");

            do {
                System.out.print("\nMake a selection: ");

                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } else {
                    scanner.nextLine();
                    System.out.println("\nInvalid option. Please enter a number.");
                }

            } while (true);

            switch (option) {
                case ADOPT_ANIMAL_OPTION -> {
                    AnimalShelterService.adoptAnimal(animalShelterService.dequeueAny());
                    pressEnterToContinue(scanner);
                }
                case ADOPT_CAT_OPTION -> {
                    AnimalShelterService.adoptAnimal(animalShelterService.dequeueCat());
                    pressEnterToContinue(scanner);
                }
                case ADOPT_DOG_OPTION -> {
                    AnimalShelterService.adoptAnimal(animalShelterService.dequeueDog());
                    pressEnterToContinue(scanner);
                }
                case SHELTER_CAT_OPTION -> {
                    System.out.print("\nEnter the cat's name: ");
                    String animalName = scanner.nextLine();

                    animalShelterService.enqueueAnimal(new Cat(animalName));
                    pressEnterToContinue(scanner);
                }
                case SHELTER_DOG_OPTION -> {
                    System.out.print("\nEnter the dog's name: ");
                    String animalName = scanner.nextLine();

                    animalShelterService.enqueueAnimal(new Dog(animalName));
                    pressEnterToContinue(scanner);
                }
                case SHOW_ANIMALS_OPTION -> {
                    System.out.println("\nAnimals available for adoption");
                    System.out.println("------------------------------\n");

                    animalShelterService.showAllAnimals();
                    pressEnterToContinue(scanner);
                }
                case QUIT_OPTION -> {
                }
                default -> {
                    System.out.println("\nInvalid option. Please try again.");
                    pressEnterToContinue(scanner);
                }
            }
        } while (option != QUIT_OPTION);

        scanner.close();
    }

    private static void pressEnterToContinue(Scanner scanner) {
        System.out.print("\nPress Enter to continue.");
        scanner.nextLine();
    }
}
