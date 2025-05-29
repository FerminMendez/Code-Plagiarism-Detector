/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mrzk
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        try
        {
            Scanner inp = new Scanner(new File("mm.in"));
            FileWriter fw=new FileWriter(new File("mm.out"));
            String line=inp.nextLine();
            int cnt=Integer.valueOf(line);
            int a=0,b=0;
            for (int i = 0; i < cnt; i++)
            {
                line=inp.nextLine();
                int pos=line.indexOf(' ');
                String temp=line.substring(0, pos);
                a=Integer.valueOf(temp);
                temp=line.substring(pos+1, line.length());
                b=Integer.valueOf(temp);
                int cntrclc=countRecycledNumbers(a, b);
                fw.write("Case #"+String.valueOf(i+1)+": "+String.valueOf(cntrclc)+"\n");
            }
            fw.close();
            inp.close();
        }
        catch (Exception ex)
        {
        }
    }

    private static int countRecycledNumbers(int a,int b)
    {
        int cnt=0;
        for(int num=a;num<=b;num++)
        {
            int len=((int) Math.log10(num))+1;
            for (int i = 0; i < len; i++)
            {
                int temp=num;
                temp=(int) ((temp % Math.pow(10, i)) * Math.pow(10, len - i) + (temp / Math.pow(10, i)));
                if((temp>=a)&&(temp<=b)&&(temp>num))
                    cnt++;
            }
        }
        return cnt;
    }
}