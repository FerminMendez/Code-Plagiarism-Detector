import java.io.*;
import java.util.*;
class Problems 
{
    public static void main (String [] args) throws Exception 
    {
        BufferedReader f = new BufferedReader(new FileReader("input.java"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.java")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T=Integer.parseInt(st.nextToken());
        for(int t=0;t<T;t++) {
            st=new StringTokenizer(f.readLine());
            int A=Integer.parseInt(st.nextToken());
            int B=Integer.parseInt(st.nextToken());
            long ans=0;
            for(int i=A;i<=B;i++) {
                for(int j=i+1;j<=B;j++) {
                    String a=i+"";
                    String b=j+"";
                    boolean works=false;
                    int count=0;
                    while(count<a.length()&&!a.equals(b)) {
                        a=a.substring(1,a.length())+a.charAt(0);
                        count++;
                    }
                    if(a.equals(b)) works=true;
                    count=0;
                    while(count<a.length()&&!a.equals(b)) {
                        a=a.charAt(a.length()-1)+a.substring(0,a.length()-1);
                        count++;
                    }
                    if(a.equals(b)) works=true;
                    if(works) ans++;
                }
            }
            out.println("Case #"+(t+1)+": "+ans);
        }
        out.close();
        System.exit(0);
    }
}
