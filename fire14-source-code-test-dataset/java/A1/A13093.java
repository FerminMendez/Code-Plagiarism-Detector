package com.ozan.jam;

import com.google.common.base.Preconditions;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class JamBase {
    private final File inputFile;
    private final File outputFile;

    protected JamBase(String contestName, String problemName, String inputSize) throws IOException {
        inputFile = new ClassPathResource(
                "com/ozan/jam/" + contestName + "/" + problemName + "-" + inputSize + "" +".in")
                .getFile();
        outputFile = new File(inputFile.getParentFile(), problemName + "-" + inputSize + "" + ".out");
        if (outputFile.exists()) {
            outputFile.delete();
        }
        Preconditions.checkState(outputFile.createNewFile(), "Failed to create output file at " + outputFile
                .getAbsolutePath());
    }

    public void run() throws IOException {
        Scanner in = new Scanner(inputFile);
        FileWriter writer = new FileWriter(outputFile);

        int tcCount = in.nextInt();
        in.nextLine();
        for (int tc = 0; tc < tcCount; tc++) {
            String line = "Case #" + (tc + 1) + ": " + handleTestCase(in) + "\n";
            writer.write(line);
            System.out.print(line);
        }
        writer.close();
    }

    protected abstract String handleTestCase(Scanner in);
}
