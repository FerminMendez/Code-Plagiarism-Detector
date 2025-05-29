package CodeJam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {

	/**
	 * @param args
	 */
	static Scanner scan = new Scanner(System.in);
	static BufferedReader brscan = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw ;
	static ArrayList<Triplet> arrTriplet = new ArrayList<Triplet>(1000);
	public static void main(String[] args) throws NumberFormatException, IOException {
		pw = new PrintWriter("output-B.txt");
		// TODO Auto-generated method stub
		
		
		
		int tc = scan.nextInt();
		
		
		int googler, surprise, minscore;
		for (int x=1; x<=tc; x++) {
			arrTriplet.clear();
			googler = scan.nextInt();
			surprise = scan.nextInt();
			minscore = scan.nextInt();

			for (int n = 0; n<googler; n++ ) {				
				arrTriplet.add(ScoreToTriplet(scan.nextInt()));
			}
			
			Collections.sort(arrTriplet);
			
			// process //
			int pass = 0;
			for (int n = 0; n<googler; n++) {
				Triplet now = arrTriplet.get(n);
				if (now.getMax()>=minscore) {
					pass++;
				} else if (surprise>0){
					if (now.x == now.y && now.y == now.z) {
						if (now.x+1>=minscore && now.y>0) {
							pass++;
							surprise--;
						}
					} else if (now.x == now.y) {
						if (now.x+1>=minscore && now.y>0) {
							pass++;
							surprise--;
						}
					} 
					
				}
				
			}
			//debug();
			pw.println("Case #"+x+": "+pass);
		}
		pw.flush();
		pw.close();
	}
	
	public static void debug() {
		for (int n=0; n<arrTriplet.size(); n++) {
			pw.println(arrTriplet.get(n).toString());
		}
	}
	
	public static Triplet ScoreToTriplet(int score) {
		int average = score/3;
		
		int remain = score-average*3;
		if (remain==2) {
			return new Triplet(average+1, average+1, average);
		} else if (remain==1) {
			return new Triplet(average+1, average, average);
		} else {
			return new Triplet(average, average, average);
		}
	}

}



class Triplet implements Comparable<Triplet> {
	int x, y, z;
	public Triplet(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	@Override
	public int compareTo(Triplet o) {
		// TODO Auto-generated method stub
		if (this.x!=o.x) {
			return o.x-this.x;
		}
		if (this.y!=o.y) {
			return o.y-this.y;
		}
		
		if (this.z!=o.z) {
			return o.z-this.z;
		}
		return 0;
	}
	
	public int getMax() {
		if (x>=y && x>=z) {
			return x;
		} 
		if (y>=x && y>=z) {
			return y;
		}
		return z;
	} 
	
	public int getMin() {
		if (x<=y && x<=z) {
			return x;
		}
		if (y<=z && y<=x) {
			return y;
		}
		return z;
	}
	
	public String toString() {
		return "["+x+","+y+","+z+"]";
	}

}