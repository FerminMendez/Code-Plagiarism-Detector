import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Algorithm{	
	int A;
	int B;
	int half;
	ArrayList<Key> map;
	int counter;
	
	public Algorithm(String line){
		Scanner scan = new Scanner(line);
		A = scan.nextInt();
		B = scan.nextInt();
		half = (B-A)/2;
		map = new ArrayList<Key>();
		counter = 0;
	}
	
	public int getOutput(){
		return counter;
	}

	public void solve(){
		for(int x = B; x >= A; x--){

			String xString = Integer.toString(x);
			for(int y = 1; y<=xString.length()/2; y++){
				for (int i = 0; i<xString.length(); i++){
					String old = xString;
					xString = xString.substring(y, xString.length());
					xString = xString.concat(old.substring(0,y));
					if(!xString.equals(old) && xString.charAt(0) != '0' && old.charAt(0) != '0'){
						int m = Integer.parseInt(old);
						int n = Integer.parseInt(xString);
						Key check = new Key(m, n);
						if(A <= m && m <= B && A <= n && n <= B && (!map.contains(check))){
							map.add(check);
							//System.out.println(m + "  " + n);
							counter++;
						}
					}
				}
			}
		}
	}
}

class Key {
	public int N;
	public int M;
	public Key(int n, int m){
		N = n;
		M = m;
	}
	
	public boolean equals(Object o){
		if(o.getClass().equals(this.getClass())){
			Key toCompare = (Key)o;
			if((toCompare.N == this.N && toCompare.M == this.M)  || (toCompare.N == this.M && toCompare.M == this.N)){
				return true;
			}
		}
		return false;
	}

}



public class Main {
	
	public static void main(String[] args) throws IOException{
		File inputFile = new File("input.txt");
		Scanner scan = new Scanner(inputFile);
		int loopCount = scan.nextInt();
		scan.nextLine();
		FileWriter outputFile = new FileWriter("output.txt");
		for(int i = 1; i <= loopCount; i++){
			Algorithm start = new Algorithm(scan.nextLine());
			start.solve();
			outputFile.write("Case #"+i+": " + start.getOutput());
			if(i < loopCount){
				outputFile.write("\r\n");
			}
		}
		outputFile.close();
	}
}
