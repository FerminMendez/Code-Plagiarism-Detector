package ru.guredd.codejam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    protected static List<String> inputData = new ArrayList<String>();
    protected static List<String> outputData = new ArrayList<String>();

    public static void loadInputData(String fileName) throws IOException {
        BufferedReader in = null;
        try {
            inputData.clear();
            String line;
            in = new BufferedReader(new FileReader(fileName));

            if (!in.ready())
                throw new IOException();

            while ((line = in.readLine()) != null)
                inputData.add(line);
        } finally {
            if(in != null) {
                in.close();
            }
        }
    }

    public static void saveOutputData(String fileName) throws IOException {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(fileName));

            for (String anOutputData : outputData) {
                out.write(anOutputData);
                out.newLine();
            }
        } finally {
            if(out != null) {
                out.close();
            }
        }
    }

    public static void main (String [] argv) throws IOException {

        loadInputData(argv[0]);

        Qualification2012B QB = new Qualification2012B();
        QB.solve();

        saveOutputData(argv[1]);
    }
}
