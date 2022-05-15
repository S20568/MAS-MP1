/*
    @author Jakub Slusarski, s20568, 20c
*/

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client extends Person implements Serializable {

    String login; //Atrybut opcjonalny
    String email, address;
    int phoneNumber;
    boolean isRegistered;

    //Przeciążanie metod - Konstruktory
    public Client(String name, String surname, String email, String address, int phoneNumber, boolean isRegistered) {
        super(name, surname);
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isRegistered = isRegistered;
        addClient(this);
    }

    public Client(String name, String surname, String login, String email, String address, int phoneNumber, boolean isRegistered) {
        super(name, surname);
        this.login = login;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isRegistered = isRegistered;
        addClient(this);
    }

    //Ekstensja - dodawanie obiektów do ekstensji
    private static List<Client> extent = new ArrayList<>();
    private static void addClient(Client client) {
        extent.add(client);
    }

    //Ekstensja - wyświetlanie ekstensji
    static void showExtent(){
        System.out.println("Extent of the class: " + Client.class.getName());

        for (Client client : extent) {
            System.out.println(client);
        }
    }

    //Ekstensja - trwałość ekstensji
    static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        extent = (ArrayList<Client>)stream.readObject();
    }

    //Metoda klasowa - Rejestracja klienta
    public static void registerClient(String email, String login){
        for (Client client : extent) {
            if(client.email.equals(email)) {
                client.login = login;
                client.isRegistered = true;
            }
        }
    }

    //Przesłonięcie metod - metoda toString()
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login=" + login +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber= +48 " + phoneNumber +
                ", isRegistered=" + isRegistered +
                '}';
    }
}
