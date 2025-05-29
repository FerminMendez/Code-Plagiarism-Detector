/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.util.Arrays;

/**
 *
 * @author dannocz
 */
public class Triplet {
    
    private int x;
    private int y;
    private int z;

    public Triplet(int x, int y, int z) {
        int[] array={x,y,z};
        Arrays.sort(array);
        
        this.x = array[0];
        this.y = array[1];
        this.z = array[2];
    }
    
    public boolean compliesWithP(int p){
        if(x>=p || y>=p || z>=p)
            return true;
        return false;
    }
    
    @Override
    public boolean equals(Object object){        
         Triplet triplet2= (Triplet)object;
        
         return (this.x==triplet2.x && this.y==triplet2.y && this.z==triplet2.z);
            
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.x;
        hash = 47 * hash + this.y;
        hash = 47 * hash + this.z;
        return hash;
    }
   
    
    public String toString(){
        return x+","+y+","+z;
    }

    public boolean surprised() {
       return validPair(x,y) && validPair(y,z) && validPair(x,z);
    }
    
    public boolean validPair(int y1, int y2){
         int r= y1-y2;
        return (r<=1 && r>=-1);
    }
    
}
