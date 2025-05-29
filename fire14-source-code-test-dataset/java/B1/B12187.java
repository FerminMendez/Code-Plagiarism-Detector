import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.HTMLReader.HiddenAction;


public class RecycledNumbers
{
    public static void main(String[] argStrings)
    {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        String[] inputStrings = new String[num];
        String[] outputStrings = new String[num];
        for (int i = 0; i < num; i++)
        {
            inputStrings[i] = in.nextLine();
        }
        for (int i = 0; i < inputStrings.length; i++)
        {
            String[] numStrings = inputStrings[i].split(" ");
            int start = Integer.parseInt(numStrings[0]);
            int end = Integer.parseInt(numStrings[1]);
            int count = 0;
            for (int j = 0; j < end - start + 1; j++)
            {
                Integer x = start + j;
                int[] sequenceArrayInteger = reverse(x);
                for (int k = 0; k < sequenceArrayInteger.length; k++)
                {
                    int xNum = sequenceArrayInteger[k];
                    if (xNum >= start && xNum <= end)
                    {
                        count++;
                    }
                }
            }
            outputStrings[i] = "Case #" + (i + 1) + ": " + count;
        }
        
        for (String string : outputStrings)
        {
            System.out.println(string);
        }
    }
    
    public static int[] reverse(Integer num)
    {
        String string = num.toString();
        int[] retArray = new int[num.toString().length() - 1];
        for (int i = 0; i < retArray.length; i++)
        {
            char x = string.charAt(string.length() - 1);
            string = x + string.substring(0, string.length() - 1);
            if(Integer.parseInt(string) > num)
                retArray[i] = Integer.parseInt(string);
        }
        
        return retArray;
    }
}
