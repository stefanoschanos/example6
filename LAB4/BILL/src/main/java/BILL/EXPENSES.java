package BILL;

import java.util.ArrayList;

public class EXPENSES
{ 
    private ArrayList<BILL>All_Bills = new ArrayList<>();

    public EXPENSES()
    {

    }


   public void readReservation()
    {           
        BILL b = new BILL();
        b.readBill();
        All_Bills.add(b);
    }

    public void FindUnpaid()
    {
        double sum=0;
        for(BILL b : All_Bills)
        {
            if(b.getPaid()==false)
            {
               System.out.println (b.toString());
                sum+=b.getCost();
            }
        }
        System.out.println("The value of the bills that haven't been paid is : " +sum);
    }

    public void ConfirmPayment(String ID)
    {
        for(BILL b : All_Bills)
        {
            if(b.getID()==ID)
            {   
                if(b.getPaid()==false)
                {
                    b.setPaid(true);
                }
            else
                {
                    System.out.println("The bill was already paid");
                }
            }
        }
    }

    @Override
    public String toString()
    {
        return All_Bills +"\n";
    }

    public void maxCost()
    {
      double max=-1000000;
      BILL bill = new BILL();
      for(BILL b : All_Bills)
      {
          if(b.getPaid() == false)
          {
              if(max < b.getCost())
              {
                  max=b.getCost();
                  bill=b;
              }
          }
      }
        System.out.println(bill.toString());
    }




   


    public static void main(String[] args)
    {
        EXPENSES E1= new EXPENSES();

        BILL b1 = new BILL("2378-A" , "Electricity" , 546.2 , false);
        E1.All_Bills.add(b1);
        BILL b2 = new BILL("34-A" , "Water" , 674.5 , true);
        E1.All_Bills.add(b2);
        BILL b3 = new BILL("AQW3r3r" , "Phone" , 54 , false);
        E1.All_Bills.add(b3);
        BILL b4 = new BILL("789/x" , "Water" , 120.3 , false);
        E1.All_Bills.add(b4);
        BILL b5 = new BILL("Th78S" , "Electricity" , 246.2 , true);
        E1.All_Bills.add(b5);

        System.out.println("The list of bills is :");
        System.out.println(E1.toString());

        E1.readReservation();
        System.out.println("\nThe list of bills after the addition of one bill is :");
        System.out.println(E1.toString());

        E1.FindUnpaid();
        E1.ConfirmPayment("789/x");

        System.out.println("\nAfter the payment of one bill");
        E1.FindUnpaid();

        System.out.println("\nThe characteristics of the bill with the largest unpaid value are : ");
        E1.maxCost();

    }
}
