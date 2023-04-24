/*
    @author Jakub Slusarski, s20568, 20c
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    static final String extentFile = "./extent.bin";
    public static boolean breakFlag = false;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while(!breakFlag) {
            System.out.println("1. Stwórz klientów");
            System.out.println("2. Stwórz produkty");
            System.out.println("3. Wyświetl klientów");
            System.out.println("4. Wyświetl produkty");
            System.out.println("5. Zapisz klientów do ekstensji");
            System.out.println("6. Odczytaj plik ekstensji");

            int option = input.nextInt();
            switch (option) {
                case 1:
                    createClients();
                    break;
                case 2:
                    createProducts();
                    break;
                case 3:
                    Client.showExtent();
                    break;
                case 4:
                    Product.showExtent();
                    break;
                case 5:
                    clientSerialize();
                    break;
                case 6:
                    productSerialize();
                    break;
                case 7:
                    clientDeserialize();
                    break;
                case 8:
                    productDeserialize();
                    break;
                case 9:
                    classMethod();
                default:
                    breakFlag = true;
                    break;
            }
        }
    }
    private static void clientSerialize() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(extentFile));
            Client.writeExtent(output);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void productSerialize() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(extentFile));
            Product.writeExtent(output);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clientDeserialize() {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(extentFile));
            Client.readExtent(input);
            input.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static void productDeserialize() {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(extentFile));
            Product.readExtent(input);
            input.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void createClients() {
        //Przeciążanie metod - konstruktory
        Client client1 = new Client("Jakub", "Slusarski", "s20568@pjwstk.edu.pl", "Koszykowa 86, 12-345, Warszawa", 123456789, false);
        Client client2 = new Client("Jan", "Kowalski", "janekkowal12", "jan.kowalski@gmail.com", "Sloneczna 1, 09-876 Bytom", 739105489, true);
    }
    private static void createProducts() {
        //Przeciążanie metod - konstruktory
        Product product1 = new Product("iPhone 13", "Appple", "Smartphone", "AP4129", 995120120, 4799, true);
        Product product2 = new Product("Galaxy S22", "Samsung", "Smartphone", "SP58124", 7741289, 3999, false);
        Product product3 = new Product("MacBook Pro", "Apple", "Laptop", "AL1120", 15125152, 8999, true);
        Product product4 = new Product("AirPods Pro", "Apple", "Headphones", "AH9902", 21412495, 999, true);
    }

    private static void classMethod() {
        //Metoda klasowa - rejestracja klienta
        System.out.println("\nRejestracja klienta na mail - s20568@pjwstk.edu.pl:");
        Client.registerClient("s20568@pjwstk.edu.pl", "kubslu1");
    }
}
