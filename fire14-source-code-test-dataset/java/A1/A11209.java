/**
 * 
 */
package google.jam.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author walir
 *
 */
public class DancingGooglers {
	
	private HashMap<Integer, Integer> s = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> ns = new HashMap<Integer, Integer>();
	
	private BufferedReader bufferedReader;

	public DancingGooglers() throws FileNotFoundException {
		setUpS();
		setUpNS();
		File file = new File("C:/test");
		InputStreamReader in = new InputStreamReader(new FileInputStream(file));
		bufferedReader = new BufferedReader(in);
	}

	private void setUpS() {
		s.put(0, 0);
		s.put(1, 1);
		s.put(2, 2);
		s.put(3, 2);
		s.put(4, 2);
		s.put(5, 3);
		s.put(6, 3);
		s.put(7, 3);
		s.put(8, 4);
		s.put(9, 4);
		s.put(10, 4);
		s.put(11, 5);
		s.put(12, 5);
		s.put(13, 5);
		s.put(14, 6);
		s.put(15, 6);
		s.put(16, 6);
		s.put(17, 7);
		s.put(18, 7);
		s.put(19, 7);
		s.put(20, 8);
		s.put(21, 8);
		s.put(22, 8);
		s.put(23, 9);
		s.put(24, 9);
		s.put(25, 9);
		s.put(26, 10);
		s.put(27, 10);
		s.put(28, 10);
		s.put(29, 10);
		s.put(30, 10);		
	}
	
	private void setUpNS() {
		ns.put(0, 0);
		ns.put(1, 1);
		ns.put(2, 1);
		ns.put(3, 1);
		ns.put(4, 2);
		ns.put(5, 2);
		ns.put(6, 2);
		ns.put(7, 3);
		ns.put(8, 3);
		ns.put(9, 3);
		ns.put(10, 4);
		ns.put(11, 4);
		ns.put(12, 4);
		ns.put(13, 5);
		ns.put(14, 5);
		ns.put(15, 5);
		ns.put(16, 6);
		ns.put(17, 6);
		ns.put(18, 6);
		ns.put(19, 7);
		ns.put(20, 7);
		ns.put(21, 7);
		ns.put(22, 8);
		ns.put(23, 8);
		ns.put(24, 8);
		ns.put(25, 9);
		ns.put(26, 9);
		ns.put(27, 9);
		ns.put(28, 10);
		ns.put(29, 10);
		ns.put(30, 10);		
	}

	public static void main(String[] args) throws NumberFormatException, IOException{
		DancingGooglers dancingGooglers = new DancingGooglers();
		dancingGooglers.bp();
	}

	private void bp() throws IOException {
		int numberOfCases = Integer.valueOf(bufferedReader.readLine());

		for (int i = 1; i <= numberOfCases; i++) {
			String s[] = bufferedReader.readLine().split(" ");
			int googlers = Integer.valueOf(s[0]);
			int noOfSurprise = Integer.valueOf(s[1]);
			int minScore = Integer.valueOf(s[2]);
			ArrayList<Integer> scores = new ArrayList<Integer>();
			for(int j=0;j<googlers;j++)
				scores.add(Integer.valueOf(s[j+3]));
			int res = calc(googlers, noOfSurprise, minScore, scores);
			System.out.println("Case #" + i + ": " + res);
		}		
	}

	private int calc(int googlers, int noOfSurprise, int minScore, ArrayList<Integer> scores) {
		int r = 0;
		int tS  = noOfSurprise;
		for(int i=0;i<googlers;i++){
			int scr = scores.get(i);
			if(ns.get(scr)>=minScore){
				r++;
			} else if(s.get(scr)>=minScore && tS>0){
				r++;
				tS--;
			}
		}
		return r;
	}

}
