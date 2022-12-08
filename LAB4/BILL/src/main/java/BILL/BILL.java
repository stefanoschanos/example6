package BILL;
import java.util.Scanner;

public class BILL
{
    private String Type;
    private double Cost;
    private boolean Paid;
    private String ID;
    Scanner userInput = new Scanner(System.in);

    void CheckType(String Type)
    {
        while(!(Type.equals("Electricity") || Type.equals("Phone") || Type.equals("Water")))
        {
            System.out.println("The type you've entered is wrong please enter the correct one (Electricity , Phone , Water)");
            Type=userInput.next();
        }
    }

    public BILL()
    {

    }

    public BILL( String ID , String T , double C , boolean P)
    {
           this.ID=ID;
           Type=T;  
           CheckType(Type);
           Cost=C;
           Paid= P;
    }

    void readBill()
    {
        System.out.println("Enter the bill's ID");
            ID=userInput.next();
        System.out.println("Enter the bill's type");
            Type=userInput.next();
            CheckType(Type);
        System.out.println("Enter the bill's cost");
            Cost=userInput.nextDouble();
        System.out.println("Please inform if the bill is paid or not (Paid=true / Unpaid=false");
            Paid=userInput.nextBoolean();
    }

    @Override
    public String toString()
    {
        if(Paid)
        {
            return "The bill's type is : " +Type+ " , the cost is : " +Cost+ " and it is paid , with ID : " +ID+ "\n";
        }
        else
        {
            return "The bill's type is : " +Type+ " , the cost is : " +Cost+ " and it is not paid , with ID : " +ID+ "\n";
        }

    }


    public String getType()
    {
        return Type;
    }


    public double getCost()
    {
        return Cost;
    }


    public Boolean getPaid()
    {
        return Paid;
    }
    public void setPaid(boolean Paid)
    {
        this.Paid=Paid;
    }


    public String getID()
    {
        return ID;
    }
}
