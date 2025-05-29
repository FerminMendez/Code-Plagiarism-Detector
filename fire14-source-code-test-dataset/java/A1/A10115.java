package source;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DancingGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("B-small-attempt5.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("B-small-attempt5.out"));
		
		int testCases = scan.nextInt();
		Map<Double, Integer> mapa = new HashMap<Double, Integer>();
		mapa.put(3d,2);
		mapa.put(6d,3);
		mapa.put(9d,4);
		mapa.put(12d,5);
		mapa.put(15d,6);
		mapa.put(18d,7);
		mapa.put(21d,8);
		mapa.put(24d,9);
		mapa.put(27d,10);
		
		for(int i=0; i < testCases; i++){
			int googlers = scan.nextInt();
			int s = scan.nextInt();
			int p = scan.nextInt();
			int bestResults = 0;
			
			for(int j=0; j < googlers; j++){
				double qual = scan.nextInt();
				
				double firstSecond = Math.round(qual/3d);
				double third = qual-(firstSecond*2);
				
				if(firstSecond >= p || third >= p) {
					bestResults++;
				} else if(s > 0 && p-third <= 2 && third <= firstSecond && !(((third+2)-(firstSecond-1)) > 2) && (third+2) <= 10) {
					bestResults++;
					s--;
				} else if(third == firstSecond && mapa.get(qual) != null && mapa.get(qual) >= p && s > 0){
					bestResults++;
					s--;
				} 
			}
			
			bw.write("Case #"+(i+1)+": "+bestResults+"\n");
		}
		bw.flush();
		bw.close();
	}

}
