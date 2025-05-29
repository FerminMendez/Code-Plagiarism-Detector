/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.*;
import java.util.StringTokenizer;

public class JavaApplication1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        if(args.length <= 0)
            System.out.println("Invalid input");
        String filename = args[0];
        BufferedReader br = new BufferedReader(new FileReader(filename));
        int numLines = Integer.parseInt(br.readLine());
        int higher,surprise,ans;
        for(int i=1; i<=numLines; i++)
        {
            higher = 0;
            surprise = 0;
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int p1 = 3*p-3;
            int p2 = 3*p-4;
            for(int j=1; j<=n; j++)
            {
                int t = Integer.parseInt(st.nextToken());
                if(p>1)
                    {
                    if(t>p1)
                        higher++;
                    else if(t>=p2)
                        surprise++;
                    }
                    else 
                    {
                        if(t>=p)
                                higher++;
                    }
            }
            ans = higher+(surprise>s?s:surprise);
                System.out.println("Case #"+i+": "+ans);
        }
    }
}
