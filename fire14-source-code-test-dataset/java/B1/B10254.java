import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class C {
    public static void main(String [] args) throws IOException {
        TreeSet<String> ts=new TreeSet<String>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int c=Integer.parseInt(br.readLine().trim());
        FileWriter fichero = new FileWriter("largoa.txt");
        PrintWriter pw = new PrintWriter(fichero);
        for(int kc=0;kc<c;kc++){
            int l,h;
            StringTokenizer st=new StringTokenizer(br.readLine());
            l=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());
            for(int i=l;i<=h;i++){
                String a=String.valueOf(i);
                String n="";
                for(int k=1;k<a.length();k++){
                    n=a.substring(k,a.length())+ a.substring(0,k);
                    if(String.valueOf(Integer.parseInt(n)).length()==a.length() && !n.equals(a)){
                            if(Integer.parseInt(n)<=h &&Integer.parseInt(n)>=l){
                                ts.add(a+" "+n);
                                ts.add(n+" "+a);
                            }
                          }
                    }
                }
            System.out.println("Case #"+(kc+1)+": "+ts.size()/2);
            //pw.println("Case #"+(kc+1)+": "+ts.size()/2);
            ts.clear();
        }
        fichero.close();
    }
}