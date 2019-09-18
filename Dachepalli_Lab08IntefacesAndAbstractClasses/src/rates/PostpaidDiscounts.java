/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rates;

/**
 *
 * @author Sai Sri Dachepalli
 */
public enum PostpaidDiscounts {

    YEAR1(4),
    YEAR2(8),
    YEAR3(10),
    YEAR4(15),
    YEAR5(20);
    
    private final double discount;

    private PostpaidDiscounts(double discount) {
        this.discount = discount;
    }

    /**
     * The getter method returns the percentage of discount
     * @return the percentage rate 
     */
    public double getDiscount() {
        return discount;
    }
    

}
