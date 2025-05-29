package cj;

import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileWriter;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {
    
    public static int[] toInts(String str, String sep) {
	String[] strs = str.split(sep);
	int[] ret = new int[strs.length];
	for (int i=0; i<ret.length; i++) {
	    ret[i] = new Integer(strs[i]);
	}
	return ret;
    }

    public static void writeLines(String[] lines, String file) {
	try {
	    FileWriter fw = new FileWriter(file);
	    PrintWriter pw = new PrintWriter(fw);
	    for (int i=0; i<lines.length; i++) {
		pw.println(lines[i]);
	    }
	    fw.close();
	    pw.close();
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	}
    }
    
    public static String[] readLines(String file) {
	List<String> lines = new ArrayList<String>();
	try {
	    FileReader fr = new FileReader(file);
	    BufferedReader textReader = new BufferedReader(fr);
	    String line = null;
	    while ((line = textReader.readLine()) != null) {
		lines.add(line);
	    }
	    fr.close();
	    textReader.close();
	} catch (IOException ioe) {
	    ioe.printStackTrace();
	}
	return lines.toArray(new String[0]);
    }
    
    public static int[] sort(int[] a) {
	boolean swapped = true;
	while (swapped) {
	    swapped = false;
	    for (int i=0; i<a.length-1; i++) {
		if (a[i]>a[i+1]) {
		    int temp = a[i];
		    a[i] = a[i+1];
		    a[i+1] = temp;
		    swapped = true;
		}
	    }
	}
	return a;
    }

    public static int[] reverse(int[] a) {
	int[] ret = new int[a.length];
	for (int i=0; i<ret.length; i++) {
	    ret[i] = a[a.length - i - 1];
	}
	return ret;
    }
}