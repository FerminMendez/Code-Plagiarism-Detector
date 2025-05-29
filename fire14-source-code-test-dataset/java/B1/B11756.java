
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;

class RecycledNumbers {

    private static int[] primeMap = new int[] {
        2, 3, 5, 7, 11, 13, 17, 19, 23, 29
    };

    public static void main(String[] args) 
        throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < n; i++) {
            int counter = 0;
            String[] line = reader.readLine().split(" ");
            int down = Math.max(10, Integer.parseInt(line[0]));
            int up = Integer.parseInt(line[1]);
            int tren = down;
            while (tren < up) {
                int limit = Math.min(up, (int) Math.pow(10, Math.ceil(Math.log10(tren + .1))));
                Map<Long, Set<String>> numbers = new TreeMap<Long, Set<String>>();
                for (; tren <= limit; tren++) {
                    long hash = hash(tren);
                    if (!numbers.containsKey(hash)) { numbers.put(hash, new TreeSet<String>()); }
                    numbers.get(hash).add(Integer.toString(tren));
                }
                
                for (Long key : numbers.keySet()) {
                    String[] vals = numbers.get(key).toArray(new String[] { });
                    for (int j = 0; j < vals.length - 1; j++) {
                        for (int k = j + 1; k < vals.length; k++) {
                            String first = vals[j];
                            String second = vals[k] + vals[k];
                            if (second.indexOf(first) != -1) {
                                counter++;
                            }
                        }
                    }
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + counter);
        }
        
    }
    
    private static long hash(int in) {
        long tmp = 1;
        while (in > 0) {
            tmp *= primeMap[in % 10];
            in /= 10;
        }
        return tmp;
    }

}