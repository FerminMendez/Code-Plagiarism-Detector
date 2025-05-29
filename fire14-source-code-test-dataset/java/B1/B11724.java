import java.awt.datatransfer.*;
import java.awt.Toolkit;
public class Repeat
{
    private static String inp;
    public Repeat()
    {
        
    }

    public static void main(String[] args)
    {
        Transferable temp = (Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null));
        try {
            inp = (String) temp.getTransferData(DataFlavor.stringFlavor);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        System.out.println(inp);
        
        System.out.println("Breakdown >" + inp.substring(inp.indexOf("\n")));
        //int iterations = Integer.parseInt(inp.substring(inp.indexOf("\n")));
        String[] newlineSplit = inp.split("\n");
        int iterations = Integer.parseInt(newlineSplit[0]);
        System.out.println(iterations);
        System.out.println("Solutions:\n\n\n\n");
        //String cases = inp.substring(inp.indexOf("\n"));
        for(int i = 1; i < newlineSplit.length;i++)
        {
            String[] nums = newlineSplit[i].split(" ");
            
           getCount(Integer.parseInt(nums[0]) ,Integer.parseInt(nums[1]), i);
        }
    }
    
    public static void getCount(int a, int b, int caseNum)
    {
        int count = 0;
        while(a <= b)
        {
            String sA = "" + a;
            String sB = "" + b;
            //System.out.println(sA + "   " + sB);
            for(int i = 0; i < sA.length();i++)
            {
                String temp = sA.substring(sA.length() - i-1) + sA.substring(0,sA.length() - i - 1);
                int iT = Integer.parseInt(temp);
                int iA = Integer.parseInt(sA);
                
                //System.out.println(">>[" + temp + "]    " + (iT - iA) );
                if(iT - iA > 0 && iT <= b)
                {
                    count++;
                    //System.out.println(">>>>>>> " + sA + " " + temp + "    " + (iT - iA));
                } 
                //else
                    //System.out.println(">>[" + temp + "]    " + (iT - iA) );
            }
            a++;
        }
        System.out.println("Case #" + caseNum + ": " + count);
        
    }
}
