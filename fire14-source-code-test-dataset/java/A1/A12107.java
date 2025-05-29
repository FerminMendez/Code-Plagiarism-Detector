/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Codejam2012;

import java.io.*;

/**
 *
 * @author Brian
 */
public class googlers {
        
    public static void main(String [] args) throws FileNotFoundException, IOException{

        String data;
        String printout="";
        String [] output;
        
        int numOfGooglers;
        int numOfSurprising;
        int leastScore;
        int [] scores;
        String [] splitData;
        
        String inputFileName = "C:/input/googlersIn.txt";
        String outputFileName = "C:/input/googlersOut.txt";
        
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        FileWriter out = new FileWriter(outputFileName);
        PrintWriter print = new PrintWriter(out);
        
        data = reader.readLine();
        int size = Integer.parseInt(data);
        output = new String[size];
        data = reader.readLine();
        int k =0;
        while(data!=null){
            
            splitData = data.split("\\s");
            numOfGooglers = Integer.parseInt(splitData[0]);
            numOfSurprising = Integer.parseInt(splitData[1]);
            leastScore = Integer.parseInt(splitData[2]);
            scores = new int[numOfGooglers];
            for(int b=3;b<splitData.length;b++){
                scores[b-3] = Integer.parseInt(splitData[b]);
            }
            int diff = leastScore-2;
            if(diff<0){
                diff = 0;
            }
            int total = 0;
            int greatCount =0; 
            int outSide = 0;
            int obvious = 0;
            int minScore = leastScore + (diff*2);
            int minScore_alt = leastScore + ((leastScore-1)*2);
            if(numOfSurprising==0){
                if(leastScore==1){
                    minScore = 1;
                }
                else{
                    if(leastScore==0){
                        minScore = 0;
                    }
                    else{
                    //minScore += 2;
                    minScore = leastScore + ((leastScore-1)*2);
                    }
                }
                for(int a=0;a<numOfGooglers;a++){
                    if(scores[a] >= minScore){
                        total ++;
                    }
                }
            }
            else{
                for(int a=0;a<numOfGooglers;a++){
                    if(scores[a]>=minScore){
                        greatCount++;
                    }
                    
                    if(scores[a]>=minScore_alt){
                        obvious++;
                    }
                } 
//                for(int a=0;a<numOfGooglers;a++){
//                    if(scores[a]>=2 && scores[a]<minScore){
//                        outSide++;
//                    }
//                }
                if(greatCount-obvious>=numOfSurprising){
                    total = obvious + numOfSurprising;
                }
                else{
                    total = greatCount;
                }
                
              }
            
            output[k++] = String.valueOf(total);                   
            
            data = reader.readLine();
        }
        
        for(int p=0; p<output.length;p++){           
            printout += "Case #"+(p+1)+": "+output[p]+"\n";  
        }
        print.println(printout);
        print.close();
        reader.close();
    }
}
