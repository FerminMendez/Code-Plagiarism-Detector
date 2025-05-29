package tw.csc.gcj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

	/**
	 * @param args
	 */
	
	public static String str1 = "abcdefghijklmnopqrstuvwxyz";
	public static String str2 = "ynficwlbkuomxsevzpdrjgthaq";
	public static void main(String[] args) {
		
		try {
			goB();
		} catch (Exception e) {

		}
	}

	public static void goB() throws NumberFormatException, IOException{
		File fin = new File("B-small-attempt0.in");
		File fout = new File("B-small-attempt0.out");		
		BufferedReader br = new BufferedReader(new FileReader(fin));
		FileOutputStream fos = new FileOutputStream(fout);
		int c = Integer.parseInt(br.readLine());
		String op = "";
		for (int i = 0 ; i < c ;i ++ ){
			op+="Case #"+ (i+1)+": ";
			String[] strin = br.readLine().split("[ ]");
			int n = Integer.parseInt(strin[0]);
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for (int k = 3 ; k< n+3 ; k++){
				arr.add(Integer.parseInt(strin[k]));
			}
			op += testB(n, Integer.parseInt(strin[1]), Integer.parseInt(strin[2]), arr) + "\n";
			
		}
		fos.write(op.getBytes());
		fos.close();
	}
	
	public static String testB(int n , int s, int p, ArrayList<Integer> arrt ){
		if (p == 0)
			return "" + n;
		if (p == 1){
			int c = 0;
			for (Integer t : arrt){
				if (t > 0)
					c++;
			}
			return ""+c;
		}
		int c = 0;
		int cs = 0;
		for (Integer t : arrt){
			if (t >= p*3-2)
				c++;
			else if (t >= p*3-4) 
				cs++;
		}
		if (cs >= s)
			c += s;
		else
			c += cs;
		return "" +c;
	}
	
	public static void goC() throws NumberFormatException, IOException {
		File fin = new File("C-large.in");
		File fout = new File("C-large.out");		
		BufferedReader br = new BufferedReader(new FileReader(fin));
		FileOutputStream fos = new FileOutputStream(fout);
		int c = Integer.parseInt(br.readLine());
		String op = "";
		for (int i = 0 ; i < c ;i ++ ){
			op+="Case #"+ (i+1)+": ";
			String[] strin = br.readLine().split("[ ]");
			op += test(Integer.parseInt(strin[0]), Integer.parseInt(strin[1])) + "\n";
			
		}
		fos.write(op.getBytes());
		fos.close();
	} 
	
	public static String test(int a , int b){
		String ret = "";
		HashSet<String> set = new HashSet<String>(); 
		for (int n = a ; n <=b ; n++){
			String strn = String.valueOf(n);
			for (int i = 1 ; i < strn.length() ; i ++){
				String strtest = strn.substring(strn.length() - i, strn.length() ) + strn.substring(0 , strn.length() -i);
				int m = Integer.parseInt(strtest);
				if (m > n && m <= b){
					set.add(strn+String.valueOf(m));
				}
			}
			
		}
		
		return ret + set.size();
	}
	
	public static void goA() throws NumberFormatException, IOException {
		HashMap map = new HashMap();
		
		for (int i = 0 ; i < str1.length() ; i ++){
			map.put(str2.charAt(i), str1.charAt(i));
		}
		File fin = new File("A-small-attempt1.in");
		File fout = new File("A-small-attempt1.out");		
		BufferedReader br = new BufferedReader(new FileReader(fin));
		FileOutputStream fos = new FileOutputStream(fout);
		int c = Integer.parseInt(br.readLine());
		String op = "";
		for (int i = 0 ; i < c ;i ++ ){
			op+="Case #"+ (i+1)+": ";
			String strin = br.readLine();
			String strout = "";
			for (int k = 0 ;k < strin.length() ;k ++){
				if (strin.charAt(k) == ' '){
					strout+=" ";
				}
				else{
					strout+= map.get(strin.charAt(k));
				}
			}
			op+=strout+"\n";
		}
		
		
		fos.write(op.getBytes());
		fos.close();
	};
}
