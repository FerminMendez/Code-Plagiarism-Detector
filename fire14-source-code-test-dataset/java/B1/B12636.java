package com.google.codejam.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Recycled {
	public static void main(String[] args) {
		String line = null;
		BufferedReader reader = null;
		File file = new File("c:\\write.txt");
		BufferedWriter  output = null;
		try {
			output = new BufferedWriter(new FileWriter(file));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			reader = new BufferedReader(new FileReader("c:\\temp1.txt"));
			line = reader.readLine();
			int n = Integer.parseInt(line);
			for (int i=0;i<n;i++){
				line = reader.readLine();
				output.write("Case #"+(i+1)+": ");

				String[]arr = line.split(" ");
				int intarr[]= new int[arr.length];
				for (int j=0;j<intarr.length;j++){
					intarr[j]= Integer.parseInt(arr[j]);
				}
				int count =0;
				int n1 = intarr[0];
				int n2= intarr[1];
				Set<Pair > set = new HashSet<Pair>();
				for (int number=n1;number<=n2;number++){
					int digitarr[] = new int[8];
					int numberOfDigits = 0;
					int no = number;
					while (no >0 ){
						int d = no%10;
						no = no/10;
						digitarr[numberOfDigits]=d;
						numberOfDigits++;
					}
					if (numberOfDigits==1){
						continue;
					}
					for (int j=0;j<numberOfDigits/2;j++){
						int temp = digitarr[j];
						digitarr[j]= digitarr[numberOfDigits-j-1];
						digitarr[numberOfDigits-j-1]=temp;
					}
					
					for (int j=0;j<numberOfDigits;j++){
						int sum =0;
						if (digitarr[j]==0){
							continue;
						}
						for (int k=0;k<numberOfDigits;k++){
							int pos = (j+k)%numberOfDigits;
							int d = digitarr[pos];
							sum=(int) (sum+ (Math.pow(10, (numberOfDigits-k-1))*d ));
							if (sum>n2){
								break;
							}
						}
						if (sum<=n2 && sum> number){
							if (set.contains(new Pair(sum,number))){
//								System.out.println(number +" "+ sum);
								continue;
							}
							
							set.add(new Pair(sum,number));
							count++;
						}
					}
				}
				output.write(count+"");
				
				if (i!=n-1)
				output.write("\n");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				reader.close();
				output.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}
}
class Pair{
	int a;
	int b;
	public Pair(int sum, int number) {
		a = sum;
		b = number;
	}
	@Override
	public boolean equals(Object obj) {
		Pair p = (Pair)obj;
		if (p.a==a && p.b==b){
			return true;
		}
		if (p.b==a && p.a==b)
			return true;
		return false;
	}
	@Override
	public int hashCode() {
		return ((a+b)%13);
	}
}
