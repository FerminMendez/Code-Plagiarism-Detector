import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Googlers {

	static public int min(int a, int b){
		return a < b ? a : b;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File( "B-small-attempt2.in" );
		FileWriter out=new FileWriter("output.txt");

		Scanner in = new Scanner(new FileReader(f));

		if(f.exists()){
			int T;
			int N, S, p;
			int[] t = new int[100];
			
			T = in.nextInt();
			
			for(int i = 1; i <= T; i++){
				
				N = in.nextInt();
				S = in.nextInt();
				p = in.nextInt();
				
				int sup = 0;
				int litige = 0;
				
				for(int j = 0; j < N ; j++)
					t[j] = in.nextInt();
				
				for(int j = 0; j < N ; j++){
					if(t[j] >= 3*p-2)
						sup++;
					else
						if(t[j] >= 3*p-4 && 3*p-4 >= 0)
							litige++;
					

				}
				out.write("Case #" + i +": " + (sup+ min(S, litige))+ "\n");
			
			
			}
		}

		in.close();
		out.close();

		
	}
}
