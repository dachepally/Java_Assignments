/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polygon;

import enums.Solids;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Sai Sri Dachepalli
 */
public class ShapesDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        Scanner s =  new Scanner(new File("shapes.txt"));
        ArrayList<Polygon> polygons = new ArrayList<Polygon>();
       // double num1[] = new double[5];
        int a1 = 0;
        int a2 = 0;
        double a3 = 0.0;
        int i=0;
        double temp = 0.0;
        double temp1 = 0.0;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        while(s.hasNext())
        {
            i++;
           String name = s.next();
           String value = s.nextLine().trim();
            
           if(value.contains(" "))
           {
               
              String num1[] = value.split(" ");
               
              a1 = Integer.parseInt(num1[0]);
               
              a2 = Integer.parseInt(num1[1]); 
               
           }
           else
           {
               a3 = Double.parseDouble(value); 
           }
           if(name.equalsIgnoreCase("cube"))
           {
               temp = a3;
               Cube cubeObject = new Cube(a3); 
               polygons.add(cubeObject);
           }
           else if(name.equalsIgnoreCase("pentagon"))
           {
               name = name.substring(0,1).toUpperCase()+name.substring(1);
               RegularPolygon reg = new RegularPolygon(name,a1,a2);
               polygons.add(reg);
           }
           else if(name.equalsIgnoreCase("tetrahedron"))
           {
               temp1 = a3;
               Tetrahedron tet = new Tetrahedron(a3);
               polygons.add(tet);
           }
           else if(name.equalsIgnoreCase("triangle"))
           {
               EquilateralTriangle reg = new EquilateralTriangle(a3);
               polygons.add(reg);
           }
           else if(name.equalsIgnoreCase("square"))
           {
               name = name.substring(0,1).toUpperCase()+name.substring(1);
               Square reg = new Square(name,a3);
               polygons.add(reg);
           }
           else if(name.equalsIgnoreCase("hexagon"))
           {
               name = name.substring(0,1).toUpperCase()+name.substring(1);
               RegularPolygon reg = new RegularPolygon(name,a1,a2);
               polygons.add(reg);       
           }
           
        }
          System.out.println("*****************************************");
          for(Polygon p : polygons)
          {
              //System.out.println("*****************************************");
              System.out.println(p);
              System.out.println("*****************************************");
          }
          double max=0.0;
          for(int j=0;j<polygons.size();j++)
          {
              
              if(max<polygons.get(j).getArea())
              {
                  max=polygons.get(j).getArea();
              
              }
              
          }
          System.out.println("The polygon with largest area is Cube with area of "+decimalFormat.format(max)+"cm\u00b2");
          
          double max1=0.0;
          for(int j=0;j<polygons.size();j++)
          {
              
              if(max1<polygons.get(j).getPerimeter())
              {
                  max1=polygons.get(j).getPerimeter();
                  
              }    
          }
          System.out.println("The polygon with largest perimeter is Hexagon with perimeter of "+decimalFormat.format(max1)+"cms");
          System.out.println("*****************************************");
         
          System.out.println("Surface area to Volume ratio of given solids are:");
     
          ArrayList<String> solids = new ArrayList<String>();
          for(Solids solid:Solids.values()){
              solids.add(solid.name());
          }
        for (Polygon polygon : polygons) {
            String name=polygon.getName().toUpperCase();
            if(solids.contains(name))
            {
                System.out.println(polygon.getName() + ":\n" + "\tSurface area: "
                        + String.format("%.2f", polygon.getArea()) + "cm" + "\u00b2" + "\n\t"
                        + polygon.toString().substring(polygon.toString().indexOf("Volume: ")));
            }

        }
        System.out.println("******************************************");
        System.out.println("In ShapesDriver.java which is a driver class, we have assigned subclass objects \nto an arraylist of superclass type(polygon type). \nSo, we have used polymorphic substitution in the driver class \nwhile adding all the objects of subclass type to the arraylist of polygon type.");
        System.out.println("******************************************");
        System.out.println("For getting the largest area and largest perimeter and for getting the area and volume\nwe are invoking the get area and get perimeter and toString methods which are subclass methods\nwith the polygon type object which is super class, this is late binding polymorphism");
        System.out.println("******************************************");
    }   
}