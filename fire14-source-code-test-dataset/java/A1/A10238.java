import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class dancing {
    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T;
        String input;
        try {
            input = reader.readLine();
            T  = Integer.parseInt(input);
            int counter = 1;
            while (T-->0)
            {
                int N,S,P;
                List<Integer> scores = new ArrayList<Integer>();
                Map<Integer,Integer> frequency = new HashMap<Integer,Integer>();
                for(int i=0;i<31;i++)
                {
                    frequency.put(i,0);
                }
                input = reader.readLine();
                String[] in = input.split(" ");
                N = Integer.parseInt(in[0]);
                S= Integer.parseInt(in[1]);
                P=Integer.parseInt(in[2]);
                int count = 3;
                while(count<N+3)
                {
                    int num = Integer.parseInt(in[count]);
                    scores.add(num);
                    frequency.put(num,frequency.get(num)+1);
                    count++;
                }
                int upperbound;
                if(P>=1)
                {
                    upperbound = P+2*(P-1);
                }
                else
                {
                    upperbound = 0;
                }
                int lowerBound;
                if(P>=2)
                {
                    lowerBound = P+2*(P-2);
                }
                else
                {
                        lowerBound =-1;
                }
                int sure = 0;
                List<Integer> possibleScores = new ArrayList<Integer>(frequency.keySet());
                Collections.sort(possibleScores);
                for(int i=upperbound;i<31;i++)
                {
                    sure += frequency.get(i);
                }
                int maxPossibleSurprises=0;
                if(lowerBound != -1)
                {
                    for(int i=lowerBound;i<upperbound;i++)
                    {
                        maxPossibleSurprises += frequency.get(i);
                    }
                }
                int actualNumber = Math.min(maxPossibleSurprises,S);
                int ans = actualNumber +sure;
                System.out.println("Case #"+counter+": "+ans);
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
