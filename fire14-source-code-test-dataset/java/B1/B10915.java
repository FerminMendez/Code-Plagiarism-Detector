package qualification;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {

	/**
	 * @param args
	 */
	static int number (int num){
		int i=0;
		while (num!=0){
			num/=10;
			i++;
		}
		return i-1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("C-small-attempt1.in"));
		PrintWriter out = new PrintWriter((new FileWriter("C-small-attempt1.out")));
		StringTokenizer st ;
		int tekrar = Integer.parseInt(f.readLine());
		
		for (int j=0;j<tekrar;j++){
			st = new StringTokenizer(f.readLine());
			int min = Integer.parseInt(st.nextToken());
			int max =  Integer.parseInt(st.nextToken());
			int count =0;
			for (int i=min;i<=max;i++){
				int num = i;
				num = (int) ((num%10)*Math.pow(10, number(num)))+num/10;
				while (num != i){
					while (number(i) != number(num)){
						num = (int) ((num%10)*Math.pow(10, number(i)))+num/10;
						if (num == i)
							break;
					}
					if (num == i)
						break;
					
					if (num>=min && num<=max ){
						count ++;
					}
					num = (int) ((num%10)*Math.pow(10, number(num)))+num/10;
				}
			}
			out.println("Case #"+(j+1)+": "+count/2);
		
		}
		out.close();
		System.exit(0);

	}

}
