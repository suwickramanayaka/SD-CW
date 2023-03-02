package TASK1;

import java.io.*;
import java.util.*;

public class crusieShip {
    
    static Scanner input = new Scanner(System.in);
    static String[] cabin = new String[12];
    static int cabinNum = 0;
    static String passengerName;

    public static void main(String[] args) {
        initialise(cabin);
        Menu();
    }

    private static void Menu() {
        System.out.println();
        System.out.println("|***********************Menu***********************|");
        System.out.println(" V: View all cabins");
        System.out.println(" A: Add a passenger to a task3Cabin");
        System.out.println(" E: Display empty cabins");
        System.out.println(" D: Delete passenger from a task3Cabin");
        System.out.println(" F: Find a task3Cabin from passenger name");
        System.out.println(" S: Store program data into file");
        System.out.println(" L: Load program data from file");
        System.out.println(" O: View passengers ordered alphabetically by name");
        System.out.println(" EX: Exit the program");
        System.out.println("|**********************************************|");
        validate();
    }

    private static void validate() {
        System.out.println();
        System.out.print("Choose Option: ");
        String option = input.nextLine();
        option = option.toUpperCase();

        label:
        while (true) {
            switch (option) {
                case "V":
                    View(cabin);
                    break label;
                case "A":
                    Add(cabin);
                    break label;
                case "E":
                    Empty(cabin);
                    break label;
                case "D":
                    Delete(cabin);
                    break label;
                case "F":
                    Find(cabin);
                    break label;
                case "S":
                    Store(cabin);
                    break label;
                case "L":
                    Load();
                    break label;
                case "O":
                    Ordered(cabin);
                    break label;
                case "EX":
                    break label;
                default:
                    System.out.println("Invalid input");
                    break label;
            }
        }
        System.out.println();
        // Prompting user whether he need to continue the program.
        System.out.println("Do you like to continue? answer(Y[yes] or N[no]): ");
        String answer = input.next();
        answer = answer.toLowerCase();
        if (answer.equals("y")) {
            input.nextLine();
            Menu();
        }
        if (answer.equals("n")) {
            System.out.println("|***********************THANK YOU***********************|");
        }
    }

    private static void initialise(String[] array) {
        // Emptying the array indexes.
        for (int i = 0; i < array.length; i++) {
            array[i] = "Empty";
        }
    }

    private static void View(String[] array) {
        System.out.println("***********************CABINS WITH PASSENGERS***********************");
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("Empty")) {
                System.out.println("Cabin number " + (i + 1) + " is empty");
            } else {
                System.out.println("Cabin number " + (i + 1) + " is occupied by " + array[i]);
            }
            System.out.println();
        }
        System.out.println("**********************************************");
    }

    private static void Add(String[] array) {
        System.out.println("***********************ADD PASSENGERS***********************|");
        System.out.println();
        System.out.print("Enter a task3Cabin number between (1-12): ");
        cabinNum = input.nextInt();
        while (true) {
            if (cabinNum >= 1 && cabinNum <= 12) {
                break;
            } else {
                System.out.println("Invalid task3Cabin number");
                System.out.print("Enter a task3Cabin number between (1-12): ");
                cabinNum = input.nextInt();
            }
        }
        // Checking whether cabins are full or not.
        boolean cabinFull = false;
        for (String s : array) {
            if (s.equals("Empty")) {
                cabinFull = false;
                break;
            } else {
                cabinFull = true;
            }
        }
        if (!cabinFull) {
            System.out.print("Enter a name to book the task3Cabin - " + cabinNum + ": ");
            array[cabinNum - 1] = input.next();

            System.out.println();
            System.out.println("|***********************task3Passenger Details have been Added***********************|");

        } else {
            System.out.println();
            System.out.println("|***********************Cabins are Full***********************| ");
        }
    }

    private static void Empty(String[] array) {
        System.out.println("|***********************EMPTY ROOMS***********************|");
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals("Empty")) {
                System.out.println("Cabin number " + (i + 1) + " is empty");
            }
        }
        System.out.println();
        System.out.println("|**********************************************|");
    }

    private static void Delete(String[] array) {
        System.out.println("|***********************REMOVE CABIN***********************|");
        System.out.println();
        System.out.print("Enter which task3Cabin do you want to delete: ");
        cabinNum = input.nextInt();
        while (cabinNum < 1 || cabinNum > 12) {
            System.out.println("Invalid Cabin number! Try again.");
            System.out.print("Enter a task3Cabin number between (1-12): ");
            cabinNum = input.nextInt();
        }
        // Clearing the passenger details
        array[cabinNum - 1] = "Empty";
        System.out.println("task3Passenger deleted from the task3Cabin number " + (cabinNum) + ".");
        System.out.println();
        System.out.println("|**********************************************|");
    }

    private static void Find(String[] array) {
        System.out.println("|***********************FIND PASSENGER***********************|");
        System.out.println();
        System.out.print("Enter passenger's name: ");
        passengerName = input.nextLine();
        while (true) {
            // Checks whether passengerName contains alphabetical letters or not.
            if (passengerName.matches("^[a-z A-Z]*$")) {
                break;
            } else {
                System.out.println("Invalid Input");
                System.out.print("Enter task3Passenger's name: ");
                passengerName = input.nextLine();
            }
        }
        // loop through the array and checks for the passenger name.
        boolean found = true;
        for (int i = 0; i < 12; i++) {
            if (array[i].equals(passengerName)) {
                System.out.println(passengerName + " is in the task3Cabin number " + (i + 1));
                found = true;
                break;
            } else {
                found = false;
            }
        }
        if (!found) {
            System.out.println("Entered task3Passenger " + passengerName + " was Not found.");
        }
        System.out.println();
        System.out.println("|*********************************************|");
    }

    private static void Store(String[] array) {
        // Storing the data in a text file
        try {
            FileWriter filewriter = new FileWriter("Output.txt");
            filewriter.write("|**********************task3Cabin DATA**********************|" + "\n");
            filewriter.write("\n");
            for (int i = 0; i < 12; i++) {
                if (array[i].equals("Empty")) {
                    filewriter.write("*********************************************" + "\n");
                    filewriter.write("task3Cabin number " + (i + 1) + " is empty \n");
                } else {
                    filewriter.write("*********************************************" + "\n");
                    filewriter.write("task3Cabin number " + (i + 1) + " is occupied by " + array[i] + "\n");
                }
                filewriter.write("*********************************************" + "\n");
                filewriter.write("\n");
            }
            filewriter.close();
            System.out.println("Successfully Stored in a file");
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    private static void Load() {
        // Loading data of the Stored file.
        System.out.println("LOADED DATA: ");
        try {
            File object = new File("Output.txt");
            Scanner reader = new Scanner(object);
            while (reader.hasNextLine()) {
                String info = reader.nextLine();
                System.out.println(info);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        System.out.println("|*********************************************| ");
    }

    private static void Ordered(String[] array) {
        System.out.println("|***********************ALPHABETICALLY ORDERED LIST OF PASSENGERS***********************|");
        System.out.println();
        String[] temp_arr = new String[array.length];
        for (int i = 0; i < array.length; i++) { // to get array clone without referencing
            temp_arr[i] = array[i];
        }
        // sorting the array
        String temp;
        for (int j = 0; j < temp_arr.length; j++) {
            for (int i = 1; i < temp_arr.length; i++) {
                if (temp_arr[i - 1].compareToIgnoreCase(temp_arr[i]) > 0) {
                    temp = temp_arr[i - 1];
                    temp_arr[i - 1] = temp_arr[i];
                    temp_arr[i] = temp;
                }
            }
        }
        // leaving the empty cabins and Printing the cabins in passengers only.
        for (String s : temp_arr) {
            if (!s.equals("Empty")) {
                for (int y = 0; y < temp_arr.length; y++) {
                    if (s.equals(array[y])) {
                        System.out.println(s + " has occupied room number " + (y + 1));
                    }
                }
            }
        }
        System.out.println();
        System.out.println("||*********************************************||");
    }
}
