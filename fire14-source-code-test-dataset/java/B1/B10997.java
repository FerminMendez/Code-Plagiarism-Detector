import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class gcj_c {
	public static void main(String[] args) {
	try{
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		String T = buff.readLine();
		for(int p=0;p<Integer.parseInt(T);p++){
			String AB = buff.readLine();
			String arr[] = AB.split(" ");
			String A = arr[0];
			String B = arr[1];
			int A_int = Integer.parseInt(A);
			int B_int = Integer.parseInt(B);
			int count = 0;
			for(int a = A_int;a<=B_int;a++){
				String a_str = String.valueOf(a);
				String a_con = a_str.concat(a_str);
				for(int b =a+1;b<=B_int;b++){
					String b_str = String.valueOf(b);
					CharSequence chr = b_str.subSequence(0, b_str.length());
					if(a_con.contains(chr)){
						//System.out.println("a_con: " + a_con + "b_str:" + b_str);
						count++;
					}
				}
			}
		System.out.println("Case #" + (p+1) + ": " + count);	
		}
	}catch(Exception e){System.out.println(e);}
	}
}
