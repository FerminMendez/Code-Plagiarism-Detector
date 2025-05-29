import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class codeJam2 {
	
	public static void main(String[] args) throws FileNotFoundException {
	
		//System.out.print("input.txt");
		Scanner input = new Scanner(new File("input.txt"));
		String Do = input.nextLine();
		String line;
		for( int i = 0 ; i < Integer.parseInt(Do)  ;++i){
			line = input.nextLine();
			StringTokenizer tokens = new StringTokenizer(line);
			int people = Integer.parseInt(tokens.nextToken());
			int suprice = Integer.parseInt(tokens.nextToken());
			int high = Integer.parseInt(tokens.nextToken());
			possible p = new possible(suprice, high);
			for( int j = 0; j < people  ; ++j ){
				p.canDo(Integer.parseInt(tokens.nextToken()));
			}
			System.out.print("Case #"); 
			System.out.print(i+1);
			System.out.print(": ");
			System.out.println(p.count);
			
			
		}//outer for
		
		
	}

}
