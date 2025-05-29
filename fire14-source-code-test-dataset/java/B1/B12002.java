import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Recycle {

	private BufferedReader br;
	private int numCases;
	
	public Recycle(String input){
		try{
		FileInputStream fstream = new FileInputStream(input);
		DataInputStream in = new DataInputStream(fstream);
		 br = new BufferedReader(new InputStreamReader(in));
		
		 numCases = Integer.parseInt(br.readLine());
		 
		 for(int i=0;i<numCases;i++){
			 System.out.print("Case #"+(i+1)+": ");
			this.Calculate(br.readLine());
			 
		 }
				 
		 in.close();
		}
	catch (Exception e){
		  System.err.println("Error: " + e.getMessage());
		  }
	}
	
	
	private void Calculate(String s){
		StringTokenizer st = new StringTokenizer(s);
		int start=Integer.parseInt(st.nextToken());
		int end=Integer.parseInt(st.nextToken());
		int count=0;
		for(int i=start;i<end;i++){
			for(int j=i+1;j<=end;j++){
				if(check(i,j))count++;
				
			}
		}
		System.out.println(count);
		
		
	}
	
	private boolean check(int n,int m){
		String n1=Integer.toString(n);
		String m1=Integer.toString(m);
		char[]n2=n1.toCharArray();
		char[]m2=m1.toCharArray();
		
		int[][]sum= new int[n1.length()+1][m1.length()+1];
		
		for(int i=1;i<=n1.length();i++){
			for(int j=1;j<=n1.length();j++){
				if(n2[i-1]==m2[j-1]){
					if(i-1>=0 || j-1>=0 )sum[i][j]=sum[i-1][j-1]+1;
					else sum[i][j]=1;
				}
				else sum[i][j]=0;
			}
		}
		
		
		for(int i=1;i<n1.length();i++){
			if(sum[n1.length()][i]>0){
				if(sum[n1.length()-i][n1.length()]==(n1.length()-sum[n1.length()][i])){
					
					return true;
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		Recycle r = new Recycle("input3.txt");

	}

}
