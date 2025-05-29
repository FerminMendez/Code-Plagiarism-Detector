/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.hallofmirrors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import uk.co.epii.codejam.common.AbstractProcessor;

/**
 *
 * @author jim
 */
public class HallOfMirrorsProcessor extends AbstractProcessor<Hall> {
    
    private static final HashMap<Integer, ArrayList<RayVector>> cachedRays =
            new HashMap<>();

    private static int ccase = 0;
    
    @Override
    public String processDatum(Hall datum) {
        System.out.println("Case: " + (++ccase));
        ArrayList<RayVector> vectors = getVectors(datum.D);
        int count = 0;
        for (RayVector rv : vectors) {
            Ray r = new Ray(datum.D * datum.D, rv, datum.meLocation);
            if (r.createsReflection(datum))
                count++;
        }
        return count + "";
    }
    
    public static ArrayList<RayVector> getVectors(int maxDistance) {
        ArrayList<RayVector> shortest = cachedRays.get(maxDistance);
        if (shortest != null)
            return shortest;
        ArrayList<RayVector> rays = new ArrayList<>();
        for (int x = -maxDistance; x <= maxDistance; x++) {
            for (int y = -maxDistance; y <= maxDistance; y++) {
                if (x == 0 && y == 0)
                    continue;
                if (x * x + y * y > maxDistance * maxDistance) 
                    continue;
                if (Math.abs(Fraction.GCD(x, y)) == 1)
                    rays.add(new RayVector(x, y));
            }
        }
        return rays;
    }
    
}
