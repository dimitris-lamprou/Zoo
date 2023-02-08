package com.unipi.lamprou;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        FunctionsForFilesAndSystem.readAnimals(); //Διαβαζει ολα τα object animal που υπαρχουν στο αρχειο και τα αποθηκευει προσορηνα σε λιστα

        Scanner scanner = new Scanner(System.in);
        int userOption;

        do { //Κεντρικη επαναληψει για να λαβει την εντολη του χρηστη και να εκτελεσει τις αντιστοιχες συναρτεισεις

            userOption = Functions.userOption(1);

            if       (userOption == 1) {

                Functions.showAllAnimals();
                FunctionsForFilesAndSystem.pressEnterToContinue();

            } else if (userOption == 2) {

                Functions.addAnimal();
                FunctionsForFilesAndSystem.pressEnterToContinue();

            } else if (userOption == 3) {

                System.out.println("Δώστε όνομα ζώου για αναζήτηση");
                Functions.searchAnimalByName(scanner.nextLine());
                FunctionsForFilesAndSystem.pressEnterToContinue();

            } else if (userOption == 4) {

                System.out.println("Δώστε κωδικό ζώου για αναζήτηση");
                Functions.searchAnimalByCode(scanner.nextLine());
                FunctionsForFilesAndSystem.pressEnterToContinue();

            } else if (userOption == 5) {

                System.out.println("Δώστε κωδικό ζώου για αναζήτηση");
                Functions.editAnimalByCode(scanner.nextLine());
                FunctionsForFilesAndSystem.pressEnterToContinue();

            } else if (userOption == 6) {

                System.out.println("Δώστε κωδικό ζώου για διαγραφή ζώου");
                Functions.deleteAnimalByCode(scanner.nextLine());
                FunctionsForFilesAndSystem.pressEnterToContinue();
            }
        } while       (userOption != 7);

        FunctionsForFilesAndSystem.saveAnimals(); // αποθηκευση σε αρχειο
    }
}