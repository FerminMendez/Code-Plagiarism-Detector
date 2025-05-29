package tw.csc.gcj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
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
			goC();
		} catch (Exception e) {

		}
	}

	public static void goC() throws NumberFormatException, IOException {
		File fin = new File("C-small-attempt0.in");
		File fout = new File("C-small-attempt0.out");		
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
