/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.common;

import java.util.ArrayList;

/**
 *
 * @author jim
 */
public class Input {
    
    private final String[] header;
    private final String[] data;

    public Input(ArrayList<String> lines, int header) {
        int size = lines.size();
        this.header = new String[header];
        this.data = new String[size - header];
        for (int i = 0; i < size; i++) {
            String line = lines.get(i);
            if (i < header)
                this.header[i] = line;
            else
                this.data[i - header] = line;
        }
    }

    public String[] getHeader() {
        return header;
    }

    public String[] getData() {
        return data;
    }
    
}
