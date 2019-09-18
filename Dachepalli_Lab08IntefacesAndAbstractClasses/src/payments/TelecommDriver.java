/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payments;

import accounts.ConnectionAccount;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import rates.Tarrif;

/**
 *
 * @author Sai Sri Dachepalli
 */
public class TelecommDriver {

    /**
     * This method is the main method that executes when project is executed.
     * @param args
     * @throws FileNotFoundException
     * @throws ParseException
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        ArrayList<MobileService> connections = new ArrayList<>();
        Scanner scannerobject = new Scanner(new File("usersCallLog.txt"));

        String callPhone = scannerobject.nextLine();
        //String callPhone;
        String str;
        Call makecall;
        double bestPayer = 0;
        Tarrif calltype2 = null;
        while (scannerobject.hasNext()) {
            String str1 = callPhone;
            String pn = scannerobject.nextLine();
            String accountType = scannerobject.nextLine();
            if ("postpaid".equals(accountType)) {
                PostpaidService account;
                String date = scannerobject.nextLine();
                double dataAvailable = scannerobject.nextDouble();
                scannerobject.nextLine();
                ConnectionAccount cn = new ConnectionAccount(accountType, str1, date, pn);
                account = new PostpaidService(cn, 0, dataAvailable);

                callPhone = scannerobject.nextLine();
                do {
                    String callPhone1 = callPhone;
                    String[] callSplit = callPhone1.split("  ");
                    String pn2 = callSplit[0];
                    String from = callSplit[1];
                    String to = callSplit[2];
                    String calltype = callSplit[3];
                    switch (calltype) {
                        case "L":
                            calltype2 = Tarrif.LOCAL;
                            break;
                        case "R":
                            calltype2 = Tarrif.ROAMING;
                            break;
                        default:
                            calltype2 = Tarrif.INTERNATIONAL;
                            break;
                    }
                    makecall = new Call(calltype2, to, pn2, from);
                    account.makeCall(makecall);
                    if (!scannerobject.hasNextLine()) {
                        break;
                    }
                    callPhone = scannerobject.nextLine();
                } while (callPhone.contains("+"));
                connections.add(account);
            } else {
                double data = scannerobject.nextDouble();
                double amount = scannerobject.nextDouble();
                scannerobject.nextLine();
                ConnectionAccount cn = new ConnectionAccount(accountType, str1, pn);
                PrepaidService account = new PrepaidService(cn,amount,data);
                callPhone = scannerobject.nextLine();
                do {
                    String phone = callPhone;
                    String[] callSplit = phone.split("  ");
                    String str2 = callSplit[0];
                    String from = callSplit[1];
                    String to = callSplit[2];
                    String calltype = callSplit[3];
                    switch (calltype) {
                        case "L":
                            calltype2 = Tarrif.LOCAL;
                            break;
                        case "R":
                            calltype2 = Tarrif.ROAMING;
                            break;
                        default:
                            calltype2 = Tarrif.INTERNATIONAL;
                            break;
                    }
                    makecall = new Call(calltype2, to, str2, from);
                    account.makeCall(makecall);
                    if (!scannerobject.hasNextLine()) {
                        break;
                    }
                    callPhone = scannerobject.nextLine();
                } while (callPhone.contains("+"));
                connections.add(account);

            }
        }
        System.out.println("************************Postpaid customers invoice***************************\n");
        for (MobileService mobile: connections) {
            if ("postpaid".equals(mobile.getAccount().getConnectionType())) {
                System.out.println(mobile);
            }
        }
        System.out.println("************************Prepaid customers invoice***************************");
        for (MobileService mobile1: connections) {
            if ("prepaid".equals(mobile1.getAccount().getConnectionType())) {
                System.out.println(mobile1);
            }
        }
        System.out.println("**********************Invoking useData() of customer*************************");
        for (MobileService mobile2 : connections) {
            if ("Robert Downey Jr.".equals(mobile2.getAccount().getCustomerName())) {
                mobile2.useData(156774.40);
                System.out.println(mobile2);
            }
            if ("Lionel Messi".equals(mobile2.getAccount().getCustomerName())) {
                mobile2.useData(13516.80);
                System.out.println(mobile2);
            }
            if ("Ed Sheeran".equals(mobile2.getAccount().getCustomerName())) {
                mobile2.useData(104427.52);
                System.out.println(mobile2);
            }
        }
        System.out.println("*************************Best postpaid customer******************************");
        for (MobileService mobile3: connections) {
            if ("postpaid".equals(mobile3.getAccount().getConnectionType())) {
               
                PostpaidService post = (PostpaidService) mobile3;
                if (post.finalBillAfterDiscount() > bestPayer) {
                     System.out.println("Best Customer Details:");
                    bestPayer = post.finalBillAfterDiscount();
                    System.out.println("Customer Name:\t"+mobile3.getAccount().getCustomerName());
                    System.out.println("Bill amount\t:$"+String.format("%.2f", post.finalBillAfterDiscount()));
                }
            }

        }
    }
}
