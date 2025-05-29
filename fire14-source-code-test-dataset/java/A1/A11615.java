import java.io.*;
import java.util.*;

public class Surprising {

    public static void main(String[]argsr)throws IOException
    {
        System.setOut(new PrintStream(new File("Surprising.out")));
        new DoSurprising();
    }

}

class DoSurprising
{
    int num, surp, target;
    Score[]scores;
    int max;

    public DoSurprising() throws IOException
    {
        Scanner sc = new Scanner(new File("Surprising.in"));
        int runs = Integer.parseInt(sc.nextLine().trim());
        int count = 0;
        while(count++<runs)
        {
            System.out.print("Case #"+count+": ");
            num = sc.nextInt();
            surp = sc.nextInt();
            target = sc.nextInt();
            scores = new Score[num];
            for(int i=0;i<num;i++)
                scores[i] = new Score(sc.nextInt());
            max = 0;
            find(0,0);
            System.out.println(max);
        }
    }

    void find(int ind, int sur)
    {
        if(sur == surp)
        {
            max = Math.max(max,targeted());
            //System.out.println(Arrays.toString(scores));
            return;
        }
        if(ind >= num)
            return;

        find(ind+1,sur);
        scores[ind].surprise();
        find(ind+1,sur+1);
        scores[ind].surprise();
    }

    int targeted()
    {
        int ret = 0;
        for(Score s : scores)
            if(s.get() >= target)
                ret++;
        return ret;
    }
}

class Score
{
    int[] surp, norm;
    int sum;
    boolean surprising;

    public Score(int sum)
    {
        this.sum = sum;
        surp = new int[3];
        norm = new int[3];
        int ave = sum / 3;
        int dif = sum - 3*ave;
        for(int i=0;i<3;i++)
        {
            norm[i] = ave + (i < dif ? 1 : 0);
            surp[i] = norm[i];
        }
        if(sum > 1)switch(dif)
        {
            case 0:surp[0]++;surp[1]--;break;
            case 1:surp[1]++;surp[2]--;break;
            case 2:surp[0]++;surp[1]--;break;
        }
        Arrays.sort(norm);
        Arrays.sort(surp);
    }
    
    int get()
    {
        return surprising ? getSurp() : getNorm();
    }

    int getNorm()
    {
        return norm[2];
    }

    int getSurp()
    {
        return surp[2];
    }

    void surprise()
    {
        surprising = !surprising;
    }

    public String toString()
    {
        return surprising ? Arrays.toString(surp) : Arrays.toString(norm);
    }
}
