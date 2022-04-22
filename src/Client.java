import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Client extends Person{

    Optional<String> login = Optional.empty(); //Atrybut opcjonalny
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
    }

    public Client(String name, String surname, String login, String email, String address, int phoneNumber, boolean isRegistered) {
        super(name, surname);
        this.login = Optional.of(login);
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isRegistered = isRegistered;
    }

    private static List<Client> extent = new ArrayList<>();
    private static void addClient(Client client) {
        extent.add(client);
    }

    static void showExtent(){
        System.out.println("Extent of the class: " + Client.class.getName());

        for (Client client : extent) {
            System.out.println(client);
        }
    }

    //Metoda klasowa - Rejestracja klienta
    public static void registerClient(String email, String login){
        for (Client client : extent) {
            if(client.email.equals(email)) {
                client.login = Optional.of(login);
                client.isRegistered = true;
            }
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                "login=" + login +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", isRegistered=" + isRegistered +
                '}';
    }
}
