package qualification.common;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: ofer
 * Date: 14/04/12
 * Time: 17:31
 * To change this template use File | Settings | File Templates.
 */
public class OutputWriter {
    
    public static void writeOutput(String filename,String[] output){
        try {
            FileWriter write = new FileWriter( filename , false);
            PrintWriter print_line = new PrintWriter( write );
            for (String str: output){
                print_line.println(str);
            }
            print_line.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
