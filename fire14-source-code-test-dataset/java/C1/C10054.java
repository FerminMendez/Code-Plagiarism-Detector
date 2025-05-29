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
public class Input<T> {
    
    private final int count;
    private final ArrayList<T> data;

    public Input(DatumConverter<T> converter, ArrayList<String> lines) {
        count = Integer.parseInt(lines.remove(0));
        data = new ArrayList<T>(count);
        for (int i = 0; i < count; i++)
            data.add(converter.getNext(lines));
    }

    public int getCount() {
        return count;
    }

    public ArrayList<T> getData() {
        return data;
    }
    
}
