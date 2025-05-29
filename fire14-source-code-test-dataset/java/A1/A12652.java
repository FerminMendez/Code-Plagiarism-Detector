import java.io.*;

public class DancingWithGooglers {

	static int caseNumber;
	static int totalCases;
	
	public static void main(String[] args) throws Exception {
		
		caseNumber = 1;

		File fileIn = new File("C:\\GCJ\\DancingWithGooglers\\B-small-attempt0.in");
		FileInputStream fileInputStream = null;
		BufferedInputStream inputStream = null;
		BufferedReader reader = null;
		Writer out;
		
		String newLine = System.getProperty("line.separator");
		
		String fileOutPath = "C:\\GCJ\\DancingWithGooglers\\output.txt";
		File fileOut = new File(fileOutPath);
		if (! fileOut.createNewFile()){
			fileOut.delete();
			fileOut.createNewFile();
		}
		
		out = new OutputStreamWriter(new FileOutputStream(fileOutPath), "US-ASCII");
		
		
		StringBuilder builder = new StringBuilder();

		try {
			fileInputStream = new FileInputStream(fileIn);

			// Here BufferedInputStream is added for fast reading.
			inputStream = new BufferedInputStream(fileInputStream);
			reader = new BufferedReader(new InputStreamReader(inputStream));

			totalCases = Integer.parseInt(reader.readLine());
			while (caseNumber <= totalCases){
				builder.append(handleTestCase(reader));
				builder.append(newLine);
				caseNumber++;
			}
			
			
			// dispose all the resources after using them.
			fileInputStream.close();
			inputStream.close();
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		System.out.print(builder.toString());
		out.write(builder.toString());
		out.close();
	}
	
	public static String handleTestCase(BufferedReader reader) throws IOException{
		String[] splitLine = reader.readLine().split(" ");
		int[] ints = stringArrayToIntArray(splitLine);
		int numScores = ints[0];
		int numSurprises = ints[1];
		int goal = ints[2];
		
		int surprisesLeft = numSurprises;
		int metGoal = 0;
		for(int i = 3; i < ints.length; i++){
			//Base cases
			if(ints[i] == 0) {
				if(goal == 0)
					metGoal++;
			}
			
			else if(ints[i] == 1){
				if(goal == 1)
					metGoal++;
			}
			//Handles if the number is divisible by 3
			//If the average is >= the goal, it is trivially meeting the goal
			//If you allow for a surprise, the max can grow by 1
			else if(ints[i] % 3 == 0){
				if(ints[i] / 3 >= goal)
					metGoal++;
				else if ( ints[i] / 3 == goal - 1){
					if(surprisesLeft > 0) {
						surprisesLeft--;
						metGoal++;
					}
				}
			}
			
			//The value of the maximum doesn't change even with a surprise with ints[i] % 3 ==1
			//So I don't even evaluate it here and worry about deducting available surprises
			else if(ints[i] % 3 == 1){
				if(ints[i] / 3 >= goal-1)
					metGoal++;
			}
			
			//Value of the maximum with % 3 == 2 is one above the average by default
			//Allowing for a surprise allows for it to be one higher
			else if(ints[i] % 3 == 2){ //Unecessary "if" statement kept to remind about the last case
				if(ints[i] / 3 >= goal-1)
					metGoal++;
				else if(ints[i] / 3 == goal - 2){
					if(surprisesLeft > 0) {
						surprisesLeft--;
						metGoal++;
					}
				}
			}
			
		}
		
		if(surprisesLeft > 0)
			System.out.println("Surprises were left: "+surprisesLeft+" on case "+caseNumber);
		return "Case #"+caseNumber+": "+metGoal;
	}
	
	public static int[] stringArrayToIntArray(String[] input){
		int[] ints = new int[input.length];
		for (int i = 0; i < input.length; i++){
			ints[i] = Integer.parseInt(input[i]);
		}
		return ints;
	}
}
