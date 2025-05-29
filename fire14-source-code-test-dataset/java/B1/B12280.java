import java.util.*;
import java.io.*;
import java.lang.Integer;


public class QuestionC
{

    public static void main(String[] args) throws IOException
    {

        Scanner inPut = new Scanner(new File("C-small-attempt0.in"));
        FileWriter fWriter = new FileWriter("C-small-attempt0.out");
        int caseTotal = inPut.nextInt();
        inPut.nextLine();
        for (int caseNum = 1; caseNum <= caseTotal; caseNum++)
        {

            // read the string length for this case
            int base = 1;
            int smallNum = inPut.nextInt();
            int largeNum = inPut.nextInt();
            int digit = 0;
            int temp = smallNum;
            while(temp != 0)
            {
                temp = temp/10;
                digit++;
            }
            int[] num = new int[digit];
            int total = 0;

            for (int i = 1; i < digit; i++)
            {
                base = base * 10;
            }
            fWriter.write("Case #" + caseNum + ": ");
            for(int i = largeNum; i >= smallNum; i--)
            {
                num[0] = i;

                for (int j = 1; j < digit; j++)
                {
                    boolean norepeat = false;
                    num[j] = num[j - 1] / base + (num[j - 1] % base) * 10;

                    if (num[j] >= smallNum && num[j] <= largeNum)
                    {
                        norepeat = true;
                        for (int k = j - 1; k >= 0; k--)
                        {
                            norepeat = norepeat && (num[j] != num[k]);
                        }
                    }
                    if(norepeat) total++;
                }
            }
            total = total / 2;
            fWriter.write(total + "\n");
        }
        fWriter.flush();
        fWriter.close();
    }
}
