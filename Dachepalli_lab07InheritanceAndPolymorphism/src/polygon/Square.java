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
public class Square extends RegularPolygon{

    public Square(String name, int noSides, double length) {
        super(name, noSides, length);
    }

    public Square(double length) {
        super("Square",4,length);
    }
    public Square(String name,double length) {
        super(name,4,length);
    }
}
