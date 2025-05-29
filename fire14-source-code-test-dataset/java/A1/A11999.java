import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Program {

	/**
	 * @param args
	 */
	public static void main1(String[] args) {
	
		Speaking_in_Tongues sit=new Speaking_in_Tongues();
		sit.initialize();
		sit.register("our language is impossible to understand", "ejp mysljylc kd kxveddknmc re jsicpdrysi");
		sit.register("there are twenty six factorial possibilities", "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd");
		sit.register("so it is okay if you want to just give up", "de kr kd eoya kw aej tysr re ujdr lkgc jv");		
		
		for(char o='a';o<= 'z';o++)
		{
			System.out.print(sit.map[o]);
		}
		
		try {
			FileWriter fileWriter=new FileWriter("A-small-attempt0.out");
			FileReader fileReader=new FileReader("A-small-attempt0.in");
			BufferedReader in = new BufferedReader(fileReader);

			int T= Integer.parseInt(in.readLine());
			for(int t=1;t<=T;t++)
			{
				String translated=in.readLine();
				String normal= sit.Solve(translated);
				fileWriter.write("Case #"+t+": "+normal+"\n");
			}
			fileWriter.close();
			fileReader.close();	
		} catch (Exception e) {
			System.out.println("Error! Exception: "+e); 
		}
		

	}
	
	public static void main(String[] args) {
		
		try {
			FileWriter fileWriter=new FileWriter("B-small-attempt4.out");
			FileReader fileReader=new FileReader("B-small-attempt4.in");
			BufferedReader in = new BufferedReader(fileReader);

			int T= Integer.parseInt(in.readLine());
			for(int t=1;t<=T;t++)
			{
				String[] tokens= in.readLine().split(" ");
				int N= Integer.parseInt(tokens[0]);
				int[] values=new int[N];
				int S= Integer.parseInt(tokens[1]);
				int p= Integer.parseInt(tokens[2]);
				
				for(int n=0;n<N;n++)
				{
					values[n]= Integer.parseInt(tokens[n+3]);
				}
				
				Dancing_With_the_Googlers d=new Dancing_With_the_Googlers();				
				int result=d.solve1(S, p, values);
				fileWriter.write("Case #"+t +": " +result+"\n");
				
			}
			fileWriter.close();
			fileReader.close();	
		} catch (Exception e) {
			System.out.println("Error! Exception: "+e); 
		}
		
		
	}

}
