/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;
/**
 * @author Sai Sri Dachepalli
 */
public interface Billing {

    /**
     * @return cost of call/calls of type double
     */
    double calcBill();

    /**
     * This method is used to calculate the discount of returning customer 
     * @return percentage of discount of type double
     */
    double discountForReturningCustomer();
       
    
}
