import java.util.*;
import java.io.*;

public class C {
	public static int computeDigits(int x){
		if(x<10){
			return 1;
		}else{
			return 1+computeDigits(x/10);
		}
	}
	public static boolean recycled(int x, int y){
		int n = computeDigits(x);
		for(int i = 1;i<n;i++){
			int c = (int)Math.pow(10,i);
			int number = x/c;
			int mod = x%c;
			int newNumber = (mod*(int)Math.pow(10,n-i))+number;
			//System.out.println(newNumber);
			if(newNumber == y) return true;		
		}
		return false;
	}	

	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		int []result = new int[cases];
		//input.nextLine();
		for(int i = 0; i < cases ;i++){
			int a = input.nextInt();
			int b = input.nextInt();
			if(a<10 || b<10){
				result[i]=0;
			}else{
				for(int j = a; j<b;j++){
					for(int k=a+1;k<=b;k++){
						if(j<k && recycled(j,k)) result[i]++;
					}
				}
			}
		}
		
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter("outfilename.txt"));
			for(int i = 1; i<=cases ;i++){
			System.out.println("Case #"+i+": "+result[i-1]);
			output.write("Case #"+i+": "+result[i-1]+"\n");
			
			}
			output.close();
		} catch (IOException e) {
		}
		
		
	}
	




}