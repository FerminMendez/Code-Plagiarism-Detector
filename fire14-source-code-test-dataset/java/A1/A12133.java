import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Recycle {

	public Recycle()
	{
		readFile("Files/recycle.in");
	}
	public void readFile(String file)
	{
		try{
			FileInputStream fstream = new FileInputStream(file);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = "";
			br.readLine();
			int count = 1;
			while ((strLine = br.readLine()) != null)  
			{
				System.out.print("Case #" + (count++) + ": ");
				Scanner scanner = new Scanner(strLine);
				int numSurprising = 0;
				int p = 0;
				scanner.nextInt();
				int numMax = 0;
				numSurprising = scanner.nextInt();
				p = scanner.nextInt();
				while(scanner.hasNextInt())
				{
					int current = scanner.nextInt();
					if(current == 0 && p != 0)
						continue;
					else if(current == 0 && p == 0)
						numMax++;
					else if(current >= (3*p-2))
					{
						numMax++;
					}
					else if(numSurprising > 0 && ((3*p-2) - current) <= 2)
					{
						numSurprising--;
						numMax++;
					}
				}
					
					
				System.out.print(numMax);
				System.out.println();
			}
		}catch(Exception e){}
	}
	public static void main(String [] args)
	{
		Recycle r = new Recycle();
	}
}
