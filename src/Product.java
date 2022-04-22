import java.util.ArrayList;
import java.util.List;

public class Product {

    String name, producer, description;
    int sku, serialNumber, price;
    boolean isAvailable;

    public Product(String name, String producer, String description, int sku, int serialNumber, int price, boolean isAvailable) {
        this.name = name;
        this.producer = producer;
        this.description = description;
        this.sku = sku;
        this.serialNumber = serialNumber;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    private static List<Product> extent = new ArrayList<>();
    private static void addClient(Product product) {
        extent.add(product);
    }

    static void showExtent(){
        System.out.println("Extent of the class: " + Product.class.getName());

        for (Product product : extent) {
            System.out.println(product);
        }
    }

    //Metoda klasowa - Zmiana dostępności
    public static void changeAvailability(int sku, boolean isAvailable) {
        for (Product product : extent) {
            if(product.sku == sku)
                product.isAvailable = isAvailable;
        }
    }

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
