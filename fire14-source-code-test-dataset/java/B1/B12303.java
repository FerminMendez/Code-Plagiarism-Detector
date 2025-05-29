package com.mohit.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class RecycledNumbers {

	public static void main(String[] args) {
		try {
			int noOfTests = 0;
			FileInputStream fis = new FileInputStream("C-small-attempt2.txt");
			DataInputStream din = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(din));

			FileWriter fstream = new FileWriter("output.txt");
			BufferedWriter out = new BufferedWriter(fstream);

			String strLine;
			strLine = br.readLine();
			if (strLine == null || strLine == "")
				return;

			strLine = strLine.trim();
			noOfTests = Integer.parseInt(strLine);

			int testNumber = 1;
			while (noOfTests > 0) {
				strLine = br.readLine();
				if (strLine == null || strLine == "" || strLine == "\n")
					break;
				strLine = strLine.trim().toLowerCase();
				String[] nums = strLine.split(" ");
				int A = Integer.parseInt(nums[0].trim());
				int B = Integer.parseInt(nums[1].trim());
				int firstCharB = Integer.parseInt(String.valueOf(B).charAt(0) +"");
				int recycledNum = 0;
				for (int i = A; i <= B; i++) {

					String n = String.valueOf(i);
					if (Integer.parseInt(n.substring(n.length() - 1)) > firstCharB) {
						int check = i;
						while(check>0)
						{
							int nexti = check % 10;
							if(nexti < firstCharB)
								break;
							else
								check = check/10;
						}
						if(check == 0)
						{
							i = i + (10 - i%10);
							continue;
						}
					}
					{
						int condition = 0;
						if (n.length() % 2 == 0
								&& n.substring(0, n.length() / 2).equals(
										n.substring(n.length() / 2))) {
							condition = n.length() / 2;
						} else {
							condition = n.length();
						}
							for (int j = 1; j < condition; j++) {
								String m = n.substring(j) + n.substring(0, j);
								int mi = Integer.parseInt(m);
								if (mi <= i || mi > B)
									continue;
								recycledNum++;
							}
						}
				}
				 out.write("Case #" + testNumber + ": " + recycledNum + "\n");
				 testNumber ++;
			}
			br.close();
			out.close();
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}

}
