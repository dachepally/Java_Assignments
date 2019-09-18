/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;


/**
 *
 * @author Sai Sri Dachepalli
 */
public interface Operations {
    
    /**
     * The method is used to check whether the customer can make a call.
     * @return a value of type boolean
     */
    boolean canMakeCall();
       
    /**
     * The method is used to make a call.
     * @param call
     * @return
     */
    boolean makeCall(Call call);
        
       
    
}
