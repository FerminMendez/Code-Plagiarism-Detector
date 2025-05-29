package dancingwiththegooglers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Masilo
 */
public class DancingWithTheGooglers {

    public static void main(String[] args) {
        Scanner inputStream = null;
        PrintWriter outputStream = null;
      
        try{
            inputStream = new Scanner(new FileInputStream("input.txt"));
            outputStream = new PrintWriter(new FileOutputStream("output.txt"));
            
            int t = Integer.parseInt(inputStream.nextLine());
            String outputLine = "";
            String[] inputNumbers = null;
            int number = 0, mod = 0, p = 0;
            int numberOfBestResults = 0, NumberOfSurprisingResults = 0;
            
            for (int i = 1; i<=t;i++){
                inputNumbers = inputStream.nextLine().split(" ");
                NumberOfSurprisingResults = Integer.parseInt(inputNumbers[1]);
                numberOfBestResults = 0;
                outputLine = "Case #"+i+": ";
                
                for (int j = 3;j<inputNumbers.length;j++){
                    number = (int) Math.floor(Integer.parseInt(inputNumbers[j])/3);
                    mod = Integer.parseInt(inputNumbers[j]) % 3;
                    p = Integer.parseInt(inputNumbers[2]);
                    
                    if (number >= p){
                        numberOfBestResults++;
                        continue;
                    }
                    
                    if (mod==1 && number+1==p){
                        numberOfBestResults++;
                        continue;
                    }
                    else if(mod==2 && NumberOfSurprisingResults==0 && number+1==p){
                        numberOfBestResults++;
                        continue;
                    }
                    
                    if (NumberOfSurprisingResults > 0 && (number>=1 || mod >0)){
                        if (number+mod == p || number+1==p){
                            numberOfBestResults++;
                            NumberOfSurprisingResults--;
                            continue;
                        }
                    }
                   
                }
                
                outputLine += ""+numberOfBestResults;
                outputStream.println(outputLine);
            }
            
            outputStream.close();
            inputStream.close();
            
        }
        catch(Exception e){
            System.out.println("file input.txt was not found");
        }
    }
}
