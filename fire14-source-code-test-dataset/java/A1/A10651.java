/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingwiththegooglers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Kholoud
 */
public class DancingWithTheGooglers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            FileInputStream ifstream = new FileInputStream("C:\\Users\\Kholoud\\Downloads\\B-small-attempt1.in");
            DataInputStream in = new DataInputStream(ifstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            int n = Integer.parseInt( br.readLine());
            String line;
            for(int i = 0;i<n;i++)
            {
                int count = 0;
                line = br.readLine();
                String[] words = line.split(" ");
                int Googlers = Integer.parseInt(words[0]);
                int surCount = Integer.parseInt(words[1]);
                int p = Integer.parseInt(words[2]);
                for(int j = 0;j<Googlers;j++)
                {
                    int Score = Integer.parseInt(words[j+3]);
                    if(Score < p)
                    {
                       continue;
                    }
                    if(pass(Score,p))
                    {
                        count++;
                    }
                    else
                    {
                        if(surCount>0 && surprisePass(Score, p))
                        {
                            count++;
                            surCount--;
                        }
                    }
                }
                System.out.println("Case #" + (i + 1) + ": " + count);
            }
            
        } catch (Exception e) {
            System.out.print(e.toString());
        }
    }
    public static boolean pass(int num,int p)
    {
        if((num%3 == 0 && num/3 >= p) || ((num-1)%3 == 0 && ((num-1)/3)+1 >= p) || ((num-2)%3 == 0 && ((num-2)/3)+1 >= p))
        {
            return true;
        }
        return false;
    }
    public static boolean surprisePass(int num,int p)
    {
        if(((num-2)%3 == 0 && ((num-2)/3)+2 >= p) || ((num-3)%3 == 0 && ((num-3)/3)+2 >= p) || ((num-4)%3 == 0 && ((num-4)/3)+2 >= p))
        {
            return true;
        }
        return false;
    }
}
