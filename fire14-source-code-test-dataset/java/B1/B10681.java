/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * @author Kholoud
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileInputStream ifstream = new FileInputStream("C:\\Users\\Kholoud\\Downloads\\C-small-attempt0.in");
            DataInputStream in = new DataInputStream(ifstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n = Integer.parseInt( br.readLine());
            String line;
            for(int i = 0;i<n;i++)
            {
                int count = 0;
                line = br.readLine();
                int A = Integer.parseInt(line.split(" ")[0]);
                int B = Integer.parseInt(line.split(" ")[1]);
                Vector<String> rotatedNumbers;
                for(int num = A;num<=B;num++)
                {
                    rotatedNumbers = new Vector<String>();
                    String rotatedNum = String.valueOf(num);
                    for(int j = 0;j<String.valueOf(num).length()-1;j++)
                    {
                        rotatedNum = rotate(rotatedNum);
                        if(num < Integer.parseInt(rotatedNum) &&Integer.parseInt(rotatedNum) <= B && !rotatedNumbers.contains(rotatedNum))
                        {
                            rotatedNumbers.add(rotatedNum);
                            count++;
                        }
                    }
                }
                System.out.println("Case #" + (i + 1) + ": " + count);
            }
            
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
    public static String rotate(String num)
    {     
        String rotated = num.charAt(num.length()-1) + num.substring(0, num.length()-1);       
        return rotated;
    }
}
