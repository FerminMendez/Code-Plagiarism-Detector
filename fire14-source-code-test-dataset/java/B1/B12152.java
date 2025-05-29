//package RecycleNumber;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class C {
	public static HashSet<String> hm = new HashSet<String>();
	public static void main(String [] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		int count = 1;
		rotate(1234,10,2222);
		while(num-- != 0){
			String [] token = in.readLine().split(" ");
			int num1 = Integer.parseInt(token[0]);
			int num2 = Integer.parseInt(token[1]);
			for(int i = num1; i <= num2; i++){
					rotate(i,num1,num2);
			}
			System.out.println("Case #"+ count++ +": " +hm.size());
			hm.clear();
		}
	
	}
	
	public static void rotate(int current, int num1, int num2){
		int times = (current+"").length()-1;
		int check = current;
		String temp = current+"";
		while(times >= 0 ){
			temp = temp.charAt(temp.length()-1) + temp.substring(0,temp.length()-1);
			times--;
			
			if(Integer.parseInt(temp) > num1 && Integer.parseInt(temp) <= num2 && Integer.parseInt(temp) > check){
				hm.add(check +": "+temp);
				//System.out.println(check + ": " + temp);
			}
			
		}
	
		
	}
}
