package codejam;

import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;


public class QualificationC {
	public static long recycled(long nr1,long b){
		long count=0;
		String n1=String.valueOf(nr1);
		String n2=n1;
		HashMap<String,Boolean> gen=new HashMap<String,Boolean>();
		for(int i=0;i<n2.length();i++){
			n2=n2.substring(1,n2.length())+n2.substring(0,1);
			if(gen.containsKey(n2))continue;
			else gen.put(n2,Boolean.TRUE);
			long nr2=Long.parseLong(n2);
			if(String.valueOf(nr2).length()!=n1.length())continue;
			if(nr2>nr1&&nr2<=b){
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args){
		try{
			Scanner sc=new Scanner(new File("C.in"));
			PrintStream ps=new PrintStream("C.out");
			int n=sc.nextInt();
			long a,b;
			for(int i=0;i<n;i++){
				long count=0;
				a=sc.nextLong();
				b=sc.nextLong();
				for(long nr1=a;nr1<b;nr1++)
					count+=recycled(nr1,b);
				ps.println("Case #"+(i+1)+": "+count);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
