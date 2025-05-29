/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author dannocz
 */
public class Googler {
    
    private int score; //A score per googler
    private HashSet<Triplet> triplets; //A set of triplets per score
    private int surprisedCases;

    public Googler(int score, int surprisedCases) {
        this.score = score;
        this.surprisedCases=surprisedCases;
        this.triplets= new HashSet<Triplet>();
    }
    
    public void addTriplet(Triplet triplet)
    {
        triplets.add(triplet);
    }    
    
    public boolean result(int p){
        Iterator iterator=triplets.iterator();
        
        while (iterator.hasNext()) {
            Triplet triplet = (Triplet)iterator.next();
            if(triplet.compliesWithP(p) && triplet.surprised())
                return true;
        }
        
         iterator=triplets.iterator();
        while (iterator.hasNext()) {
            Triplet triplet = (Triplet)iterator.next();
            if(triplet.compliesWithP(p) && !triplet.surprised() && surprisedCases>0)
            {
                surprisedCases--;
                return true;
            }
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public HashSet<Triplet> getTriplets() {
        return triplets;
    }

    public void setTriplets(HashSet<Triplet> triplets) {
        this.triplets = triplets;
    }
    
    
}
