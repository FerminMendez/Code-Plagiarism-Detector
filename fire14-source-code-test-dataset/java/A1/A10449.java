import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DancingWithTheGooglers {
	
	public static int count(int N, int S, int p, int[] num){
		int sureCount = 0;
		int possibleCount = 0;
		
		for(int i = 0 ; i < num.length ; i ++){
			int n = num[i];
			int average = n / 3;
			
			if(n % 3 == 0){
				if(average >= p && average >= 0 && average <= 10)
					sureCount ++;
				else if(average + 1 >= p && average - 1 >= 0 && average + 1 <= 10)
					possibleCount ++;
			}else if(n % 3 == 1){
				if(average + 1 >= p && average >= 0 && average + 1 <= 10)
					sureCount ++;
			}else{
				if(average + 1 >= p && average >= 0 && average + 1 <= 10)
					sureCount ++;
				else if(average + 2 >= p && average >= 0 && average + 2 <= 10){
					possibleCount ++;
				}
			}
		}
		
		if(possibleCount > S){
			return sureCount + S;
		}else{
			return sureCount + possibleCount;
		}
	}
	public static void main(String args[]) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output.txt")));
		String line = reader.readLine();
		int T = Integer.parseInt(line);
		for(int i = 0 ; i < T ; i ++){
			line = reader.readLine();
			String tokens[] = line.split("\\s+");
			int N = Integer.parseInt(tokens[0]);
			int S = Integer.parseInt(tokens[1]);
			int p = Integer.parseInt(tokens[2]);
			int[] num = new int[N];
			for(int j = 3 ; j < 3 + N ; j ++){
				num[j - 3] = Integer.parseInt(tokens[j]); 
			}
			int count = count(N , S , p , num);
			writer.write("Case #" + (i + 1) + ": " + count + "\r\n");
		}
		reader.close();
		writer.close();
	}

}
