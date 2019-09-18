/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

/**
 *
 * @author Sai Sri Dachepalli
 */
public class Polygon {
         private String name;
         int noSides;
         
    /**
     *
     * @param name
     * @param noSides
     */
    public Polygon(String name,int noSides)
         {
             this.name = name;
             this.noSides = noSides; 
         }

    /**
     *
     * @return name
     */
    public String getName() {
             return name;
         }

    /**
     *
     * @return NoSides
     */
    public int getNoSides() {
             return noSides;
         }
          
    /**
     *
     * @return area
     */
    public double getArea()
         {
             return 0.0;
         }
         
    /**
     *
     * @return Perimeter
     */
    public double getPerimeter()
         {
             return 0.0;
         }
  
    /**
     *
     * @return InternalAngle
     */
    public double getInternalAngle()  
         {
             return 0.0;
         }
      
         public String toString()
         {
             return "Polygon: "+getName()+"\n\tNumber of sides: "+noSides;
         }
         
}
