package Qual2012;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Qual2012B {
	
	public static void main(String args[]){

		String filePath = "X:\\GCJ\\2012B-small-attempt0.in";
//		String filePath = "X:\\GCJ\\2012B-large-attempt0.in";
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

		int n = Integer.parseInt(temp[0]);
		int s = Integer.parseInt(temp[1]);
		int p = Integer.parseInt(temp[2]);
		int[] t = new int[n];
		
		int ret = 0;
		
		for (int i = 0; i < n; i++) 
			t[i] = Integer.parseInt(temp[i + 3]);
		
		for (int i = 0; i < n; i++) {
			int remainder = t[i] % 3;
			int max = (t[i] + 2) / 3;
			
			if (max >= p) {
				ret++;
				continue;
			} else if (remainder != 1 && t[i] > 0 && max + 1 >= p && s > 0) {
				ret++;
				s--;
			}
		}
		
		return ret;

	}
}
