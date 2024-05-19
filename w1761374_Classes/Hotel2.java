//Importing the libraries
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Hotel2 {


    public static void main(String[] args) {

        Room[] hotel = new Room[8];
        HotelWaiting2 q = new HotelWaiting2();

        initialise(hotel);
        menuSection(hotel,q);
    }

    //creating private methods for initialise
    private static void initialise(Room[] hotelRef) {

        for (int y = 0; y < 8; y++) {
            hotelRef[y] = new Room("k","k",new Person("k","k","k"));
        }
    }

    //creating private methods to addCustomers
    private static void addCustomers(Room[] hotel,HotelWaiting2 q) {

        Scanner input = new Scanner(System.in);
        int roomNum = 0;
        String guest;
        String fisrtName;
        String lastName;
        String cardNumber;
        String roomName;

        int full = 0;


        //addCustomers
        for (int x = 0; x < 8; x++) {
            if (!hotel[x].getRoomName().equalsIgnoreCase("e")) {
                full += 1;
            }
        }


        while (roomNum < 9) {

            System.out.println("Enter room number (1-8) or 9 to stop:");
            roomNum = input.nextInt();
            if (roomNum > 8) {
                break;
            }
            System.out.println("Enter name for room " + roomNum + " :");
            roomName = input.next();
            if (roomNum > 0 && roomNum < 9) {
                System.out.println("Enter number of guests ");
                guest = input.nextLine();
                System.out.println("Enter payer first name ");
                fisrtName = input.nextLine();
                System.out.println("Enter payer last name ");
                lastName = input.nextLine();
                System.out.println("Enter payer card number ");
                cardNumber = input.nextLine();

                if (full < 8) {
                    hotel[roomNum - 1] = new Room(roomName,guest,new Person(fisrtName,lastName,cardNumber));
                } else {
                    q.enQueue(new Room(roomName,guest,new Person(fisrtName,lastName,cardNumber)));
                }
            }
        }

    }

    //creating private methods for viewRooms
    private static void viewRooms(Room[] hotel) {
        for (int x = 0; x < 8; x++) {
            if (hotel[x].getRoomName().equals("e")) {
                System.out.println("room " + x + " is empty");
            } else {
                System.out.println("room " + x + " occupied by " + hotel[x].getRoomName());
            }
        }
    }

    //creating private methods for menuSection
    private static void menuSection(Room[] hotel,HotelWaiting2 q) {

        Scanner input = new Scanner(System.in);
        String selection;

        boolean state = true;

        while (state) {
            System.out.println("Enter the the menu number that you want to select");
            System.out.println("A - Add customers");
            System.out.println("V - View all rooms");
            System.out.println("E - Display empty rooms");
            System.out.println("D - Delete customer from room");
            System.out.println("F - Find room from customer name");
            selection = input.nextLine();

            if (selection.equalsIgnoreCase("A")) {
                addCustomers(hotel,q);
            } else if (selection.equalsIgnoreCase("V")) {
                viewRooms(hotel);
            } else if (selection.equalsIgnoreCase("E")) {
                displayEmptyrooms(hotel);
            } else if (selection.equalsIgnoreCase("D")) {
                deleteCutomer(hotel,q);
            } else if (selection.equalsIgnoreCase("F")) {
                findRoomForCustomer(hotel);
            } else {
                System.out.println("Please add a correct value. Try again");
            }
        }
    }

    //creating private methods for displayEmptyrooms
    private static void displayEmptyrooms(Room[] hotel) {

        for (int x = 0; x < 8; x++) {
            if (hotel[x].getRoomName().equals("e")) {
                System.out.println("room " + x + " is empty");
            }
        }

    }

    //creating private methods for deleteCutomer
    private static void deleteCutomer(Room[] hotel,HotelWaiting2 q) {

        Scanner input = new Scanner(System.in);
        int roomNum = 0;

        while (roomNum < 9) {

            System.out.println("Enter room number (1-8) or 9 to stop:");
            roomNum = input.nextInt();

            if (roomNum > 0 && roomNum < 9) {
                if (!q.isEmpty()) {
                    Room obj = q.deQueue();
                    hotel[roomNum - 1] = obj;
                } else {
                    hotel[roomNum - 1] = new Room("e","e",new Person("e","e","e"));
                }
            }

        }

    }

    //creating private methods for find room for customer
    private static void findRoomForCustomer(Room[] hotel) {

        Scanner input = new Scanner(System.in);
        String name;

        System.out.println("Enter customer name");
        name = input.nextLine();

        for (int x = 0; x < 8; x++) {
            if (hotel[x].getRoomName().equals(name)) {
                System.out.println("Room " + x + 1 + " was occupied by " + name);
            }
        }

    }

    //creating private methods for store program in to file path
    private static void StoreProgramDataInToFile(Room[] hotel) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter("C:/Users/Hp - Pavilion/Desktop/CW/w1761374_Classes/outputfile.txt"))) {

            for (int x = 0; x < 8; x++) {
                out.println("Name and Room number is: " + hotel[x].getRoomName() + "at: " + x);

            }
        }
        System.out.println("All Room Names have been Saved.");

    }

}