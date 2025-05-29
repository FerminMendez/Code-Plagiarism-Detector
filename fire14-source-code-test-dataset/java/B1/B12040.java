/** QProblemC.java
 * 
 * Solves Problem C of the Qualification round of the Google Code Jam 2012
 * Tests for the 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class QProblemC {
	
	public static void main(String[] args) {
		try {
			Scanner in = new Scanner(new BufferedReader(
                    new FileReader("C-small-attempt3.in")));
			BufferedWriter out = new BufferedWriter(new FileWriter(
                    new File("C-small.out")));
			int numberOfTests = in.nextInt();

            // Given integers
            int A = 0;
            int B = 0;
            
            // Variables for recycled pairs
            int n = 0;
            String nString; // To check the number of digits for equality with m
            String m = ""; // String avoids problem of losing 0 as a digit
            int mInt = 0;
            String mTemp; // Remove leading 0s before length equality
            
            // Reference for m to test when a full rotation has occurred
            String originalM = "";
            
            int count = 0;
            
			for(int i = 0; i < numberOfTests; i++) {
				System.out.print("Case #" + (i+1) + ": ");
				out.write("Case #" + (i+1) + ": ");

                A = in.nextInt();
                B = in.nextInt();
                n = A;
                nString = "" + n;
                
                // Run through all the numbers between A and B looking for
                // recycled pairs
                while(n < B) {
                    m = "" + n;
                    originalM = m; 
                    m = rotate(m);
                    
                    // Run through all possible recycles of n
                    while(!m.equals(originalM)) {
                        mInt = Integer.parseInt(m);
                        mTemp = "" + mInt; // For check without leading 0s
                        // If a recycle fits our constraints, count it
                        if(mInt > n && mInt <= B && 
                                mTemp.length() == nString.length()) {
                            count++;
                        }
                        m = rotate(m);
                    }
                    
                    n++;
                    nString = "" + n;
                }
                
                
                System.out.println(count);
                out.write(count + "\n");
                
                count = 0;
			}

			in.close();
			out.close();
		} catch (IOException e) {
			System.out.println("Error reading file. " + e);
		}
	}
    
    /** 
     * "Rotates" the given string so that the last character becomes the first
     * character.
     * 
     * @param x. The string to rotate.
     * @return String. The rotated string
     */
    public static String rotate(String x) {
        // Only take action if there are multiple characters
        if (x.length() > 1) {
            char lastChar = x.charAt(x.length() - 1);
            // Remove last char from buffer string, then add it to the front
            x = "" + lastChar + x.substring(0, x.length() - 1);
        }
        return x;
    }
}
