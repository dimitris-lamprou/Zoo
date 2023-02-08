package com.unipi.lamprou;

import java.io.*;
import static com.unipi.lamprou.Functions.animalsList;

public abstract class FunctionsForFilesAndSystem {

    public static void saveAnimals() {

        try { //αποθηκευει ολα τα object animal σε αρχειο
            FileOutputStream fileOutputStream = new FileOutputStream("animalsCharacteristics.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            int i = 0;
            while (animalsList.size() > i) {
                objectOutputStream.writeObject(animalsList.get(i));
                i++;
            }
            objectOutputStream.close();
            fileOutputStream.close();
            if (animalsList.size() > 0) {
                System.out.println("Τα ζώα αποθηκεύτηκαν");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readAnimals() {

        try { //Διαβαζει ολα τα object animal απο αρχειο και τα αποθηκευει προσορηνα σε λιστα
            FileInputStream fileInputStream = new FileInputStream("animalsCharacteristics.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            while (true) {
                Animals animal = (Animals) objectInputStream.readObject();
                if (animal == null) {
                    break;
                }
                animalsList.add(animal);
            }
            objectInputStream.close();
            fileInputStream.close();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        } catch (IOException ignored) {}
    }

    public static void pressEnterToContinue() {

        System.out.println("Πιέστε το ENTER για να συνεχίσετε");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}