package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bohmd
 */
public abstract class BaseResolver {

    private final String file;
    private BufferedReader reader;
    private BufferedWriter writer;
    int lineNum = 0;
    int caseNum = 0;

    public BaseResolver(String file) {
        this.file = file;
    }

    public void resolve() throws Exception {
        reader = new BufferedReader(new FileReader(input()));
        writer = new BufferedWriter(new FileWriter(output()));
        while (reader.ready()) {
            executeLine(reader.readLine());
            lineNum++;
        }
        reader.close();
        writer.close();
    }

    private String input() {
        return file + ".in";
    }

    private String output() {
        return file + ".out";
    }

    protected abstract void executeLine(String line) throws Exception;

    protected void write(String result) throws Exception {
        writer.write("Case #" + (++caseNum) + ":" + result);
        writer.newLine();
    }

    public int getLineNum() {
        return lineNum;
    }
}
