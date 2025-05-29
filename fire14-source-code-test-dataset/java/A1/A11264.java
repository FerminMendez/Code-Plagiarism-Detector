// library In.java at http://introcs.cs.princeton.edu/stdlib/stdlib.jar

public class PB {
    public static void main (String[] args) {
        int t, n, s, p;
        
        int num, mod, quot;
        int maybe;
        int counter;
        int max;
        
        In in = new In("input.txt");
        t = Integer.parseInt(in.readLine());
        
        int i = 1;
        // get input
        while (in.hasNextLine()) {
            maybe = 0;
            counter = 0;
            n = in.readInt();
            s = in.readInt();
            p = in.readInt();
            
            for (int j = 0; j < n; j++) {
                num = in.readInt();
                quot = num / 3;
                mod = num % 3;

                if (mod == 1) {
                    if (quot + 1 >= p) {
                        counter++;
                        continue;
                    }
                    if (3 * p - 2 <= num) {
                        maybe++;
                        continue;
                    }
                }
                if (mod == 0){ 
                    if (quot >= p) {
                        counter++;
                        continue;
                    }
                    if (3 * p - 3 <= num && num != 0) {
                        maybe++;
                        continue;
                    }
                }
                if (mod == 2) {
                    if (quot + 1 >= p) {
                        counter++;
                        continue;
                    }
                    if (3 * p - 4 <= num) {
                        maybe++;
                        continue;
                    }
                }
            }
            max = Math.min(s, maybe);
            
            System.out.print("Case #" + i + ": " + (max + counter) + "\n");
            i++;
        }
    }
}
