import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class recycle {
	public static void main(String[] args) {
		recycle rec = new recycle();
         rec.readFile("test.txt");
	}

	public void readFile(String filename){
	int i = 1;
	BufferedReader reader = null;
	try {
		reader = new BufferedReader(new 
				FileReader(filename));
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	String newLine;
		try {
			newLine = reader.readLine();
			while ((newLine = reader.readLine()) != null) {
				evalline(newLine,i);
				i++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void evalline(String line,int casenum){
		Scanner sc = new Scanner(line);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int tot = 0;
		
		System.out.print("Case #" + casenum + ": ");
		for(int x = n; x < m; x++){
			for(int y = x+1; y<= m; y++){
				if(check(x,y)){
					tot++;
				}
			}
		}
		
		System.out.println(tot);
			
		
	}
	
	public boolean check(int x, int y){
		String str1 = Integer.toString(x);
		String str2 = Integer.toString(y);
		int len = str1.length();
		for(int z = 0; z < len; z++){
			int a = 0;
			int b = z;
			while(str1.charAt(a) == str2.charAt(b % len)){
				a++;
				b++;
				if(z == (b % len)){
					return true;
				}
			}
		}
		return false;
		
	}
}
	
