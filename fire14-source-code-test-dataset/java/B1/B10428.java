import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;


public class Recycle {

	public static void main(String[] args) throws IOException{
		FileInputStream inFile = new FileInputStream("C-small-attempt0.in");
		// Get the object of DataInputStream
		DataInputStream in = new DataInputStream(inFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String inputCnt = br.readLine();
		FileOutputStream outFile = new FileOutputStream("output.txt");
		DataOutputStream out = new DataOutputStream(outFile);
		BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(out));

		int cnt = Integer.parseInt(inputCnt);
		for(int line=1;line<=cnt;line++){
			String inputString = br.readLine();
			String[] splited = inputString.split(" ");
			int A = Integer.parseInt(splited[0]);
			int B = Integer.parseInt(splited[1]);
			String outputString = "Case #"+line+": ";
			int result = 0;
			for(Integer num = A; num<=B; num++){
				//for each number 
				String s = num.toString();
				result += permute(s,num,B);
			}
			outputString += result+"";
			wr.write(outputString);
			wr.newLine();
			wr.flush();

		}
		wr.close();
		out.close();
		br.close();
		in.close();
		inFile.close();
		outFile.close();
	}

	public static int permute(String original, int min, int max) {
		String target = original;
		HashSet<Integer> resultSet =  new HashSet<Integer>();
		for(int i = 1;i<original.length();i++){
			String shifted = target.charAt(target.length()-1)+"";
			shifted += target.substring(0,target.length()-1);
			int potential = Integer.parseInt(shifted);
			if(potential>min && potential <= max)
				resultSet.add(potential);
			target = shifted;
		}
		return resultSet.size();
	}
}
