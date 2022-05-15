/*
    @author Jakub Slusarski, s20568, 20c
*/

import java.time.LocalDate;
import java.util.List;

public class Order {

    final int minOrderNumber = 1; //Atrybut klasowy
    final int maxOrderNumber = 10000; //Atrybut klasowy
    Client client; //Atrybut złozony
    int orderNumber;
    int orderAmount; //Atrybut pochodny
    LocalDate orderTime; //Atrybut złożony
    List<Product> orderedProducts; //Atrybut powtarzalny
    String orderStatus, paymentType, deliveryType;

    public Order(Client client, List<Product> orderedProducts, String orderStatus, String paymentType, String deliveryType) {
        this.client = client;
        this.orderNumber = (int) (Math.random() * (maxOrderNumber-minOrderNumber+1)+minOrderNumber);
        this.orderAmount = setOrderAmount(orderedProducts);
        this.orderTime = LocalDate.now();
        this.orderedProducts = orderedProducts;
        this.orderStatus = orderStatus;
        this.paymentType = paymentType;
        this.deliveryType = deliveryType;
    }

    public int setOrderAmount(List<Product> orderedProducts) {
        for (Product product : orderedProducts)
            orderAmount += product.price;
        return orderAmount;
    }

    //Przesłonięcie metod - metoda toString()
    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", orderTime=" + orderTime +
                ", orderedProducts=" + orderedProducts +
                ", orderAmount=" + orderAmount +
                ", orderStatus='" + orderStatus + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", deliveryType='" + deliveryType + '\'' +
                '}';
    }
}
