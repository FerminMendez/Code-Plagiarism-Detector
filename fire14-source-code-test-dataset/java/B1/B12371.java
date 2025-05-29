/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ka
 */
public class Recy {
        private File file;
    private int aantal;
    private ArrayList<String> cases;
    private ArrayList<Integer> max;
    public Recy(File f) throws FileNotFoundException
    {
        file = f;
        Scanner scanner = new Scanner(new FileReader(file));
        aantal = scanner.nextInt();
        cases = new ArrayList<String>(aantal);
        max = new ArrayList<Integer>(aantal);
        scanner.nextLine();
        for(int i =0; i < aantal ; i++)
        {
            String s = scanner.nextLine();
            cases.add(s);
        }
        System.out.println(cases);
    }
    public void scores()
    {
        for(String s : cases)
        {
            int counter = 0;
            ArrayList<Integer> nb = new ArrayList<Integer>();
            String sb = "";
            while(counter < s.length())
            {
                if(s.charAt(counter)!= ' ')
                {
                    sb = sb + s.charAt(counter);
                }
                if(s.charAt(counter) == ' '&& counter != s.length()-1)
                {
                    int n = Integer.parseInt(sb);
                    nb.add(n);
                    sb = "";
                }
                counter++;
            }
            if(counter == s.length())
            {
                int n = Integer.parseInt(sb);
                nb.add(n);
                sb = "";
            }
            System.out.println(nb);
            options(nb);
        }
    }
    public void options(ArrayList<Integer>nr)
    {
        int n = nr.get(0), m = nr.get(1),amount=0;
        if(n < 10 && m < 10)
            amount = 0;
        else if(n >= 10 && n < 100&& n % 10 < 10)
        {
            for(int i = n ; i < m ; i++)
            {
                String s = Integer.toString(i);
                int g = Integer.parseInt(s);
                String s1 = s.charAt(1)+""+ s.charAt(0)+"";
                int r = Integer.parseInt(s1);
                if(g >= n && g <= m && r >= n && r <= m && g < r )
                    amount++;
            }
        }
        else if(n >= 100 && n < 1000)
        {
            for(int i = n ; i < m ; i++)
            {
                String s = Integer.toString(i);
                int g = Integer.parseInt(s);
                String s1 = s.charAt(2)+""+ s.charAt(0)+""+s.charAt(1);
                String s2 = s.charAt(1)+""+ s.charAt(2)+""+s.charAt(0);
                int r = Integer.parseInt(s1);
                int r1 = Integer.parseInt(s2);
                if(g >= n && g <= m && r >= n && r <= m && g < r )
                    amount++;
                if(r != r1)
                {
                    if(g >= n && g <= m && r1 >= n && r1 <= m && g < r1 )
                        amount++;
                }
            }
        }
        else if(n >= 1000 && n < 10000)
        {
            for(int i = n ; i < m ; i++)
            {
                String s = Integer.toString(i);
                int g = Integer.parseInt(s);
                String s1 = s.charAt(3)+""+s.charAt(0)+""+ s.charAt(1)+""+s.charAt(2);
                String s2 = s.charAt(2)+""+s.charAt(3)+""+ s.charAt(0)+""+s.charAt(1);
                String s3 = s.charAt(1)+""+s.charAt(2)+""+ s.charAt(3)+""+s.charAt(0);
                int r = Integer.parseInt(s1);
                int r1 = Integer.parseInt(s2);
                int r2 = Integer.parseInt(s3);
                if(g >= n && g <= m && r >= n && r <= m && g < r )
                    amount++;
                if(r != r1 && r1 != r2 && r != r2)
                {
                    if(g >= n && g <= m && r1 >= n && r1 <= m && g < r1 )
                        amount++;
                    if(g >= n && g <= m && r2 >= n && r2 <= m && g <= r2 )
                        amount++;
                }
            }
        }
        max.add(amount);
    }
        public void output(BufferedWriter out) throws FileNotFoundException, IOException
    {
        int counter = 1;
        for(Integer s : max )
        {
            out.write("Case #" + counter + ": ");
            out.write(s+"\n");
            counter++;
        }
        out.close();
    }
}
