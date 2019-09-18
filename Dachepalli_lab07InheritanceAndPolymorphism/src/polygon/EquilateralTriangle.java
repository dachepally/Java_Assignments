/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

import java.text.DecimalFormat;

/**
 *
 * @author Sai Sri Dachepalli
 */
public class EquilateralTriangle extends RegularPolygon{

    //private double length;

    /**
     *
     * @param length
     */
        public EquilateralTriangle(double length) {
        super("Equilateral Triangle",3,length);
    }
    
    /**
     *
     * @param name
     * @param length
     */
    public EquilateralTriangle(String name,double length) {
        super(name,3,length);
    }
        
    /**
     *
     * @return height
     */
    public double getHeight()
    {
        double height = (Math.sqrt(3)*super.length)/2;
        return height;
    }
    /*@Override This method overrides the getArea() of Polygon Class.*/        
    public String toString()
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return super.toString()
                +"\n\tHeight: "+decimalFormat.format(getHeight())+"cms";
    
    }
    
}
