/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;

import accounts.ConnectionAccount;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import rates.PostpaidDiscounts;
import rates.Tarrif;

/**
 *
 * @author Sai Sri Dachepalli
 */
public class PostpaidService extends MobileService implements Billing, Operations {

    private ArrayList<Call> calls = new ArrayList<Call>();

    /**
     * An all argument constructor that initializes all the instance variables of this class.
     * @param account
     * @param balance
     * @param dataAvailable
     */
    public PostpaidService(ConnectionAccount account, double balance, double dataAvailable) {
        super(account, balance, dataAvailable);
        this.calls = calls;
    }

    /**
      As postpaid customers do not have attribute balance to place a call
     * @return a value of type boolean
     */
    @Override
    public double calcBill() 
    {
        double total = 0;
        double minutes = 0;
        double pay;
        double afterUsedInternet;
        for (Call call : calls)
        {
            try 
            {
                minutes = call.getSeconds() / 60;
            }
            catch (ParseException ex)
            {
                System.out.println(ex);
            }
            Tarrif calltype = call.getCallType();
            switch (calltype) {
                case LOCAL:
                    pay = minutes * (Tarrif.LOCAL.getPostpaid() / 100);
                    total += pay;
                    break;
                case INTERNATIONAL:
                    pay = minutes * (Tarrif.INTERNATIONAL.getPostpaid() / 100);
                    total += pay;
                    break;
                case ROAMING:
                    pay = minutes * (Tarrif.ROAMING.getPostpaid() / 100);
                    total += pay;
                    break;
            }
        }

        if (super.getDataAvailable() < 0) 
        {
            afterUsedInternet = Math.abs(super.getDataAvailable()) * 0.05;
            return total += afterUsedInternet;
        } 
        else 
        {
            return total;
        }

    }

    @Override
    public double discountForReturningCustomer() {
        int years = account.numberOfYears();
        if (years < 1) {
            return 0.0;
        }
        if (years >= 5) {
            return PostpaidDiscounts.YEAR5.getDiscount();
        }
        switch (years) {
            case 1:
                return PostpaidDiscounts.YEAR1.getDiscount();
            case 2:
                return PostpaidDiscounts.YEAR2.getDiscount();
            case 3:
                return PostpaidDiscounts.YEAR3.getDiscount();
            case 4:
                return PostpaidDiscounts.YEAR4.getDiscount();
        }
        return 0;
    }

    private double discountPrice() {
        return this.calcBill() * (this.discountForReturningCustomer() / 100);
    }

    /**
     * This method applies discount on calculated bill
     */
    public double finalBillAfterDiscount() {
        return this.calcBill() - this.discountPrice();
    }

    /**
     * This method overrides the abstract method declared in super class.
     */
    @Override
    public boolean canMakeCall() {
        return true;
    }

    /**
     * The method is used to update the amount of data available 
     * @param dataUsed
     * @return a value of type boolean
     */
    @Override
    public boolean useData(double dataUsed) {

        double data = dataUsed / 1024;
        if (data > super.getDataAvailable()) {
            this.dataAvailable -= data;
            return true;
        }
        return false;
    }

    /**
     * This method overrides the abstract method declared in super class.
     * @param call
     * @return a value of type boolean
     */
    @Override
    public boolean makeCall(Call call) {
        if (calls.isEmpty()) 
        {
            calls.add(call);
            return true;

        } 
        else 
        {
            if (!calls.contains(call))
            {
                calls.add(call);
                return true;
            }
            return false;
        }
    }

    @Override
    public String toString() {
        DecimalFormat dc = new DecimalFormat("#.##");
        String header = "Phone number\t\tFrom\t\t\tTo\t\tCall Type";
        String line = "-----------------------------------------------------------------------------";
        String string1 = "";
        for (Call cal1 : calls) {
           string1 += cal1 + "\n";
        }
        return line + "\n" + super.toString() + "\n" + line + "\n" + header + "\n" + string1 + "\n" + line
                + "\nAdditional mobile data used\t\t:" + (this.getDataAvailable()>= 0?0.0 : dc.format(Math.abs(this.getDataAvailable())))
                + "MB\nBill Amount\t\t\t\t:$" + dc.format(this.calcBill())
                + "\nReturning Customer Discount(" + dc.format(this.discountForReturningCustomer()) + "%)\t:$" + dc.format(this.discountPrice())
                + "\nFinal Bill Amount\t\t\t:$" + dc.format(this.finalBillAfterDiscount()) + "\n" + line;
    }

}
