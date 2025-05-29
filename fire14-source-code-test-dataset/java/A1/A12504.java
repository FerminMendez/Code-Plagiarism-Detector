import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Rashmika
 */
public class Main {
    
    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
            int numLines = 0, i=0;
            String str = "";
            String[] testRounds = new String[1];
            while ((str = in.readLine()) != null && str.length() != 0) {
                if(numLines!=0){
                    testRounds[i++] = str;
                }else{
                    numLines = Integer.parseInt(str);
                    testRounds = new String[numLines];
                }
            }
            
            for(int j=0; j<numLines-1; j++){
                output("Case #"+(j+1)+": "+getWinners(testRounds[j]) +"\n");
            }
                output("Case #"+(numLines)+": "+getWinners(testRounds[numLines-1]));
            
        } catch (IOException e) {
        }
        
        //System.out.println(""+getWinners("2 1 1 8 0"));
        
    }
    
    public static void output(String line){
        try{
          FileWriter fstream = new FileWriter("dancing.out",true);
          BufferedWriter out = new BufferedWriter(fstream);
          out.write(line);
          out.close();
          }catch (Exception e){//Catch exception if any
          System.err.println("Error: " + e.getMessage());
          }
    }
    
    public static int getWinners(String line){
        
        String[] temp = line.split(" ");
        int N = Integer.parseInt(temp[0]);
        int S = Integer.parseInt(temp[1]);
        int P = Integer.parseInt(temp[2]);
        int player[] = new int[N];
        
        for(int i=0; i<N; i++){
            player[i] = Integer.parseInt(temp[3+i]);
        }
        
        int winnerCount = 0;
        
        //for a single round
        int total;
        int n1;
        for(int i=0; i<N; i++){
            
            total = player[i];
            
            if(total==0){
                if(P<=0){
                    winnerCount++;
                    //System.out.println("Counted "+i);
                    continue;
                }                
            }else if(total%3==0){
                n1 = total/3;
                //System.out.println(i+":"+n1+"  "+total);
                if( (n1>=P) ){
                    //System.out.println("Counted "+i);
                    winnerCount++;
                    continue;
                }else if( (S>0) && ((n1+1)>=P) ){
                    //System.out.println("Counted "+i);
                    winnerCount++;
                    S--;
                    continue;        
                }
            }else if(total%3==1){
                n1 = total/3 + 1;
                //System.out.println(i+":"+n1+"  "+total);
                if( (n1>=P) ){
                    //System.out.println("Counted "+i);
                    winnerCount++;
                    continue;
                }
            }else if(total%3==2){
                n1 = total/3 + 1;
                //System.out.println(i+":"+n1+"  "+total);
                if( (n1>=P) ){
                    //System.out.println("Counted simile"+i);
                    winnerCount++;
                    continue;
                }else if( (S>0) && ((n1+1)>=P) ){
                    //System.out.println("Counted "+i);
                    winnerCount++;
                    S--;
                    continue;        
                }
            }
            
        }        
        return winnerCount;
        
    }
    
}