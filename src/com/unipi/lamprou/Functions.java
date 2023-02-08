package com.unipi.lamprou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Functions {

    static List<Animals> animalsList = new ArrayList<>();
    static boolean flag; //Το κανω static και οχι local var,
                        // για να το βλεπει και η editAnimal εκτος απο την searchAnimalByCode

    public static void showAllAnimals() {                                                                               //1. Προβολή όλων των διαθέσιμων ζώων του ζωολογικού κήπου

        if (animalsList.isEmpty()) {
            System.out.println("Δεν βρέθηκαν καταχωρημένα ζώα");
            return;
        }

        for (Animals animal : animalsList) {
            System.out.println("Όνομα ζώου: " + animal.getName() + "\n" +
                    "Κωδικός ζώου: " + animal.getCode() + "\n" +
                    "Ομοταξία ζώου: " + animal.getSpecies() + "\n" +
                    "Μέσο βάρος ζώου: " + animal.getAverageWeight() + "\n" +
                    "Μέγιστη ηλικία ζώου: " + animal.getMaxAge() + "\n");
        }
    }

    public static void addAnimal() {                                                                                    //2. Προσθήκη νέου ζώου
        Animals animal = new Animals();

        System.out.println("Προσθήκη νέου ζώου\n" +
                "Παρακαλώ δώστε όνομα ζώου");
        animal.setName();

        System.out.println("Παρακαλώ δώστε κωδικό ζώου");
        animal.setCode();

        System.out.println("Παρακαλώ δώστε ομοταξία ζώου");
        animal.setSpecies();

        System.out.println("Παρακαλώ δώστε μέσο βάρος ζώου");
        animal.setAverageWeight();

        System.out.println("Παρακαλώ δώστε ακέραια μέση μέγιστη ηλικία ζώου");
        animal.setMaxAge();

        animalsList.add(animal);
    }

    public static void searchAnimalByName(String name) {                                                                //3. Αναζήτηση ζώου βάσει ονόματος

        boolean flag = false;

        for (Animals animal : animalsList) {
            if (name.equals(animal.getName())) {
                System.out.println("Βρέθηκε!\n" +
                        "Όνομα ζώου: " + animal.getName() + "\n" +
                        "Κωδικός ζώου: " + animal.getCode() + "\n" +
                        "Ομοταξία ζώου: " + animal.getSpecies() + "\n" +
                        "Μέσο βάρος ζώου: " + animal.getAverageWeight() + "\n" +
                        "Μέγιστη ηλικία ζώου: " + animal.getMaxAge() + "\n");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Δεν Βρέθηκε ζώο με το όνομα: " + name);
        }
    }

    public static int searchAnimalByCode(String code) {                                                                 //4. Αναζήτηση ζώου βάσει κωδικού

        flag = false;

        for (Animals animal : animalsList) {
            if (code.equals(animal.getCode())) {
                System.out.println("Βρέθηκε!\n" +
                        "Όνομα ζώου: " + animal.getName() + "\n" +
                        "Κωδικός ζώου: " + animal.getCode() + "\n" +
                        "Ομοταξία ζώου: " + animal.getSpecies() + "\n" +
                        "Μέσο βάρος ζώου: " + animal.getAverageWeight() + "\n" +
                        "Μέγιστη ηλικία ζώου: " + animal.getMaxAge() + "\n");
                flag = true;
                return animalsList.indexOf(animal); //Επιστρεφει σε ποια θεση βρεθηκε το ζωο-object στην λιστα.
                                                    // Αν δεν βρεθει επιστρεφει -1
            }
        }
        if (!flag) {
            System.out.println("Δεν Βρέθηκε ζώο με τον κωδικό: " + code);
        }
        return -1; //Αν δεν βρεθει επιστρεφει -1
    }

    public static void editAnimalByCode(String code) {                                                                  //5. Επεξεργασία ζώου βάσει κωδικού

        int indexOfAnimal; // Δινει σε ποια θεση βρεθηκε το ζωο-object στην λιστα. Αν δεν βρεθει επιστρεφει -1
        indexOfAnimal = Functions.searchAnimalByCode(code);

        if (flag) {

            int userOption;
            int count = 0;
            Animals animal;

            do {
                System.out.println("Επιλέξτε απο 1-6 ποιο πεδίο θέλετε να αλλάξετε\n" +
                        "1. Όνομα ζώου\n" +
                        "2. Κωδικός ζώου\n" +
                        "3. Ομοταξία ζώου\n" +
                        "4. Μέσο βάρος ζώου\n" +
                        "5. Μέγιστη ηλικία ζώου\n" +
                        "6. Κανένα πεδίο");

                userOption = Functions.userOption(2);

                if (count == 0) {
                    animal = animalsList.get(indexOfAnimal);
                    count++;
                } else {
                    animal = animalsList.get(animalsList.size() - 1); //επειδη οταν βαζω καινουριο πεδιο
                                                                     //διαγραφω το object και το ξανακαω add
                                                                    //παει στο τελος της λιστας
                }

                if (userOption == 1) {

                    animalsList.remove(animal);
                    System.out.println(animal.getName());
                    System.out.println("Παρακαλώ δώστε νέο όνομα ζώου");
                    animal.setName();
                    animalsList.add(animal);

                } else if (userOption == 2) {

                    animalsList.remove(animal);
                    System.out.println(animal.getCode());
                    System.out.println("Παρακαλώ δώστε νέο κωδικό ζώου");
                    animal.setCode();
                    animalsList.add(animal);

                } else if (userOption == 3) {

                    animalsList.remove(animal);
                    System.out.println(animal.getSpecies());
                    System.out.println("Παρακαλώ δώστε νέα ομοταξία ζώου");
                    animal.setSpecies();
                    animalsList.add(animal);

                } else if (userOption == 4) {

                    animalsList.remove(animal);
                    System.out.println(animal.getAverageWeight());
                    System.out.println("Παρακαλώ δώστε νέο μέσο βάρος ζώου");
                    animal.setAverageWeight();
                    animalsList.add(animal);

                } else if (userOption == 5) {

                    animalsList.remove(animal);
                    System.out.println(animal.getMaxAge());
                    System.out.println("Παρακαλώ δώστε νέα μέγιστη ηλικία ζώου");
                    animal.setMaxAge();
                    animalsList.add(animal);

                }
            } while (userOption != 6);
        }
    }

    public static void deleteAnimalByCode(String code) {                                                                //6. Διαγραφή ζώου βάσει κωδικού

        boolean flag = false;

        for (Animals animal : animalsList) {
            if (code.equals(animal.getCode())) {
                animalsList.remove(animal);
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Βρέθηκε ζώο με τον κωδικό: " + code + " και διαγράφτηκε");
        } else {
            System.out.println("Δεν Βρέθηκε ζώο με τον κωδικό: " + code);
        }
    }

    public static int userOption(int showMessage) { //η επιλογη συναρτησης απο τον χρηστη || showMessage = μεταβλητη
                                                    //για να μπορεσω να χρησιμοποιησω την ιδια συναρτηση
                                            //(με διαφορετικο μηνημα) και μεσα στην editAnimal χωρις να την ξαναγραψω

        //showMessage 1 ειναι για την περιπτωση που θελω να χρησιμοποιησω μονο την userOption
        //showMessage 2 ειναι για την περιπτωση που θελω να χρησιμοποιησω την userOption μεσα στην editAnimal
        Scanner scanner = new Scanner(System.in);
        boolean ifBool; //για να αλλαζω ευκολα την συνθηκη μιας if αναλογα το value της showMessage
        int userOption;

        if (showMessage == 1) {
            System.out.println("Εφαρμογή Zoo\n" +
                    "Παρακαλώ Επιλέξτε απο το παρακάτω menu επιλογών\n" +
                    "-----------------------------------------------\n" +
                    "1. Προβολή όλων των διαθέσιμων ζώων του ζωολογικού κήπου\n" +
                    "2. Προσθήκη νέου ζώου\n" +
                    "3. Αναζήτηση ζώου βάσει ονόματος\n" +
                    "4. Αναζήτηση ζώου βάσει κωδικού\n" +
                    "5. Επεξεργασία ζώου βάσει κωδικού\n" +
                    "6. Διαγραφή ζώου βάσει κωδικού\n" +
                    "7. Έξοδος από την εφαρμογή");
        }
        while (true) { // Επαναληψη για να χειρηστει exceptions στην επιλογη συναρτησης απο τον χρηστη

            try {

                userOption = Integer.parseInt(scanner.nextLine());

                    if (showMessage == 1) {
                        ifBool = userOption != 1 && userOption != 2 && userOption != 3 && userOption != 4 && userOption
                                != 5 && userOption != 6 && userOption != 7;
                    } else {
                        ifBool = userOption != 1 && userOption != 2 && userOption != 3 && userOption != 4 && userOption
                                != 5 && userOption != 6;
                    }

                    if (ifBool) { //Εξεταζει την περιπτωση που ο χρηστης επιλεξει ακεραιο οχι αναμεσα απο τις επιλογες
                        if (showMessage == 1) {
                            System.out.println("Η επιλογή σας πρέπει να βρίσκεται ανάμεσα απο τους αριθμούς 1-7\n" +
                                    "Παρακαλώ Επιλέξτε απο το παρακάτω menu επιλογών\n" +
                                    "-----------------------------------------------\n" +
                                    "1. Προβολή όλων των διαθέσιμων ζώων του ζωολογικού κήπου\n" +
                                    "2. Προσθήκη νέου ζώου\n" +
                                    "3. Αναζήτηση ζώου βάσει ονόματος\n" +
                                    "4. Αναζήτηση ζώου βάσει κωδικού\n" +
                                    "5. Επεξεργασία ζώου βάσει κωδικού\n" +
                                    "6. Διαγραφή ζώου βάσει κωδικού\n" +
                                    "7. Έξοδος από την εφαρμογή");
                        } else {
                            System.out.println("Η επιλογή σας πρέπει να βρίσκεται ανάμεσα απο τους αριθμούς 1-6\n" +
                                    "1. Όνομα ζώου\n" +
                                    "2. Κωδικός ζώου\n" +
                                    "3. Ομοταξία ζώου\n" +
                                    "4. Μέσο βάρος ζώου\n" +
                                    "5. Μέγιστη ηλικία ζώου\n" +
                                    "6. Κανένα πεδίο");
                        }
                        continue;
                    }
                return userOption;
            } catch (NumberFormatException e) { // Πιανει την περιπτωση που ο χρηστης δεν δωσει ακεραιο
                if (showMessage == 1) {
                    System.out.println("Λάθος είσοδος δεδομένων.\n" +
                            "Παρακαλώ Επιλέξτε απο το παρακάτω menu επιλογών\n" +
                            "-----------------------------------------------\n" +
                            "1. Προβολή όλων των διαθέσιμων ζώων του ζωολογικού κήπου\n" +
                            "2. Προσθήκη νέου ζώου\n" +
                            "3. Αναζήτηση ζώου βάσει ονόματος\n" +
                            "4. Αναζήτηση ζώου βάσει κωδικού\n" +
                            "5. Επεξεργασία ζώου βάσει κωδικού\n" +
                            "6. Διαγραφή ζώου βάσει κωδικού\n" +
                            "7. Έξοδος από την εφαρμογή");
                } else {
                    System.out.println("Λάθος είσοδος δεδομένων.\n" +
                            "Επιλέξτε απο 1-6 ποιο πεδίο θέλετε να αλλάξετε\n" +
                            "1. Όνομα ζώου\n" +
                            "2. Κωδικός ζώου\n" +
                            "3. Ομοταξία ζώου\n" +
                            "4. Μέσο βάρος ζώου\n" +
                            "5. Μέγιστη ηλικία ζώου\n" +
                            "6. Κανένα πεδίο");
                }
            }
        }
    }
}