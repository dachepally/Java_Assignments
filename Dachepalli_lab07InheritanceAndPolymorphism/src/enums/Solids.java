/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Sai Sri Dachepalli
 */
public enum Solids {
    TETRAHEDRON(4),CUBE(6),BOX(6);
    
    public int noFaces;
    
    private Solids(int noFaces)
    {
        this.noFaces = noFaces;
    }
    
}
