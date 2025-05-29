import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;


public class ProblemaB {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		int couldHaveBeenQuantity = 0;
		int couldHaveBeenSurprinsinglyQuantity = 0;
		PrintWriter pw = new PrintWriter ("C:\\Users\\Rodrigo\\Downloads\\B-small-attempt0.out");
		BufferedReader reader = new BufferedReader(new FileReader (new File ("C:\\Users\\Rodrigo\\Downloads\\B-small-attempt0.in")));
		int cases = Integer.parseInt(reader.readLine());
		for (int i = 1; i <= cases; i++){
			couldHaveBeenQuantity = 0;
			couldHaveBeenSurprinsinglyQuantity = 0;
			String linha = reader.readLine();
			String []  tokens = linha.split(" ");
			int N = Integer.parseInt(tokens[0]);
			int S = Integer.parseInt (tokens[1]);
			int p = Integer.parseInt (tokens[2]);
			for (int j = 3; j < tokens.length; j++){
				
				int total = Integer.parseInt(tokens[j]);
				if (couldHaveBeenNormally(total, p)){
					couldHaveBeenQuantity++;
				}
				else if (couldHavebeenSurprisingly(total, p)){
					couldHaveBeenSurprinsinglyQuantity++;
				}
			}
			int allThatCould = couldHaveBeenQuantity + (couldHaveBeenSurprinsinglyQuantity <= S ? couldHaveBeenSurprinsinglyQuantity : S);
			System.out.println("Case #" + i + ": " + allThatCould);
			pw.println("Case #" + i + ": " + allThatCould);
		}
		pw.close();

	}
	static boolean couldHaveBeenNormally (int total, int p){
		//if (total < p)
			//return false;
		//if (total == p)
			//return false;
		switch (p){
			case 10:
				if (total >= 28)
					return true;
				return false;
				
			case 9:
				if (total >= 25)
					return true;
				return false;
			case 8:
				if (total >= 22)
					return true;
				return false;
			case 7:
				if (total >= 19)
					return true;
				return false;
			case 6:
				if (total >= 16)
					return true;
				return false;
			case 5:
				if (total >= 13)
					return true;
				return false;
			case 4:
				if (total >= 10)
					return true;
				return false;
			case 3:
				if (total >= 7)
					return true;
				return false;
			case 2:
				if (total >= 4)
					return true;
				return false;
			case 1:
				if (total >= 1)
					return true;
				return false;
			default:
				return true;				
		}
		
	}
	static boolean couldHavebeenSurprisingly (int total, int p){
		//if (total < p)
			//return false;
		//if (total == p)
			//return false;
		switch (p){
			case 10:
				if (total >= 26)
					return true;
				return false;
			case 9:
				if (total >= 23)
					return true;
				return false;
			case 8:
				if (total >= 20)
					return true;
				return false;
			case 7:
				if (total >= 17)
					return true;
				return false;
			case 6:
				if (total >= 14)
					return true;
				return false;
			case 5:
				if (total >= 11)
					return true;
				return false;
			case 4:
				if (total >= 8)
					return true;
				return false;
			case 3:
				if (total >= 5)
					return true;
				return false;
			case 2:
				if (total >=2)
					return true;
				return false;
			case 1:
				if (total >= 1)
					return true;
				return false;
			default:
				return true;
			
				
		}
	}
}
