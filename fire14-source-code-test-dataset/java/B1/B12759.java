package com.google.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {

	public static Scanner openFile(String path) {
		File file = new File(path);
		Scanner scanner;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return scanner;
	}

	public static boolean writeFile(StringBuilder sb, String filetype) {
		File resultFile = new File("E:\\Google_Jam\\" + filetype);
		try {
			resultFile.createNewFile();
			FileOutputStream os = new FileOutputStream(resultFile);
			os.write(sb.toString().getBytes());
			os.flush();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
