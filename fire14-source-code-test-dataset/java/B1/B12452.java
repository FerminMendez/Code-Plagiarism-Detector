import java.util.*;
import java.io.*;
public class Josephus {
   public static void main(String[] args)throws IOException {
     FileInputStream is = null;
     try {
       is = new FileInputStream("input.txt");
       DataInputStream in = new DataInputStream(is);
       BufferedReader br = new BufferedReader(new InputStreamReader(in));
       String str;
       int n;
       String sn;
       int m;
       String sm;
       int counter = 0;
       int loop = Integer.parseInt(br.readLine());
       ArrayList<Integer> nlist = new ArrayList<Integer>();
       ArrayList<Integer> mlist = new ArrayList<Integer>();
       
       for (int i = 0 ; i < loop ; i++)  {
         str = br.readLine();
         n = Integer.parseInt(str.substring(0,str.length()/2));
         m = Integer.parseInt(str.substring(str.length()/2+1,str.length()));
         for (int k = n ; k < m ; k++){
           String current = Integer.toString(k);
           for (int j = 0; j< current.length()-1; j++){
             char c = current.charAt(0);
             current += c;
             
             current = current.substring (1,current.length());
             int check = Integer.parseInt(current);
             if (check > k && check <= m){
               nlist.add(k);
               mlist.add(check);
              // System.out.println(k+" , "+current);
               counter++;
              }
           }
         }
         System.out.println("Case #"+(i+1)+": "+counter);
         //System.out.println(nlist);
         //System.out.println(mlist);
         counter = 0; 
       }
 
       in.close();
     }catch (Exception e){//Catch exception if any
       System.err.println("Error: " + e.getMessage());
     }
   }
}