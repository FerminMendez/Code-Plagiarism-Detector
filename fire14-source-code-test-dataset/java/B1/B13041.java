import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class C {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("C:/Users/Farnoosh/Desktop/C-small.in"));
		FileWriter fw = new FileWriter("C:/Users/Farnoosh/Desktop/C-small.out");
		/*BufferedReader in = new BufferedReader(new FileReader("C:/Users/Farnoosh/Desktop/C-large.in"));
		FileWriter fw = new FileWriter("C:/Users/Farnoosh/Desktop/C-large.out");*/
		
		int N = new Integer(in.readLine());
		
			
		//System.out.print(N);
		 for (int cases = 1; cases <= N; cases++) {
			int count = 0;
			String[] ss = in.readLine().split(" ");
			
			int A = Integer.parseInt(ss[0]);
			int B = Integer.parseInt(ss[1]);
			
			
			for(int num = A ; num <= B ; num++){
				int num2 = 0;
				int len = (int)Math.pow(10, Integer.toString(num).length()-1);
				
				int i = 0;
				int num1 = num;
				for(i = 1; i < Integer.toString(num).length() ; i++){
					
					if(Integer.toString(num2).length() == Integer.toString(num1).length() || num2==0){
						num2 = 10 * (num1 % len) + (num1 / len);
					}
					else{
						num2 = num2 * 10;
					}
				
				    if(num2 == num)
				    	break;
					
					if (num2 <= B && num2 > num){
						count++;
					}// end of if
					num1 = num2;
				}//end of for
				

			}//end of for
					
			fw.write ("Case #" + cases + ": " + count + "\n");
		} 
		

		fw.flush();
		fw.close();
	}

}