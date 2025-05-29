import java.io.*;
import java.util.*;

public class recycle{
    static class pair{
        int a,b;
        @Override
        public int hashCode(){ return a^b;}
        @Override
        public boolean equals(Object o){
            pair p = (pair)o;
            return p.a == a && p.b == b;
        }
    }

    public static void main(String args[]) throws Exception{
        Scanner s=  new Scanner(System.in);
        int nu= s.nextInt(); s.nextLine();
        int casen=1;while (nu-->0){
        
            int A = s.nextInt(); int B = s.nextInt(); 
                try{s.nextLine();}catch(Exception e){}
            Set<pair> pairs = new HashSet<pair>();
            long num=0;
            for (int i= A; i <=B;i++){
                int k=i;
                int digits = 0; int mult = 1;
                while (k>0){ digits++; k/=10; mult *= 10; }

                k=i; int sum = 0; 
                int m2 = 1;
                while (k>0){
                    sum += m2*(k%10);
                    boolean zero =k%10 == 0;
                    mult/=10;
                    k/=10;
                    int a = i;
                    int b = sum*mult+k;
                    if (!zero && b >= A && b <= B && a!=b){
                            pair p = new pair();
                            p.a = b; 
                            p.b = i;
                        if(!pairs.contains(p)) {
                            p.a = i; p.b=b;
                            if (!pairs.contains(p)){
                            num++;pairs.add(p);
                         //   System.out.println(p.a + "-"+p.b);
                            }
                        }
                    }
                    m2*=10;
                }
            }
            System.out.println("Case #"+casen++ +": "+ num);
       } 
    }
}
