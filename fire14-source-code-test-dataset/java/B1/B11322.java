import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class recycling {
	public static void main (String args[]){
		if (args.length != 1){
			System.out.println ("Gimme the right arguments!");
			return;
		}
		File f = new File(args[0]);
		int testcases, A, B;
		ArrayList <Integer> values = new ArrayList <Integer>();
		
	
		

		try{
			BufferedReader in = new BufferedReader (new FileReader(f));
			String s;
			testcases = Integer.parseInt(in.readLine());
			for (int i = 1; i<=testcases; i++){
				String temp [] = in.readLine().split(" ");
				A = Integer.parseInt(temp[0]);
				B = Integer.parseInt(temp[1]);
				int count = 0;
				for (int j=A; j<=B; j++){
					ArrayList <Integer> v = new ArrayList <Integer> ();
					v.add(j);
					String number = Integer.toString(j);
					int val;
					for (int k=0; k<number.length(); k++){
						number = shuffle(number);
						val = Integer.parseInt(number);
						if (j <= val && val <= B && !(v.contains(val))){
							count++;
							v.add(val);
						}
					}
					
					
					
				}
				
				System.out.printf ("Case #%d: %d\n", i, count );
				
				
			


			}
		}
			//while ((s = in.readLine()) != null){

			//}

		
		catch (IOException e){

		}
	}
	
	public static String shuffle (String s){
		String shuffled = "";
		for (int i = 1; i<s.length(); i++){
			shuffled += s.charAt(i); 
		}
		shuffled += s.charAt(0);
		return shuffled;
	}

}
