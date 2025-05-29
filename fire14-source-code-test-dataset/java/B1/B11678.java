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
public class AbstractMain {
    public static void main(String[] args, AbstractProcessor p) {
        
        FileLoader fileLoader = new FileLoader();
        try {
            Input input = new Input(fileLoader.loadFile(args[0]), 1);
            Output output = p.process(input);
            output.export(args.length < 2 ? null : args[1]);
        }
        catch (IOException ioe) {
            System.out.println(ioe);
            ioe.printStackTrace();
        }
    }
}
