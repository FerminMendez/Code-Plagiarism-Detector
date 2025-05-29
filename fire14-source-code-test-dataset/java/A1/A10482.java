
public class Pair {
    public int max;
    public boolean surprise;
    
    public Pair(int max, boolean surprise) {
        this.max = max;
        this.surprise = surprise;
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pair)) {
            return false;
        }
        
        Pair pOther = (Pair) other;
        return (max == pOther.max && surprise == pOther.surprise);
    }
    
    @Override
    public String toString() {
        return max + " " + surprise;
    }

    @Override
    public int hashCode() {
        // Dirty implementation
        return 0;
    }
    
    
}
