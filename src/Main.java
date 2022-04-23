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

public class Main {
    public static void main(String[] args) {

        final String extentFile = "src\\extent.bin";

        //Przeciążanie metod - konstruktory
        Client client1 = new Client("Jakub", "Slusarski", "s20568@pjwstk.edu.pl", "Koszykowa 86, 12-345, Warszawa", 123456789, false);
        Client client2 = new Client("Jan", "Kowalski", "janekkowal12", "jan.kowalski@gmail.com", "Sloneczna 1, 09-876 Bytom", 739105489, true);

        //Trwałość ekstensji - zapisywanie do pliku i odczytywanie z pliku
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(extentFile));
            Client.writeExtent(output);
            output.close();

            ObjectInputStream input = new ObjectInputStream(new FileInputStream(extentFile));
            Client.readExtent(input);
            input.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        Client.showExtent();

        //Metoda klasowa - rejestracja klienta
        System.out.println("\nRejestracja klienta na mail: s20568@pjwstk.edu.pl");
        Client.registerClient("s20568@pjwstk.edu.pl", "kubslu1");
        Client.showExtent();

        Product product1 = new Product("iPhone 13", "Appple", "Smartphone", "AP4129", 995120120, 4799, true);
        Product product2 = new Product("Galaxy S22", "Samsung", "Smartphone", "SP58124", 7741289, 3999, false);
        Product product3 = new Product("MacBook Pro", "Apple", "Laptop", "AL1120", 15125152, 8999, true);
        Product product4 = new Product("AirPods Pro", "Apple", "Headphones", "AH9902", 21412495, 999, true);

        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(extentFile));
            Product.writeExtent(output);
            output.close();

            ObjectInputStream input = new ObjectInputStream(new FileInputStream(extentFile));
            Product.readExtent(input);
            input.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();
        Product.showExtent();

        //Metoda klasowa - zmiana dostępności produktu
        System.out.println("\nZmiana dostępności produktu: Samsung Galaxy S22");
        Product.changeAvailability("SP58124", true);
        Product.showExtent();

        List<Product> orderedProducts1 = new ArrayList<>();
        List<Product> orderedProducts2 = new ArrayList<>();

        orderedProducts1.add(product1);
        orderedProducts1.add(product4);
        orderedProducts2.add(product3);

        Order order1 = new Order(client1, orderedProducts1, "Nowe", "Za pobraniem", "Kurier");
        Order order2 = new Order(client2, orderedProducts2, "Wysłane", "Przelew", "Paczkomat");
        System.out.println();
        System.out.println(order1);
        System.out.println(order2);
    }
}
