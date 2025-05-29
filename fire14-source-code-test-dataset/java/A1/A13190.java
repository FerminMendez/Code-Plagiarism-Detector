import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ProblemB {

/**
* @param args
*/
public static void main(String[] args) {
BufferedReader br = null;
BufferedWriter bw = null;
String input[] = null;
String output = null;
try {
br = new BufferedReader(new FileReader(new File("E:/B-small-attempt0.in")));
bw = new BufferedWriter(new FileWriter("output.txt"));
int count = Integer.parseInt(br.readLine());
for (int i = 0; i < count; i++) {
input = br.readLine().split(" ");
int noOfScores = Integer.parseInt(input[0]);
int noOfSuprises = Integer.parseInt(input[1]);
int expectedScore = Integer.parseInt(input[2]);
int noOfSolutions=0;
int scores[]=new int[noOfScores];
for(int j=0;j<noOfScores;j++)
{
	scores[j]=Integer.parseInt(input[j+3]);
}
for(int j=0;j<noOfScores;j++)
{
	if((scores[j]%3)==1)
	{
		if(((int)(scores[j]/3)+1)>=expectedScore)
		{
			noOfSolutions++;
		}
	}else {
		if((scores[j]%3)==0)
		{
			int probScore=(int)(scores[j]/3);
			if(probScore>=expectedScore)
			{
				noOfSolutions++;
			} else {
			if(((probScore+1)>=expectedScore)&&((probScore-1)>=0)&&noOfSuprises!=0)
			{
				noOfSolutions++;
				noOfSuprises--;
			}
			}
		}
		else
		{
			int probScore=(int)(scores[j]/3)+1;
			if(probScore>=expectedScore)
			{
				noOfSolutions++;
			} else {
			if(((probScore+1)>=expectedScore)&&noOfSuprises!=0)
			{
				noOfSolutions++;
				noOfSuprises--;
			}
			}
		}
	}
}
output = new String("Case #" + (i + 1) + ": "+noOfSolutions);
bw.write(output);
bw.newLine();
//logic here
}
bw.close();
} catch (Exception e) {
e.printStackTrace();
}

}

}
				