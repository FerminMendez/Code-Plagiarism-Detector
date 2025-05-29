import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


public class Dancing {
	public static void main(String...args) throws IOException  {
		//the result file
		PrintWriter writer = new PrintWriter(new FileWriter("c:\\jam\\B-small-attempt0.out"));
		//reading input file the file
		BufferedReader reader = new BufferedReader(new FileReader("c:\\jam\\B-small-attempt0.in"));
		//Reading cases number
		int count = Integer.parseInt(reader.readLine());
		//Iterating over the cases
		for(int k=1;k<count+1;k++){
			String g = reader.readLine();
			String[] tab = g.split("\\s");
			int numberOfG = Integer.parseInt(tab[0]);
			int surprisingT = Integer.parseInt(tab[1]);
			int bestRes = Integer.parseInt(tab[2]);
			int res = 0;
			int value1 = 3*bestRes - 4;//maybe surprising
			int value2 = 3*bestRes - 3;//maybe surprising
			int value3 = 3*bestRes - 2;//maybe surprising
			int numberS = 0;
			String[] array = Arrays.copyOfRange(tab, 3, tab.length);
			Arrays.sort(array);
			for(int i=0;i<numberOfG;i++){
				int score = Integer.parseInt(array[i]);
				if(bestRes==0){
					res++;
					continue;
				} else if(score == 0){
					continue;
				}
				if(numberS < surprisingT){
					if((score == value1 || score == value2 || score == value3)){
						res++;
						numberS++;
					} else if(score > value3){
						res++;
					}
				} else if(numberS >= surprisingT){
					if(score > value2){
						res++;
					}
				}
			}
			writer.println("Case #" + k + ": " + res);
		}
		
			reader.close();
			writer.close();
	}
}
