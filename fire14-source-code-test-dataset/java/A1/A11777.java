import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class BSol {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		Date d1 = new Date();
		solveA("B-small-attempt0.in", "B-small-attempt0.out");		
		Date d2 = new Date();
		//System.out.println("time: " + (d2.getTime() - d1.getTime()) + " ms");

	}
	/*
	public static void main(String[] args) {
		for (int j0 = 0; j0 <= 10; j0++) {
			for (int j1 = j0; j1 <= 10; j1++) {
				for (int j2 = j1; j2 <= 10; j2++) {
					if ((j1-j0 <= 2) && (j2-j1<=2) && (j2-j0<=2)) {
					
						int sum = j0+j1+j2;
						System.out.println(j0 + " " + j1 + " " + j2 + " " + sum);
					}
				}
			}
			
			
		}
	}
	*/
	
	private static void solveA(String in, String out) {
		try {
			FileReader fis = new FileReader(in);
			BufferedReader  dis = new BufferedReader (fis);
			
			FileWriter fw = new FileWriter(out);
			BufferedWriter bw = new BufferedWriter(fw);

			
			int t = Integer.parseInt(dis.readLine());
			for (int i = 0; i < t; i++) {
				String e = dis.readLine();
				String ee[] = e.split(" ");
				int n = Integer.parseInt(ee[0]);
				int s = Integer.parseInt(ee[1]);
				int p = Integer.parseInt(ee[2]);

				int tt [] = new int[n];
				for (int j = 0; j < n; j++) {
					int sc = Integer.parseInt(ee[2+j+1]);
					tt[j] = sc;
				}
				
				String original = solve(n,s,p, tt);
				//System.out.println(original);
				bw.write("Case #" + (i+1) + ": " + original + "\n");
			}
			
			
			bw.flush();
			bw.close();
			fw.close();
			dis.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	private static String solve(int n, int s, int p, int[] tt) {
		//System.out.println("solve " + n +  " " + s + " " + p);
		int rez = 0;
		
		int potential = 0;
		for (int i = 0; i < n; i++) {
			
			int sc = tt[i]/3;
			int max = 0;
			int min = sc;
			
			if (tt[i] % 3 == 0) {
				min = sc;
				max = sc+1;
			}
			if (tt[i] % 3 == 1) {
				min = sc+1;
				max = sc+1;
			}
			if (tt[i] % 3 == 2) {
				min = sc+1;
				max = sc+2;
			}
			
			if (tt[i] == 0) {
				min = 0;
				max = 0;
			} else if (tt[i] == 1) {
				min = 1;
				max = 1;
			} else if (tt[i] == 29) {
				min = 10;
				max = 10;
			} else if (tt[i] == 30) {
				min = 10;
				max = 10;
			} 
			
			if (min == max) {
				//System.out.println(tt[i] + " " + min + " " + max + " *");
				if (min >= p) {
					rez++;
				}
			} else {
				if (min >= p) {
					//System.out.println(tt[i] + " " + min + " " + max + " *");
					rez++;
				} else {
					if (max < p) {
						//System.out.println(tt[i] + " " + min + " " + max + "**");
					} else {
						// left
						//System.out.println(tt[i] + " " + min + " " + max);
						potential++;
					}
					
				}
				
			}
		}
		
		//System.out.println("real: " + rez + " " + potential);
		
		
		
		return "" + (rez+Math.min(potential,s));
	}


}
