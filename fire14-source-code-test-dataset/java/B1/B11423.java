import java.util.*;

public class Recycle
{
    public static void main(String args[])
    {
        int uBound, lBound, count=0, caseNo=1;

        Scanner input = new Scanner(System.in);

        input.nextLine();

        while(true)
        {
            lBound = input.nextInt();
            uBound = input.nextInt();

            for(int i=lBound; i<=uBound; i++)
            {
                int numDigits = new Integer(i).toString().length();
                int[] pastPairs = new int[numDigits-1];
                for(int j=1; j<numDigits; j++)
                {
                    int rotatedInt = rotateInt(i,j);
                    if(rotatedInt>i && rotatedInt<=uBound)
                    {
                        for(int k=0; k<numDigits-1; k++)
                        {
                            if(rotatedInt==pastPairs[k])
                            {
                                count--;
                            }
                        }
                        count++;
                    }
                    pastPairs[j-1] = rotatedInt;
                }
            }
            System.out.printf("Case #%d: %d\n",caseNo,count);
            count=0; caseNo++;
        }
    }

    static int rotateInt(int number, int rotate)
    {
        String numStr = new Integer(number).toString();
        String last = numStr.substring(numStr.length()-rotate);
        String rest = numStr.substring(0,numStr.length()-rotate);
        numStr = last.concat(rest);
        return Integer.parseInt(numStr);
    }
}

// Called with java Recycle < in.in > out.txt
