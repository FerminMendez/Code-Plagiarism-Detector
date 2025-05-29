import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class GooglerDancerMain {

	public static void main(String[] args) {
		
		
		
		try {
			Scanner s=new Scanner(new BufferedReader(new FileReader("B-small-attempt0.in")));
			ArrayList<GooglerDancer> list=new ArrayList<GooglerDancer>();
			int i=0;
			int totalCases=Integer.parseInt(s.nextLine());
			while(s.hasNextLine()){
				list.add(new GooglerDancer(++i,s.nextLine()));
			}
			
			for (GooglerDancer googlerDancer : list) {
				googlerDancer.process();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		
		
	}
}
