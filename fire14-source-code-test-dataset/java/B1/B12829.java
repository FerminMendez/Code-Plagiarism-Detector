package com.cj.utils;

import java.io.*;

public class OutputWriter {
    File file;
    BufferedWriter bw;
    public OutputWriter(String fileName){
        try{
            file = new File(fileName);
            bw = new BufferedWriter(new FileWriter(file));
        }catch(Exception ex){ex.printStackTrace();}
    }
    public void writeLine(String line){
        try{
            bw.write(line);
            bw.newLine();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void closeFile(){
        try{
            bw.close();
        }catch(Exception ex){ex.printStackTrace();}
    }
    public static void main(String args[]){
        OutputWriter ow = new OutputWriter("output.txt");
        ow.writeLine("arijit pal1");
        ow.writeLine("arijit pal");
        ow.closeFile();
    }
}
