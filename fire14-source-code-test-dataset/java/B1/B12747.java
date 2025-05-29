import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;
import java.io.*;

public class cx{
	public static void main(String[] args){
		try{			
			File output;
			FileWriter outputwriter;
			BufferedWriter out;
			String filename = "bx.out";
			
			output = new File(filename);
			outputwriter = new FileWriter(output);
			out = new BufferedWriter(outputwriter);
			
			//System.out.println("siap");
			//out.write("ardhianvv\nll");
			BufferedReader f = new BufferedReader(new FileReader("a.in"));
			StringTokenizer st = new StringTokenizer(f.readLine());			
			int angka = Integer.parseInt(st.nextToken());
			for(int a=0;a<angka;a++){
				st = new StringTokenizer(f.readLine());
				String hh[] = st.nextToken("\n").split(" ");
				int aa = Integer.parseInt(hh[0]);
				int bb = Integer.parseInt(hh[1]);
				int hasil =0;
				HashSet<String>jkl = new HashSet<String>();
				for(int b=aa;b<=bb;b++){
					String as = ""+b;
					//if(a==3)
					//System.out.println("- "+as);
					int len = as.length();					
					for(int c=0;c<as.length()-1;c++){
						if(as.charAt(len-1-c)<as.charAt(0)){
							continue;
						}
						int gg = Integer.parseInt(""+as.substring(len-1-c,len)+as.substring(0,len-1-c));						
						if(gg>b && gg<=bb){
							//if(a==3)
								//System.out.println((hasil+1)+ " "+b+" "+gg);
							jkl.add(b+" "+gg);
							//hasil++;
						}
					}
				}
				//System.out.println(jkl.size());
				if(a!=angka-1)					
					out.write("Case #"+(a+1)+": "+jkl.size()+"\n");
				else
					out.write("Case #"+(a+1)+": "+jkl.size());
			}
			out.close();
		} catch(Exception cc){
			System.out.println(cc.toString());
		}
	}
}