import java.io.*;

public class Dancing{
   public static void main(String args []){
        try{
            FileInputStream fstream = new FileInputStream("Btest.in");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            FileWriter ostream = new FileWriter("danceOut.txt");
            BufferedWriter out = new BufferedWriter(ostream);

            String str = br.readLine();
            int num = Integer.parseInt(str.replaceAll("\\s",""));

            String [] cases = new String[num];
            String temp;
            int k = 0;

            while((temp = br.readLine()) != null && k < num){
                cases[k] = temp;
                ++k;
            }

            for(int i=1; i<= num; i++){
                String scores = cases[i-1].trim();
                int n = calcScores(scores);
     
                out.write("Case #" + i + ": " + n);
                out.write("\n");
                out.flush();
            }
            out.close();
        }
        catch(Exception e){}
   }
   public static int calcScores(String input){
       String [] nums = input.split(" ");
       int N = Integer.parseInt(nums[0].replaceAll("\\s",""));
       int s = Integer.parseInt(nums[1].replaceAll("\\s",""));
       int p = Integer.parseInt(nums[2].replaceAll("\\s",""));

       int scores[] = new int[N];
       int max = 0;
       int sLeft = s;

       for (int i=0; i< N; i++)
           scores[i] = Integer.parseInt(nums[3+i].replaceAll("\\s",""));

       for(int i=0; i < N; i++){
           int x = scores[i];
           if(findMax(x) >= p)
               ++max;
           else{
               if(sLeft > 0 && findSurprise(x) >= p){
                   ++max;
                   --sLeft;                          
               }
           }
       }
       return max;
   }

   // Three cases: mod 1, mod 2 or mod 0
   public static int findMax(int x){
       if(x % 3 == 0)
           return x/3;
       else
           return (x/3) + 1;
   }

   public static int findSurprise(int x){
       if(x % 3 == 2)
           return (x/3) + 2;
       else if(x != 0)
           return (x/3) + 1;
       else
           return 0;
   }
}
