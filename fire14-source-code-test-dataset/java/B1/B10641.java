import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class RecycledNumbersMain {
public static void main(String[] args) {
	
	try {
		Scanner s=new Scanner(new BufferedReader(new FileReader("C-small-attempt0.in")));
		ArrayList<RecycledNumbers> list=new ArrayList<RecycledNumbers>();
		int i=0;
		int totalCases=Integer.parseInt(s.nextLine());
		while(s.hasNextLine()){
			list.add(new RecycledNumbers(++i,s.nextLine()));
		}
		
	for (RecycledNumbers recycledNumbers : list) {
		recycledNumbers.process();
	}
		
	} catch (FileNotFoundException e) {
		System.out.println("file not found");
	}
	
}


}
