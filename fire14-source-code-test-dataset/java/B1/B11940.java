import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ari
 */
public class ProblemC {
    static String in = "src/c.in";
    static String out = "src/c.out";
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner scan = new Scanner(new File(in));
        BufferedWriter write = new BufferedWriter(new FileWriter(out));
        int numlines = scan.nextInt();
        String mini;
        String maxi;
        byte[] min = new byte[7];
        byte[] max = new byte[7];
        byte[] iter = new byte[7];
        int numDigits;
        int numPossible;
        int answer;
        int[] rots = new int[7];
        byte currentRots;
        byte compare = 0;
        
        //Loop vars:
        int x;
        int y;
        int d;
        int m;
        int n;
        int rot;
        int count;
        
        for(x = 0; x < numlines; x++) {
            write.write("Case #" + (x+1) + ": ");
            mini = scan.next();
            maxi = scan.next();
            answer = 0;
            
            numPossible = Integer.parseInt(maxi) - Integer.parseInt(mini);
            numDigits = mini.length();
            
            for(y = 0; y < numDigits; y++) {
                min[y] = Byte.parseByte(""+mini.charAt(y));
                iter[y] = min[y];
                max[y] = Byte.parseByte(""+maxi.charAt(y));
            }
            
            for(count = 0; count < numPossible; count++) {
                currentRots = 0;
                for(rot = 1; rot < numDigits; rot++) {
                    compare = 0;
                    for(d = 0; d < numDigits - 1; d++) {
                        compare = iter[(d + rot) % numDigits];
                        if(compare > iter[d]) {
                            compare = -2;
                            break;
                        }
                        else if(compare < iter[d]) {
                            compare = -1;
                            break;
                        }
                    }
                    if(compare > -1) {
                        if(iter[(numDigits + rot - 1) % numDigits] > iter[numDigits - 1]) {
                            compare = -2;
                        }
                    }
                    if(compare == -2) {//rotation is greater
                        for(d = 0; d < numDigits; d++) {
                            compare = iter[(d + rot) % numDigits];
                            if(compare > min[d]) {
                                compare = 1;
                                break;
                            }
                            else if(compare < min[d]) {
                                compare = -1;
                                break;
                            }
                        }
                        if(compare > -1) {//>=min
                            for(d = 0; d < numDigits; d++) {
                                compare = iter[(d + rot) % numDigits];
                                if(compare > max[d]) {
                                    compare = -1;
                                    break;
                                }
                                else if(compare < max[d]) {
                                    compare = 1;
                                    break;
                                }
                            }
                            if(compare > -1) {//<=max
                                rots[currentRots] = rot;
                                currentRots++;
                                answer++;
                            }
                        }
                    }
                }
                
                for(n = 0; n < currentRots-1; n++) {
                    for(m = n+1; m < currentRots; m++) {
                        for(d = 0; d < numDigits; d++) {
                            compare = iter[(d + rots[n]) % numDigits];
                            compare -= iter[(d + rots[m]) % numDigits];
                            if(compare != 0) {
                                compare = 1;
                                break;
                            }
                        }
                        if(compare == 0) {
                            answer--;
                            break;
                        }
                    }
                }
                
                for(d = numDigits-1; d >= 0; d--) {
                    if(iter[d] == 9) {
                        iter[d] = 0;
                    }
                    else {
                        iter[d]++;
                        break;
                    }
                }
            }
            
            write.write("" + answer);
            write.write('\n');
        }
        scan.close();
        write.close();
    }

    private static void print(byte[] iter, int rot) {
        for(int d = 0; d < iter.length; d++) {
            System.out.print(""+iter[(d + rot) % iter.length]);
        }
    }
    
    private static int get(byte[] iter, int rot, int length) {
        String s = "";
        for(int d = 0; d < length; d++) {
            s+=iter[(d + rot) % length];
        }
        return Integer.parseInt(s);
    }
}
