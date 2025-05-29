import java.io.*;
import java.math.*;
import java.util.*;

class Main{

	static BufferedReader br;
	static PrintWriter pw;
	static File in;
	static File out;
	static String name="C-small-attempt0";
	
	
	public static void main(String[] args){
		try{
			in=new File(name+".in");
			out=new File(name+".out");
			br=new BufferedReader(new FileReader(in));
			pw=new PrintWriter(new BufferedWriter(new FileWriter(out)));
			
			int nbCase = Integer.parseInt(br.readLine());
			
			
			for (int n=1;n<=nbCase;n++){
				String line=br.readLine();
				long a=Long.parseLong(line.substring(0,line.indexOf(" ")));
				long b=Long.parseLong(line.substring(line.indexOf(" ")+1));
				long count=0;
				
				for (long n1=a;n1<b;n1++){
					for (long m=n1+1;m<=b;m++){
						if (isRecycled(n1,m)) count++;
					}
				}
				
				pw.println("Case #"+n+": "+count);
			}
			
			
			
			pw.flush();
			pw.close();
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	static boolean isRecycled(long n,long m){
		if (n!=m){
			boolean res=false;
			String strM=String.valueOf(m);
			String strN=String.valueOf(n);
			for (int i=1;i<strM.length() && !res;i++){
				String tmp=strN.substring(strN.length()-i,strN.length())+strN.substring(0,strN.length()-i);
				if (tmp.equals(strM)) res=true;
			}
			return res;
		}else return false;
	}
	
	
	
	
}
