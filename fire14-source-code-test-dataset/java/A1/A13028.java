import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Parser {

	private Scanner sc;
	private int ncases;
	private int curcase;

	public Parser(String inputFile) throws FileNotFoundException {
		InputStream input = (inputFile == null) ? System.in : new FileInputStream(new File(inputFile));
		sc = new Scanner(input);
		ncases = sc.nextInt();
	}
	
	public boolean hasNext() {
		return ncases > curcase;
	}

	public Case nextCase() {
		if (!hasNext())
			return null;
		curcase++;
		int n = sc.nextInt();
		int s = sc.nextInt();
		int p = sc.nextInt();
		List<Integer> g = new ArrayList<Integer>(n);
		for (int i = 0; i < n; i++)
			g.add(sc.nextInt());
		return new Case(curcase, n, s, p, g);
	}

}