/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jim
 */
public class FileLoader {
    
    public FileLoader() {
        
    }
    
    public ArrayList<String> loadFile(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String in;
        ArrayList<String> lines = new ArrayList<String>();
        while ((in = br.readLine()) != null) {
            lines.add(in);
        }
        return lines;
    }
    
}
