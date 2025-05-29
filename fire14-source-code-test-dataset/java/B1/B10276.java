
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Mody
 */
public class c {

    public static void main(String[] args) throws FileNotFoundException, IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new FileReader("C-small-attempt0.in"));
        FileWriter out= new FileWriter("sol.out");
        int t = Integer.parseInt(in.readLine());
        StringTokenizer st;
        int a, b ;
        int ret=0;
        String s1="",s2="";
        for (int i = 0; i < t; i++) {
            st=new StringTokenizer(in.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            ret=0;
            for (int j = a; j <=b; j++) {
                for (int k = j+1; k <=b; k++) {
                    s1=j+"";
                    s2=k+"";
                    
                    if(s1.length()!=s2.length())
                        break;
                    
                        ret+=is(s1,s2);
                    
                        
                }
            }
            out.write("Case #"+(i+1)+": "+ret);
            if(i!=t-1)
                out.write("\n");
        }
        out.close();


    }
   private static int is(String s1, String s2) {
        String s,ss;
        if(s1.length()==2)
            if(s1.charAt(0)==s2.charAt(1)&&s1.charAt(1)==s2.charAt(0))
                return 1;
        for (int i = 1; i < s1.length(); i++) {
            s=s1.substring(0,i);
            ss=s1.substring(i,s1.length());
           if(!s.equals("")&&!ss.equals(""))
            if(s2.endsWith(s)&&s2.startsWith(ss)){
                return 1;
            }
        }
        return 0;
    }
}
