import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class RecycledNumbers 
{
	public RecycledNumbers()
	{
		
	}
	public int getNumDigits(int x)
	{
		if(x == 0 || x == 1)
			return 1;
		int counter =0 ;
		int check = 1;
		while(check<=x)
		{
			counter ++ ;
			check*=10;
		}
		return counter;
	}
	public int traverse(int x, int i)
	{
		if(x<10)
			return x ;
		int y = x/((int)Math.pow(10,i+1));
		int lastDigits = x-(y * (int)Math.pow(10,i+1));
		return ((int)Math.pow(10, getNumDigits(y))*lastDigits )+ y;
	}
	public boolean isRecycled(int x, int y)
	{
		int numOFDigits = getNumDigits(x);
		int z = x ;
		for(int i=0 ; i <numOFDigits ; i++)
		{
			if(y == z)
				return true ;
			z = traverse(x , i);
		}
		return false ;
	}
	public int numOfRecycledNum(int a , int b)
	{
		int counter  = 0;
		for(int i =a ; i <= b ; i++)
		{
			for(int j = i+1 ; j <= b ; j++)
			{
				if(isRecycled(i, j))
				{
					counter ++ ;
				}
			}
		}
		return counter ;
	}
	public static void perform()
	{
		RecycledNumbers recycled= new RecycledNumbers();
		try {
			BufferedReader inputStream = new BufferedReader(new FileReader("C-small-attempt0.in"));
			PrintWriter outputStream = new PrintWriter(new FileWriter("Output.txt"));
			try
			{
			int numOfLines = Integer.parseInt(inputStream.readLine());
			for(int i=1 ; i<=numOfLines ; i++)
			{
				String line = inputStream.readLine();
				boolean firstNum = true ;
				String num1 = "", num2 = "";
				for(int j=0 ; j< line.length() ; j++)
				{
					if(line.charAt(j) == ' ')
					{
						firstNum = false ;
						j++;
					}
					if(firstNum)
						num1 += line.charAt(j);
					else
						num2 += line.charAt(j);
				}
				int x = Integer.parseInt(num1);
				int y = Integer.parseInt(num2);
				String toOutput = "Case #"+i+": ";
				toOutput += recycled.numOfRecycledNum(x, y);
				outputStream.println(toOutput);
			}
			}catch(Exception e)
			{
				//no input in the file
				//or there was a problem in one of the lines
				//or there is a line that doesn't exist
			}
			inputStream.close();
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		perform();
	}
}
