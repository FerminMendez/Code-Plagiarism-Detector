import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ProblemBDancingWithTheGooglers {
	
	private static int lines;
	private static Scanner input;
	private static String [] outputs;
	
	public static void main(String[] args) {
		try {
			input = new Scanner(new FileReader(args[0]));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		lines = Integer.parseInt(input.nextLine());
		outputs = new String [lines];
		for(int i = 1; i<=lines; i++)
		{
			int maxVal;
			int num;
			int supriseCase;
			int iAns = 0;
			String ans = "Case #" + i + ": ";
			StringTokenizer str = new StringTokenizer(input.nextLine());
			num = Integer.parseInt(str.nextToken());
			supriseCase = Integer.parseInt(str.nextToken());
			maxVal = Integer.parseInt(str.nextToken());
			for(int j = 0; j<num; j++)
			{
				Triplet t = new Triplet(Integer.parseInt(str.nextToken()));
				if(t.highest()>=maxVal)
				{
					iAns++;
				}
				else if(supriseCase>0 && (t.highest() + 1)>= maxVal && t.highest() != t.sum && t.canBeSuprise())
				{
					supriseCase--;
					iAns++;
				}
				
			}
			ans += iAns;
			outputs[i-1] = ans;
			
		}
		try{
			 
    	    File file =new File("outputB.txt");
 
    	    //if file doesnt exists, then create it
    	    if(!file.exists()){
    		file.createNewFile();
    	    }
 
    	    FileWriter fw = new FileWriter(file.getName());
    	    BufferedWriter bw = new BufferedWriter(fw);
    	    for(int k = 0; k<outputs.length; k++)
    	    {
    	    	bw.write(outputs[k]);
    	    	bw.newLine();
    	    }
    	    bw.close();
    	    
		}catch(IOException e){
    		e.printStackTrace();
    	}

	}
	public static class Triplet {
		public static int sum, x, y, z;
		public Triplet(int i)
		{
			sum = i;
			x = (int) Math.round(((double)sum)/3.0);
			y = (int) Math.round(((double)sum)/3.0);
			z = sum - x - y;
		}
		public static boolean canBeSuprise()
		{
			return ((x==y && x==z) || x>z);
		}
		public static boolean allEqual()
		{
			return (x==y && x==z);
		}
		public static int highest()
		{
			if(x>=y)
			{
				if (x>=z)
				{
					return x;
				}
				else
				{
					return z;
				}
			}
			else
			{
				if(y>=z)
				{
					return y;
				}
				else
				{
					return z;
				}
			}
		}
	}

}
