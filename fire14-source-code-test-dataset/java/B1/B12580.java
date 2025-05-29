package com.google.codejam.abs;

import com.google.codejam.practice2010.round1A.Rotate;
import com.google.codejam.utils.files.ManejoArchivos;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Date;

public abstract class Problem {
    public Problem(String name) throws FileNotFoundException, IOException {
        System.out.println(new Date() + " " + name);
        
        ManejoArchivos.initInput(name);
        ManejoArchivos.initOutput(name);
        
        int cases = ManejoArchivos.getInt();
        System.out.println(new Date() + " Se procede a evaluar " + cases + " cases");
        for(int caso=0;caso<cases;caso++) {
            System.out.println(new Date() + " Eval Case: " + caso);
            String str = execCase();
            ManejoArchivos.writeCase(caso+1, str);
        }

        ManejoArchivos.closeInput();
        ManejoArchivos.closeOutput();
        
        System.out.println(new Date() + " " + name);
    }
    
    public abstract String execCase() throws IOException ;
}
