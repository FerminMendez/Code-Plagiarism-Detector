import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Recycle {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("C-small-attempt1.in"));
		int t; // number of test cases
		int n = 1;
		int counter=0;
		int A, B;

		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		t = sc.nextInt();
		//System.out.println("Output");

		for (int i = 0; i < t; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			String aStr = String.valueOf(A);
			
			int len = aStr.length();
			for (int c = A; c < B+1; c++) {
				for (int k=1; k<len; k++){
					//System.out.println("Before: "+c);
					char[] ch = String.valueOf(c).toCharArray();
					shiftRight(ch,k);
					//System.out.println("Shifted: "+String.valueOf(ch));
					int d = Integer.parseInt(String.valueOf(ch));
					
					if (c<d && d<B+1) {	
						if(map.containsKey(c)){
							if(map.get(c)!=d) {
								//System.out.println("--------------------------------Success!");
								counter++;	
								//System.out.println(counter+": Before: "+c+" After: "+d);
								map.put(c, d);
							}
						}
						else {
							//System.out.println("--------------------------------Success!");
							counter++;	
							//System.out.println(counter+": Before: "+c+" After: "+d);
							map.put(c, d);
						}
							
					}
				}

			}
			System.out.printf("Case #%d: %s\n", n++, counter);
			counter = 0;
			map = new HashMap<Integer,Integer>();
		}

	}

	public static char[] shiftLeft(char[] array, int amount) {
		for (int j = 0; j < amount; j++) {
			char a = array[0];
			int i;
			for (i = 0; i < array.length - 1; i++)
				array[i] = array[i + 1];
			array[i] = a;
		}
		return array;
	}

	public static char[] shiftRight(char[] array, int amount) {
		for (int j = 0; j < amount; j++) {
			char a = array[array.length - 1];
			int i;
			for (i = array.length - 1; i > 0; i--)
				array[i] = array[i - 1];
			array[i] = a;
		}
		return array;
	}
}
