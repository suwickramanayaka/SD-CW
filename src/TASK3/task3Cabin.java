package TASK3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class task3Cabin
{

    private String mainName;
    private int guestsInRoom=0;
    private int cabin_num;
    task3Passenger[]  passger_arr = new task3Passenger[3];

    // class Scanner class object
    private static final Scanner Scan = new Scanner(System.in);

    // Defult Constructor
    protected task3Cabin()
    {
        for (int x=0;x<3;x++)
        {
            this.passger_arr[x]=new task3Passenger();
        }
    }

    // set task3Cabin name,task3Cabin number and task3Cabin size
    protected void book_cabin(int room_num)
    {
        this.cabin_num=room_num;
        System.out.println("Enter name for task3Cabin " + this.cabin_num + " :");
        this.mainName = Scan.next();

        while (true)
        {
            System.out.println("Enter how many task3Passenger in task3Cabin " + this.cabin_num + "[max=3 passenger] :");
            if (Scan.hasNextInt())
            {
                this.guestsInRoom = Scan.nextInt();
                if ((this.guestsInRoom>0) & (this.guestsInRoom<4))
                {
                    break;
                }
                else
                {
                    System.out.println("Sorry! Maxmium 3 task3Passenger only!!");
                }
            }
            else
            {
                System.out.println("Wrong input");
                Scan.next();
            }
        }
    }
    //Setters
    // update task3Cabin name
    protected void setName(String mainName)
    {
        this.mainName=mainName;
    }

    // update task3Cabin number
    protected void setcabin_num(int cabin_num)
    {
        this.cabin_num=cabin_num;
    }

    // set passengers
    protected void setpassager()
    {
        for (int x=0;x<(this.guestsInRoom);x++)
        {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("task3Passenger " +(x+1));
            this.passger_arr[x].setFirstname(this.cabin_num,x);
            this.passger_arr[x].setSurname(this.cabin_num,x);
            this.passger_arr[x].SetExpenses(this.cabin_num,x);
        }
    }

    // return task3Cabin name
    protected String getName()
    {
        return this.mainName;
    }

    // return task3Cabin task3Cabin count
    protected int getguests()
    {
        return this.guestsInRoom;
    }

    // view all data
    protected void Passger_detils()
    {
        System.out.println();

        if (this.mainName.equals("not yet booked"))
        {
            System.out.println("----task3Cabin No." + this.cabin_num + " - " + this.mainName+"----");
        } else {
            System.out.println("----task3Cabin No." + this.cabin_num + " - " + this.mainName + "'s task3Cabin"+"----");
        }
        for (int x=0;x<this.guestsInRoom;x++)
        {
            System.out.println("task3Passenger "+(x+1)+" details");
            System.out.println("First name : "+this.passger_arr[x].getFirstname());
            System.out.println("Surname    : "+this.passger_arr[x].getSurname());
            System.out.println("Expenses   : "+this.passger_arr[x].getExpenses());
            System.out.println();
        }
    }

    // delete task3Cabin and clear data
    protected void dataclear_cabin()
    {
        for (int x=0;x<(this.guestsInRoom);x++)
        {
            this.passger_arr[x].dataclear_passenger();
        }
        mainName="not yet booked";
        guestsInRoom=0;
    }

    // find custermer
    protected int return_find_names(String find_name,int find_results)
    {
        for (int x=0;x<(this.guestsInRoom);x++)
        {
            if ((this.passger_arr[x].getSurname()+" "+this.passger_arr[x].getFirstname()).contains(find_name))
            {
                System.out.println("task3Cabin " + this.cabin_num + " task3Passenger "+(x+1)+" name "+(this.passger_arr[x].getSurname()+" "+this.passger_arr[x].getFirstname()));
                find_results+=1;
            }
        }
        return find_results;
    }

    // store data in log
    protected void store_detils(FileWriter myWriter)
    {
        try
        {
            myWriter.write("\n");
            if (this.mainName.equals("not yet booked"))
            {
                myWriter.write("----task3Cabin No." + this.cabin_num + " - " + this.mainName+"----"+"\n");
            }
            else
            {
                myWriter.write("----task3Cabin No." + this.cabin_num + " - " + this.mainName + "'s task3Cabin"+"----"+"\n");
            }
            for (int x=0;x<this.guestsInRoom;x++)
            {
                myWriter.write("task3Passenger "+(x+1)+" details"+"\n");
                myWriter.write("First name : "+this.passger_arr[x].getFirstname()+"\n");
                myWriter.write("Surname    : "+this.passger_arr[x].getSurname()+"\n");
                myWriter.write("Expenses   : "+this.passger_arr[x].getExpenses()+"\n");
                myWriter.write("\n");
            }
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // getting passegers names to list
    protected List<String> name_list()
    {
        List<String> arr=new ArrayList<String>();
        for (int x=0;x<(this.guestsInRoom);x++)
        {
            if (!(this.mainName.equals("not yet booked")))
            {
                arr.add((this.passger_arr[x].getFirstname()+" "+this.passger_arr[x].getSurname())+" task3Cabin number "+this.cabin_num);
            }
        }
        return arr;
    }

    // calculate passegnger expenses
    protected double total_expenses()
    {
        double cabin_total=0;
        for (int x=0;x<(this.guestsInRoom);x++)
        {
            if (!(this.mainName.equals("not yet booked")))
            {
                System.out.println(this.passger_arr[x].getFirstname()+" - " + this.passger_arr[x].getExpenses());
                cabin_total+=this.passger_arr[x].getExpenses();
            }
        }
        return cabin_total;
    }

    //remove passger only
    protected void remove_pass(int remove_pass)
    {
        this.passger_arr[remove_pass].dataclear_passenger();
    }

    //update passenger details
    protected void Update_passenger(int remove_pass,String x,String y,double z)
    {
        this.passger_arr[remove_pass].dataupdate_passenger(x,y,z);
    }

}
