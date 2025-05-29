/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.util.ArrayList;

/**
 *
 * @author dannocz
 */
public class Input {
    
    private int noTestCases;
    private ArrayList<TestCase> testCases;
   //private ArrayList<String> resultCases;

    public int getNoTestCases() {
        return noTestCases;
    }

    public void setNoTestCases(int noTestCases) {
        this.noTestCases = noTestCases;
    }

    public Input(int noTestCases, ArrayList<String> cases) {
        this.noTestCases = noTestCases;
        this.testCases= new ArrayList<TestCase>();
        for (String case1 : cases) {
            testCases.add(new TestCase(case1));
        }
        
       // this.resultCases= new ArrayList<>();
    }

//    public ArrayList<String> getResultCases() {
//        return resultCases;
//    }
//
//    public void setResultCases(ArrayList<String> resultCases) {
//        this.resultCases = resultCases;
//    }
//    
//    public void addResultCase(String result) {
//        this.resultCases.add(result);
//    }

    
    public void printResultCases(){
        for (int i = 0; i < testCases.size(); i++) {
            String result=testCases.get(i).result()+"";
            FileManagerGUI.log.append("Case #"+(i+1)+": "+result+"\n");
            System.out.println("Case #"+(i+1)+": "+result);
        }
    }
    
    
}
