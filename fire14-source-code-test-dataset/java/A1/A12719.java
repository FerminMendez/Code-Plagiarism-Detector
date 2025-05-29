package com.google.dancing;

import java.util.Scanner;

import com.google.util.FileUtil;

/*
 *
 *
 */
public class Dancing {

	public static void main(String[] args) {
		String orgFilePath = "E:\\Google_Jam\\Dancing\\B-small-attempt6.in";
		Scanner scanner = FileUtil.openFile(orgFilePath);
		StringBuilder sb = new StringBuilder();

		int caseNum = Integer.valueOf(scanner.nextLine());
		for (int i = 0; i < caseNum; i++) {
			sb.append("Case #" + (i + 1) + ": ");
			String line = scanner.nextLine();
			String[] numbers = line.split(" ");
			// String[] numbers = {"15"};
			int n = 0;// �ﵽ���ֵ�ĸ���
			int googlers = Integer.valueOf(numbers[0]);// ѡ�ָ���
			int suprising = Integer.valueOf(numbers[1]);// �÷ֲ����2
			int max = Integer.valueOf(numbers[2]);// ����ֵ
			/*
			 * int googlers = 1; int suprising =1; int max = 3;
			 */
			for (int j = 0; j < googlers; j++) {
				int temp = Integer.valueOf(numbers[j + 3]);// ��ǰѡ�������ܷ�
				// int temp = Integer.valueOf(numbers[0]);
				if (temp / 3 >= max) {
					n++;
				} else if ((max - (temp / 3) == 1)
						&& ((temp / 3) + (temp % 3)) >= max) {
					n++;
				} else if ((max - (temp / 3)) > 1
						&& ((temp / 3) + (temp % 3)) >= max && suprising > 0) {
					n++;
					suprising--;
				} else if (temp != 0 && max - temp / 3 == 1 && suprising > 0
						&& temp % 3 == 0) {
					n++;
					suprising--;
				}
			}
			sb.append(n);
			sb.append("\n");
		}
		FileUtil.writeFile(sb, "Dancing\\small1.in");
	}
}
