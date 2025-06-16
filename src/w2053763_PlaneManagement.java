import java.util.Scanner; // Importing the scanner.

public class w2053763_PlaneManagement {
    private static int[] seats_plan_array = new int[52]; // Array to store seat details.
    private static Ticket[] ticket_plan_array = new Ticket[52]; // Ticket Array.
    private static Scanner scan = new Scanner(System.in); // Scanner.
    public static void main(String[] args) {

        // Welcome message.
        System.out.println("Welcome to the Plane Management application");


        // Menu options.
        int option;
        while(true) {

            // Printing the menu.
            System.out.println("***************************************");
            System.out.println("*     MENU OPTION     *");
            System.out.println("***************************************");
            System.out.println("");
            System.out.println("1) Buy a seat");
            System.out.println("2) Cancel a seat");
            System.out.println("3) Find first available seat");
            System.out.println("4) Show seating plan");
            System.out.println("5) Print tickets information and total sales");
            System.out.println("6) Search ticket");
            System.out.println("0) Exit");

            System.out.println("");
            System.out.println("***************************************");
            System.out.print("Please select an option: ");

            try {
                option = scan.nextInt(); // Asking for user options.
                scan.nextLine();
            }catch (Exception error){
                scan.nextLine();
                continue;
            }

            // Checking user option and calling relevant methode.
            if (option == 1){ // EX-user pressed 1 buy seat will be called.
                buy_seat();
            } else if (option == 2) {
                cancel_seat();
            } else if (option == 3) {
                find_first_available();
            } else if (option == 4){
                show_seating_plan();
            } else if (option == 5){
                print_ticket_info();
            } else if (option == 6) {
                search_ticket();
            } else if (option == 0) {
                System.out.println("Thank you for using our Airline !");
                return;
            }else{
                System.out.println("Enter 1 - 6 ");
            }

        }
    }

    // Creating method to buy seat.
    private static void buy_seat(){
        // Creating variables.
        String row_letter;
        int seat_number;
        do {
            System.out.println("Enter your row letter"); // Asking for row letter.
            row_letter = scan.nextLine().toUpperCase();

            if (row_letter.equals("A") || row_letter.equals("B") || row_letter.equals("C") || row_letter.equals("D")){
                break; // Validating and exit the loop.
            }

        }while (true);

        do {
            try {
                System.out.println("Enter your seat number");
                seat_number = scan.nextInt();
                scan.nextLine();
            }catch (Exception error){
                scan.nextLine();
                continue;
            }

            if (row_letter.equals("A") || row_letter.equals("D")){
                if (seat_number < 15){
                    break; // Validating and exit the loop.
                }
            }

            else if (row_letter.equals("C") || row_letter.equals("B")){
                if (seat_number < 13){
                    break; // Validating and exit the loop.
                }
            }
        }while (true);

        // Price rate.
        int price = 0;
        if (seat_number <= 5){
            price = 200;
        } else if (seat_number <= 9){
            price = 150;
        } else if (seat_number <= 14) {
            price = 180;
        }

        // If row is "A"
        if (row_letter.equals("A")){
            if (seats_plan_array[seat_number - 1] == 1){ // Checking if the seat is already booked.
                System.out.println("Sorry! This seat was already booked");
            } else if (seats_plan_array[seat_number - 1] == 0) { // Checking if the seat is already available.

                // Asking for user details.
                System.out.println("Please enter your name:");
                String name = scan.nextLine();
                System.out.println("Please enter your surname:");
                String surname = scan.nextLine();
                System.out.println("Please enter your E-mail:");
                String email = scan.nextLine();

                // Creating person object.
                Person person = new Person(name,surname,email);

                // Finding empty space in ticket array and creating object.
                for (int i = 0; i < 52; i++) {
                    if (ticket_plan_array[i] == null){
                        ticket_plan_array[i] = new Ticket(row_letter, seat_number, price, person);
                        ticket_plan_array[i].save(); // Saving text file.
                        break; // Exiting the loop.
                    }
                }
                seats_plan_array[seat_number - 1] = 1; // Updating array.
                System.out.println("Your seat has been booked !");
                System.out.println("Thank You");
            }

            // If row is "B"
        } else if (row_letter.equals("B")){
            if (seats_plan_array[14 + seat_number - 1] == 1){ // Checking if the seat is already booked.
                System.out.println("Sorry! This seat was already booked");
            } else if (seats_plan_array[14 + seat_number - 1] == 0) {  // Checking if the seat is already available.

                // Asking for user details.
                System.out.println("Please enter your name:");
                String name = scan.nextLine();
                System.out.println("Please enter your surname:");
                String surname = scan.nextLine();
                System.out.println("Please enter your E-mail:");
                String email = scan.nextLine();

                // Creating person object.
                Person person = new Person(name,surname,email);

                for (int i = 0; i < 52; i++) {
                    if (ticket_plan_array[i] == null) {
                        ticket_plan_array[i] = new Ticket(row_letter, seat_number, price, person);
                        ticket_plan_array[i].save();
                        break;
                    }
                }
                seats_plan_array[14 + seat_number - 1] = 1;
                System.out.println("Your seat has been booked !");
                System.out.println("Thank you");
            }

            // If row is "C"
        } else if (row_letter.equals("C")) {
            if (seats_plan_array[26 + seat_number - 1] == 1) { // Checking if the seat is already booked.
                System.out.println("Sorry! This seat was already booked");
            } else if (seats_plan_array[26 + seat_number - 1] == 0) {// Checking if the seat is already available.

                // Asking for user details.
                System.out.println("Please enter your name:");
                String name = scan.nextLine();
                System.out.println("Please enter your surname:");
                String surname = scan.nextLine();
                System.out.println("Please enter your E-mail:");
                String email = scan.nextLine();

                Person person = new Person(name,surname,email);

                for (int i = 0; i < 52; i++) {
                    if (ticket_plan_array[i] == null) {
                        ticket_plan_array[i] = new Ticket(row_letter, seat_number, price, person);
                        ticket_plan_array[i].save();
                        break;
                    }
                }
                seats_plan_array[26 + seat_number - 1] = 1;
                System.out.println("Your seat has been booked !");
                System.out.println("Thank you");
            }

            // If row is "D"
        } else{
            if (seats_plan_array[38 + seat_number - 1] == 1){
                System.out.println("Sorry! This seat was already booked");
            } else if (seats_plan_array[38 + seat_number - 1] == 0) {

                // Asking for user details.
                System.out.println("Please enter your name:");
                String name = scan.nextLine();
                System.out.println("Please enter your surname:");
                String surname = scan.nextLine();
                System.out.println("Please enter your E-mail:");
                String email = scan.nextLine();

                Person person = new Person(name,surname,email);

                for (int i = 0; i < 52; i++) {
                    if (ticket_plan_array[i] == null) {
                        ticket_plan_array[i] = new Ticket(row_letter, seat_number, price, person);
                        ticket_plan_array[i].save();
                        break;
                    }
                }
                seats_plan_array[38 + seat_number - 1] = 1;
                System.out.println("Your seat has been booked !");
                System.out.println("Thank you");
            }
        }
    }

    // Creating method to cancle seat.
    private static void cancel_seat(){
        String row_letter;
        int seat_number;
        do {
            System.out.println("Enter your row letter");
            row_letter = scan.nextLine().toUpperCase();

            if (row_letter.equals("A") || row_letter.equals("B") || row_letter.equals("C") || row_letter.equals("D")){
                break;
            }

        }while (true);

        do {
            try {
                System.out.println("Enter your seat number");
                seat_number = scan.nextInt();
                scan.nextLine();
            }catch (Exception error){
                scan.nextLine();
                continue;
            }

            if (row_letter.equals("A") || row_letter.equals("D")){
                if (seat_number < 15){
                    break;
                }
            }

            else if (row_letter.equals("C") || row_letter.equals("B")){
                if (seat_number < 13){
                    break;
                }
            }
        }while (true);

        if (row_letter.equals("A")){ // If row letter is "A"
            if (seats_plan_array[seat_number - 1] == 0){ // If the seat is not booked.
                System.out.println("This seat is not booked !");
            } else if (seats_plan_array[seat_number - 1] == 1) { // If the seat is booked, cancle it.
                seats_plan_array[seat_number - 1] = 0; // updating the array.

                // updating the ticket array to empty.
                for (int i = 0; i < 52; i++) {
                    if (ticket_plan_array[i] != null) {
                        if (ticket_plan_array[i].getRow().equals(row_letter) && ticket_plan_array[i].getSeat() == seat_number){
                            ticket_plan_array[i] = null;
                            break;
                        }
                    }
                }

                System.out.println("booked canceled !");
                System.out.println("Thank You");
            }
        } else if (row_letter.equals("B")){
            if (seats_plan_array[14 + seat_number - 1] == 0){
                System.out.println("This seat is not booked !");
            } else if (seats_plan_array[14 + seat_number - 1] == 1) {
                seats_plan_array[14 + seat_number - 1] = 0;

                for (int i = 0; i < 52; i++) {
                    if (ticket_plan_array[i] != null) {
                        if (ticket_plan_array[i].getRow().equals(row_letter) && ticket_plan_array[i].getSeat() == seat_number){
                            ticket_plan_array[i] = null;
                            break;
                        }
                    }
                }

                System.out.println("Booked canceled !");
                System.out.println("Thank you");
            }
        } else if (row_letter.equals("C")) {
            if (seats_plan_array[26 + seat_number - 1] == 0) {
                System.out.println("This seat is not booked !");
            } else if (seats_plan_array[26 + seat_number - 1] == 1) {
                seats_plan_array[26 + seat_number - 1] = 0;

                for (int i = 0; i < 52; i++) {
                    if (ticket_plan_array[i] != null) {
                        if (ticket_plan_array[i].getRow().equals(row_letter) && ticket_plan_array[i].getSeat() == seat_number){
                            ticket_plan_array[i] = null;
                            break;
                        }
                    }
                }

                System.out.println("Booked canceled !");
                System.out.println("Thank you");
            }

        } else{
            if (seats_plan_array[38 + seat_number - 1] == 0){
                System.out.println("This seat is not booked !");
            } else if (seats_plan_array[38 + seat_number - 1] == 1) {
                seats_plan_array[38 + seat_number - 1] = 0;

                for (int i = 0; i < 52; i++) {
                    if (ticket_plan_array[i] != null) {
                        if (ticket_plan_array[i].getRow().equals(row_letter) && ticket_plan_array[i].getSeat() == seat_number){
                            ticket_plan_array[i] = null;
                            break;
                        }
                    }
                }

                System.out.println("Booked canceled !");
                System.out.println("Thank you");
            }
        }
    }

    // Creating find first available seat.
    private static void find_first_available(){

        // Looping through seats.
        for (int i = 0; i < 52; i++) {
            if (seats_plan_array[i] == 0){
                String row_letter_find;
                int seat_number_find;
                if (i < 14){ // Finding relevent row letter and seat number.
                    row_letter_find ="A";
                    seat_number_find = i + 1;
                } else if (i < 26){
                    row_letter_find ="B";
                    seat_number_find = i - 13;
                } else if (i < 38) {
                    row_letter_find = "C";
                    seat_number_find = i - 25;
                } else{
                    row_letter_find = "D";
                    seat_number_find = i - 37;
                }
                System.out.println("First available seat is: " + row_letter_find + seat_number_find); // Printing first available seat.
                break; // Exiting the loop.
            }

        }

    }

    // Creating method to show seating plan.
    private static void show_seating_plan(){

        // Looping through the area for row "A"
        // If seat is 0, show O. If seat is 1, show X.
        for (int i = 0; i < 14; i++) {
            if (seats_plan_array[i] == 0){
                System.out.print(" O");
            } else if (seats_plan_array[i] == 1) {
                System.out.print(" X");
            }
        }
        System.out.println();

        // Looping through the area for row "B"
        // If seat is 0, show O. If seat is 1, show X.
        for (int i = 14; i < 26; i++) {
            if (seats_plan_array[i] == 0){
                System.out.print(" O");
            } else if (seats_plan_array[i] == 1) {
                System.out.print(" X");
            }
        }
        System.out.println();

        // Looping through the area for row "C"
        // If seat is 0, show O. If seat is 1, show X.
        for (int i = 26; i < 38; i++) {
            if (seats_plan_array[i] == 0){
                System.out.print(" O");
            } else if (seats_plan_array[i] == 1) {
                System.out.print(" X");
            }
        }
        System.out.println();

        // Looping through the area for row "D"
        // If seat is 0, show O. If seat is 1, show X.
        for (int i = 38; i < 52; i++) {
            if (seats_plan_array[i] == 0){
                System.out.print(" O");
            } else if (seats_plan_array[i] == 1) {
                System.out.print(" X");
            }
        }
        System.out.println();
    }

    // creating method for print ticket info.
    private static void print_ticket_info(){
        int total_price = 0;

        // Looping through ticket array.
        for (int i = 0; i < ticket_plan_array.length; i++) {
            if (ticket_plan_array[i] != null){ // If not empty, show details.
                System.out.println("Row letter " + ticket_plan_array[i].getRow());
                System.out.println("Seat letter" + ticket_plan_array[i].getSeat());
                System.out.println("Price" + ticket_plan_array[i].getPrice());
                System.out.println("First Name" + ticket_plan_array[i].getPerson().getName());
                System.out.println("Surname" + ticket_plan_array[i].getPerson().getSurname());
                System.out.println("Email" + ticket_plan_array[i].getPerson().getEmail());
                total_price = total_price + ticket_plan_array[i].getPrice();
            }
        }
        System.out.println();
        System.out.println("Total Price:" + total_price); // Print the total.
        System.out.println();
    }

    // Creating the search ticket.
    private static void search_ticket(){
        String row_letter;
        int seat_number;
        do {
            System.out.println("Enter your row letter");
            row_letter = scan.nextLine().toUpperCase();

            if (row_letter.equals("A") || row_letter.equals("B") || row_letter.equals("C") || row_letter.equals("D")){
                break;
            }

        }while (true);

        do {
            try {
                System.out.println("Enter your seat number");
                seat_number = scan.nextInt();
                scan.nextLine();
            }catch (Exception error){
                scan.nextLine();
                continue;
            }

            if (row_letter.equals("A") || row_letter.equals("D")){
                if (seat_number < 15){
                    break;
                }
            }

            else if (row_letter.equals("C") || row_letter.equals("B")){
                if (seat_number < 13){
                    break;
                }
            }
        }while (true);

        // Looping through ticket array.
        for (int i = 0; i < ticket_plan_array.length; i++) { // Ticket array.

            // Checking for row letter and seat number.
            if (ticket_plan_array[i] != null && ticket_plan_array[i].getRow().equals(row_letter) && ticket_plan_array[i].getSeat() == seat_number){

                // Printing ticket details.
                System.out.println("Row letter " + ticket_plan_array[i].getRow());
                System.out.println("Seat letter" + ticket_plan_array[i].getSeat());
                System.out.println("Price" + ticket_plan_array[i].getPrice());
                System.out.println("First Name" + ticket_plan_array[i].getPerson().getName());
                System.out.println("Surname" + ticket_plan_array[i].getPerson().getSurname());
                System.out.println("Email" + ticket_plan_array[i].getPerson().getEmail());

            }

        }

    }
}