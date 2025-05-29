import java.io.*;

/**
 * ***************************************************************************
 * Created by IntelliJ IDEA.
 * User: Narender Singh Pal
 * Date: 4/14/12
 * Time: 8:32 AM
 * <p/>
 * ***************************************************************************
 * <p/>
 * Copyright (c) 2012 All Rights Reserved.
 * <p/>
 * <p/>
 * ***************************************************************************
 */
public class DancingWithTheGooglers
{
    public static void main (String args[])
    {
        try
        {
            BufferedReader Br = new BufferedReader(new FileReader("C:\\Input\\B-small-attempt0.in"));
            BufferedWriter Bw = new BufferedWriter(new FileWriter("C:\\Input\\B-small-attempt0.out"));
            //read number if test cases
            int $TC = Integer.valueOf(Br.readLine());
            //System.out.println("$TC :"+ $TC);
            int $N, $S, $P;
            int [] $Input;
            for(int tc=1; tc <=$TC; tc++)
            {
                String Pl = Br.readLine();
                String []arr = Pl.split(" ");
                $Input = new int[arr.length];
                for(int j =0; j < arr.length; j++)
                {
                    $Input[j] = Integer.valueOf(arr[j]);
                }
                $N = $Input[0];
                $S = $Input[1];
                $P = $Input[2];
                //System.out.println("$N :" + $N + "\n$S :" + $S + "\n$P :" + $P);

                int $Result=0, $BR_Min=0, $BS_Min=0, $BS_Max=0;
                if($P ==0)
                {
                    $Result = $N;
                }
                else
                {
                    //Calculate minimum sum for Best Result
                    $BR_Min = ($P * 3) - 2;

                    //calculate maximum and minimum sum for Best and Surprising result
                    $BS_Min = $BR_Min - 2;
                    $BS_Max = $BR_Min;

                    //count the maximum number of best results
                    for (int n=3; n < 3+$N ; n++)
                    {
                        int $Num = $Input[n];
                        if($Num >= $BR_Min)
                        {
                            $Result++;
                        }
                        else if($Num <= $BS_Max && $Num >= $BS_Min && $S > 0 && $Num > 0)
                        {
                            $Result++;
                            $S--;
                        }
                    }
                }
                //System.out.println("Case #"+ tc+": "+$Result);
                Bw.write("Case #"+ tc+": "+$Result);
                Bw.write('\n');
            }
            Br.close();
            Bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

