/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;

import accounts.ConnectionAccount;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import rates.Tarrif;

/**
 *
 * @author Sai Sri Dachepalli
 */
public class PrepaidService extends MobileService implements Billing,Operations{ 
    
    private Call call;
    
    /**
     * An all argument constructor that initializes all the instance variables of this class.
      Method Summary
     * @param account
     * @param balance
     * @param dataAvailable
     */
    public PrepaidService(ConnectionAccount account, double balance, double dataAvailable) {
        super(account, balance, dataAvailable);
    }

    /**
     * This method will calculate the bill for the call duration. For example: If an INTERNATIONAL call is placed for 65 seconds(1.083 minutes) and prepaid call tarrif for INTERNATIONAL call is $0.70 then total call cost for 1.083 minutes is $0.7583
     * @return bill for the current call og type double
     */
    @Override
    public double calcBill(){
        
        double minutes = 0;
        try {
            minutes = call.getSeconds() / 60;
        }
        catch (ParseException ex) {
            Logger.getLogger(PrepaidService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            Tarrif calltype = call.getCallType();
            switch (calltype) {
                case LOCAL:
                    return minutes * (Tarrif.LOCAL.getPrepaid() / 100);
                case INTERNATIONAL:
                    return minutes * (Tarrif.INTERNATIONAL.getPrepaid() / 100);
                case ROAMING:
                    return minutes * (Tarrif.ROAMING.getPrepaid() / 100);
            }
        return 0;
    }

    /**
     * This method overrides the abstract method declared in super class.
       This method returns true if balance is greater that 0
     * @return balance of Type boolean
     */
    @Override
    public boolean canMakeCall(){
        if(super.getBalance()>0){
             return true;
        }
       return false;
    }

    /**
     *  This method overrides the abstract method declared in super class.
        As prepaid customer does not have any discounts, return 0
     * @return discount of type double
     */
    @Override
    public double discountForReturningCustomer(){
        return 0;
    }

    /**
     * This method takes a Call object as input and verifies if they can make a call using canMakeCall. If the customer can make a call, the passed Call object is assigned to the instance variable call and deduct the call bill from current balance. If the call was success return true
     * @param call
     * @return a value of type boolean
     */
    @Override
    public boolean makeCall(Call call){
        if(canMakeCall()==true){
            this.call = call;
            
        }
        return true;
    }

     @Override
    public String toString() {
        DecimalFormat d1 = new DecimalFormat("#.##");
        String header = "Phone number\t\tFrom\t\t\tTo\t\tCall Type";
        String line="-----------------------------------------------------------------------------";
        return line+"\n"+super.toString()+"\n"+line+"\nLast Call Details:"+
                "\n"+header+
                "\n"+call+
                "\n"+line+
                "\n\tAvailable mobile data\t:"+d1.format(super.getDataAvailable())+
                "MB\n\tBalance\t\t\t:$"+d1.format((super.getBalance()-this.calcBill()))+
                "\n\tLast Call Amount\t:$"+d1.format(this.calcBill())+"\n"+line;
    }
}
