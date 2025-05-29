package com.vp.common;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class InputOutputProcessor {
  
  private int numberOfCases;
  private boolean doesInputHaveDataSetLines;
  private int indexOfDataSetLine;
  private int numberOfDataSetLines;
  private final static String DELIMITER = " ";
  
  private Scanner scanInput;
  
  public void initializeInput(String strInputFileName) {
    readInput(strInputFileName);
    numberOfCases = Integer.parseInt(scanInput.nextLine());
  }
  
  /*
   * read input
   */
  private void readInput(String strInputFileName) {
    try {
      scanInput = new Scanner(new BufferedReader(new FileReader(
          strInputFileName)));
    }
    
    catch (Exception exp) {
      // exp.printStackTrace();
      System.out.println(" Please provide File Name with proper location ");
    }
  }
  
  public String[] getDataSet() throws Exception {
    String[] dataSet;
    String strDataSetLine = "";
    
    strDataSetLine = scanInput.nextLine();
    
   // System.out.println("strDataSetLine: " + strDataSetLine);
    
    if (doesInputHaveDataSetLines) {
      String[] DataSetLineArray = strDataSetLine.split(DELIMITER);
      numberOfDataSetLines = Integer
          .parseInt(DataSetLineArray[indexOfDataSetLine]);
    }
    
    dataSet = new String[numberOfDataSetLines];
    dataSet[0] = strDataSetLine;
    
    for (int i = 1; i < numberOfDataSetLines; i++) {
      dataSet[i] = scanInput.nextLine();
    }
    return dataSet;
  }
  
  /**
   * * @return Returns the numberOfDataSetLines.
   */
  public int getNumberOfDataSetLines() {
    return numberOfDataSetLines;
  }
  
  /**
   * @param numberOfDataSetLines
   *          The numberOfDataSetLines to set.
   */
  public void setNumberOfDataSetLines(int numberOfDataSetLines) {
    this.numberOfDataSetLines = numberOfDataSetLines;
  }
  
  /**
   * * @return Returns the numberOfCases.
   */
  public int getNumberOfCases() {
    return numberOfCases;
  }
  
  /**
   * * @return Returns the doesInputHaveDataSetLines.
   */
  public boolean isDoesInputHaveDataSetLines() {
    return doesInputHaveDataSetLines;
  }
  
  /**
   * @param doesInputHaveDataSetLines
   *          The doesInputHaveDataSetLines to set.
   */
  public void setDoesInputHaveDataSetLines(boolean doesInputHaveDataSetLines) {
    this.doesInputHaveDataSetLines = doesInputHaveDataSetLines;
  }
  
  /**
   * * @return Returns the indexOfDataSetLine.
   */
  public int getIndexOfDataSetLine() {
    return indexOfDataSetLine;
  }
  
  /**
   * @param indexOfDataSetLine
   *          The indexOfDataSetLine to set.
   */
  public void setIndexOfDataSetLine(int indexOfDataSetLine) {
    this.indexOfDataSetLine = indexOfDataSetLine;
  }
  
  public void closeScanner() {
    scanInput.close();
  }
  
  public void writeOutput(String outputFileName, String[] resultArray) {
    // To be moved out
    PrintStream out = null;
    try {
      out = new PrintStream(new FileOutputStream(outputFileName));
      for (int i = 0; i < resultArray.length; i++) {
        out.print(resultArray[i]);
        out.print("\n");
      }
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(0);
    }
    
  }
  
}
