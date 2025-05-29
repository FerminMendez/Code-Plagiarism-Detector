package recyclednumbers.util;

import java.util.ArrayList;
import java.util.List;
import recyclednumbers.recycler.Recycler;

public class Main {

    public static void main(String[] args) {

        String inputFile = "small-data-input";
        String outputFile = "small-data-output";

        Recycler recycler = new Recycler();

        List<String> inputLines = IOUtil.readLines(inputFile);
        inputLines.remove(0); //Burn first line

        List<String> outputLines = new ArrayList<String>();
        for (String line : inputLines) {
            int first = Integer.parseInt(line.split(" ")[0]);
            int second = Integer.parseInt(line.split(" ")[1]);
            outputLines.add(recycler.countPairs(first, second) + "");
        }

        IOUtil.writeLines(outputFile, outputLines);


    }
}
