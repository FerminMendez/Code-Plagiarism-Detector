import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Recycled {
    public static void main(String []args)
    {
        int T,counter = 1;
       try {
         BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("output.txt"))));
           String input = reader.readLine();
            T = Integer.parseInt(input);
            while (T-->0)
            {
                input= reader.readLine();
                String []in = input.split(" ");
                int A,B;
                A=Integer.parseInt(in[0]);
                B=Integer.parseInt(in[1]);
                int numPairs = 0;
                for(int i=A;i<=B;i++)
                {
                    Set<Integer> pairs = new HashSet<Integer>();
                    String num = String.valueOf(i);
                    int currentHighestFaceValue = num.charAt(0);
                    for(int j=num.length()-1;j>0;j--)
                    {
                       if(num.charAt(j)=='0')
                        {
                            continue;
                        }
                       if(num.charAt(j)<currentHighestFaceValue)
                        {

                        }
                        else
                        {
                            String poss = num.substring(j) + num.substring(0,j);
                            int possNum = Integer.parseInt(poss);
                            if(possNum<=B && i<possNum)
                            {
                                pairs.add(possNum);
                            }
                        }
                   }
                        numPairs+=pairs.size();
                    }

                writer.write("Case #"+counter+": "+numPairs+"\n");
                counter++;
            }
           writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
