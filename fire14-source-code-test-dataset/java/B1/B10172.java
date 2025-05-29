import java.io.*;
import java.util.*;
public class codejam2
{

    void kick() throws IOException

    {
        FileReader fr=new FileReader("input.in");
        BufferedReader br=new BufferedReader(fr);

        FileWriter fw=new FileWriter("output.in");
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);

        String txt="";
        int tc=Integer.parseInt(br.readLine());
        int c=0;
        

        while((txt=br.readLine())!=null)
        {

            StringTokenizer st=new StringTokenizer(txt);
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int posi=0;

            for(int i=a; i<b; i++)
            {
                for(int j=i+1; j<=b; j++)
                {
                    String a1=Integer.toString(i);
                    String b1=Integer.toString(j);

                    if(pos(a1,b1))
                       { posi++;}

                }
            }
            
            c++;
            pw.println("Case #"+c+": "+posi);

        }
        
        

        pw.close();
        bw.close();
        fw.close();

        br.close();
        fr.close();
    }

    boolean pos(String s,String p)
    {

        p=p+p;

        for(int j=0; j<s.length(); j++)
        {
            String subs=p.substring(j,j+(s.length()));
            if(s.equalsIgnoreCase(subs))
            {
                return true;
            }
        }
        return false;
    }
}