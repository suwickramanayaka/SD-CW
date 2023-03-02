package TASK2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class main {

    private static final Scanner Scan = new Scanner(System.in);

    public static void main(String[] args)
    {
        //cabin array
        cabin[] ship_cabin = new cabin[12];

        for (int i=0;i<12;i++)
        {
            ship_cabin[i]=new cabin();
        }

        initialise(ship_cabin);

        while (true)
        {
            String option1;
            String main_loop_input;

            while (true)
            {
                System.out.println("******************* Menu *******************\n");
                System.out.println("Enter [V] for Views All cabins");
                System.out.println("Enter [A] for Adds task3Passenger to task3Cabin");
                System.out.println("Enter [E] for Display Empty cabins");
                System.out.println("Enter [D] for Delete task3Passenger from task3Cabin");
                System.out.println("Enter [F] for Find task3Cabin from task3Passenger name");
                System.out.println("Enter [S] for Store program data into file");
                System.out.println("Enter [L] for Load program data from file");
                System.out.println("Enter [O] for View passengers Ordered alphabetically by name");
                System.out.println("Enter [T] for Expenses per passenger as well as the total expenses of all passengers");
                System.out.println("Enter [Q] for Quit the Menu \n");
                System.out.println("********************************************************************");
                System.out.print("Choose option : ");
                option1 = Scan.next().toUpperCase();
                if ((option1.equals("V")) |(option1.equals("A"))|(option1.equals("E"))|(option1.equals("D"))
                        |(option1.equals("F"))|(option1.equals("S"))|(option1.equals("L"))|(option1.equals("O"))
                        |(option1.equals("T"))|(option1.equals("Q")))
                {
                    break;
                }
                else
                {
                    System.out.println("Sorry! Invalid input");
                }
            }

            //Terminate
            switch (option1) {
                case "V" -> views_all_cabins(ship_cabin);
                case "A" -> adds_customer_to_cabin(ship_cabin);
                case "E" -> display_Empty_cabins(ship_cabin);
                case "D" -> delete_customer_from_cabin(ship_cabin);
                case "F" -> Find_customer_name(ship_cabin);
                case "S" -> Store_data_file(ship_cabin);
                case "L" -> Load_data_from_file();
                case "O" -> ordered_alphabetically_name(ship_cabin);
                case "T" -> expenses_print(ship_cabin);
                case "Q" -> {
                    System.out.println("\n\n----------------Thank you!----------------\n\n");
                    System.exit(0);
                }
            }
            System.out.println();


            while (true)
            {
                System.out.print("Do you like to continue? answer(Y[yes] or N[no]): " );
                main_loop_input = Scan.next().toUpperCase();
                if (main_loop_input.equals("Y") )
                {
                    break;
                }
                else if (main_loop_input.equals("N"))
                {
                    System.out.println("\n\n----------------Thank you!----------------\n\n");
                    System.exit(0); //Terminate
                }
                else
                {
                    System.out.println("Sorry! Invalid input");
                }
            }
        }
    }

    // Methods
    // task3Cabin initialise
    private static void initialise( cabin cabinRef[] )
    {
        for (int i = 0; i < 12; i++ )
        {
            cabinRef[i].setName("Empty") ;
            cabinRef[i].setcabin_num(i);
        }
        System.out.println( "initialise Done ");
    }

    // Views All cabins
    private static void views_all_cabins(cabin[] cabinRef)
    {
        String option;
        int choose_num;

        for (int i = 0; i < 12; i++ )
        {
            System.out.println("Cabin " + i +" "+ cabinRef[i].getName());
        }

        while (true)
        {
            System.out.println();
            System.out.println("Do you want to see passengers ?answer(Y[yes] or N[no]): ");
            option=Scan.next().toUpperCase();
            if (option.equals("Y") )
            {
                while (true)
                {
                    System.out.print("Enter Cabin number (0-11) or 12 to all passengers: " );
                    if (Scan.hasNextInt())
                    {
                        choose_num = Scan.nextInt();
                        if ((choose_num>=0) & (choose_num<=12))
                        {
                            break;
                        }
                        else
                        {
                            System.out.println("Sorry! Cabin number out of range ");
                        }
                    }
                    else
                    {
                        System.out.println("Wrong Invalid input");
                        Scan.next();
                    }
                }
                System.out.println("************************************************************");
                if (choose_num==12)
                {
                    for (int i = 0; i < 12; i++ )
                    {
                        System.out.println();
                        cabinRef[i].Passger_detils();
                        System.out.println("************************************************************");
                    }
                }
                else
                {
                    cabinRef[choose_num].Passger_detils();
                    System.out.println("************************************************************");
                }
                break;
            }
            else if (option.equals("N"))
            {
                break;
            }else
            {
                System.out.println("Sorry! Invalid input");
            }
        }
    }

    // Adds customer to task3Cabin method
    private static void adds_customer_to_cabin(cabin[] cabinRef)
    {
        int cabinnNum = 0;

        System.out.println() ;
        System.out.println("Would you like to book a Cabin of cruise ship?" ) ;
        while (cabinnNum!=12)
        {
            while (true)
            {
                System.out.println("Enter Cabin number (0-11) or 12 to stop:");
                if (Scan.hasNextInt())
                {
                    cabinnNum = Scan.nextInt();
                    if ((cabinnNum>=0) & (cabinnNum<12))
                    {
                        if ((cabinRef[cabinnNum].getName().equals("Empty"))) {
                            break;
                        }
                        else {
                            System.out.println("Sorry! Already booked this Cabin");
                        }
                    }
                    else if (cabinnNum==12)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Sorry! out of range Cabin numbers");
                    }
                }
                else
                {
                    System.out.println("Invalid input");
                    Scan.next();
                }
            }

            if (cabinnNum!=12)
            {
                cabinRef[cabinnNum].book_cabin(cabinnNum);
                cabinRef[cabinnNum].setpassager();
                System.out.println("---------------------------------------------------------------------------");
                cabinRef[cabinnNum].Passger_detils();
                System.out.println("---------------------------------------------------------------------------");

                System.out.println("Successfully added!" ) ;
            }
        }
    }

    // Display Empty cabins method
    private static void display_Empty_cabins(cabin[] cabinRef)
    {
        System.out.println("Display Empty cabins are:");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < 12; i++ )
        {
            if (cabinRef[i].getName().equals("Empty"))
            {
                System.out.println("Cabin " + i + " is empty ");
            }
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    // Delete customer from Cabin method
    private static void delete_customer_from_cabin(cabin[] cabinRef)
    {
        int remove_cus;
        int remove_pass;
        String option;

        while (true)
        {
            System.out.print("Enter[C] to clear Cabin, Enter [P] to clear Passenger :");
            option=Scan.next().toUpperCase();
            if (option.equals("P")|option.equals("C"))
            {
                break;
            }else
            {
                System.out.println("Sorry! Invalid input");
            }
        }

        if (option.equals("C"))
        {
            while (true)
            {
                System.out.print("Which Cabin number want to clear? :");
                if (Scan.hasNextInt())
                {
                    remove_cus = Scan.nextInt();
                    if ((remove_cus >= 0) & (remove_cus <= 12))
                    {
                        if (cabinRef[remove_cus].getName().equals("Empty"))
                        {
                            System.out.println("Sorry! Already free Cabin ");
                            break;
                        }
                        else
                        {
                            cabinRef[remove_cus].dataclear_cabin();
                            System.out.println("Updated.........");
                            break;
                        }
                    }
                }
                else
                {
                    System.out.println("Invalid input");
                    Scan.next();
                }
            }
        } else
        {
            while (true)
            {
                System.out.println("Enter Passenger number :" );
                if (Scan.hasNextInt())
                {
                    remove_cus = Scan.nextInt();
                    if ((remove_cus>=0) & (remove_cus<=12))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Sorry! out of range Cabin numbers");
                    }
                }
                else
                {
                    System.out.println("Invalid input");
                    Scan.next();
                }
            }
            cabinRef[remove_cus].Passger_detils();
            while (true)
            {
                System.out.print("Enter Passenger's Cabin number: " );
                System.out.println("---------------------------------------------------------------------------");
                if (Scan.hasNextInt())
                {
                    remove_pass = Scan.nextInt();
                    if ((remove_pass>0) & ( remove_pass<=(cabinRef[remove_cus].getguests() )))
                    {
                        cabinRef[remove_cus].remove_pass((remove_pass-1));
                        System.out.println("Successfully removed passenger "+remove_pass);
                        break;
                    }
                    else
                    {
                        System.out.println("Sorry! out of range Passenger numbers");
                    }
                }
                else
                {
                    System.out.println("Invalid input");
                    Scan.next();
                }
                System.out.println("---------------------------------------------------------------------------");
            }
        }
        System.out.println();
    }

    // Find task3Cabin from customer name method
    private static void Find_customer_name(cabin[] cabinRef)
    {
        String find_name;
        int find_results=0;

        System.out.print("What name do you like to find? :");
        find_name = Scan.next();
        System.out.println("---------------------------------------------------------------------------");
        for (int x = 0; x < 12; x++ )
        {
            if (cabinRef[x].getName().contains(find_name))
            {
                System.out.println("Cabin " + x + " name");
                find_results+=1;
            }

            find_results=cabinRef[x].return_find_names(find_name,find_results);
        }
        if (find_results==0)
        {
            System.out.println("No results found!");
        }else
        {
            System.out.println(find_results + " results found!");
        }
        System.out.println("---------------------------------------------------------------------------");
    }

    // Store program data into file method
    public static void Store_data_file(cabin[] cabinRef )
    {
        // display time and date
        Date date = new Date();

        try
        {
            FileWriter myWriter = new FileWriter("logs_task2.txt");
            myWriter.write("---------------Cabin Details----------------"+"\n");
            myWriter.write(String.format("Logs updated Date/Time : %tc", date )+"\n");

            for (int x = 0; x < 12; x++ )
            {
                cabinRef[x].store_detils(myWriter);
            }
            myWriter.write("---------------------------------------------------------------------------\n");
            myWriter.close();
            System.out.println("Successfully stored to the file.");
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //Load program data from file method
    public static void Load_data_from_file()
    {
        try
        {
            File myObj = new File("logs_task2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    //View passengers Ordered alphabetically by name
    public static void ordered_alphabetically_name(cabin[] cabinRef)
    {
        boolean isordered;

        List<String> temp_list=new ArrayList<String>();
        List<String> namelist=new ArrayList<String>();

        for (int x = 0; x < 12; x++ )
        {
            temp_list=cabinRef[x].name_list();
            for (String element: temp_list)
            {
                namelist.add(element);
            }
        }
        int elements=namelist.size();

        //sorting part
        for(int i=0;i<(elements-1);i++)
        {
            isordered=false;
            for(int j=0;j<(elements-1);j++)
            {
                if ((namelist.get(j).compareTo(namelist.get(j+1))) > 0)
                {
                    String temp_=namelist.get(j);
                    namelist.set(j,namelist.get(j+1));
                    namelist.set((j+1),temp_);
                    isordered=true;
                }
            }
            //When all sorted loop break
            if (isordered==false)
            {
                break;
            }
        }

        // print view passengers Ordered alphabetically by name
        for (String element: namelist)
        {
            System.out.println(element);
        }
        if(elements==0)
        {
            System.out.println( "0 results found!");
        }


    }

    // total expenses of all passengers
    public static void expenses_print(cabin[] cabinRef )
    {
        int expenses_total=0;
        for (int x = 0; x < 12; x++ )
        {
            expenses_total+=cabinRef[x].total_expenses();
        }
        System.out.println("Total expenses of all passengers - "+ expenses_total);
    }
}