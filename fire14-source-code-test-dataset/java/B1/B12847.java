import java.util.*;
import java.io.*;

public class recycled_numbers {
	public static void main(String[]a) throws Exception{
		
		Scanner f = new Scanner(new File(a[0]));
		int result=0;
		int A,B;
		String n,m;
		HashSet<String> s=new HashSet<String>();
		
		int T=f.nextInt();	//T total case count
		for (int t=1; t<=T;t++){//for each case t
			
			s.clear();
			result=0;				//reset
			A=f.nextInt();B=f.nextInt();	//get values for next case
			
			if (A==B)result=0;//remove case not meeting problem limits 
			else{
				for(int i=A;i<=B;i++){//for each int in range
					n=Integer.toString(i);
					m=new String(n);
					//System.out.println(n);
					for (int j=1;j<n.length();j++){//move each digit to the front & test
						m = m.substring(m.length()-1)+m.substring(0,m.length()-1);
						if(m.matches("^0+[\\d]+")!=true &&
								Integer.parseInt(m)<=B &&
								Integer.parseInt(n)<Integer.parseInt(m)){
							s.add(new String(n+","+m));
							//result++;
							//System.out.println(" matched: "+m);
						}
						
					}
				}
				result = s.size();
			}

			//display output
			System.out.println("Case #" + t + ": " + result);
		}
	}
}