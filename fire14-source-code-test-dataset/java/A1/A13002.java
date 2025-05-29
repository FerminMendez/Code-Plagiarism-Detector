import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class DancingWithTheGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length < 1)
			return;
		
		String inputFileName = args[0];
		File inputFile = new File(inputFileName);
		
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(inputFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found: "+inputFileName);
			return;
		}
		
		
		String line = null;
		try {
			line = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("First line nonexistent: "+inputFileName);
			return;
		}
		
		int numCases = Integer.parseInt(line);
		
		for(int i = 1; i <= numCases; i++){
			try {
				line = in.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Input ran out at line "+ i +" of "+ numCases);
				return;
			}
			
			String[] ins = line.split(" ");
			
			int gs = Integer.parseInt(ins[0]);
			int surps = Integer.parseInt(ins[1]);
			int min = Integer.parseInt(ins[2]);
			
			int capable = 0;
			for(int j = 0; j < gs; j++){
				int cur = Integer.parseInt(ins[3+j]);
				
				if(cur / 3 >= min)
					capable++;
				else if((min-1 >= 0) && (cur/3 == (min-1)) && (cur%3 > 0))
					capable++;
				else if(surps > 0 && (min-2 >= 0) && (cur/3 >= (min-2)) && (cur %3 > 1)){
					capable++;
					surps--;
				} else if(surps > 0 && (min-2 >= 0) && (cur/3 >= (min-1))){
					capable++;
					surps--;
				}
			}
			
			StringBuilder ob = new StringBuilder();
			ob.append("Case #").append(i).append(": ");
			ob.append(capable);
			System.out.println(ob.toString());
		}
		
//		String inp = "3 3 8 3 21 13";
//		
//		String[] ins = inp.split(" ");
//		
//		int gs = Integer.parseInt(ins[0]);
//		int surps = Integer.parseInt(ins[1]);
//		int min = Integer.parseInt(ins[2]);
//		
//		int capable = 0;
//		
//		for(int j = 0; j < gs; j++){
//			int cur = Integer.parseInt(ins[3+j]);
//			
//			System.out.println("cur/3: "+(cur/3));
//			System.out.println("cur%3: "+(cur%3));
//			
//			if(cur / 3 >= min)
//				capable++;
//			else if((min-1 >= 0) && (cur/3 == (min-1)) && (cur%3 > 0))
//				capable++;
//			else if(surps > 0 && (min-2 >= 0) && (cur/3 >= (min-2)) && (cur %3 > 1)){
//				capable++;
//				surps--;
//			} else if(surps > 0 && (min-2 >= 0) && (cur/3 >= (min-1))){
//				capable++;
//				surps--;
//			}
//		}
//		System.out.println(capable);
	}
}
