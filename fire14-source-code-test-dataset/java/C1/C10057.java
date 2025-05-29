/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.hallofmirrors;

/**
 *
 * @author jim
 */
public class Ray {
    
    
    private final Fraction expiryLengthSquared;
    public RayVector vector;
    
    private FractionPoint currentLocation;
    private Fraction xTravelled;
    private Fraction yTravelled;
    
    public Ray(int expiryLengthSquared, RayVector vector, 
            FractionPoint startLocation) {
        this.expiryLengthSquared = new Fraction(expiryLengthSquared);
        this.vector = vector;
        this.currentLocation = startLocation;
        xTravelled = new Fraction(0, 1);
        yTravelled = new Fraction(0, 1);
    }
    
    public static FractionPoint locationChangeInSq(FractionPoint enter, RayVector v) {
        Fraction xFrac = enter.x.fractionalPart();
        Fraction yFrac = enter.y.fractionalPart();
        Fraction xLen;
        Fraction yLen;
        if (xFrac.n == 0) {
            xLen = new Fraction(1);
            yLen = yFrac.n == 0 ? new Fraction(1) : 
                    (v.y < 0 ? yFrac : new Fraction(1).substract(yFrac));
        }
        else if (yFrac.n == 0) {
            yLen = new Fraction(1);
            xLen =  xFrac.n == 0 ? new Fraction(1) :
                    (v.x < 0 ? xFrac : new Fraction(1).substract(xFrac));
        }
        else {
            yLen = v.y < 0 ? yFrac: new Fraction(1).substract(yFrac);
            xLen = v.x < 0 ? xFrac: new Fraction(1).substract(xFrac);
        }
        Fraction scalar;
        if (xLen.multiply(v.getScalarGardient()).compareTo(yLen) > 0) 
            scalar = yLen.divide(Math.abs(v.y));
        else 
            scalar = xLen.divide(Math.abs(v.x));
        FractionPoint fp =
                new FractionPoint(scalar.multiply(v.x), scalar.multiply(v.y));
        return fp;
    }
    
    public FractionPoint locationChangeInSq() {
        return locationChangeInSq(currentLocation, vector);
    }
    
    public boolean createsReflection(Hall h) {
//        System.out.println("\nRay: " + vector.toString());
        Boolean b = null;
        while (b == null)
            b = step(h);
//        System.out.println(b);
        return b;
    }
    
    public Boolean step(Hall h) {
        FractionPoint locationChange = locationChangeInSq();
        if (locationChange.x.isInt() || locationChange.y.isInt()) {
            FractionPoint changeToMid = new FractionPoint(
                locationChange.x.divide(2), 
                locationChange.y.divide(2));
            FractionPoint midpoint = currentLocation.add(changeToMid);
            if (midpoint.equals(h.meLocation)) {
                xTravelled = xTravelled.add(changeToMid.x.abs());
                yTravelled = yTravelled.add(changeToMid.y.abs());
                return stillGoing();
            }
        }
        currentLocation = currentLocation.add(locationChange);
        vector = h.processBoundary(currentLocation, vector);
        if (vector == null)
            return false;
        xTravelled = xTravelled.add(locationChange.x.abs());
        yTravelled = yTravelled.add(locationChange.y.abs()); 
//        System.out.println("Chng: " + locationChange);
//        System.out.println("Loc: " + currentLocation);
//        System.out.println("d: " + distanceTravelled());
        if (!stillGoing())
            return false;
        else
            return null;
   }
    
    private Fraction distanceTravelled() {
        Fraction f = xTravelled.multiply(xTravelled).add(
                yTravelled.multiply(yTravelled));
        return f;
    }
    
    private boolean stillGoing() {
        int compare = distanceTravelled().compareTo(
                expiryLengthSquared);
        return compare <= 0;
    }

    public FractionPoint getCurrentLocation() {
        return currentLocation;
    }
}
