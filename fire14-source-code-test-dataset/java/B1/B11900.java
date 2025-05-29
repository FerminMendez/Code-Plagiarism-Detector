package gcj2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

public class RecycledNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\GAUTAM\\Downloads\\GCJ2012Inputs\\C-small-attempt0.in")));
		int noOfInput = Integer.parseInt(reader.readLine());
			
		StringBuilder finalOutput = new StringBuilder();
		for(int i=1;i<=noOfInput;i++) {
			String input = reader.readLine();
			String[] range = input.split(" ");
			finalOutput.append("Case #"+i + ": " + result(Integer.parseInt(range[0]),Integer.parseInt(range[1]))+"\n");
		}
		reader.close();
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:\\Users\\GAUTAM\\Downloads\\GCJ2012Outputs\\C-small.out")));
		writer.write(finalOutput.toString());
		writer.close();
	}
	
	public static int result(int A, int B) {
		HashSet<String> result = new HashSet<String>();
		for(int i = A; i <= B;i++) {
			LinkedList<String> digits = digits(i);
			for(int k =0 ; k < digits.size()-1; k++) {
				int m = rightshift(digits,k);
				if(m >= A && m <= B && digits.size() == digits(m).size() && m != i) {
					if(!result.contains(String.valueOf(i) + "-" + String.valueOf(m)) && 
							!result.contains(String.valueOf(m) + "-" + String.valueOf(i))) {
						result.add(String.valueOf(i) + "-" + String.valueOf(m));
					}
				}				
			}
		}
		return result.size();
	}
	
	public static LinkedList<String> digits(int num) {
		LinkedList<String> digits = new LinkedList<String>();
		 while (num > 0 ){
			 int r = num % 10;
			 digits.addFirst(String.valueOf(r));
	         num = num / 10;
	     }
		 return digits;
	}
	
	public static int getNum(LinkedList<String> digits) {
		StringBuilder builder = new StringBuilder();
		for(String a : digits) {
			builder.append(a);
		}
		return Integer.parseInt(builder.toString());
	}

	public static int rightshift(LinkedList<String> digits,int noOfDig) {
		LinkedList<String> newList = new LinkedList<String>();
		int k = 0;
		for(int i = digits.size()-noOfDig-1; i < digits.size();i++ ) {
			newList.add(k, digits.get(i));
			k++;
		}
		for(int i = 0; i < digits.size()-noOfDig-1;i++ ) {
			newList.add(k, digits.get(i));
			k++;
		}
		return getNum(newList);
	}
}
