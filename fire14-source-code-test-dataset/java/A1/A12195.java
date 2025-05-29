package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.*;

public class case2 {
	
	public static void main(String[] args){
	try {
	FileReader is_reader= new FileReader("C:\\Users\\Paul\\Downloads\\B-small-attempt0.in");
	BufferedReader reader = new BufferedReader(is_reader);
	FileWriter out_writer = new FileWriter("c:\\output.txt");
	int T = common.readInt(reader);
	int result;
	String sResult = "";
	
	for (int i=0;i<T;i++){
		int input[] = common.readInt(reader, " ");
		int N = input[0];
		int S = input[1];
		int p = input[2];
		int L1 = 3*p-2;
		int L2 = Math.max(1, 3*p-4);
		result = 0;
		for(int j=0;j<N;j++){
			if (input[j+3]>=L1)
				result++;
			else if (input[j+3]<L1&&input[j+3]>=L2&&S>0){
				result++;
				S--;
			}
		}
		sResult+="Case #" + (i+1)+": "+result+"\n";
		
	}
	System.out.print(sResult);
	out_writer.write(sResult);
	out_writer.flush();
	}
	catch (Exception e){
		
		
	}
	
	}
}
