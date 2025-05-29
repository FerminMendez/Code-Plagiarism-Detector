import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class dancers {
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(new File("c:\\files\\B-small-attempt0.in"));
			FileWriter fw =  new FileWriter("c:\\files\\douts.txt");
			PrintWriter output = new PrintWriter(fw);
			int n = input.nextInt();
			for(int i=0;i<n;i++)
			{
				
				int noD = input.nextInt();
				int surprise = input.nextInt();
				int points = input.nextInt();
				
				int total[] = new int[noD];
				int count = 0;
				
				for(int j=0;j<noD;j++)
					total[j]=input.nextInt();
				
				for(int j=0;j<noD-1;j++)
					for(int k=j+1;k<noD;k++)
						if(total[j]<total[k])
						{
							int temp=total[j];
							total[j]=total[k];
							total[k]=temp;
						}
				
				for(int dIndex=0;dIndex<noD;dIndex++)
				{
					if(total[dIndex]>=3*points-2)
						count++;
					else if(surprise>0 && (total[dIndex]==3*points-3 || total[dIndex]==3*points-4) && total[dIndex]>0)
					{
						surprise--;
						count++;
					}
					else
						break;
				}
				output.println("Case #"+(i+1)+": "+count);
			}
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
