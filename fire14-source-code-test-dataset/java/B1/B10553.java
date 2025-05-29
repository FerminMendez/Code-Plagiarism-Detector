import java.util.*;
import java.io.*;
public class Tester
{
    public static void main(String[]args) throws IOException
    {
        Scanner sc = new Scanner(new File("C-small-attempt1.in"));
        int intNum = sc.nextInt();
        sc.nextLine();
                String[] first = new String[intNum];
        String[] second =new String[intNum];
        for(int i =0;i<intNum;i++)
        {
            first[i] =sc.next();
            second[i]=sc.next();
        }

        int recycle = 0;
        //Loop through each set of numbers
        for(int i = 0;i<intNum;i++)
        {
            //List of recycled numbers
                    ArrayList recycled = new ArrayList();
            recycle = 0;
            //Get the first and second number.
            int firstNum = Integer.parseInt(first[i]);
            int secondNum = Integer.parseInt(second[i]);
            //LOOP THROUGH THE FIRST TO SECOND NUM
            for(int j = firstNum;j<secondNum+1;j++)
            {
                //GET THE CURRENT NUMBER
                String temp = Integer.toString(j);
                //LOOP THROUGH EACH DIGIT
                for(int k = 0;k<temp.length();k++)
                {
                    //GET THE SUBSTRING OF IT AND APPEND IT TO THE BEGINNING
                    String append = temp.substring(k+1);
                    append +=temp.substring(0,k+1);
                    //CHECK FOR LEADING 0'S
                    if(append.charAt(0)!='0')
                    {
                        //GET THE ACTUAL NUMERIC NUMBER
                    int appendNum = Integer.parseInt(append);
                    //Switched number in the range
                    if(appendNum<=secondNum)
                    {
                        //Check if it is lower than tested numbers
                        if(appendNum>j)
                        {
                            //If it is  greater than the first number

                            recycle++;recycled.add(append);
                        }
                    }
                }
            }
            }
            System.out.println("Case #" + (i+1) + ": " + recycle);
        }
    }
}
