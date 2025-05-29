package CodeJam2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q3 {
	public static void main(String[] args)throws IOException {
		FileReader buf=new FileReader("C-small.in");
		BufferedReader br=new BufferedReader(buf);
		int cases=Integer.parseInt(br.readLine());
		String[] output=new String[cases];
		for(int i=1;i<=cases;i++){
			int ctr=0;
			String input=br.readLine();
			String[] splits=input.split(" ");
			int A=Integer.parseInt(splits[0]);
			int B=Integer.parseInt(splits[1]);
			for(int n=A;n<=B;n++){
				String temp=n+""+n;
				for(int m=n+1;m<=B;m++){
					String temp2=m+"";
					if(temp.contains(temp2)){
						ctr++;
					}
				}
			}
			if(i!=cases)
			output[i-1]="Case #"+i+": "+ctr+"\n";
			else
			output[i-1]="Case #"+i+": "+ctr;	
		}
		br.close();
		buf.close();
		 FileWriter buf1 = new FileWriter(new File ("C-small_Output.txt"), true);
		 BufferedWriter bw1=new BufferedWriter(buf1);
		for(int i=0;i<cases;i++){
			bw1.write(output[i]);
		}
		bw1.close();
		buf1.close();
	}

}
