import java.io.*;
import java.util.Arrays;
public class GoogleCodeJam2 
{
    public static void main(String[] args) throws IOException 
    {
        FileInputStream fstreami = new FileInputStream("input.txt");
        DataInputStream in = new DataInputStream(fstreami);
        FileWriter fstreamo = new FileWriter("output.txt");
        BufferedWriter out = new BufferedWriter(fstreamo);
        int testCases = Integer.parseInt(in.readLine());
        int i = 0;
        while(i < testCases)
        {
            String test = in.readLine();
            String [] testInput = test.split(" ");
            int [] input = new int[testInput.length-3];
            int googlers = Integer.parseInt(testInput[0]);
            int allowed = Integer.parseInt(testInput[1]);
            int max = Integer.parseInt(testInput[2]);
            int possible = 0;
            for (int j = 0; j < testInput.length-3; j++)
                input[j] = Integer.parseInt(testInput[3+j]);
            Arrays.sort(input);
            for (int j = googlers-1; j >= 0; j--)
            {
                if (input[j]%3 == 0)
                {
                    if (input[j]/3 >= max)
                        possible++;
                    else if ((input[j]+3)/3 >= max && allowed>=1 && input[j]>=3)
                    {
                        possible++;
                        allowed--;
                    }
                    else ;
                }
               else if (input[j]%3 == 1)
                {
                    if (((input[j]+2)/3) >= max && input[j]>=1)
                        possible++;
                    else ;
                }
                else
                {
                    if (((input[j]+1)/3) >= max && input[j]>=2)
                        possible++;
                    else if (((input[j]+4)/3) >= max && allowed>=1 && input[j]>=2)
                    {
                        possible++;
                        allowed--;
                    }
                    else ;
                }
			}
			System.out.println("Done");
            out.write("Case #" + (i+1) + ": " + possible + "\n");
			i++;
		}
		in.close();
		out.close();
    }
}