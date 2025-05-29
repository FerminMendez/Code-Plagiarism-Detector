package com.renoux.gael.codejam.utils;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Output implements Closeable {

    private static String lineSeparator = System.getProperty("line.separator");

    private FileWriter writer;


    private Output(File file) {
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }

    public static Output open(File file) {
        System.out.println("======== " + file);
        return new Output(file);
    }

    public void writeLine(String text) {
        System.out.println(text);
        try {
            writer.write(text);
            writer.write(lineSeparator);
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }

    public void write(String text) {
        System.out.print(text);
        try {
            writer.write(text);
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }

    public void writeLine(Object... text) {
        try {
            for (Object s : text) {
                System.out.print(s);
                writer.write(s.toString());
            }
            System.out.println();
            writer.write(lineSeparator);
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }

    public void write(Object... text) {
        try {
            for (Object s : text) {
                System.out.print(s);
                writer.write(s.toString());
            }
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }

    public void close() {
        System.out.println("================ closed");
        try {
            writer.close();
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }

}
