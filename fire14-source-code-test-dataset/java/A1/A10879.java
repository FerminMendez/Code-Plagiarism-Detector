package org.klishu.googlers;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    public static int solve(int N, int S, int p, int[] t) {
                
        if (N == 0) {
            return 0;
        }
        
        int diff;
        for (int x = 0; x <= 10; x++) {
            diff = t[N - 1] - x * 3;
            switch (diff) {
                case 0:
                    if (x >= p) {
                        return solve(N-1, S, p, t) + 1;
                    } else {
                        return solve(N-1, S, p, t);
                    }
                case 1:
                    if (x + 1 >= p) {
                        return solve(N-1, S, p, t) + 1;
                    } else {
                        return solve(N-1, S, p, t);
                    }
                case 2:
                    if (x < 9 && S > 0) {
                        return Math.max(solve(N-1, S-1, p, t) + (x + 2 >= p ? 1 : 0),
                                        solve(N-1, S, p, t)   + (x + 1 >= p ? 1 : 0));
                    } else {
                        return solve(N-1, S, p, t) + (x + 1 >= p ? 1 : 0);
                    }
                case 3:
                    if (x < 9 && S > 0) {
                        return Math.max(solve(N-1, S-1, p, t) + (x + 2 >= p ? 1 : 0),
                                        solve(N-1, S, p, t)   + (x + 1 >= p ? 1 : 0));
                    } else {
                        return solve(N-1, S, p, t) + (x + 1 >= p ? 1 : 0);
                    }
                default:
                    // Continue
            }
        }
        
        return 0;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader("B-small-attempt0.in"));
            writer = new BufferedWriter(new FileWriter("B-small-attempt0.out"));
            
            int T = Integer.parseInt(reader.readLine());
            for (int i = 1; i <= T; i++) {
                String input = reader.readLine();
                String[] inputs = input.split(" ");
                
                int N = Integer.parseInt(inputs[0]);
                int S = Integer.parseInt(inputs[1]);
                int p = Integer.parseInt(inputs[2]);
                int[] t = new int[inputs.length - 3];
                for (int j = 3; j < inputs.length; j++) {
                    t[j-3] = Integer.parseInt(inputs[j]);
                }
                
                writer.append("Case #" + i + ": " + solve(N, S, p, t));
                writer.newLine();
            }
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (Exception ex) {
                Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
