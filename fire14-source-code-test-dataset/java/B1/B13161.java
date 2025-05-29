package org.weiwei.recyclenumber;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * User: ding
 * Date: 12-4-14
 * Time: 下午1:57
 * To change this template use File | Settings | File Templates.
 */
public class FileProcessor {
    public static void testOutput(String input, String output) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        PrintWriter pw = new PrintWriter(output);
        String line = reader.readLine();
        int total = Integer.parseInt(line.trim());
        line = reader.readLine();
        int i = 1;
        while(line != null) {
            String[] elems = line.trim().split(" ");
            RecyleBin bin = new RecyleBin(Integer.parseInt(elems[0]), Integer.parseInt(elems[1]));
            pw.write("Case #"+i+": "+bin.exhaust());
            pw.write("\r\n");
            line = reader.readLine();
            i++;
        }
        reader.close();
        pw.close();
    }

        public static void main(String[] args) throws IOException {
        testOutput("F:\\input.txt", "F:\\output.txt");
    }
}
