import java.io.*;
import java.lang.*;
import java.util.*;

public class Recycle{
   public static void main(String args []){
        try{
            FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            FileWriter ostream = new FileWriter("recOut.txt");
            BufferedWriter out = new BufferedWriter(ostream);

            String str = br.readLine();
            int num = Integer.parseInt(str.replaceAll("\\s",""));

            String [] AB = new String[num];
            String temp;
            int k = 0;

            while((temp = br.readLine()) != null && k < num){
                AB[k] = temp;
                ++k;
            }

            //for(int i=1; i<= num; i++){
            for(int i=1; i<= num; i++){
                String ABs = AB[i-1].trim();
                int n = calcDig(ABs);
     
                out.write("Case #" + i + ": " + n);
                out.write("\n");
                out.flush();
            }
            out.close();
        }
        catch(Exception e){}
   }
   public static int calcDig(String input){
       String [] nums = input.split(" ");
       int A = Integer.parseInt(nums[0].replaceAll("\\s",""));
       int B = Integer.parseInt(nums[1].replaceAll("\\s",""));

       if(A < 10)
           return 0;
        else return numRot(A, B);     
   }

   public static int numRot(int A, int B){
       int toRet = 0;
       int len = Integer.toString(A).length();
       int cur = A;
       //System.out.println(A);
       //System.out.println(B);
       //System.out.println(len);

       HashMap<Integer, Integer> sets = new HashMap<Integer, Integer>();

       while(cur < B){
           for(int j=1; j< len; j++){         
               int newPerm = Rotate(cur, j, len);
               int newLen = Integer.toString(newPerm).length();
               //System.out.println(cur + " " +newPerm);
               if(B >= newPerm && newLen == len && cur < newPerm){
                   ++toRet;
                   //sets.put(cur, newPerm);
                   if(sets.containsKey(cur)){
                       if(sets.get(cur) == newPerm){
                           //System.out.println("Found: " + sets.get(cur));
                           --toRet;
                       }
                   }
                   else{
                    sets.put(cur, newPerm);
                   }
               }
               /*
               else
                   System.out.println("  perm " + newPerm + " not counted");
                   */
           }
           ++cur;
       }
       return toRet;
   }

   public static int checkRot(int A, int B, int len){
     //System.out.print("A: " + A);
     //System.out.println("B: " + B);

     List<Integer> aList = new ArrayList<Integer>();
     List<Integer> bList = new ArrayList<Integer>();

     int a = A;
     int b = B;

     while(a > 0){
         aList.add(a % 10);
         bList.add(b % 10);
         a /= 10;
         b /= 10;
      }
     
     Collections.sort(aList);
     Collections.sort(bList);

     if(aList.equals(bList)){
         //nreturn iterRot(A, B, len);
         return 0;
     }
     else
         return 0;
   }

   /*
   public static int iterRot(int A, int B, int len){
       int toRet = 0;
       for(int i=1; i<len; i++){
           if(Rotate(A, i, len) <= B)
               ++toRet;
       }
       return toRet;
    }*/

   public static int Rotate(int n, int k, int len){
       int rem = len-k;
       int place = (int)Math.pow(10,(rem));
       //System.out.println(place);
       int x = n/place;               
       //System.out.println(x);
       int y = n % place;
       //System.out.println(y);
       int newPlace = (int)Math.pow(10,k);

       return (y*newPlace) + x; 
   }
}

