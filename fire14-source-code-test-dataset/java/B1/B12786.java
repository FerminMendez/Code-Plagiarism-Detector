import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {
	
	File instance;
	Scanner sc;
	
	public Parser(String f){
		instance = new File(f);
	}
	
	public List<List<List<String>>> parse(int nbLinePerCase) throws FileNotFoundException{
		sc = new Scanner(instance);
		int nbCase = sc.nextInt();
		List<List<List<String>>> input = new ArrayList<List<List<String>>>(nbCase);
		String line;
		sc.nextLine();
		for(int i = 0; i < nbCase; i++){
			List<List<String>> ll = new ArrayList<List<String>>(nbLinePerCase);
			for(int j = 0; j < nbLinePerCase; j++){
				List<String> l = new ArrayList<String>();
				line = sc.nextLine();
				Scanner sc2 = new Scanner(line);
				while(sc2.hasNext()){
					l.add(sc2.next());
				}
				ll.add(l);
			}
			input.add(ll);
		}
		
		return input;
	}
}
