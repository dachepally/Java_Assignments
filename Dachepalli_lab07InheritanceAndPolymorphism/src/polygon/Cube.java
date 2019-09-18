/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

import enums.Solids;
import java.text.DecimalFormat;

/**
 *
 * @author Sai Sri Dachepalli
 */
public class Cube extends Square {

    /**
     *
     * @param length
     */
    public Cube(double length) {
        super("Cube",length);
    }

    /**
     *
     * @return area of the cube
     */
     /* @Override This method overrides the getArea() of Polygon Class. */
    public double getArea()
    {
        double area = super.getArea()*Solids.CUBE.noFaces;
        return area;
    }
    
    /**
     *
     * @return volume of the cube
     */
    
    public double getVolume()
    {
        double volume = Math.pow(super.length, 3);
        return volume;
    }

    /**
     *
     * @return InSphereRadius
     */
   
    public double getInSphereRadius()
    {
        double inRadius = (super.length/2);
        return inRadius;
    }

    /**
     *
     * @return
     */
    public double getCircumSphereRadius()
    {
        double sphereradius = (Math.sqrt(3))*(super.length)/2;
        return sphereradius;
    }
    
      /* @Override This method overrides the getArea() of Polygon Class. */
    public String toString()
    {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return super.toString()+"\n\tInsphere radius: "+decimalFormat.format(getInSphereRadius())+"cms"+"\n\tCircumsphere radius: "+decimalFormat.format(getCircumSphereRadius())+"cms"
                +"\n\tVolume: "+decimalFormat.format(getVolume())+"cm"+"\u00b3";
    }
    
    
}
