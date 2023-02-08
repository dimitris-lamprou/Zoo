package com.unipi.lamprou;

import java.io.Serializable;
import java.util.Scanner;
import static com.unipi.lamprou.Functions.animalsList;

public final class Animals implements Serializable {
    private String code; //μπορει να ειναι οτιδηποτε
    private String name; //μπορει να ειναι μονο γραμματα
    private String species; // Ομοταξία. μπορει να ειναι μονο γραμματα
    private double averageWeight; //μπορει να ειναι μονο θετικός αριθμός
    private int maxAge; //μπορει να ειναι μονο θετικός ακεραιος

    public String getCode() {
        return code;
    }

    public void setCode() {

        Scanner scanner = new Scanner(System.in);
        this.code = scanner.nextLine();

        for (Animals animals : animalsList) { //ελέγχει αν ο χρηστης εδωσε κωδικο που υπαρχει ηδη στην λιστα
            while (this.code.equals(animals.getCode())) {
                System.out.println( "Πληκτρολογήσατε κωδικό ζώου που υπάρχει ήδη στον ζωολογικό κύπο\n" +
                        "Παρακαλώ δώστε κωδικό ζώου");
                this.code = scanner.nextLine();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName() {

        Scanner scanner = new Scanner(System.in);
        this.name = scanner.nextLine();

        for (Animals animals : animalsList) { //ελέγχει αν ο χρηστης εδωσε ονομα που υπαρχει ηδη στην λιστα
            while (this.name.equals(animals.getName())) {
                System.out.println( "Πληκτρολογήσατε όνομα ζώου που υπάρχει ήδη στον ζωολογικό κύπο\n" +
                        "Παρακαλώ δώστε όνομα ζώου");
                this.name = scanner.nextLine();
            }
        }

        while ( !this.name.matches("[A-Za-zα-ωΑ-ΩάΆέΈήΉίΊόΌύΎώΏ ]+") ) { //ελεγχει αν εδωσε ο χρηστης μονο γραμματα και οχι αριθμους ή συμβολα
            System.out.println( "Πρέπει να δώσετε μόνο γράμματα\n" +
                    "Παρακαλώ δώστε όνομα ζώου");
            this.name = scanner.nextLine();
        }
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies() {

        Scanner scanner = new Scanner(System.in);
        this.species = scanner.nextLine();

        while ( !this.species.matches("[A-Za-zα-ωΑ-ΩάΆέΈήΉίΊόΌύΎώΏ]+") ) { //ελεγχει αν εδωσε ο χρηστης μονο γραμματα και οχι αριθμους ή συμβολα
            System.out.println( "Πρέπει να δώσετε μόνο γράμματα\n" +
                    "Παρακαλώ δώστε ομοταξία ζώου");
            this.species = scanner.nextLine();
        }
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try { // Πιανει την περιπτωση που ο χρηστης δεν δωσει double
                this.averageWeight = Double.parseDouble(scanner.nextLine());
                if (this.averageWeight <= 0) { // Πιανει την περιπτωση που ο χρηστης δεν δωσει θετικό double
                    System.out.println( "Λάθος είσοδος δεδομένων. Δώσατε αρνητικό αριθμό ή μηδεν\n" +
                            "Παρακαλώ δώστε θετικό μέσο βάρος ζώου");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println( "Λάθος είσοδος δεδομένων.\n" +
                        "Παρακαλώ δώστε μέσο βάρος ζώου");
            }
        }
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge() {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try { // Πιανει την περιπτωση που ο χρηστης δεν δωσει ακεραιο
                this.maxAge = Integer.parseInt(scanner.nextLine());
                if (this.maxAge <= 0) { // Πιανει την περιπτωση που ο χρηστης δεν δωσει θετικό ακεραιο
                    System.out.println( "Λάθος είσοδος δεδομένων. Δώσατε αρνητικό αριθμό ή μηδεν\n" +
                            "Παρακαλώ δώστε θετική ακέραια μέση μέγιστη ηλικία ζώου");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println( "Λάθος είσοδος δεδομένων.\n" +
                        "Παρακαλώ δώστε ακέραια μέση μέγιστη ηλικία ζώου");
            }
        }
    }
}