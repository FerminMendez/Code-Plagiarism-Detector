
package recyclednumbers;

import java.io.*;

/**
 *
 * @author Kuzu
 */
public class RecycledNumbers {

   
    public static void main(String[] args) {
        try{
      FileInputStream fstream = new FileInputStream("C-small-attempt3.in");
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      
      String numberOfTest = br.readLine();
      int numberOfTestCases = Integer.parseInt(numberOfTest);
      Recycler recycler = new Recycler(numberOfTestCases + 1);
      
      for(int i = 0; i < numberOfTestCases; i++){
        
        String line = br.readLine();
        int spaceIndex = line.indexOf(" ");
        
        String char3 = line.substring(0,spaceIndex);
        int char1 = Integer.parseInt(char3);

        char3 = line.substring(spaceIndex+1);
        int char2 = Integer.parseInt(char3);

        recycler.addNumbers(char1, char2);        
      }
      recycler.convert();
      in.close();
    }
    catch (IOException | NumberFormatException e){
      System.err.println("Error: " + e.getMessage());
    }
    }
    
    public static class Recycler {
    
    public int caseNumber;
    int [] lines = new int[100];
    int index, ind, count;
    
    public Recycler(int n) {
      caseNumber = n;
      index = 0;
      ind = -2;
      count = 0;
    }
    
    public void convert() throws IOException{
           
      try (BufferedWriter out = new BufferedWriter(new FileWriter("Output-C-small.txt"))) {
        
        for(int a = 1; a < caseNumber; a++){
          out.write("Case #" + a + ": " );
          ind = ind +2;

          count = 0;
         
          
          for(int i = lines[ind]; i < lines[ind+1];){

              if((i/10 == 0)&&(i <= 100)) i++;
              else if((i % 10 == 0)&&(i <= 100)) i++;
              else {
                  if(i < 100) {
                      String temp = Integer.toString(i);
                      String compare = temp.substring(1,2) + temp.substring(0,1);
                      int compare1 = Integer.parseInt(compare);
                      if((i < compare1) && (compare1 <= lines[ind+1])){
                          count++;

                          i++;
                      }
                      else i++;
                  }
                  
                  if((i>99) && (i<1000)){
                    
                      String temp = Integer.toString(i);

                      String compare = temp.substring(2,3) + temp.substring(0,2);

                      int compare1 = Integer.parseInt(compare);
                      if((i < compare1) && (compare1 <= lines[ind+1])){
                                      
                          count++;
                      }
    
                      compare = temp.substring(1,3) + temp.substring(0,1);
      
                      compare1 = Integer.parseInt(compare);
         

                      if ((i < compare1) && (compare1 <= lines[ind+1])){
                                
                          count++;
                          i++;
                          if(temp.substring(1,2).equals("0")) count--;
                    }      
                      else  i++;
          }
      
              }  
     
              }
          out.write("" + count);          
           out.write("\r\n");   
        }
          out.close();           
        } 
    }
    
    private void addNumbers(int ch1, int ch2) {
      lines[index] = ch1;
      index++;
      lines[index] = ch2;
      index++;
      
      
    }
  }
}
