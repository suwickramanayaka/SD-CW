package TASK2;

import java.util.Scanner;


public class Passenger
{
    private String First_Name;
    private String Surname;
    private int Expenses;

    private static final Scanner Scan = new Scanner(System.in);

    //Default Constructor
    public Passenger()
    {
        this.First_Name="Not reserved";
        this.Surname="Not reserved";
        this.Expenses=0;
    }


    //Setters
    protected void setFirstname(int cabin_num,int x)
    {
        System.out.print("Enter Cabin "+(cabin_num)+" Passenger "+ (x+1) +" first name :");
        this.First_Name=Scan.next();
    }

    protected void setSurname(int cabin_num,int x)
    {
        System.out.print("Enter Cabin "+(cabin_num)+" Passenger "+ (x+1) +" Surname :");
        this.Surname=Scan.next();
    }

    protected void SetExpenses(int cabin_num,int x)
    {
        while (true)
        {
            System.out.print("Enter Cabin "+(cabin_num)+" Passenger "+ (x+1) +" Expenses :");
            if (Scan.hasNextInt())
            {
                this.Expenses=Scan.nextInt();
                break;
            }
            else
            {
                System.out.println("Invalid input");
                Scan.next();
            }
        }
    }


    // Getters
    protected String getFirstname()
    {
        return this.First_Name;
    }

    protected String getSurname()
    {
        return this.Surname;
    }

    protected int getExpenses()
    {
        return this.Expenses;
    }



    protected void dataclear_passenger()
    {
        this.Expenses=0;
        this.First_Name="Not reserved";
        this.Surname="Not reserved";
    }
}