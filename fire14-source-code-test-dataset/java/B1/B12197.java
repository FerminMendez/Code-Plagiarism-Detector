package recyclednumbers;

import java.io.*;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Diego Villatora
 */
public class RecycledNumbers {
    static int  numberOfCases =0;
    static boolean first = true;
    static int currentInt = 0;
    static int firstNumber = 0;
    static int secondNumber = 0;
    static int[] founds = new int[]{};   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner s = null;
        BufferedWriter output = null;
        int counter = 0;
        
        // for the output and the writing on file
        // Create file 
        File file =null;
        FileWriter fstream = null;

        try {
            //input
            s = new Scanner(new BufferedReader(new FileReader("C:\\Users\\Utente\\Downloads\\C-small-attempt5.in")));
            //output
            file = new File("C:\\Users\\Utente\\Downloads\\google3.out");
            fstream = new FileWriter(file);
            output = new BufferedWriter(fstream);

            //while not EOF
            int i=0;
            while (s.hasNext()) {
                if(first){
                    numberOfCases = s.nextInt();
                    first=false; 
                }else{
                    currentInt = s.nextInt();
                    
                    //get int
                    counter++;
                    if(counter == 1){
                        firstNumber = currentInt;
                    }
                    else{
                        secondNumber = currentInt;
                        counter = 0;
                    }
                    if (counter == 0){
                        i++;
                        int maxNumberRecycled = getMaxRecycled(firstNumber,secondNumber);

                        output.write("Case #"+ i +": " + maxNumberRecycled);            
                        output.newLine();                        
                    }
                }
            }
     }catch (Exception e){//Catch exception if any
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error: " + e.toString());

        //to close the file if still open
        }finally {
            if (s != null) s.close();
            if (output != null) output.close();
        }
    }
        
    private static int getMaxRecycled(int firstNumber, int secondNumber){
        int total = 0;
        int partial = 0;
        int numberRotating = 0;
                
        while(firstNumber<secondNumber) {
            //lastRoundInt = firstNumber;
            numberRotating = shiftNumber(firstNumber);
            while (numberRotating != firstNumber){
                if(firstNumber < numberRotating && numberRotating <= secondNumber){
                    //partial = findEquals(numberRotating, firstNumber , secondNumber);
                    total = total + 1;                                       
                }
                if(firstNumber > numberRotating){
                    if((new Integer(numberRotating).toString().length()) < (new Integer(firstNumber).toString().length())){
                        numberRotating = numberRotating * 10;
                    }
                    else{
                        numberRotating = shiftNumber(numberRotating);                         
                    }
                }else{
                numberRotating = shiftNumber(numberRotating); 
                }
            }
            firstNumber++;            
        }      
        return total;
    }
    
    private static int findEquals(int toFind, int start, int end){
        int found = 0;
        
        /*for(int i = 0; i< founds.length; i++){
            if (toFind == founds[i]){
                return found;
            }
        }*/
        
        if(toFind <= end){
            /*int[] appo = new int[]{toFind};
            int[] C= new int[appo.length+founds.length];
            System.arraycopy(appo, 0, C, 0, appo.length);
            System.arraycopy(founds, 0, C, appo.length, founds.length);
            founds = C;*/
            found = 1;
        }
        return found;
    }
    private static int shiftNumber(int toShift){
        double toAdd = 0;
        double partial = 0;
        double restoInit = toShift;
        double numExp = 0;
        
        while(restoInit > 9){
            restoInit = Math.floor(restoInit / 10);
            numExp++;
        }
        
        toAdd = Math.floor(toShift / Math.pow(10.0, numExp));
        toShift = toShift * 10;        
        partial = toShift % Math.pow(10.0, numExp+1);
        partial = partial + toAdd;
        
        return new Double(partial).intValue();
    }
}
