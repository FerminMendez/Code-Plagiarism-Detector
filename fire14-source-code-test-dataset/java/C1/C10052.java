/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.common;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author jim
 */
public class Output {
    
    private final String[] data;

    public Output(String[] data) {
        this.data = data;
    }
    
    public Output(ArrayList<String> data) {
        this(data.toArray(new String[0]));
    }
    
    public int size() {
        return data.length;
    }
    
    public String get(int i) {
        StringBuilder sb = new StringBuilder(data[i].length() + 10);
        sb.append("Case #");
        sb.append(i + 1);
        sb.append(": ");
        sb.append(data[i]);
        return sb.toString();
    }
    
    public void export(String fileName) {
        if (fileName == null) 
           print(); 
        else {
            try {
                save(fileName);
            }
            catch (IOException ioe) {
                System.out.println(ioe.getMessage());
                ioe.printStackTrace();
            }
        }
    }
    
    private void print() {
        for (int i = 0; i < size(); i++)
            System.out.println(get(i));
    }
    
    private void save(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < size(); i++) {
            pw.println(get(i));
        }
        pw.flush();
        pw.close();
        fw.close();
    }
    
}
