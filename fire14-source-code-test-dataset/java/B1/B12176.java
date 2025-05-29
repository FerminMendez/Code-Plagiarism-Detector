/**
 *
 * @author Tag
 */

/*
 * Given integers A and B with the same number of digits and no leading zeros, how many distinct recycled pairs (n, m) are there with A ≤ n < m ≤ B?
 * Input
 * The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of a single line containing the integers A and B.
 * 
 * Output
 * For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1), and y is the number of recycled pairs (n, m) with A ≤ n < m ≤ B.\
 * 
 * Sample
 * Input                Output
 * 4
 * 1 9                     Case #1: 0
 * 10 40                   Case #2: 3
 * 100 500                 Case #3: 156
 * 1111 2222               Case #4: 287
 */


import java.util.Scanner;

public class RecycledNumbers 
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        
        int numTests = new Integer(input.nextLine());
        int recycledPairs;
        
        for(int i = 1; i <= numTests; i++)
        {
            String[] tokens = input.nextLine().split(" ");
            
            Integer smallerNum = new Integer(tokens[0]);
            Integer biggerNum = new Integer(tokens[1]);
            
            recycledPairs = calcRecycled(smallerNum, biggerNum);
            
            System.out.println("Case #" + i + ": " + recycledPairs);
        }
    }

    private static int calcRecycled(Integer smallerNum, Integer biggerNum) 
    {
        int recycledPairs = 0;
        
        while(smallerNum < biggerNum)
        {
            String toCheck = smallerNum.toString();
            
            Integer tmpBigger = new Integer(biggerNum);
            
            while(smallerNum < tmpBigger)
            {
                String biggerStr = tmpBigger.toString();
                
                for(int i = 1; i < biggerStr.length(); i++)
                {
                    if((biggerStr.substring(biggerStr.length() - i) + 
                        biggerStr.substring(0, biggerStr.length() - i)).equals(toCheck))
                    {
                        recycledPairs++;
                    }
                }
                
                tmpBigger--;
            }
            
            smallerNum++;
        }
        
        return recycledPairs;
    }
}
