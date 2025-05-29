package org.ryan.jam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * user: ryan.moore
 * date: 4/14/12
 */
public class CodeJamQualifications {

    public static void main(String [] args) throws Exception {

        //get input
        String in = CodeJamUtil.readFileAsString("/Users/ryanmoore/dev/misc/GCJ1B/src/in.txt");

        List<String> lineList = CodeJamUtil.parseInputToList(in);

        //call util method that will do the work
        List<Integer> resultingPairsList = CodeJamUtil.getDistinctRecycledPairs(lineList);

        //write to file
        try {

            FileWriter fstream = new FileWriter("out.txt");
            BufferedWriter out = new BufferedWriter(fstream);

            for (int i = 0; i < resultingPairsList.size(); i ++) {

                out.write("Case #" + (i + 1) + ": " + resultingPairsList.get(i) + "\n");
            }

            out.close();

        } catch (IOException e) {

            System.out.println(":'(");
        }

    }


}
