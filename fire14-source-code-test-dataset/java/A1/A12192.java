import java.io.*;
public class Dancing {
	public static void main(String[] args) {
		try{
			BufferedWriter output = new BufferedWriter(new FileWriter("output.txt"));
			BufferedReader input = new BufferedReader(new FileReader("B-small-attempt2.in"));
			int i = 0;
			int j = Integer.parseInt(input.readLine());
			while(i < j) {
				//get the line
				String line = input.readLine();
				//split into data
				String[] splitLine = line.split(" ");
				//get the useful data out of the line
				int n = Integer.parseInt(splitLine[0]);
				int s = Integer.parseInt(splitLine[1]);
				int p = Integer.parseInt(splitLine[2]);
				int[] scores = new int[n];
				//get out the total score
				for(int foo = 0; foo < n; foo++) {
					scores[foo] = Integer.parseInt(splitLine[foo + 3]);
				}
				//setup the output value
				int caseValue = 0;
				for(int score: scores) {
					//if total score is less then value needed there is no chance
					if(score >= p){
						int average = score / 3;
						//if the average is higher then the scores are then 1 value is definately higher then p
						if (average >= p) {
							caseValue++;
						//if average is 1 less then scores are there is a possibilty of a hit
						} else if(average+1 == p) {
							//if it's scores are not divisible by 3 at least one is higher then average
							if(score % 3 != 0) {
								caseValue++;
							//if the total score is divisible by 3 then only a surprising score can make up difference
							} else {
								if(s>0){
									caseValue++;
									s--;
								}
							}
						//there is also a very specific case when the average is 2 less that you can use a surprising case to make up the difference	
						} else if (average+2 == p && score % 3 == 2 && s >0) {
							caseValue++;
							s--;
						}
					}
				}
				System.out.println();
				output.write("Case #" + (i+1) +": " + caseValue);
				output.newLine();
				i++;
			}
			output.close();
			input.close();
		} catch(Exception e) {System.out.println(e);}
	}
}
