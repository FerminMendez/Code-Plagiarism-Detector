import java.io.*;
import java.util.*;

public class Problem3
{
    static int size = 4;
    public static void main(String args[])
    {
        try
        {
            FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            
            String line;
            int i = 0;
            int num1 = 0, num2 = 0;
            int times;
            Scanner sc;
            int count, total;
            while ((line = br.readLine()) != null)
            {
                if(i == 0)
                {
                    total = Integer.parseInt(line);
                    i = 1;
                    continue;
                }
                sc = new Scanner(line);
                if(sc.hasNextInt()) num1 = sc.nextInt();
                if(sc.hasNextInt()) num2 = sc.nextInt();
                size = (num1==0)?1:(int)Math.log10(num1) + 1;
                times = solve(num1, num2);
                System.out.println("Case #"+i+": "+times);
                write("Case #"+i+": "+times);
                i++;
            }
            in.close();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }       
    }
    
    public static int solve(int num1, int num2)
    {
        int i;
        int count = 0;
        int generated;
        for(i = num1; i <= num2; i++)
        {
            for(int j = 1; j < size; j++)
            {
                generated = generate(i, j);
                if(num1 <= i && i < generated && generated <= num2) 
                {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static int generate(int i, int j)
    {
        int temp = i;
        int putfor = temp % (power(10, j));
        int last = temp / (power(10, j));
        int generated = putfor*power(10, size-1-(j-1)) + last;
        return generated;
    }
    
    public static int power(int i, int j)
    {
        int power = 1;
        for(int k = 0; k < j; k++)
        {
            power *= i;
        }
        return power;
    }
    
    public static void write(String text)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("Problem3Output.out"), true));
            bw.write(text);
            bw.newLine();
            bw.close();
        }catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}