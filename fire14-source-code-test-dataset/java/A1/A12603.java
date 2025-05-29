/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlecodequalificationround;

import java.util.Scanner;

/**
 *
 * @author LeongYan
 */
public class DancingWithGooglers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        int[] out = new int[t];
        for (int i = 0; i < t; i++) {
            out[i] = 0;
            int n = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();
            int[] scores = new int[n];
            for (int j = 0; j < n; j++) {
                scores[j] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                if(scores[j] > ((p * 3) - 3)){
                    out[i]++;
                }
                else if(scores[j] >= ((p * 3) - 4) && scores[j] <= ((p * 3) - 3) && s > 0){
                    if(scores[j] == 0){
                        
                    }
                    else{
                        out[i]++;
                        s--;
                    }
                }
            }
        }
        for (int i = 0; i < t; i++) {
            System.out.println("Case #" + (i + 1) + ": " + out[i]);
        }
    }
}
