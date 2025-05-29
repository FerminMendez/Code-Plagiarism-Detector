import java.util.Scanner;
import java.io.*;


public class B{
	public static int calculate(String str){
		String[] numbers = str.split(" ");
		int googlers = Integer.parseInt(numbers[0]);
		int surprising = Integer.parseInt(numbers[1]);
		int p = Integer.parseInt(numbers[2]);
		int loc = 3;
		int ret = 0;

		for(int i = 0; i < googlers; i++){
			int total = Integer.parseInt(numbers[loc]);
			loc ++;
			if(total % 3 == 0){
				if((total / 3) > (p - 1))
					ret++;
				else if((total / 3) == (p - 1) && surprising > 0 && total != 0 && total != 30){
					surprising--;
					ret++;
				}
			}
			else if(total % 3 == 1){
				if((total / 3) > (p - 2))
					ret++;
			}
			else if(total % 3 == 2){
				if((total / 3) > (p - 2))
					ret++;
				else if((total / 3) == (p - 2) && surprising > 0 && total != 29){
					surprising--;
					ret++;
				}
			}
		}
		return ret;
	}

	public static void main(String[] args){
		Scanner sc = null;
		String next;
		int out;
		try{
			sc = new Scanner(new File("B-small-attempt0.in"));
			int cases = Integer.parseInt(sc.nextLine());
			int current = 0;
			

			FileWriter fs = new FileWriter("output.txt");
			BufferedWriter buff = new BufferedWriter(fs);
			while(current < cases){
				next = sc.nextLine();
				current++;
				out = calculate(next);
				buff.write("Case #" + current + ": " + out + "\n");
			}
			buff.close();
		}
		catch(Exception ex){}
	}
}