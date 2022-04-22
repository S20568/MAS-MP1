public abstract class Person {
    String name, surname;

    public Person(String name, String surname){
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
