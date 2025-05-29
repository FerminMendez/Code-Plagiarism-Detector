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

/**
 * @author walir
 *
 */
public class RecycledNumbers {

	private BufferedReader bufferedReader;

	public RecycledNumbers() throws FileNotFoundException {
		File file = new File("C:/test");
		InputStreamReader in = new InputStreamReader(new FileInputStream(file));
		bufferedReader = new BufferedReader(in);
	}

	public static void main(String[] args) throws NumberFormatException, IOException{
		RecycledNumbers  recycledNumbers = new RecycledNumbers();
		recycledNumbers.bp();
	}

	private void bp() throws NumberFormatException, IOException {
		int numberOfCases = Integer.valueOf(bufferedReader.readLine());

		for (int i = 1; i <= numberOfCases; i++) {
			String s[] = bufferedReader.readLine().split(" ");
			Integer lLim = Integer.valueOf(s[0]);
			Integer uLim = Integer.valueOf(s[1]);
			int res = calc(lLim, uLim);
			System.out.println("Case #" + i + ": " + res);
		}
		
	}

	private int calc(Integer lLim, Integer uLim) {
		int total = 0;
		for(int l = lLim;l<uLim;l++){
			for(int u = lLim;u<=uLim;u++){
				if(l<u && recycleable(l,u))
					total++;
			}
		}
		return total;
	}

	private boolean recycleable(int l, int u) {
		int temp = l;
		
		int d = 0;
		while(temp>0){
			temp /= 10;
			d++;
		}
		int a[]=new int[d];
		for(int i=0;i<d;i++){
			int t = (int) (u%10);
			u /= 10;
			a[d-1-i] = t;
			
		}
		for(int s = 1; s < d; s++){
			int b  = shift(a, s);
			if((l ^ b) == 0)
				return true;
		}
		return false;
	}

	private int shift(int[] a, int s) {
		int r = 0;
		int l = a.length;
		for(int i=0;i<l;i++){
			r = r*10 + a[(s+i)%l];
		}
		//System.out.println(r);
		return r;
	}

}
