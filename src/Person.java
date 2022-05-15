import java.io.Serializable;

public abstract class Person implements Serializable {
    String name, surname;

    protected Person(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + name + '\'' +
                ", nazwisko='" + surname + '\'' +
                '}';
    }
}
