import java.io.FileWriter; // Importing relevant modules.
import java.io.IOException;

public class Ticket {

    // Creating attributes.
    private String row;

    private int seat;

    private int price;

    private Person person;

    // Creating constructor.
    Ticket(String row, int seat, int price, Person person){
        this.row = row;

        this.seat  = seat;

        this.price = price;

        this.person = person;
    }

    // Creating getters.
    public String getRow() {
        return row;
    }

    // Creating getters.
    public int getSeat() {
        return seat;
    }

    // Creating getters.
    public int getPrice() {
        return price;
    }

    // Creating getters.
    public Person getPerson() {
        return person;
    }

    // Creating method to save file.
    public void save(){
        try{
            FileWriter file = new FileWriter(row + seat + ".txt");
            file.write("Row : " + row);
            file.write("\n");
            file.write("Seat : " + seat);
            file.write("\n");
            file.write("Price : " + price);
            file.write("\n");
            file.write("Name : " + person.getName());
            file.write("\n");
            file.write("Surname : " + person.getSurname());
            file.write("\n");
            file.write("Email : " + person.getEmail());
            file.write("\n");
            file.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
