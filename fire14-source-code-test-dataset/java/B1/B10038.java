package Qual2012;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Qual2012C {
	
	public static void main(String args[]){

		String filePath = "X:\\GCJ\\2012C-small-attempt0.in";
//		String filePath = "X:\\GCJ\\2012C-large-attempt0.in";
		FileInputStream fis = null;
		BufferedReader readFile = null;
        String line;
        
        try {
        	fis = new FileInputStream(filePath);
            readFile = new BufferedReader(new InputStreamReader(fis, "ISO-8859-1"));
            line = readFile.readLine();
            int T = Integer.parseInt(line);
            for (int i = 1; i <= T; i++) {
            	line = readFile.readLine();
            	System.out.println("Case #" + i + ": " + solve(line) );
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }finally{
            try {
                fis.close();
                readFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}
	
	private static int solve (String line) {
		
		String[] temp = line.split(" ");
		int a = Integer.parseInt(temp[0]);
		int b = Integer.parseInt(temp[1]);
		
		int ret = 0;
		
		for (int i = a; i < b; i++) 
			ret += count(i, b);
		
		return ret;
	}
	
	private static int count(int x, int b) {
		
		int ret = 0;
		int digitnum = 0;
		int temp = x;
		boolean[] isCounted = new boolean[b + 1];
		
		while (temp > 0) {
			digitnum ++;
			temp /= 10;
		}
		
		for (int i = 10; i <= x; i *= 10) {
			int target = 0;
			target += x / i;
			target += (x % i) * (Math.pow(10, digitnum) / i);
			if (target > x && target <= b && !isCounted[target] ) {
				ret++;
				isCounted[target] = true;
			}
		}
		return ret;
	}
}
