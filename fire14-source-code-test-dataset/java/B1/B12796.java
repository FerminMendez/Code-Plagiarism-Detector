import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Scanner;

public class recycle {
	
	static int cases;
	static int[] state;
	static String[][] delta;
	
	static void console(Object a, int line){
		String time = Calendar.getInstance().getTime().toString();
		String type = a.getClass().getName();
		System.out.println(time+" "+line+": "+type+" = "+a);
	}
	
	static void simpleConsole(Object a){
		System.out.println(a.toString());
	}
	
	static void error(String a, int line){
		System.out.println("ERROR "+line+": "+a);
	}
	
	static void fileHandler(File a) throws FileNotFoundException{
		Scanner v = new Scanner(a);
		cases = Integer.parseInt(v.nextLine());
		console(cases, new Exception().getStackTrace()[0].getLineNumber());
		state = new int[cases];
		delta = new String[cases][2];
		for(int g = 0; g < cases; g++){
			for(int f = 0; f < 2; f++){
				delta[g][f] = v.next();
				//state[g][f] = delta[g][f];
				console(delta[g][f], new Exception().getStackTrace()[0].getLineNumber());
				//console(state[g][f], new Exception().getStackTrace()[0].getLineNumber());
			}
		}
	}
	
	static void print(){
		System.out.println("");
		System.out.println("Input");
		System.out.println(cases);
		for(int f = 0; f < cases; f++){
			for(int j = 0; j < 2; j++){
				System.out.print(delta[f][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("Output");
		for(int f = 0; f < cases; f++){
			System.out.print("Case #"+(f+1)+": "+state[f]);
			System.out.println("");
		}
	}
	
	static String shuffle(String num, int length){
		String value;
		if(num.length() == length){
			String b = num.substring(0, 1);
			//console(b, 1);
			String a = num.substring(1);
			//console(a, 1);
			//console(a+b, 1);
			value = a+b;
		} else {
			value = num;
			for(int i = 0; i < length-num.length(); i++){
				value += "0";
			}
		}
		return value;
	}
	
	static boolean check(int min, int max, int n, String m){
		if(min <= n && n < Integer.parseInt(m) && Integer.parseInt(m) <= max)
			return true;
		else
			return false;
	}
	
	static void recycling(){
		int max, min;
		for(int f = 0; f < cases; f++){
			min = Integer.parseInt(delta[f][0]);
			max = Integer.parseInt(delta[f][1]);
			int play = min;
			for(int k = 0; k < max-min+1; k++){
				String test = String.valueOf(play+k);
				int length = String.valueOf(play).length();
				//simpleConsole("** "+(play+k)+" l:"+length);
				for(int l = 0; l < length; l++){
					test = shuffle(test, length);
					//simpleConsole(test);
					if(check(min, max, (play+k), test)){
						state[f] += 1;
						//simpleConsole("** "+(play+k)+" l:"+length);
						//simpleConsole(test+" "+(play+k));
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		if(args.length == 0){
			error("No inputs!", new Exception().getStackTrace()[0].getLineNumber());
			System.exit(1);
		}
		fileHandler(new File(args[0]));
		recycling();
		print();
	}
}
