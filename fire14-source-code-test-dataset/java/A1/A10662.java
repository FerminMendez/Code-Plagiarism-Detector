package codejam.world2012.qualification.b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class B {
    
    private static class Triplet {
        public boolean surprising = false;
        public boolean unsurprising = false;
        
        public Triplet() {}
        
        public Triplet(boolean surprising, boolean unsurprising) {
            this.surprising = surprising;
            this.unsurprising = unsurprising;
        }
        
        @Override
        public String toString() {
            return "[ " + (surprising?"surprising":"") + " " + (unsurprising?"unsurprising":"") +  " ]";
        }
    }

    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("src/codejam/world2012/qualification/b/small.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter("src/codejam/world2012/qualification/b/small.out"));
        
        HashMap<Integer, HashMap<Integer, Triplet>> matrix = new HashMap<Integer, HashMap<Integer, Triplet>>();
        
        for (int q = 0; q<=10; q++) {
            HashMap<Integer, Triplet> row = new HashMap<Integer, Triplet>();
            for (int r=0; r<31; r++) row.put(r, new Triplet(false, false));
            matrix.put(q, row);
        }
        
        for (int i = 10; i>= 0; i--) {
            for (int j=i; j >= i-2; j--) {
                if (j < 0) continue;
                
                for (int k = i; k >= i-2; k--) {
                    if (k < 0) continue;
                    
                    int ti = i+j+k;
                    
                    Triplet triplet = matrix.get(i).get(ti);
                    if (triplet == null) triplet = new Triplet();
                    
                    if ((i-j == 2) || (i-k == 2) || (j-k == 2)) {
                        // surprising
                        triplet.surprising = true;
                    } else {
                        // unsurprising
                        triplet.unsurprising = true;
                    }
                    matrix.get(i).put(ti, triplet);
                }
                
            }
        }
        
        for (int ti=0; ti<31; ti++) {
            Triplet triplet = new Triplet(false, false);
            for (int p = 10; p>= 0; p--) {
                if (matrix.get(p).get(ti).surprising) triplet.surprising = true;
                if (matrix.get(p).get(ti).unsurprising) triplet.unsurprising = true;
                matrix.get(p).put(ti, new Triplet(triplet.surprising, triplet.unsurprising));
            }
        }
        
        int T = 0;
        T = Integer.parseInt(in.readLine());
        
        for (int t = 0; t < T; t++) {
            String[] line = in.readLine().split(" ");
            
            Long N = Long.parseLong(line[0]);
            Long S = Long.parseLong(line[1]);
            Integer p = Integer.parseInt(line[2]);
            List<Integer> scoresList = new ArrayList<Integer>();
            
            Long answer = 0L;
            
            for (int i = 3; i< line.length; i++) {
                scoresList.add(Integer.parseInt(line[i]));
            }
            
            for (Integer ti : scoresList) {
                
                Triplet triplet = matrix.get(p).get(ti);
                
                if (triplet.surprising && !triplet.unsurprising) {
                    if (S > 0) {
                        answer++;
                        S--;
                    }
                } else if (triplet.unsurprising) {
                    answer++;
                }
            }
            
            out.write("Case #"+String.valueOf(t+1) +": "+answer.toString());
            if (t < T-1) out.write(System.getProperty("line.separator"));
            
            /*
            for (Long totalScore : scoresList) {
                Long diff = totalScore - p;
                Long first = Math.round((double) diff/2);
                
                if (p - first > 2) {
                    // impossible
                    continue;
                }
                
                Long second = diff - first;
                if (p - second > 2) {
                    // impossible
                    continue;
                }
                
                
            }
            
            
            for (Long totalScore : scoresList) {
                
                // ceiling
                Long ceil = Math.round(Math.ceil(totalScore/3));
                Long floor = Math.round(Math.floor(totalScore/3));
                
                if (ceil == floor) {
                    // nice
                    
                } else {
                    
                    if (ceil*3 - totalScore < 3) {
                        
                    }
                    
                    if (totalScore - floor*3 < 3) {
                        
                    }
                    
                }
                
                //System.err.println("total: " + totalScore + ", average: " + average);
                Long diff = average*3 - totalScore; // diff > 0 
                
                Long max =  0L;
                if (diff > 0) max = average + diff;
                else max = average;
                if (max >= p) answer++;
                if ((Math.abs(diff) > 1) && (S > 0)) S--;
            }
            
            if (S == 0) {
                System.err.println("Case #"+String.valueOf(t+1) +": "+answer.toString());
                continue;
            }
            
            // S > 0
            
            for (Long totalScore : scoresList) {
                Long average = Math.round((double) totalScore/3);
                Long diff = totalScore - average*3;
                
                Long max =  0L;
                if (diff > 0) max = average + diff;
                else max = average;
                
                if (Math.abs(diff) > 0) continue;
                if (max >= p) continue;
                if (S == 0) break;
                max = average + 1;
                S--;
                if (max >= p) answer++;
            }
            System.err.println("Case #"+String.valueOf(t+1) +": "+answer.toString());
             */
        }
        
        out.close();
    }
    
}
