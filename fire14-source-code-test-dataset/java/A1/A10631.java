import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;


public class Test{
   public static void main(String[] args)
        throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream   = null;
        
        
        try {
            inputStream = 
                new BufferedReader(new FileReader("test.in"));
            outputStream = 
                new PrintWriter(new FileWriter("test.out"));

            String l;
            l = inputStream.readLine();
            int t = Integer.parseInt(l);
            int i = 1;
            while ((l = inputStream.readLine()) != null) {
                String result = "Case #"+(i++)+": "+getNum(l);
                outputStream.println(result);
                //System.out.println(result);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
    
    
    public static int getNum(String l){
        int number;
        int surpriseNumber;
        int maxScore;
        int[]totalPoints = new int[100];
        
        String[] strArray = l.split(" ");
        
        number = Integer.parseInt(strArray[0]);
        surpriseNumber = Integer.parseInt(strArray[1]);
        maxScore = Integer.parseInt(strArray[2]);
        
        
        for(int i=0;i<number;i++){
            totalPoints[i] = Integer.parseInt(strArray[3+i]);
        }
        
        int lessOnePoint = (maxScore-1)<0?0:(maxScore-1);
        int lessTwoPoint = (maxScore-2)<0?0:(maxScore-2);
        
        int minTotalPoint = maxScore+lessOnePoint*2;
        int minTotalPointWithSurprise = maxScore+lessTwoPoint*2;

        
        int returnValue = 0;
        for(int i=0;i<number;i++){
           
            if(totalPoints[i]>=minTotalPoint){
                returnValue++;
            }
            else if(totalPoints[i]>=minTotalPointWithSurprise){
                if(surpriseNumber>0){
                    returnValue++;
                    surpriseNumber--;
                }
            }
        }
        
        
        return returnValue;
    }
    
   
}