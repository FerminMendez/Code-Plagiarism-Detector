import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * ***************************************************************************
 * Created by IntelliJ IDEA.
 * User: Narender Singh Pal
 * Date: 4/14/12
 * Time: 10:59 AM
 * <p/>
 * ***************************************************************************
 * <p/>
 * Copyright (c) 2012 All Rights Reserved.
 * <p/>
 * <p/>
 * ***************************************************************************
 */
public class RecycledNumbers
{
    public static void main (String args[])
    {
        try
        {
            BufferedReader Br = new BufferedReader(new FileReader("C:\\Input\\C-small-attempt0.in"));
            BufferedWriter Bw = new BufferedWriter(new FileWriter("C:\\Input\\C-small-attempt0.out"));
            try
            {
                //read number of test cases
                int $TC = Integer.valueOf(Br.readLine());
                System.out.println("Number of Test Cases :"+ $TC);
                int $A, $B;
                int [] $InputNum;
                for(int tc = 1; tc <= $TC; tc++)
                {
                    String $InputStr = Br.readLine();
                    String []TempArr = $InputStr.split(" ");
                    $InputNum = new int[TempArr.length];
                    for(int j =0; j < TempArr.length; j++)
                    {
                        $InputNum[j] = Integer.valueOf(TempArr[j]);
                    }
                    //get numbers A, B from input number pair
                    $A = $InputNum[0];
                    $B = $InputNum[1];
                    int $RecycledPairs = 0;

                    //Iterate the given integer range
                    for( int $n = $A; $n <= $B ; $n++ )
                    {
                        String lStr = String.valueOf($n);
                        int $length = lStr.length();
                        int [] $m = new int[$length-1];
                        Set<Integer> $MSet = new HashSet<Integer>();

                        //for each $n get all possible recycled number
                        for(int k = 1; k < $length; k++ )
                        {
                            StringBuffer s = new StringBuffer();
                            s.append(lStr.subSequence(k,$length));
                            s.append(lStr.subSequence(0,k));
                            $m[k-1] = Integer.valueOf(s.toString());

                            //Recycled pair found if the SA <= $n < $m <= $B
                            if($m[k-1] > $n && $m[k-1] <= $B && $m[k-1] >= $A)
                            {
                                if($MSet.isEmpty())
                                {
                                    $MSet.add($m[k-1]);
                                }
                                else
                                {
                                    if($MSet.contains($m[k-1]))
                                    {
                                        System.out.println("###Repeat : skipping ($n, $m) :("  +$n +", "+ $m[k-1]+")####" );
                                        continue;
                                    }
                                    $MSet.add($m[k-1]);
                                }
                                $RecycledPairs++;
                                System.out.println("$Recycled Pair ("+ $RecycledPairs +") : ($n, $m) :(" +$n +", "+ $m[k-1]+")");
                            }
                        }
                    }
                    System.out.println("Case #"+ tc+": "+$RecycledPairs);
                    Bw.write("Case #"+ tc+": "+ $RecycledPairs);
                    Bw.write('\n');
                }
            }
            finally
            {
                Br.close();
                Bw.close();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

