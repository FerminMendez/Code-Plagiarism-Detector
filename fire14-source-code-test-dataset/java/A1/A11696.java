package dg.gcj.bdancing;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
* Created by IntelliJ IDEA.
* User: Dmitry
* Date: 15.04.12
* Time: 0:03
* To change this template use File | Settings | File Templates.
*/
public class Triplet
{
    int[] sorted;

    public Triplet(int[] sorted) {
        this.sorted = Arrays.copyOf(sorted, sorted.length);
    }

    public int getTotal() {
        return sorted[0] + sorted[1] + sorted[2];
    }

    public boolean isSurprising()
    {
        return this.sorted[2] - this.sorted[1] > 1 || this.sorted[1] - this.sorted[0] > 1 || this.sorted[2] - this.sorted[0] > 1;
    }

    public int getMaximumScore() {
        return sorted[2];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triplet triplet = (Triplet) o;

        return Arrays.equals(sorted, triplet.sorted);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.sorted);
    }

    @Override
    public String toString() {
        return "{" +  this.sorted[2] +
                ", " + this.sorted[1] +
                ", " + this.sorted[0] +
                '}';
    }
}
