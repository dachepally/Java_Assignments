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
public class RegularPolygon extends Polygon {
    double length;

    /**
     *
     * @param name
     * @param noSides
     * @param length
     */
    public RegularPolygon(String name, int noSides, double length) {
        super(name, noSides);
        this.length = length;
    }
    
    /* @Override This method overrides the getArea() of Polygon Class. */
    public double getArea()
    {
        double area = (super.getNoSides()*Math.pow(length,2))*(1/(4*Math.tan(Math.PI/(super.getNoSides()))));
        //double area = (super.getNoSides()/4)*(Math.pow(length,2))*(1/(Math.tan(Math.PI/super.getNoSides())));
        return area;     
    }
    
    /* @Override This method overrides the getPerimeter() of Polygon Class. */
    public double getPerimeter()
    {
        double p = super.getNoSides()*length;
        return p;
    }
    
     /* @Override This method overrides the getInternalAngle() of Polygon Class. */
    public double getInternalAngle()
    {
        double angle = 180*(super.getNoSides()-2)/(super.getNoSides());
        return angle;     
    }

    /**
     *
     * @return InCircleRadius
     */
    public double getInCircleRadius()
    {
        double inRadius = length*(1/(2*Math.tan(Math.PI/(super.getNoSides()))));
        return inRadius;
    }

    /**
     *
     * @return CircumCircleRadius
     */
    public double getCircumCircleRadius()
    {
        double circumRadius = (length/2)*((1/Math.sin(Math.PI/super.getNoSides())));
        return circumRadius;
    }
    
    /* @Override This method overrides the toString() of Polygon Class. */
    public String toString()
    {
        
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return  super.toString()+"\n\tLength of side: "+length+"cms"+"\n\tInternal angle: "+decimalFormat.format(getInternalAngle())
                +"\u00b0"+"\n\tCircumcircle radius: "+decimalFormat.format(getCircumCircleRadius())+"cms"
                +"\n\tIncircle radius: "+decimalFormat.format(getInCircleRadius())+"cms\n\tArea: "+decimalFormat.format(getArea())+"cm\u00b2"
                +"\n\tPerimeter: "+decimalFormat.format(getPerimeter())+"cms";
                
                
    }
}
