package com.google.recyclednumbers;

import java.util.Scanner;

import com.google.util.FileUtil;

public class RecycledNumbers {

	public static void main(String[] args) {
		String orgFilePath = "E:\\Google_Jam\\RecycledNumbers\\C-small-attempt0.in";
		Scanner scanner = FileUtil.openFile(orgFilePath);
		StringBuilder sb = new StringBuilder();
		int caseNum = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < caseNum; i++) {
			sb.append("Case #" + (i + 1) + ": ");
			int n = 0;
			 int a = scanner.nextInt();
			 int b = scanner.nextInt();
			/*int a = 1111;
			int b = 2222;*/
			if (b <= 20) {
				n = 0;
				sb.append(n);
				sb.append("\n");
				continue;
			} else {
				for (int k = a; k <= b; k++) {
					String left = String.valueOf(k);
					int length = left.length();// 左边数的位数
					int temp = 0;// 用于记录能转换出来的数的个数
					int[] tempCase = new int[20];
					for (int j = 0; j < length; j++) {
						String sub1 = left.substring(0, j + 1);
						String sub2 = left.substring(j + 1, length);
						String newNum = sub2 + sub1;
						int right = Integer.valueOf(newNum);			
						if (right <= b && k < right) {
							if (temp == 0) {
								n++;
								tempCase[temp] = right;
								temp++;
							} else {
								int p;
								for (p = 0; p < temp && tempCase[p] != right; p++);
								if (p == temp) {
									tempCase[temp] = right;
									temp++;
									n++;
								}
							}
							//System.out.println(k + "&&" + right);
							//sb.append(k + "&&" + right);
							//sb.append("\n");
						}
					}
				}
			}
			sb.append(n);
			sb.append("\n");
		}
		FileUtil.writeFile(sb, "RecycledNumbers\\small.in");
	}
}
