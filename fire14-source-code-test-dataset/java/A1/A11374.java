import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;


public class B {
	private static final String INPUTFILE = "./B.in";
	private static final String OUTPUTFILE = "./B.out";
	private static FileReader in;
	private static FileWriter out;
	private static BufferedReader buffIn;
	private static BufferedWriter buffOut;
	private static Scanner s;

	public static String executeSingle(){
		int res = 0;
		int N = s.nextInt();
		int S = s.nextInt();
		int p = s.nextInt();
		int[] t= new int[N];
		for(int i=0;i<N;i++){
			t[i] = s.nextInt();
		}
		Arrays.sort(t);
		int minimumOKScore = p+Math.max(p-1, 0)*2;
		int minimumPossibleScore = p+Math.max(p-2, 0)*2;
		//tant que le score est plus grand que le plus petit plausible possible (p+p-1+p-1)
		
		for(int i=N-1;i>=0;i--){
			if(t[i]>= minimumOKScore){
				res++;
			}
			else if(t[i]>= minimumPossibleScore && S > 0){
				S--;
				res++;
			}
		}
		
		
		return ""+res;
	}


	public static void execute() throws IOException{
		int n = s.nextInt();
		s.nextLine();
		for(int i=1;i<=n;i++){
			buffOut.append("Case #"+i+": "+executeSingle());
			buffOut.newLine();
			//System.out.println("Case #"+i+": "+executeSingle());
		
		}
	}


	public static void main(String[] args) throws IOException {
		in = new FileReader(INPUTFILE);
		out = new FileWriter(OUTPUTFILE);
		buffIn = new BufferedReader(in);
		buffOut = new BufferedWriter(out);
		s = new Scanner(buffIn);
		execute();
		buffOut.flush();
		buffOut.close();
		buffIn.close();
		out.close();
		in.close();
	}

}