package com.google.codejam.utils.files;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class ManejoArchivos {
    private static String path = "D:\\Proyectos\\Google\\files\\2012\\";
    
    public static int[][] readFile(String name) throws FileNotFoundException, 
                                                        IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path + name)));
        
        int arr[][] = new int[Integer.parseInt(br.readLine())][2];
        for(int i=0;i<arr.length;i++) {
            String str[] = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }
        
        return arr;
    }
    
    public static void writeFile(String name, StringBuffer sb) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream(path + name));
        out.print(sb.toString());
        out.flush();
        out.close();
    }
    
    
    public static int LOG = 0;
    private static BufferedReader in = null;
    public static void initInput(String name) throws FileNotFoundException {
        in = new BufferedReader(new InputStreamReader(new FileInputStream(path + name + ".in")));
    }
    public static void closeInput() throws IOException {
        in.close();
    }
    
    private static void logRead(String str) {
        if( LOG == 1 ) {
            System.out.println(str);
        }
    }
    public static String getString() throws IOException {
        String str = in.readLine();
        logRead(str);
        
        return str;
    }    
    public static String[] getStrings() throws IOException {
        String str = in.readLine();
        logRead(str);
        
        return str.split(" ");
    }
    public static int getInt() throws IOException {
        String str = in.readLine();
        logRead(str);
        
        return Integer.parseInt(str);
    }
    public static int[] getInts() throws IOException {
        String str = in.readLine();
        logRead(str);
        
        String arr[] = str.split(" ");
        int ints[] = new int[arr.length];
        for(int i=0;i<arr.length;i++) {
            ints[i] = Integer.parseInt(arr[i]);
        }
        return ints;
    }
    public static long[] getLongs() throws IOException {
        String str = in.readLine();
        logRead(str);
        
        String arr[] = str.split(" ");
        long longs[] = new long[arr.length];
        for(int i=0;i<arr.length;i++) {
            longs[i] = Long.parseLong(arr[i]);
        }
        return longs;
    }
    
    public static int TIPO_WRITE = 0;
    private static PrintWriter out = null;
    private static String strName = null;
    public static void initOutput(String name) throws FileNotFoundException {
        initOutput(name, false);
    }
    public static void initOutput(String name, boolean append) throws FileNotFoundException {
        strName = name;
        out = new PrintWriter(new FileOutputStream(path + name + ".out", append));
    }
    public static void closeOutput() {
        try {
            out.flush();
            out.close();
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }

    private static void openWrite() throws FileNotFoundException {
        if( TIPO_WRITE == 1 ) {
            initOutput(strName, true);
        }
    }
    private static void closeWrite() {
        if( TIPO_WRITE == 1 ) {
            closeOutput();
        }
    }
    public static void writeCase(int i, String str) throws FileNotFoundException {
        openWrite();
        
        out.print("Case #");
        out.print(i);
        out.print(": ");
        out.print(str);
        out.print("\n");
        
        closeWrite();
    }
}
