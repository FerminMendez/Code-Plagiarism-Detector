/**
* The HelloWorldApp class implements an application that
* simply prints "Hello World!" to standard output.
 */
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Math;



class help{
	
	public help(){
		
	}
	
	static int power(int x, int n)  
	{  
		if (n == 0)  
			return 1;                   // anchor case  
		else   
			return power(x, n - 1) * x;   // inductive step (n > 0)  
	}  
	
	public static int solve(int n, int i, int len, int upper, HashMap<Integer,Integer> hash){   // say n=123 i=2 len=3
		int count=0;
		//System.out.println("n= "+n+"  i="+i+"   len="+len);
		
		int i2=n/power(10, i);    ///i2=1
		//System.out.println("i2= "+i2);
		int b=i2*power(10, i);	////b=100
		int j1=n-b;             ///// j1=23
		int i1=j1*(power(10, (len-i)));
		
		int n2=i1+i2; /// now we have 231
		//System.out.println("n2= "+n2);
		if (n2>n && n2<=upper) {
			if (hash.containsKey(n2)) {
				count+=0;
			}
			else {
				count+=1;
				hash.put(n2,1);
			}
		}
		return count;
	}
}

class solve{
	
	public static void main(String[] args)
	{
		BufferedReader bf= null;
        String line;
		int n;
		int n1,n2;
		int ans=0;
		
        try {
			
			
			
            bf = new BufferedReader(new InputStreamReader(System.in));
			int indicator=0;
			int playerno=0;
			String output="";
			
			BufferedWriter f=new BufferedWriter(new FileWriter("output.txt"));
			while ((line=bf.readLine())!=null) {
				HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
				if (indicator==0) {
					n=Integer.parseInt(line);
				}
				else {
					String[] a=line.split(" ");
					int len=a[0].length();
					n1=Integer.parseInt(a[0]);
					n2 =Integer.parseInt(a[1]);
					/////////////////////////////////// now  solve this
					int number=n1;
					for (; number<n2; number++) {
						hash.clear();
						for (int i=1; i<len; i++) {
							int temp=help.solve(number, i, len,n2,hash);
							ans+=temp;
						}
					}
					playerno+=1;
					output+="Case #"+playerno+": "+ans+"\n";
					ans=0;
					
				}

				indicator=1;
				

			}
			f.write(output);
			f.close();
		}catch (Exception e) {
			System.out.println("exception 1");
		}
	
	}
}