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
        final String extentFile = "extent.bin";

        //Przeciążanie metod - konstruktory
        Client client1 = new Client("Jakub", "Slusarski", "s20568@pjwstk.edu.pl", "Koszykowa 86, 12-345, Warszawa", 123456789, false);
        Client client2 = new Client("Jan", "Kowalski", "janekkowal12", "jan.kowalski@gmail.com", "Sloneczna 1, 09-876 Bytom", 739105489, true);
        Client client3 = new Client("Piotr", "Nowak", "piotrn@gmail.com", "Dobra 1, 01-234 Warszawa", 687903746, false);

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

        System.out.print("Stan poczatkowy ekstensji - Client:\n");
        Client.showExtent(); // Wyświetlanie ekstensji


        System.out.println("\nRejestracja klienta na mail - s20568@pjwstk.edu.pl:");
        //Metoda klasowa - rejestracja klienta
        Client.registerClient("s20568@pjwstk.edu.pl", "kubslu1"); // atrybut login jest atrybutem opcjonalnym
        Client.showExtent();

        System.out.println(client1); //Wykorzystanie przesłonięcia metody toString() w klasie Client

        Product product1 = new Product("iPhone 13", "Appple", "Smartphone", "AP4129", 995120120, 4799, true);
        Product product2 = new Product("Galaxy S22", "Samsung", "Smartphone", "SP58124", 7741289, 3999, false);
        Product product3 = new Product("MacBook Pro", "Apple", "Laptop", "AL1120", 15125152, 8999, true);
        Product product4 = new Product("AirPods Pro", "Apple", "Headphones", "AH9902", 21412495, 999, true);

        //Trwałość ekstensji - zapisywanie do pliku i odczytywanie z pliku
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
        System.out.println("\nStan początkowy ekstensji - Product:");
        Product.showExtent();


        System.out.println("\nZmiana dostępności produktu - Samsung Galaxy S22:");
        Product.changeAvailability("SP58124", true); //Metoda klasowa - zmiana dostępności produktu
        Product.showExtent();

        List<Product> orderedProducts1 = new ArrayList<>(); // atrybut powtarzalny
        List<Product> orderedProducts2 = new ArrayList<>(); // atrybut powtarzalny

        orderedProducts1.add(product1);
        orderedProducts1.add(product4);
        orderedProducts2.add(product3);

        Order order1 = new Order(client1, orderedProducts1, "Nowe", "Za pobraniem", "Kurier");
        Order order2 = new Order(client2, orderedProducts2, "Wysłane", "Przelew", "Paczkomat");

        System.out.println(order1.orderAmount); // "orderAmount" atrybut pochodny wyliczany na podstawie listy zamówionych produktów
        System.out.println("\nZłożone zamówienia:");
        System.out.println(order1);
        System.out.println(order2);

        System.out.println("Klient w zamówieniu nr 1 przed zmianą " + order1.client);
        order1.client = client3; // "client" atrybut złożony - zmiana klienta w zamówieniu
        System.out.println("Klient w zamówieniu nr 1 po zmianie " + order1.client);
    }
}
