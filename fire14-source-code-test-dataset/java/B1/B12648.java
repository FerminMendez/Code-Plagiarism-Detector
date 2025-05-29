import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.List;
import java.util.ArrayList;


public class Rec{
    static int rotate(int n, int l){
        int pot = (int)Math.pow(10,l-1);
        int ld = (int)Math.floor(n/pot);
        int cd = n-ld*pot;
        int ans = cd*10+ld;
        return ans;
    }
    
    static String bw(String a, int n){
        String ans = "";
        for(int i=n;i<a.length();i++)
            ans = ans + a.charAt(i);
        String ans2="";
        for(int i=0;i<a.length()-ans.length();i++)
            ans2 = ans2+a.charAt(i);
            
        System.out.println(a+"->"+ans+ans2);
        return ans+ans2;
    }

    public static int recnum(int a, int b){
        int[] test = new int[b-a+1];
        int ans = 0;
        int l=String.valueOf(a).length();

        for(int i=a;i<=b;i++){
            int c = i;
            List<Integer> reps = new ArrayList<Integer>();
            for(int j=1;j<l;j++){
                c=rotate(c,l);
                if(c<=b && c>i && String.valueOf(c).length()==l && c!=i && !reps.contains(c)){
                    ans++;
                    reps.add(c);
                    //System.out.println("("+String.valueOf(i)+","+String.valueOf(c)+")"); 
                }
            }
        }
        
        return ans;
    }

    public static void main(String[] args) throws IOException{
      BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
      String ttt = "";
      int n = Integer.parseInt(stdin.readLine());
      int i = 1;

      while (i<=n){
        ttt = stdin.readLine();
        String[] AB = ttt.split(" ");
        int a = Integer.parseInt(AB[0]);
        int b = Integer.parseInt(AB[1]);        
        System.out.println("Case #"+String.valueOf(i++)+": "+String.valueOf(recnum(a,b)));
      }

      stdin.close();

    }
}

