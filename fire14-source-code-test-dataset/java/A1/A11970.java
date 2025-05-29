import java.util.*;
import java.io.*;

public class B {

	

	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		int []result = new int[cases];
		//input.nextLine();
		for(int i = 0; i < cases ;i++){
			int n = input.nextInt();
			int s = input.nextInt();
			int p = input.nextInt();
			for(int j = 0 ;j<n;j++){
				int total = input.nextInt();
				int avg = total/3;
				int mod = total%3;
				if(total/3.0 > p-1){
					result[i]++;
				}else{
					if(avg == p-1 || (avg+mod)>=p){
						if(s>0 && avg>0){
							result[i]++;
							s--;
						}
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