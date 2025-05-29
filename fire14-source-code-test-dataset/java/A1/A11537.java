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
		BufferedReader br  = new BufferedReader(new FileReader("B-small-attempt1.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"));
		Pattern pat = Pattern.compile(" ");
		String firstLine = (br.readLine());
		Integer numLines = new Integer(firstLine);
		Integer i;
		
		for(i=1;i<=numLines;i++){
			Integer res=0;
			bw.write("Case #"+i+": ");
			String line = (br.readLine()).trim();
			String [] st= pat.split(line);
			List<Integer> scores = Lists.newArrayList();
			for(Integer j=3;j<st.length;j++){
				scores.add(new Integer(st[j]));
				
			}
			res=solve(new Integer(st[1]),new Integer(st[2]),scores);
			bw.write(res.toString());
			bw.newLine();
		}
		bw.close();
	}
	public static Integer solve(Integer numS,Integer p,List<Integer> scores){
		Integer res=0;
		for(Integer e:scores){
			Double aver= new Double(e)/3;
			Boolean r=false;
			if(aver>=p){
				res++;
			}else{
				Integer max=0;
				if(aver!=0.0){
				if(aver>=(Math.floor(aver)+0.25)){
					max= (int) (Math.floor(aver)+1);
					if(max>=p){
						res++;
						r=true;
					}					
				}
				if(numS!=0&&!r){
					if(aver>=(Math.floor(aver)+0.50)){
						max= (int) (Math.floor(aver)+2);				
					}else{
						max= (int) (Math.floor(aver)+1);					
					}
					if(max>=p){
						res++;
						numS--;
					}	
				}
				
				
			}	}		
		}
		
		return res;
	}
}