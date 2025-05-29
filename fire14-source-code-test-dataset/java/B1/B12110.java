package com.renoux.gael.codejam.utils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Input implements Closeable {

    BufferedReader reader;

    private Input(BufferedReader reader) {
        this.reader = reader;
    }

    public static Input open(File f) {
        final BufferedReader r;
        try {
            r = FileUtils.getReader(f);
        } catch (FileNotFoundException e) {
            throw new TechnicalException(e);
        }

        return new Input(r);
    }

    public void close() {
        try {
            reader.close();
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new TechnicalException(e);
        }
    }


}
