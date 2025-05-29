package net.jbirch.gcj12qual.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 *
 * @author Birch
 */
public class FileLoader {

    protected String filename;
    protected InputStream stream;
    protected Scanner scanner;

    public FileLoader(String filename) {
        this.filename = filename;
    }

    public InputStream getStream() throws FileNotFoundException {
        if (stream == null) {
            stream = new FileInputStream(filename);
        }
        return stream;
    }

    public Scanner getScanner() throws FileNotFoundException {
        if (scanner == null) {
            scanner = new Scanner(this.getStream());
        }
        return scanner;
    }
}