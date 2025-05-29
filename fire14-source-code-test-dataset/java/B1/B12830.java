package com.cj.utils;

import java.io.*;
import java.util.*;

public class InputReader {
    //public ArrayList<String> inputs;
    public int cases;
    public Scanner scanner;
    public InputReader(){
        //inputs = new ArrayList<String>();
        cases = 0;
    }
    public Scanner loadInput(String fileName){
        try{
            File file = new File(fileName);
            scanner = new Scanner(file);
            cases = scanner.nextInt();
            //for(int count = 0; count < cases ; count++){}
            return scanner;
        }
        catch(Exception ex){ex.printStackTrace(); return null;}

    }
    
    public static void main(String[] args){
    	InputReader ir = new InputReader();
        Scanner input = ir.loadInput("test.txt");
        int cases = ir.cases;
        System.out.println(cases);
        System.out.println(input.nextInt()+"mm"+input.nextInt());
    }

}