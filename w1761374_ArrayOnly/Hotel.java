//Importing the libraries
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Hotel {


    public static void main(String[] args) {
//creating 2 arrays
        String[][] hotel = new String[5][8];
        HotelWaiting q = new HotelWaiting();

        initialise(hotel);
        menuSection(hotel,q);


    }
    //creating private methods for initialise
    private static void initialise(String hotelRef[][]) {

        //initialaise
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 8; x++) {
                hotelRef[y][x] = "e";
            }
        }
    }

    //creating private methods to addCustomers
    private static void addCustomers(String[][] hotel, HotelWaiting q) {
        //for the user input create a scanner
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
            if (!hotel[0][x].equals("e")) {
                full += 1;
            }
        }


        while (roomNum < 9 ) {

            System.out.println("Enter room number (1-8) or 9 to stop:");
            roomNum = input.nextInt();

            if (roomNum > 8){
                break;
            }
            System.out.println("Enter name for room " + roomNum + " :");
            roomName = input.next();
            if (roomNum > 0 && roomNum < 9) {
                System.out.println("Enter number of guests ");
                guest = input.next();
                System.out.println("Enter payer first name ");
                fisrtName = input.next();
                System.out.println("Enter payer last name ");
                lastName = input.next();
                System.out.println("Enter payer card number ");
                cardNumber = input.next();

                if (full < 8) {
                    hotel[0][roomNum - 1] = roomName;
                    hotel[1][roomNum - 1] = guest;
                    hotel[2][roomNum - 1] = fisrtName;
                    hotel[3][roomNum - 1] = lastName;
                    hotel[4][roomNum - 1] = cardNumber;
                }
                else {
                    q.enQueue(roomName,guest,fisrtName,lastName,cardNumber);
                }
            }
        }

    }

    //creating private methods for viewRooms
    private static void viewRooms(String[][] hotel) {
        for (int x = 0; x < 8; x++) {
            if (hotel[0][x].equals("e")) {
                System.out.println("room " + x + " is empty");
            } else {
                System.out.println("room " + x + " occupied by " + hotel[0][x]);
            }
        }
    }

    //creating private methods for menuSection
    private static void menuSection(String[][] hotel, HotelWaiting q) {

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
            System.out.println("S-  Store To File :");
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
            }
//             else if (selection.equalsIgnoreCase("S")) {
//                StoreProgramDataInToFile(hotel);
//            }
            else {
                System.out.println("Please add a correct value. Try again");
            }
        }
    }

    //creating private methods for displayEmptyrooms
    private static void displayEmptyrooms(String[][] hotel) {

        for (int x = 0; x < 8; x++) {
            if (hotel[0][x].equals("e")) {
                System.out.println("room " + x + " is empty");
            }
        }

    }

    //creating private methods for deleteCutomer
    private static void deleteCutomer(String[][] hotel, HotelWaiting q) {

        Scanner input = new Scanner(System.in);
        int roomNum = 0;

        while (roomNum < 9) {

            System.out.println("Enter room number (1-8) or 9 to stop:");
            roomNum = input.nextInt();

            if (roomNum > 0 && roomNum < 9) {
                if (!q.isEmpty()) {
                    String[][] obj = q.deQueue();
                    hotel[0][roomNum - 1] = obj[0][0];
                    hotel[1][roomNum - 1] = obj[1][0];
                    hotel[2][roomNum - 1] = obj[2][0];
                    hotel[3][roomNum - 1] = obj[3][0];
                    hotel[4][roomNum - 1] = obj[4][0];
                }
                else {
                    hotel[0][roomNum - 1] = "e";
                    hotel[1][roomNum - 1] = "e";
                    hotel[2][roomNum - 1] = "e";
                    hotel[3][roomNum - 1] = "e";
                    hotel[4][roomNum - 1] = "e";
                }
            }

        }

    }

    //creating private methods for find room for customer
    private static void findRoomForCustomer(String[][] hotel) {

        Scanner input = new Scanner(System.in);
        String name;

        System.out.println("Enter customer name");
        name = input.nextLine();

        for (int x = 0; x < 6; x++) {
            if (hotel[x].equals(name)) {
                System.out.println("Room " + x + 1 + " was occupied by " + name);
            }
        }

    }

    //creating private methods for store program in to file path
    private static void StoreProgramDataInToFile(String[][] hotel) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter("C:/Users/Hp - Pavilion/Desktop/CW/w1761374_ArrayOnly/outputfile.txt"))) {

            for (int x = 0; x < 8; x++) {
                out.println("Name and Room number is: " + hotel[0][x] + "at: " + x);

            }
        }

        System.out.println("All Room Names have been Saved.");
    }



}