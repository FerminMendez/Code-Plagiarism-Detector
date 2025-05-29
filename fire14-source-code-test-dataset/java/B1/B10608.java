package io;

import java.io.File;
import java.util.Scanner;

public class Reader {
	public static String[] getInput(File f){
		try {
			Scanner reader = new Scanner(f);
			int numLines = Integer.parseInt(reader.nextLine());
			String[] res = new String[numLines];
			for (int i = 0; i < res.length; i++)res[i] = reader.nextLine();
			return res;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
