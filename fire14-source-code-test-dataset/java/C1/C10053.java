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
public abstract class AbstractProcessor<T> implements Processor<T> {
    
    public Output process(Input input) {
        int lines = input.getCount();
        ArrayList<T> data = input.getData();
        if (lines != data.size())
            throw new IllegalArgumentException("There are a different number "
                    + "of data lines to the number specified in the header");
        String[] out = new String[lines];
        for (int i = 0; i < lines; i++) {
            out[i] = processDatum(data.get(i));
        }
        return new Output(out);
    }
}
