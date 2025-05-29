import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class C {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new FileReader(args[0]));
		BufferedWriter bw= new BufferedWriter(new FileWriter(args[0]+".out"));
		String line= br.readLine();
		int cases= Integer.parseInt(line);
		for (int i= 0; i != cases; i++) {
			Scanner sc= new Scanner(br.readLine());
			bw.write("Case #"+(i+1)+": "+recycle(sc.nextInt(), sc.nextInt())+"\n");
		}
		br.close();
		bw.close();
	}
	
	public static int recycle(int a, int b) {
		int pairs= 0;
		for (int n= a; n != b; n++) {
			char[] num= (""+n).toCharArray();
			for (int i= 0; i != num.length-1; i++) {
				char[] rec= new char[num.length];
				rec[0]= num[num.length-1];	// put last digit at beginning
				for (int j= 0; j != num.length-1; j++) rec[j+1]= num[j];
				num= rec;
				int m= Integer.parseInt(new String(num));
				if (m > n && m <= b) {
					pairs++;
					//System.out.println(q+" "+n);
				}
			}
		}
		return pairs;
	}

}
