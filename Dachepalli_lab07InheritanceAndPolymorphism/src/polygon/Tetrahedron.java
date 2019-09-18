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
public class Tetrahedron extends EquilateralTriangle {

    /**
     *
     * @param length
     */
    public Tetrahedron(double length) {
        super("Tetrahedron",length);
    }
    
    /**
     *
     * @return height
     *
     * @Override This method overrides the getHeight() of Polygon Class./
    public double getHeight()
    {
        double height = (Math.sqrt(6))*(super.length/3);
        return height;
    }
    
    /**
     *
     * @return area
     *@Override This method overrides the getArea() of Polygon Class/
    public double getArea()
    {
        double area = super.getArea() * Solids.TETRAHEDRON.noFaces;
        return area;
    }
    
    /**
     *
     * @return Volume
     */
    public double getVolume()
    {
        double volume = (Math.sqrt(2)*Math.pow(length,3))/12;
        return volume; 
    }
   
    /**
     *
     * @return InSphereRadius
     */
    public double getInSphereRadius()
    {
        double inRadius = (length)*(1/(Math.sqrt(24)));
        return inRadius;
        
    }
    
    /**
     *
     * @return CircumSphereRadius
     */
    public double getCircumSphereRadius()
    {
        double sphereRadius = (Math.sqrt(6)*length)/4;
        return sphereRadius;
    }
    /**@Override This method overrides the getArea() of Polygon Class*/
    public String toString()
    {
        
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
         return super.toString()
                +"\n\tInsphere radius: "+decimalFormat.format(getInSphereRadius())+"cms\n\tCircumsphere radius: "+decimalFormat.format(getCircumSphereRadius())
                +"cms\n\tVolume: "+decimalFormat.format(getVolume())+"cm\u00b3";
    
    }
}
