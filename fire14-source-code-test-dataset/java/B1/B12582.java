package com.google.codejam.practice2012.qualificationRound;

import com.google.codejam.abs.Problem;
import com.google.codejam.utils.files.ManejoArchivos;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class RecycledNumbers extends Problem {
    public RecycledNumbers(String name) throws FileNotFoundException, 
                                               IOException {
        super(name);
    }

    public static void main(String[] args) throws FileNotFoundException, 
                                                  IOException {
        //new RecycledNumbers("RecycledNumbers-Sample");
        new RecycledNumbers("RecycledNumbers-Small");
        //new RecycledNumbers("RecycledNumbers-Large");
    }

    public String execCase() throws IOException {
        int[] rango = ManejoArchivos.getInts();
        int numRecycled = 0;
        for(int number=rango[0];number<rango[1];number++) {
            String strNumber = String.valueOf(number);
            for(int i=0;i<strNumber.length()-1;i++) {
                strNumber = strNumber.substring(1) + strNumber.charAt(0);
                int newNumber = Integer.parseInt(strNumber);
                if( number < newNumber && newNumber <= rango[1] ) {
                    numRecycled++;
                    System.out.println(number + " " + newNumber);
                }
            }
        }

        return "" + numRecycled;
    }
}
