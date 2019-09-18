/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Sai Sri Dachepalli
 */
public class ConnectionAccount {
    
    private String connectionType;
    private String customerName;
    private String joiningDate;
    private String phoneNumber;

    /**
     * A four argument constructor of class ConnectionAccount
     * @param connectionType passing connectionType attribute
     * @param customerName passing customerName attribute
     * @param joiningDate passing joiningDate attribute
     * @param phoneNumber passing phoneNumber attribute
     */
    public ConnectionAccount(String connectionType, String customerName, String joiningDate, String phoneNumber) {
        this.connectionType = connectionType;
        this.customerName = customerName;
        this.joiningDate = joiningDate;
        this.phoneNumber = phoneNumber;
    }

    /**
     *A three argument constructor of class ConnectionAccount
     * @param connectionType passing connectionType attribute
     * @param customerName passing customerName attribute
     * @param phoneNumber passing phoneNumber attribute
     */
    public ConnectionAccount(String connectionType, String customerName, String phoneNumber) {
        this.connectionType = connectionType;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }

    /**
     * This getter method returns connectionType
     * @return returns connectionType
     */
    public String getConnectionType() {
        return connectionType;
    }

    /**
     * @return returns customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @return returns joiningDate of the customer
     */
   public String getJoiningDate() {
        return joiningDate;
    }

    /**
     * @return returns phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * @return  returns the number of years between account opening date and current system date.
     */
    public int numberOfYears(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date1 = LocalDate.parse(joiningDate, format);
        LocalDate date2 = LocalDate.now();
        int years = (int) ChronoUnit.YEARS.between(date1, date2);
        return years;
    }
}
