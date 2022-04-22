import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    int orderNumber;
    LocalDate orderTime;
    List<Product> orderedProducts; //Atrybut złożony
    String orderStatus, paymentType, deliveryType;

    public Order(int orderNumber, Date orderTime, List<Product> orderedProducts, String orderStatus, String paymentType, String deliveryType) {
        this.orderNumber = orderNumber;
        this.orderTime = LocalDate.now();
        this.orderedProducts = orderedProducts;
        this.orderStatus = orderStatus;
        this.paymentType = paymentType;
        this.deliveryType = deliveryType;
    }

    private static List<Order> extent = new ArrayList<>();
    private static void addClient(Order order) {
        extent.add(order);
    }

    static void showExtent(){
        System.out.println("Extent of the class: " + Order.class.getName());

        for (Order order : extent) {
            System.out.println(order);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderTime=" + orderTime +
                ", orderedProducts=" + orderedProducts +
                ", orderStatus='" + orderStatus + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                '}';
    }
}
