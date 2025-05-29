/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Madu
 */

import java.io.*;

public class Ex2 {
    
    public static void main(String[] args) {
        
          try{

  FileInputStream fstream = new FileInputStream("C:/Users/Madu/Documents/NetBeansProjects/CodeJamR1Ex1/input/A-small-attempt0.in");
  FileOutputStream fout = new FileOutputStream ("C:/Users/Madu/Documents/NetBeansProjects/CodeJamR1Ex1/output/out.txt");
  PrintStream printStream = new PrintStream(fout);
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String inputIlne;
  br.readLine();
      //printStream.println ("Output");
  //Read File Line By Line
      int lineNum = 1;
  while ((inputIlne = br.readLine()) != null)   {
  // Print the content on the console
      
      //##########
	    
        String[] marks =  inputIlne.split(" ");
        
      
      
        int peopleCount = Integer.parseInt(marks[0].toString());
        int s = Integer.parseInt(marks[1].toString());
        int p = Integer.parseInt(marks[2].toString());
        
        int ans = 0;
        
    
        
          for (int i = 3; i < marks.length; i++) {            
            
            System.out.println(marks[i]);
            int total = Integer.parseInt(marks[i].toString());
            
            int value = total/3;
            int reminder = total%3;
            
            if(total==0){
                if(p==0){ans++;}
                
                continue;}
            
            if(reminder==0){
            
                if(value>=p){ans++;}
                else if(value+1>=p){
                
                    if(s>=1){ans++; s--;
                    }
                
                }
                
            }
            
            else if(reminder==1){
                
                if(value>=p){ans++;}
                else if(value+1>=p){ans++;}
            
            }
            
            else if(reminder==2){
            
                if(value>=p){ans++;}
                else if(value+1>=p){ans++;}
                else if(value+2>=p){
                    
                    if(s>=1){ans++; s--;}
                    }
            
            }
            
        }
        
        
        
        printStream.print ("Case #"+lineNum+": "+ans);lineNum++;
      
	  //###########
      printStream.println("");
  }
  //Close the input stream
  in.close();
  
  
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.toString());
  }
        
    }
    
    
    
//    public static void main(String[] args) {
//        
//        String test = "2 1 1 8 0";
//        int peopleCount = Integer.parseInt(test.substring(0, 1));
//        int s = Integer.parseInt(test.substring(2, 3));
//        int p = Integer.parseInt(test.substring(4, 5));
//        
//        int ans = 0;
//        
//        //System.out.println(p);
//        
//        String[] marks = (test.substring(6)).split(" ");
//        
//        
//        
//        for (int i = 0; i < marks.length; i++) {            
//            
//            System.out.println(marks[i]);
//            int total = Integer.parseInt(marks[i].toString());
//            
//            int value = total/3;
//            int reminder = total%3;
//            
//            if(total==0){continue;}
//            
//            if(reminder==0){
//            
//                if(value>=p){ans++;}
//                else if(value+1>=p){
//                
//                    if(s>=1){ans++; s--;
//                    }
//                
//                }
//                
//            }
//            
//            else if(reminder==1){
//                
//                if(value>=p){ans++;}
//                else if(value+1>=p){ans++;}
//            
//            }
//            
//            else if(reminder==2){
//            
//                if(value>=p){ans++;}
//                else if(value+1>=p){ans++;}
//                else if(value+2>=p){
//                    
//                    if(s>=1){ans++; s--;}
//                    }
//            
//            }
//            
//        }
//        
//        
//        
//        System.out.println("Answer :"+ans);
//        
//    }
    
}
