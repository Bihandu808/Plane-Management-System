public class Person {

    // Creating atribute.
    private String name;

    private String surname;

    private String email;

    // Creating constructor.
    Person(String name, String surname, String email){
        this.name = name;

        this.surname = surname;

        this.email = email;
    }

    // Creating getters.
    public String getName() {
        return name;
    }

    // Creating getters.
    public String getSurname() {
        return surname;
    }

    // Creating getters.
    public String getEmail() {
        return email;
    }
}

