/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;

import accounts.ConnectionAccount;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sai Sri Dachepalli
 */
public abstract class MobileService implements Operations {

    ConnectionAccount account;
    double balance;
    double dataAvailable;

    /**
     * An all argument constructor that initializes all the instance variables of this class.
     * @param account passing account attribute
     * @param balance passing balance attribute
     * @param dataAvailable passing dataAvailable attribute
     */
    public MobileService(ConnectionAccount account, double balance, double dataAvailable) {
        this.account = account;
        this.balance = balance;
        this.dataAvailable = dataAvailable;
    }

    /**
     * This getter method returns the account object.
     * @return account of type ConnectionAccount
     */
    public ConnectionAccount getAccount() {
        return account;
    }

    /**
     * This getter method returns the balance.
     * @return Balance of the customer of type double.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * This getter method returns the data available.
     * @return Available data of type double.
     */
    public double getDataAvailable() {

        return dataAvailable;
    }

    /**
     * This method overrides the abstract method declared in Operations interface.
     * @return a value of type boolean
     */
    @Override
    public abstract boolean canMakeCall();

    /**
     * The method is used to update the amount of data 
     * @param dataUsed the argument of double type
     * @return a value of type boolean
     */
    public boolean useData(double dataUsed) {
        double data = dataUsed / 1024;
        if (data < this.dataAvailable) {
            this.dataAvailable -= data;
            return true;
        }
        return false;
    }

    /**
     * This abstract method is used to make a call.
     * @param call the argument of Call type
     * @return a value of type boolean
     */
    @Override
    public abstract boolean makeCall(Call call);

    @Override
    public String toString() {
        String string = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        if ("postpaid".equals(account.getConnectionType())) {
            try {
                string = "Customer Name\t:" + account.getCustomerName()
                        + "\nPhone Number\t:" + account.getPhoneNumber()
                        + "\nConnection Type\t:" + account.getConnectionType()
                        + "\tConnection Date :" + formatter.format(new SimpleDateFormat("MM/dd/yyyy").parse(account.getJoiningDate()));
            } catch (ParseException ex) {
                Logger.getLogger(MobileService.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            string = "Customer Name\t:" + account.getCustomerName()
                    + "\nPhone Number\t:" + account.getPhoneNumber()
                    + "\nConnection Type\t:" + account.getConnectionType();
        }

        return string;
    }

}
