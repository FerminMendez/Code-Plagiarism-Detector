package com.codegem.zaidansari;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CodeGemUtil {

    public static List<String> getInputValues(File file) {
        List<String> inputData = new ArrayList<String>();
        if (!file.exists()) { throw new RuntimeException("File not fould:" + file.getAbsolutePath()); }
        try {
            Scanner scanner = new Scanner(new FileReader(file));
            while (scanner.hasNextLine()) {
                inputData.add(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Failed to find file :" + file);
        }

        return inputData;
    }

    public static boolean createOutputFile(List<String> outputData, String fileName) {
        File folderName = new File("/Users/zaansari/Desktop/CodeGem2012/OutputFiles/");
        File outputFile = new File(folderName, fileName);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            int count = 0;
            for (String outputDatum : outputData) {
                writer.write("Case #" + (++count) + ": ");
                writer.write(outputDatum);
                writer.newLine();
            }
            writer.close();
            return true;
        } catch (IOException e) {
            System.out.println("Failed to write file :" + outputFile + ", Error Message:" + e.getMessage());
        }
        // Failed to wrirte file return false;
        return false;
    }

    public static void main(String[] args) {
        File file = new File("/Users/zaansari/Desktop/CodeGem2012/InputFiles/codeGem.in.txt");
        List<String> inputData = CodeGemUtil.getInputValues(file);
        for (String inputDatum : inputData) {
            System.out.println(inputDatum);
        }


        boolean createdOutputFile = CodeGemUtil.createOutputFile(inputData, "Q2Small.txt");
        if (createdOutputFile) {
            System.out.println("Successfully created output file");
        } else {
            System.out.println("Failed to create output file");
        }
    }
}
