/**
 * 
 */
package hu.hke.gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author katalma
 *
 */
public class DancingWithTheGooglers {

	static DancingWithTheGooglers dwtg = new DancingWithTheGooglers() ;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		readAndCalculate(args[0], args[1]);
	}

	private static void readAndCalculate(String inputF, String outputF) {
		BufferedReader input = null;
		BufferedWriter output = null;
		try {
			String line = null;
			input =  new BufferedReader(new FileReader(inputF));
			output = new BufferedWriter(new FileWriter(outputF));
			boolean first = true;
			int expectedRows = 0;
			int actualRows = -1;
			while ((( line = input.readLine()) != null) && (actualRows < expectedRows)) {
				System.out.print(actualRows+1);
				System.out.println("----------------------------------------------------");
				if (first) {
					first = false;
					expectedRows = Integer.parseInt(line);
				} else {
					output.write("Case #" +(actualRows+1)+": "+ dwtg.maximumBestResults(line));
					if (actualRows +1 < expectedRows) {
						output.write("\n");
					}
				}
				actualRows++;
			}
			
			input.close();
			output.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
		
	}

	private String maximumBestResults(String line) {
		// TODO Auto-generated method stub
		System.out.println(line);
		B actLine = new B(line);
		return actLine.pGooglers();
	}
	
	class B {
		int googlerN;
		int suprs;
		int p;
		Googler[] googlers;
		int pGooglers;
		
		private B() {};
		
		B(String line) {
			String[] tmp = line.split(" ");
			googlerN = Integer.parseInt(tmp[0]);
			suprs = Integer.parseInt(tmp[1]);
			p = Integer.parseInt(tmp[2]);
			googlers = new Googler[googlerN<= tmp.length-3? googlerN : tmp.length-3];
			for (int i = 0; i < googlers.length; i++) {
				googlers[i] = new Googler(Integer.parseInt(tmp[i+3])); 
			}
			pGooglers = 0;
		}

		public String pGooglers() {
			// TODO Auto-generated method stub
			System.out.println("Limit: "+p+" Suprise: "+suprs);
			pGooglers = 0;
			int actSuprs = 0;
			for (int i = 0; i < googlers.length; i++) {
				if (googlers[i].possibleP(p)) {
					System.out.println("Possible: " +googlers[i]);
					pGooglers++;
				} else if (actSuprs< suprs) {
					System.out.println("with suprise?");
					if (googlers[i].possiblePS(p)) {
						System.out.println("Possible with suprise: " +googlers[i]);
						pGooglers++;
						actSuprs++;
					} 
				}
			}
			return Integer.toString(pGooglers);
		}
		
	}

	class Googler {
		int totalCounts;
		int div;
		int mod;
		
		Googler(int i) {
			totalCounts = i;
			div = i/3;
			mod = i%3;
		}

		public boolean possibleP(int p) {
			if (div>=p) {
				return true;
			}
			if ((mod<2 ) &&(div+mod>=p)) {
				return true;
			}
			if ((mod==2 ) && (div+1>=p)&& (totalCounts>1)) {
				return true;
			}
			return false;
		}
		public boolean possiblePS(int p) {
			if (div>=p) {
				return true;
			}
			if (div+mod>=p) {
				return true;
			}
			if ((mod==0 ) && (div+1>=p) && (totalCounts>1)) {
				return true;
			}
			return false;
		}
		public String toString() {
			return "googgler: "+totalCounts+"::"+div+"::"+mod;
		}
	}
}
