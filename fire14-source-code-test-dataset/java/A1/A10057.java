/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package google.code.jam.dancing.with.the.googlers;

/**
 *
 * @author Lucas
 */
public class GoogleCodeJamDancingWithTheGooglers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Utils ut = new Utils();
        BestResultFinder brf = new BestResultFinder();
        
        ut.write(brf.findBestResult(ut.parse("Input/B-small-attempt2.in")), "Output/output");
        
    }
}
