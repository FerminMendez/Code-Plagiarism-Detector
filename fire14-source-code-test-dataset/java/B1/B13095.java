import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Scanner;


public class Rec {

	static Writer out;
	static Scanner sc;
	public static void main(String[] args) throws IOException {
		sc=new Scanner(new File("input.txt"));
		out = new OutputStreamWriter(new FileOutputStream("out.txt"));
		int num_of_cases=sc.nextInt();
		int a,b;
		
		for (int i = 1; i <= num_of_cases; i++) {
			a=sc.nextInt();
			b=sc.nextInt();
			solve(a,b,i);
		}
		//System.out.println("Done");
		out.close();
	}
	private static void solve(int a, int b, int case_num) throws IOException {
		int len=String.valueOf(a).length();
		int count=0;
		int t;
		boolean [][]arr=new boolean[b+1][b+1];
		for(int i=0;i<b+1;i++){
			for (int j = 0; j < b+1; j++) {
				arr[i][j]=false;
			}
		}
		for(int k=a;k<b;k++){
			
			for (int i = 1; i <len ; i++) {			
				t=(int) (k/Math.pow(10, i) + k%Math.pow(10,i) * Math.pow(10,len-i) );
				if(t>a && t<=b && k<t){
					
					if(arr[k][t]==true){
						//System.out.println("***************************************************************************");
						count--;
					}
					arr[k][t]=true;
					count++;
					//System.out.println(a+", "+k+", "+t+", "+b);
				}
			}

		}
		//System.out.println("Case #"+case_num+": "+count);
		out.append("Case #"+case_num+": "+count+'\n');
	}
	
	

}
