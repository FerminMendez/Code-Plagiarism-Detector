/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.co.epii.codejam.common;

import java.io.IOException;

/**
 *
 * @author jim
 */
public class AbstractMain<T> {
    
    private final DatumConverter<T> dc;
    private final AbstractProcessor p;

    public AbstractMain(DatumConverter<T> dc, 
            AbstractProcessor p) {
        this.dc = dc;
        this.p = p;
    }
    
    public void main(String[] args) {
        
        FileLoader fileLoader = new FileLoader();
        try {
            Input<T> input = new Input<T>(dc, fileLoader.loadFile(args[0]));
            Output output = p.process(input);
            output.export(args.length < 2 ? null : args[1]);
        }
        catch (IOException ioe) {
            System.out.println(ioe);
            ioe.printStackTrace();
        }
    }
}
