
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Dancers {
    
    public static void main(String[] args) throws FileNotFoundException
    {
        FileInputStream file = new FileInputStream("C:\\Users\\Taghi\\Downloads\\B-small-attempt0.in");
        DataInputStream in2 = new DataInputStream(file);
        Scanner in=new Scanner(new InputStreamReader(in2));
        int numberOfTests=in.nextInt();
        int[] results=new int[numberOfTests];
        for (int i=0;i<numberOfTests;i++)
        {
            int counter=0;
            int numberOfGooglers=in.nextInt();
            int N=in.nextInt();
            int p=in.nextInt();
            int j=0;
		while (j < numberOfGooglers) {
                    int score=in.nextInt();
			if (score < (3*p - 4)||score<p) {}
			else if (score <= (3*p - 3)) {
				if (N > 0) {
					counter++;
					N--;
				}
			}
			else {
				counter++;
			}
			j++;
		}
            results[i]=counter;
        }
        
        for (int i=0;i<numberOfTests;i++)
        {
            System.out.println("Case #"+(i+1)+": "+results[i]);
        }
    }
}
