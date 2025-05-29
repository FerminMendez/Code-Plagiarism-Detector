
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class Recycled {
    public static void main(String[] args) throws IOException {
        int[] powersOf10 = {1, 10, 100, 1000, 10000, 100000, 1000000};
        String inFileName = "C-small-attempt1.in";
        Scanner in = new Scanner(new File(inFileName));
        String outFileName = inFileName.substring(0, inFileName.lastIndexOf('.')) + ".out";
        PrintWriter out = new PrintWriter(outFileName);
        int numSets = in.nextInt();
        in.nextLine();
        for(int probSet = 1; probSet <= numSets; probSet++) {
            out.print("Case #" + probSet + ": ");
            int a = in.nextInt();
            int b = in.nextInt();
            HashSet<Pair> set = new HashSet<Pair>();
            int numOne = a;
            while(numOne <= b) {
                //figure out length of a, could use logs but don't want to worry
                //about double division, rounding, ceiling, etc.
                int temp = numOne;
                int len = 1;
                while((temp /= 10) > 0) len++;
                int numTwo = numOne;
                //cycle through all possible pairs with a
                for(int i = 0; i < len - 1; i++) {
                    int dig = numTwo % 10;
                    if(dig == 0) continue; //moving a 0 from the back to the front
                                            //would change the length of the number
                    numTwo /= 10;
                    numTwo += dig * powersOf10[len - 1];
                    if(numTwo < a || numTwo > b || numOne == numTwo) continue;
                    Pair pair = new Pair(numOne, numTwo);
                    set.add(pair);
                }
                numOne++;
            }
            out.println(set.size());
        }
        in.close();
        out.close();
    }
    
    private static class Pair {
        int one, two;
        public Pair(int o, int t) {
            one = o;
            two = t;
        }

        @Override
        public int hashCode() {
            return one + two; //a bad hash, but I need something commutative
        }
        
        public boolean equals(Object obj) {
            Pair other = (Pair) obj;
            return (other.one == one && other.two == two) || 
                    (other.one == two && other.two == one);
        }
        
        public String toString() {
            return "{" + one + ", " + two + "}";
        }
    }
}
