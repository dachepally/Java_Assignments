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
public enum Tarrif {
    
    LOCAL(19,20),
    ROAMING(29,30),
    INTERNATIONAL(69,70);
    
    private final double postpaid;
    private final double prepaid;

    private Tarrif(double postpaid, double prepaid) {
        this.postpaid = postpaid;
        this.prepaid = prepaid;
    }

    /**
     * Method that returns rates of postpaid.
     * @return the rate of postpaid call
     */
    public double getPostpaid() {
        return postpaid;
    }

    /**
     * Method that returns rates of prepaid call
     * @returns the rate of prepaid call
     */
    public double getPrepaid() {
        return prepaid;
    }
    
}
