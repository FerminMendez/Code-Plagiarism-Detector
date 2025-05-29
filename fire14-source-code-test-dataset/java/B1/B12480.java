
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doda
 */
public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        BufferedReader R=new BufferedReader(new FileReader("C:\\Users\\doda\\Desktop\\C-small.in"));
        PrintWriter P=new PrintWriter(new FileWriter("C:\\Users\\doda\\Desktop\\small.txt"));
        while(R.ready()){
            int t=Integer.parseInt(R.readLine());
            for(int i=0;i<t;++i){
               StringTokenizer s=new StringTokenizer(R.readLine());
               int n=Integer.parseInt(s.nextToken());
               int m= Integer.parseInt(s.nextToken());
               int out=0;String O="Case #"+(i+1)+":";
               for(int j=n;j<m;++j){
                   int numbers[]=diffOrder(j);
                   for(int k=0;k<numbers.length;++k){
                       if(numbers[k]>j && numbers[k]<=m)++out;
                   }
               }
               O+=" "+out;
               P.println(O);
            }
        }
        P.close();
    }
    public static int [] diffOrder(int num){
        String s=""+num;
        ArrayList<Integer> in=new ArrayList<Integer>();
        int re[];
        for(int i=0;i<s.length()-1;++i){
            s=s.charAt(s.length()-1)+""+s.substring(0,s.length()-1);
            int y=Integer.parseInt(s);
            String h=""+y;
            if(h.length()<s.length())y=0;
            if(!in.contains(y))in.add(y);
        }
        re=new int[in.size()];
        for(int i=0;i<in.size();++i){
            re[i]=in.get(i);
        }
        return re;
    }
}
