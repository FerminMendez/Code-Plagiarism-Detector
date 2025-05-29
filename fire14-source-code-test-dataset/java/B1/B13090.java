import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class recycled {
	
	static int A;
	static int B;
	static int count=0;
	static int n;
	
	private static Scanner x;
	private static Formatter y;
	static String newline = System.getProperty("line.separator");
	
	static List<String> words = new ArrayList<String>();	
	static int testCases;
	
	public static void main(String args[]){
		
		// open input file
		
		 try{
			  x= new Scanner(new File("C-small-attempt0.in"));
			 				
				
		  }catch(Exception e){
			  System.out.println("Could not find the file");
		  }		  

		
		
		while(x.hasNext()){
			words.add(x.nextLine());			
		}
		testCases=Integer.parseInt(words.get(0));
		words.remove(0);
		
		
		int cnt=0;
		
		// create output file
		
		try{
			y= new Formatter("recycled.ou");
			//System.out.println("sampleTongue.ou has been created");
		
		}catch(Exception e){
			System.out.println("Could not create a file");
		}
		
		//evaluate		
		
		for(int k=0; k<testCases;k++){
			
			String[] pStr = (words.get(k)).split(" ");
			
			A=Integer.parseInt(pStr[0]);
			B=Integer.parseInt(pStr[1]);
			
			System.out.println("A :"+ A);
			System.out.println("B :"+ B);
			
				for(int i=A; i<=B; i++){
					
					n=i;
					String sNum=Integer.toString(i);
					cnt=shift(sNum.toCharArray());
					
					//System.out.println("////////////////////");
				}
			System.out.println("count :"+ cnt);
			
			y.format("Case #%d: ",(k+1));
			y.format("%d",cnt);
			y.format(newline);
			
			cnt=0;
			count=0;
		}
		
		
		x.close();
		y.close();
			
	}
	
	public static int shift(char[] c){
		
		
		char []d= new char[c.length];
		
		//shifting 
		for(int k=0; k<c.length; k++){
			
			for(int i=0; i<c.length ;i++){
				
				if(i==0)
					d[i]=c[c.length-1];
				else
					d[i]=c[i-1];
				
				//System.out.print(d[i]);
				
				
			}
			
			int m = Integer.parseInt(new String(c));
			
			
			if(A<=n && m>n && m<=B){
				count++;
				System.out.println(n+"  "+m);
			}
			//copying
			
			for(int j=0; j<c.length; j++){
				c[j]=d[j];
			}
			
		}
		
		return count;
	}
	
	
	
	
	
	
}
