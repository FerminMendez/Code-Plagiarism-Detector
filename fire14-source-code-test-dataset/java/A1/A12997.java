package qualification.common;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: ofer
 * Date: 14/04/12
 * Time: 17:21
 * To change this template use File | Settings | File Templates.
 */
public class InputReader {
    
    public static String[] getInputLines(String filename){
        String[] input = null;
        File file = new File(filename);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            int size = Integer.parseInt(line);
            input = new String[size  + 1];
            input[0] = line;
            for (int i=0 ; i <size ; i++){
                line = br.readLine();
                input[i+1] = line;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        return input;
    }
}
