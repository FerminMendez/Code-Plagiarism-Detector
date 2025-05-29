package googlers;

/**
 *
 * @author amr
 */
import java.io.*;
public class Main {


    public static void main(String[] args) throws Exception 
    {
         FileWriter foutstream = new FileWriter("result.out");
        FileReader finstream  = new FileReader("B-small-attempt5.in");
        PrintWriter out = new PrintWriter(foutstream);
        BufferedReader br = new BufferedReader(finstream);
        int i=0,count=1,result=0;
        int N,S,P,min_val_1,min_val_2;
        while(br.ready())
        {
            i++;
            String str = br.readLine();
            if(i != 1)
            {
               result = 0;
               String str_arr[] = str.split(" ");
               int arr[] = new int[str_arr.length];
               for(int j=0 ; j<arr.length ; j++)
               {
                   arr[j] = Integer.parseInt(str_arr[j]);
               }
               N = arr[0];
               S = arr[1];
               P = arr[2];
             
                   min_val_1 = P+P-2+P-2;
                   min_val_2 = P+P-2+P-1;

               int min_val_1_count = 0;
               int min_val_2_count = 0;
               for(int j=3 ; j<arr.length ; j++)
               {
                   if(P > 1)
                   {
                   if(arr[j] > min_val_1 && arr[j] > min_val_2)
                       result++;

                   if(arr[j] == min_val_1)
                        min_val_1_count++;

                   if(arr[j] == min_val_2)
                       min_val_2_count++;
                   }
                    else
                   {
                       if(arr[j] >= P)
                           result++;
                    }
               }

               if(S == 0 || P <= 1)
               {
               out.print("Case #"+count+": ");
                out.println(result);
               }
               else if(S > 0)
               {
                    int d = 0;
                    int x = min_val_1_count + min_val_2_count ;

                    if(x >= S)
                        d = S;
                    else
                        d = x;

                        out.print("Case #"+count+": ");
                        out.println(result+d);

               }
                count++;
             }

    }
        out.close();
    }

}
