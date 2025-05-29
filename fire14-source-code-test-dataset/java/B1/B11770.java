import java.io.*;
import java.util.*;


public class RecycledNumbers {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input"));
		int n=sc.nextInt();
		for (int i = 1; i <= n; i++) {
			int N=sc.nextInt();
			int M=sc.nextInt();			
			Set<String> set=new HashSet<String>();
			for(int j=N;j<=M;j++) {
				String currentNumber=String.valueOf(j);
				if(currentNumber.length()==1) {
					continue;
				}				
				for(int k=1;k<currentNumber.length();k++){					
					StringBuilder newNumber=new StringBuilder();
					newNumber.append(currentNumber.substring(k)).append(currentNumber.substring(0, k));
					int num1=Integer.parseInt(newNumber.toString());
					if(currentNumber.length()!=String.valueOf(num1).length()){
						continue;
					}					
					if(j!=num1 && num1>=N && num1<=M) {
						set.add(Math.min(j,num1)+":"+Math.max(j,num1));
					}
				}
			}
			System.out.println("Case #" + i + ": "+set.size());
		}
		

	}

}
