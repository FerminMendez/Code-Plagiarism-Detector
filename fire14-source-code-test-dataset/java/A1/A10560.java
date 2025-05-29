package qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class DancingWithGoogler {
	public static void main(String[] args) throws IOException{
		BufferedReader file = new BufferedReader(new FileReader(new File("src/input")));
		String firstline = file.readLine();
		int casenum = Integer.parseInt(firstline);
		StringWriter s= new StringWriter();
		for(int i=0;i<casenum;++i){
			int count = 0;
			String temp = file.readLine();
			int start=0,end=0;
			while(temp.charAt(end)!=' '){
				++end;
			}
			int number = Integer.parseInt(temp.substring(start, end));
			start = ++end;
			while(temp.charAt(end)!=' '){
				++end;
			}
			int surprise = Integer.parseInt(temp.substring(start, end));
			start=++end;
			while(temp.charAt(end)!=' '){
				++end;
			}
			int p = Integer.parseInt(temp.substring(start, end));
			start = ++end;
			for(int j = 0;j<number;++j){
				int googler = -1;
				if(j<number-1){
					while(temp.charAt(end)!=' '){
						++end;
					}
					googler = Integer.parseInt(temp.substring(start, end));
					start = ++end;
				}
				else{
					googler = Integer.parseInt(temp.substring(start));//end of line has no space
				}
				if(googler<2||googler>28){
					//no surprising
					int min = googler/3;
					if(min>=p)++count;
				}
				else{
					if(googler<3*p-4){
						;//no-op
					}
					else if(googler>3*p-3){
						++count;
					}
					else{//only when the sum is 3p-3 or 3p-4 we need a surprise
						if(surprise>0){
							--surprise;
							++count;
						}
					}
				}
			}
			s.append("Case #"+(i+1)+": "+count);
			s.append("\n");
		}
		
		FileWriter fout = new FileWriter("src/out.txt");
		fout.write(s.toString());
		fout.close();
	}
}
