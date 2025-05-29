import java.io.*;
import java.util.*;

public class Recycled {
    public static void main(String[] args)throws IOException{
        new SolveRecycled();
    }
}
class SolveRecycled{
    public SolveRecycled()throws IOException
    {
        Scanner sc, oScan,scan;
        System.setOut(new PrintStream(new File("Recycled.out")));
        sc=oScan=scan=new Scanner(new File("Recycled.dat"));

        int runs = Integer.parseInt(sc.nextLine());
        for(int r123=1; r123<=runs; r123++)
        {
            System.out.print("Case #"+r123+": ");
            int A = sc.nextInt();
            int B = sc.nextInt();
            int count=0;
            ArrayList<pair>list = new ArrayList<pair>();
            for(int i=A; i<=B; i++)
            {
                String num=""+i;
                for(int j=0; j<num.length();j++)
                {
                    String t = num.substring(j)+num.substring(0,j);
                    pair p = new pair(i,Integer.parseInt(t));
                    if(!t.equals(num)&&(""+Integer.parseInt(t)).length()==num.length()&&!list.contains(p)&&Integer.parseInt(t)<=B&&i<Integer.parseInt(t))
                    {
                        list.add(p);
//                        System.out.println(p);
                    }
                }
            }
            System.out.println(list.size());

        }
    }


}
class pair{
    int one,two;
    public pair(int o, int t){
        one=o;
        two=t;
    }
    public boolean equals(Object o){
        pair p = (pair)o;
        return p.one==one&&p.two==two||p.one==two&&p.two==one;
    }
    public String toString(){
        return one+" - "+ two;
    }
}