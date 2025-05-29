import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class RecycledNumbers {
	
	public static int len(int A){
		int k = 1 ;
		int r = 0;
		while( k < A){
			k = k * 10;
			r = r + 1;
		}
		return r;
	}
	public static int count(int A , int B){
		int r = 0;
		for(int i = A ; i < B ; i ++){
			int mul = 1 ;
			int len = 0;
			while(mul <= A){
				mul = mul * 10;
				len = len + 1;
			}
			
			int[] prev = new int[len - 1];
			int it = 10;
			for(int j = 0 ; j < len - 1 ; j ++){
				int right = i % it;
				int left = i / it;
				mul = mul / 10;
				int result = right * mul + left;
				it = it * 10;
				
				boolean duplicate = false;
				for(int k = 0 ; k < j ; k ++){
					if(result == prev[k]){
						duplicate = true;
						break;
					}
				}
				if(result > i && result >= A && result <= B && !duplicate){
					System.out.println(result + "\t" + i);
					r ++;
					prev[j] = result;
				}
			}
		}
		return r;
	}
	
	public static void main(String args[]) throws IOException{
		//System.out.println(count(531 , 976));
		BufferedReader reader = new BufferedReader(new FileReader(new File("C-small-attempt1.in")));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output.txt")));
		String line = reader.readLine();
		int T = Integer.parseInt(line);
		for(int i = 0 ; i < T ; i ++){
			line = reader.readLine();
			String tokens[] = line.split("\\s+");
			int N = Integer.parseInt(tokens[0]);
			int S = Integer.parseInt(tokens[1]);
			int count = count(N , S);
			writer.write("Case #" + (i + 1) + ": " + count + "\r\n");
		}
		reader.close();
		writer.close();
	}

}
