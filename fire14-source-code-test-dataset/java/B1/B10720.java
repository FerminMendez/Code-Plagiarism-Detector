import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class C {

	public static ArrayList<String> toArray(String number){
		ArrayList<String> array = new ArrayList<String>();	
		char[] numbers = number.toCharArray();
		
		for (int i=0; i<number.length(); i++)
			array.add(new String(numbers[i]+""));

		return array;
	}
	
	
	public static boolean isPossible(ArrayList<String> array1, ArrayList<String> array2){
		String number1="";
		String number2="";
	
		for (int i=0; i<array1.size(); i++)
			number1 = number1.concat(array1.get(i).toString());
		
		int n1 = Integer.parseInt(number1);
				
		for (int j=0; j<array2.size(); j++){
			number2="";
			for (int m=0; m<array2.size(); m++)
				number2 = number2.concat(array2.get(m).toString());

			if (!number2.startsWith("0")){
				int n2 = Integer.parseInt(number2);
	
				if (n1 == n2)
					return true;
			}
			
			String lastElement = array2.get(array2.size()-1);
			array2.add(0, lastElement);
			array2.remove(array2.size()-1);
		}
		
		return false;
	}
	
	
	
	public static void main(String[] args) throws IOException  {
		Scanner in = new Scanner(new FileReader("C-small-attempt5.in"));
		FileWriter output = new FileWriter("C-small-output.txt");
		String line = in.nextLine();
		ArrayList<String> array1;
		ArrayList<String> array2;
		String number1, number2;
		int n = Integer.parseInt(line);
		int pairs, n1, n2;

		for (int i = 0; i < n; i++) {
			n1 = in.nextInt();
			n2 = in.nextInt();
			pairs = 0;

			for (int j=n1; j<n2; j++){
				number1 = String.valueOf(j);
				
				for (int k=j+1; k<=n2; k++){
					number2 = String.valueOf(k);	
					array1 = toArray(number1);
					array2 = toArray(number2);
					
					if (isPossible(array1, array2))
						pairs++;
				}
			}
			
			output.write("Case #" + (int) (i+1) +": " + pairs + "\n");
		}
		
		output.close();
	}
}
