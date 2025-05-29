package codeJam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * http://code.google.com/codejam/contest/1460488/dashboard#s=p1
 * @author Weiwei Cheng
 */
public class DancingWithTheGooglers {

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new FileReader("_input.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("_output.in"));
        
        br.readLine();
        
        String line = null;
        int count = 0;
        
        while((line=br.readLine())!=null){
           
            String[] input = line.split(" ");

            int numGooglers = Integer.parseInt(input[0]);
            int maxNumSuprises = Integer.parseInt(input[1]);
            int neededScore = Integer.parseInt(input[2]);
            
            int[] scores = new int[numGooglers]; 
            int ans = 0;
            int numSuprises = 0;
            
            for(int i=3; i<input.length; i++){
                scores[i-3] = Integer.parseInt(input[i]);
            }
            
            for(int score : scores){
                if(score % 3 == 0){
                    if(score != 0){
                        int highscoreWithSup = score / 3 + 1;
                        int highscoreNoSup = score / 3;
                        if(highscoreNoSup >= neededScore){
                            ans++;
                        }
                        else if(highscoreWithSup >= neededScore && numSuprises < maxNumSuprises){
                            ans++;
                            numSuprises++;
                        }
                    }
                    else{//score==0
                        if(0 >= neededScore){
                            ans++;
                        }
                    }
                }
                else if(score % 3 == 1){
                    int highscoreWithSup = score / 3 + 1;
                    int highscoreNoSup = highscoreWithSup;
                    if(highscoreNoSup >= neededScore){
                        ans++;
                    }
                }
                else{
                    int highscoreWithSup = score / 3 + 2;
                    int highscoreNoSup = score / 3 + 1;
                    if(highscoreNoSup >= neededScore){
                        ans++;
                    }
                    else if(highscoreWithSup >= neededScore && numSuprises < maxNumSuprises){
                        ans++;
                        numSuprises++;
                    }
                }
            }
                    
            bw.append("Case #" + ++count + ": " + ans);
            
            bw.newLine();
        }

        br.close();
        bw.close();
        
    }

}
