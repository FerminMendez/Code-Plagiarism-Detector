package com.vp.common;

import com.vp.fact.SolutionFactory;
import com.vp.iface.Problem;

public class ExecutorApp {
  
  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String inputFileName = "C:/Workspace/GCJ2012/src/com/vp/data/sample_input.txt";
    String outputFileName = "C:/Users/dhananitin/Desktop/sample_output.txt";
    //String outputFileName = "C:/Workspace/GCJ2012/src/com/vp/data/sample_output.txt";
    
    InputOutputProcessor inputOutputProcessor = new InputOutputProcessor();
    inputOutputProcessor.initializeInput(inputFileName);
    int numberOfCases = inputOutputProcessor.getNumberOfCases();
    
    String[] resultArray = new String[numberOfCases];
    inputOutputProcessor.setDoesInputHaveDataSetLines(false);
    //inputOutputProcessor.setIndexOfDataSetLine(0);
    inputOutputProcessor.setNumberOfDataSetLines(1);
    
    for (int i = 1; i <= numberOfCases; i++) {
      
      try {
        String[] dataSet = inputOutputProcessor.getDataSet();
        Problem problem = SolutionFactory.getInstance(Problem.DANCINGWITHGOOGLERS);
        resultArray[i-1] = "Case #"+i+": "+ problem.solve(dataSet);
      }
      
      catch (Exception exp) {
        exp.printStackTrace();
        inputOutputProcessor.closeScanner();
      }
      
    }
    
    inputOutputProcessor.closeScanner();
    inputOutputProcessor.writeOutput(outputFileName, resultArray);
  }
  
}




