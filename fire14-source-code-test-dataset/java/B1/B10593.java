package recyclednumbers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Masilo
 */
public class RecycledNumbers {

    public static void main(String[] args) {
        Scanner inputStream = null;
        PrintWriter outputStream = null;
      
        try{
            inputStream = new Scanner(new FileInputStream("input.txt"));
            outputStream = new PrintWriter(new FileOutputStream("output.txt"));
            
            int t = Integer.parseInt(inputStream.nextLine());
            String outputLine = "";
            String[] inputNumbers = null;
            int numberOfRecycledPair =0;
            int number =0, length =0;
            
            
            for (int i = 1; i<=t;i++){
                inputNumbers = inputStream.nextLine().split(" ");
                numberOfRecycledPair = 0;
                outputLine = "Case #"+i+": ";
                ArrayList<String> pairs = new ArrayList<String>();
                
                length = inputNumbers[0].length();
                if (length >1){
                    for (int n = Integer.parseInt(inputNumbers[0]);n<Integer.parseInt(inputNumbers[1]);n++){
                        for (int j = 1;j<length;j++){
                            number = Integer.parseInt(Integer.toString(n).substring(length-j)+Integer.toString(n).substring(0,length-j));
                            if (number>n && number<=Integer.parseInt(inputNumbers[1]))
                                if (!(pairs.contains(n+":"+number))){
                                    numberOfRecycledPair++;
                                    pairs.add(n+":"+number);
                                }
                        }
                    }
                }
                outputLine += ""+numberOfRecycledPair;
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
