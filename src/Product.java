/*
    @author Jakub Slusarski, s20568, 20c
*/

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Product implements Serializable {

    String name, producer, sku, description;
    int price;
    long serialNumber;
    boolean isAvailable;

    public Product(String name, String producer, String description, String sku, long serialNumber, int price, boolean isAvailable) {
        this.name = name;
        this.producer = producer;
        this.description = description;
        this.sku = sku;
        this.serialNumber = serialNumber;
        this.price = price;
        this.isAvailable = isAvailable;
        addProduct(this);
    }

    //Ekstensja - dodawanie obiektów do ekstensji
    private static List<Product> extent = new ArrayList<>();
    private static void addProduct(Product product) {
        extent.add(product);
    }

    //Ekstensja - wyświetlanie ekstensji
    static void showExtent(){
        System.out.println("Extent of the class: " + Product.class.getName());

        for (Product product : extent) {
            System.out.println(product);
        }
    }

    //Ekstensja - trwałość ekstensji
    static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Product>) stream.readObject();
    }

    //Metoda klasowa - Zmiana dostępności
    public static void changeAvailability(String sku, boolean newAvailability) {
        for (Product product : extent) {
            if(product.sku.equals(sku))
                product.isAvailable = newAvailability;
        }
    }

    //Przesłonięcie metod - metoda toString()
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", description='" + description + '\'' +
                ", sku=" + sku +
                ", serialNumber=" + serialNumber +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
