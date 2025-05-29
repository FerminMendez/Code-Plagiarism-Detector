package se.round1.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class JamUtil {

	public static BufferedReader getReader(String path)
			{
		File file = new File(path);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader bf = new BufferedReader(new InputStreamReader(fis));

		return bf;
	}
	
	public static BufferedWriter getWriter(String path) {
		try {
			return new BufferedWriter(new FileWriter(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
