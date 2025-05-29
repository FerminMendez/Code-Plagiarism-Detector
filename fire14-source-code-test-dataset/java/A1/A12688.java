import java.io.*;
public class googleJam2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = null;
		PrintWriter writer = null;
		try{
			reader = new BufferedReader(new FileReader("B-small-attempt1.in"));
			int numInputs = Integer.parseInt(reader.readLine());
			writer = new PrintWriter(new BufferedWriter(new FileWriter("B-small-attempt1.out")));
			for(int i = 0; i < numInputs; i++)
			{
				System.out.println(i);
				String temp = reader.readLine();
				System.out.println(temp);
				int index = temp.indexOf(" ");
				int numGooglers = Integer.parseInt(temp.substring(0, index));
				temp = temp.substring(index+1);
				index = temp.indexOf(" ");
				System.out.println(temp);
				int numSurprising = Integer.parseInt(temp.substring(0,index));
				temp = temp.substring(index+1);
				index = temp.indexOf(" ");
				int p = Integer.parseInt(temp.substring(0,index));
				temp = temp.substring(index+1);
				int withoutSurprise = 0;
				int withSurprise = 0;
				for(int k = 0; k < numGooglers-1; k++)
				{
					index = temp.indexOf(" ");
					int totalScore = Integer.parseInt(temp.substring(0, index));
					temp = temp.substring(index+1);
					if(totalScore >= 3*p -2)
						withoutSurprise++;
					else if(totalScore >= 3*p-4 && totalScore >= p)
						withSurprise++;
				}
				int totalScore = Integer.parseInt(temp);
				if(totalScore >= 3*p -2)
					withoutSurprise++;
				else if(totalScore >= 3*p-4 &&totalScore >= p)
					withSurprise++;
				int numWinners;
				if(withSurprise >= numSurprising)
					numWinners = numSurprising + withoutSurprise;
				else
					numWinners = withSurprise + withoutSurprise;
				writer.print("Case #" + (i+1) + ": " + numWinners + "\n");
				
				
			}
			writer.close();
		}
		catch(Exception e)
		{
			throw(e);
		}
	}

}
