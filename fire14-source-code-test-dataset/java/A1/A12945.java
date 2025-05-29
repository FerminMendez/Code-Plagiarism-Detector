/**
 * Copyright Carma Systems, Inc. All rights reserved.
 */
package com.jessehutton.codejam.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Jesse Hutton <jesse.hutton@carmasys.com>
 */
public abstract class IOHandler {

  protected BufferedReader reader;
  protected PrintStream writer;

  public IOHandler(String inputFile) throws FileNotFoundException {
    this(new String[] {inputFile});
  }

  public IOHandler(String[] args) throws FileNotFoundException {
    reader = new BufferedReader(new FileReader(args[0]));
    if (args.length > 1 && args[1] != null) {
      writer = new PrintStream(new FileOutputStream(args[1]));
    } else {
      writer = System.out;
    }
  }

  public abstract String formatCase(int caseNum, Object result);

  public String line() throws IOException {
    return reader.readLine();
  }

  public void recordCase(int caseNum, Object result) {
    writer.println(formatCase(caseNum, result));
  }

  public void finish() {
    try {
      reader.close();
    } catch (IOException e) {
      System.err.println("closing reader failed.");
      e.printStackTrace();
    }

    writer.close();
  }
}
