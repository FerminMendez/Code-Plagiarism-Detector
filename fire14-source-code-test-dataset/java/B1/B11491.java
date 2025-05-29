
import java.io.*;
import java.util.Scanner;


public class Recycling {
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        FileInputStream file = new FileInputStream("C:\\Users\\Taghi\\Downloads\\C-small-attempt1.in");
        DataInputStream in2 = new DataInputStream(file);
        Scanner in=new Scanner(new InputStreamReader(in2));
        int numberOfTests=in.nextInt();
        int[] results=new int[numberOfTests];
        for (int i=0;i<numberOfTests;i++)
        {
            int lowerBound=in.nextInt();
            int higherBound=in.nextInt();
            //System.out.println(lowerBound+" "+higherBound);
            int possibilities=0;
            for (int k=lowerBound;k<=higherBound;k++)
            {
                for (int j=k+1;j<=higherBound;j++)
                {
                    String clone=Integer.toString(j);
                    for (int l=0;l<clone.length();l++)
                    {
                        String newClone=clone.substring(clone.length()-l-1,clone.length())+clone.substring(0,clone.length()-l-1);
                        int check=Integer.parseInt(newClone);
                        if (check==k)
                        {
                            possibilities++;
                        }
                    }
                }
            }
            //System.out.println(possibilities);
            results[i]=possibilities;
        }
        for (int i=0;i<numberOfTests;i++)
        System.out.println("Case #"+(i+1)+": "+results[i]);
    }
}
