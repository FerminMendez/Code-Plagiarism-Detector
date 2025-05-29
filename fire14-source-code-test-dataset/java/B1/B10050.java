/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package google.code.jam.recycled.numbers;

/**
 *
 * @author Lucas
 */
public class GoogleCodeJamRecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Utils ut = new Utils();
        RecycledNumbers rn = new RecycledNumbers();
        
        ut.write(rn.findRecycledNumbers(ut.parse("Input/C-small-attempt0.in")), "Output/output");
        
    }
}
