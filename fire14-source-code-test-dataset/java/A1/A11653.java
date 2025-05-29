/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.common;

/**
 *
 * @author jim
 */
public abstract class AbstractProcessor implements Processor {
    
    public Output process(Input input) {
        int lines = Integer.parseInt(input.getHeader()[0]);
        String[] data = input.getData();
        if (lines != data.length)
            throw new IllegalArgumentException("There are a different number "
                    + "of data lines to the number specified in the header");
        String[] out = new String[lines];
        for (int i = 0; i < lines; i++) {
            out[i] = processLine(data[i]);
        }
        return new Output(out);
    }
}
