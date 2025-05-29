
import java.io.*;
import java.util.HashSet;

public class code33 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fos = new FileWriter("outfile",false);
        BufferedWriter bw = new BufferedWriter(fos);
        int T=Integer.parseInt(br.readLine()), A , B , j ,i ;
        String str[];
        for(j=1;j<=T; j++)
        {
            str=br.readLine().split(" ");
            A= Integer.parseInt(str[0]); B=  Integer.parseInt(str[1]);
            
            bw.write("Case #"+j+": "+swapncal(A, B)+"\n");
        }
        bw.close();
        
        
    }
    public static int swapncal(int A,int B)
    {
        int n=0, p ,num; 
        String xs; 
        HashSet<Integer> set = new HashSet<Integer>();
        for (int x= A; x <=(A+B); x++)
            {
                set.clear();
                xs=x+"";
                for(p=1;p< xs.length();p++)
                {
                    num=Integer.parseInt(xs.substring(p)+xs.substring(0, p));
                    if( num > x && !set.contains(num) && num >=A && num <=B)
                    {
                        set.add(num);
                        n++;
                    }
                }
                
            }
        return n;
    }
}