import java.io.*;
public class googleJam3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader reader = null;
		PrintWriter writer = null;
		try{
			reader = new BufferedReader(new FileReader("C-small-attempt0.in"));
			writer = new PrintWriter(new BufferedWriter(new FileWriter("C-small-attempt0.out")));
			int numInputs = Integer.parseInt(reader.readLine());
			for(int i = 0; i < numInputs; i++)
			{
				String temp = reader.readLine();
				int index = temp.indexOf(" ");
				int A = Integer.parseInt(temp.substring(0, index));
				temp = temp.substring(index+1);
				int B = Integer.parseInt(temp);
				int numWinners = 0;
				for(int j = A; j < B; j++)
				{
					for(int k = j+1; k <= B; k++)
					{
						String original = (new Integer(j)).toString();
						String start = "";
						start += original;
						String goal = (new Integer(k)).toString();
						do{
							String tempString = "";
							tempString += start;
							start = tempString.substring(start.length()-1);
							start+= tempString.substring(0,tempString.length()-1);
							if(start.equals(goal))
								numWinners++;
						} 
						while(!start.equals(original));
						
					}
				}
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
