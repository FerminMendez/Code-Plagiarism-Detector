import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class main {

	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new FileReader("C-small-attempt0.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
		Pattern pat = Pattern.compile(" ");
		String firstLine = (br.readLine());
		Integer numLines = new Integer(firstLine);
		Integer i;
		
		for(i=1;i<=numLines;i++){
			bw.write("Case #"+i+": ");
			String line = (br.readLine()).trim();
			String [] st= pat.split(line);
			Integer a = new Integer(st[0]);
			Integer b = new Integer(st[1]);
			bw.write(solve(a,b).toString());
			bw.newLine();
		}
		bw.close();
	}
	
	public static Integer solve(Integer a,Integer b){
		Integer i,j;
		Integer res=0;
		for(i=a;i<=b;i++){
			for(j=i+1;j<=b;j++){
				if(isRecycledPair(i,j)){
					res++;
				}
			}
		}
		return res;
	}
	public static Boolean isRecycledPair(Integer i, Integer j){
		Integer a;
		String iS= i.toString();
		String jS= j.toString();
		for(a=1;a<=iS.length();a++){
			iS=iS.substring(1)+iS.charAt(0);
			if(iS.charAt(0)!='0'){	
				if(iS.compareTo(jS)==0){
					return true;
				}
			}
		}
		return false;
	}
}
	