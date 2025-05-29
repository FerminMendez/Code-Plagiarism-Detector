/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package google;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Arber
 */
public class Google {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path input_path = new File("Input.in").toPath();
        try {
            List<String> input_list = Files.readAllLines(input_path,Charset.forName("UTF-8"));
            int begin = 0;
            while(begin<input_list.size())
            {
                int start = new Integer(input_list.get(begin)).intValue();
                for(int i = 0; i<start; i++)
                {
                    String[] in = input_list.get(begin+i+1).split(" ");
                    int[] t = new int[in.length-3];
                    for(int j=3; j<in.length;j++)
                    {
                        t[j-3] = new Integer(in[j]).intValue();
                    }
                    System.out.println("Case #"+(i+1)+": " +google4(new Integer(in[0]).intValue(), new Integer(in[1]).intValue(), new Integer(in[2]).intValue(), t));
                }
                begin = begin + start + 1;
            }
        } catch (IOException ex) {
            Logger.getLogger(Google.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int google3(int n, int m)
    {
        ArrayList<String> a1 = new ArrayList<String>();
        for(int i = n; i<=m; i++)
        {
            for(int j = 1; j<(""+n).length();j++)
            {
                int rec = recycled(""+i, j);
                if(rec>=n &&rec<=m && rec != i)
                {
                    if(rec<i)
                    {
                        String tem = (""+rec)+(""+i);
                        if(!a1.contains(tem))
                            a1.add(tem);
                    }
                    else
                    {
                        String tem = (""+i)+(""+rec);
                        if(!a1.contains(tem))
                            a1.add(tem);
                    }
                }
            }
        }
        return a1.size();
            
    }
    public static int recycled(String s, int m)
    {
        s = s.substring(s.length()-m) + s.substring(0,s.length()-m);
        return new Integer(s).intValue();
    }
    public static int google4(int T,int s,int p, int[] t)
    {
        int rez = 0;
        for(int i=0; i<T; i++)
        {
            if(t[i]>=3*p-2)
                rez++;
            else if((t[i]>=3*p-4&&s>0&&p>1))
            {
                s--;
                rez++;
            }
        }
        return rez;
    }
}
