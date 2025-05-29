package qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class RecycledNumber {
	public static void main(String[] args) throws IOException{
		BufferedReader file = new BufferedReader(new FileReader(new File("src/input")));
		String firstline = file.readLine();
		int casenum = Integer.parseInt(firstline);
		StringWriter s= new StringWriter();
		for(int i=0;i<casenum;++i){
			int count = 0;
			int digit = 0;
			String temp = file.readLine();
			int index=0;
			while(temp.charAt(index)!=' '){
				++index;
				++digit;
			}
			int low = Integer.parseInt(temp.substring(0, index));
			int high = Integer.parseInt(temp.substring(index+1));
			if(1==digit){
				s.append("Case #"+(i+1)+": "+count);
				s.append("\n");
			}
			else{
				for(int j=low;j<=high;++j){
					int temp1 = j;
					int temp2 = temp1;					
					for(int k=0; k<digit-1;++k){
						int upper = temp2/10;
						int lower = temp2%10;
						if(0==lower){
							temp2 = upper;
						} else{
							temp2 = upper+lower*((int)Math.pow(10, digit-1));		
							if((temp1<temp2) && (temp2<=high))++count;
						}
					}
				}
				s.append("Case #"+(i+1)+": "+count);
				s.append("\n");
			}
		}
		FileWriter fout = new FileWriter("src/out.txt");
		fout.write(s.toString());
		fout.close();
	}
}
