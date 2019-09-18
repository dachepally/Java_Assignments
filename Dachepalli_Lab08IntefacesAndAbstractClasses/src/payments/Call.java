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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import rates.Tarrif;

public class Call {
    
    Tarrif callType;
    String endTime;
    String phoneNumber;
    String startTime;

    /**
     * An all argument constructor that initializes all the instance variables of this class.
     * @param callType passing callType attribute
     * @param endTime passing endTime attribute
     * @param phoneNumber passing phoneNumber attribute
     * @param startTime passing startTime attribute
     */
    public Call(Tarrif callType , String endTime, String phoneNumber, String startTime) {
        this.callType = callType;
        this.endTime = endTime;
        this.phoneNumber = phoneNumber;
        this.startTime = startTime;
    }

    /**
     * This method returns the type of call as Tarrif type.
     * @return Type of the call as Tarrif enum.
     */
    public Tarrif getCallType() {
       return callType;
    }

    /**
     * This method returns the endTime.
     * @return returns the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * This method returns the phone number.
     * @return Phone number to which a call is placed.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method returns the startTime.
     * @return returns the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * This method calculates and returns the number of seconds.
     * @return No of seconds a call was active.
     * @throws ParseException
     */
    public  double getSeconds() throws ParseException{
        SimpleDateFormat time= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate= time.parse(startTime);
        Date endDate= time.parse(endTime);
        double sec = (endDate.getTime()-startDate.getTime())/1000;
        return sec;
    }
    @Override
    public String toString() {
        return phoneNumber + "\t"+startTime+"\t"+endTime+"\t"+callType;
    }
    
    
    
}
