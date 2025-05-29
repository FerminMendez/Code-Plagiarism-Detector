
public class Pair2 {
    public int left;
    public int right;
    
    public Pair2(int left, int right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Pair2)) {
            return false;
        }
        
        Pair2 pOther = (Pair2) other;
        return (left == pOther.left && right == pOther.right);
    }
    
    @Override
    public String toString() {
        return left + " " + right;
    }

    @Override
    public int hashCode() {
        return left * 100001 + right;
    }
    
    
}
