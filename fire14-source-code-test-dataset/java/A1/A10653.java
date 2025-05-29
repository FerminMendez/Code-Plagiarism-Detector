import java.io.*;
import java.util.*;

public class GCJ2Edit{
  
  
  public static void main(String args[])throws Exception{
    
//    Scanner Input = new Scanner(System.in);
    Scanner Input = new Scanner(new File("B-small-attempt3.in"));
    
    int TC = Input.nextInt();
    
    int NG;
    
    int [] Scores;
    int P;
    int Surprise;
    
    int Combos;
    
    for(int i = 0; i<TC; i++){
      
      NG = Input.nextInt();
      
      Scores = new int[NG];
      Surprise = Input.nextInt();
      P = Input.nextInt();
      int count = 0;
      int [] Indi;
      
      for(int j = 0; j<NG; j++){
        
        Scores[j] = Input.nextInt();
        
      }
      
      Indi = new int[3];
      
      for(int j = 0; j<NG; j++){
        
        if(Scores[j]%3 == 0){
          Indi[0] = Scores[j]/3;
          Indi[1] = Scores[j]/3;
          Indi[2] = Scores[j]/3;
        }
        else if(Scores[j]%3 == 1){
          Indi[0] = (Scores[j]/3)+1;
          Indi[1] = (Scores[j]-Indi[0])/2;
          Indi[2] = (Scores[j]-Indi[0])/2;
        }
        else if(Scores[j]%3 == 2){
          Indi[0] = (Scores[j]/3)+1;
          Indi[1] = ((Scores[j]-Indi[0])/2)+1;
          Indi[2] = (Scores[j]-Indi[0])/2;
        }
        
        if(Indi[0]>=P){
          count++;
        }
        
        else{
          if(Scores[j]%3==0){
            Indi[0] = Indi[0]+1;
            Indi[1] = Indi[1]-1;
            if(Indi[0]>=P && Indi[1]>=0){
              if(Surprise == 0){
                if(Math.abs(Indi[0]-Indi[1])<2&&Math.abs(Indi[2]-Indi[1])<2&&Math.abs(Indi[0]-Indi[2])<2)
                  count++;
              }
              else{
                if(Math.abs(Indi[0]-Indi[1])<=2&&Math.abs(Indi[2]-Indi[1])<=2&&Math.abs(Indi[0]-Indi[2])<=2){
                  count++;
                }
              }
            }
            else if (Surprise>0){
              Indi[0] = Indi[0]+1;
              Indi[1] = Indi[1]-1;
              if(Indi[0]>=P && Indi[1]>=0){
                if(Math.abs(Indi[0]-Indi[1])<=2&&Math.abs(Indi[2]-Indi[1])<=2&&Math.abs(Indi[0]-Indi[2])<=2){
                  count++;
                  Surprise--;
                }
              }
            }
          }
          else if(Surprise>0){
            Indi[0] = Indi[0]+1;
            Indi[1] = Indi[1] - 1;
            if(Indi[0]>=P&&Indi[1]>=0){
              if(Math.abs(Indi[0]-Indi[1])<=2&&Math.abs(Indi[2]-Indi[1])<=2&&Math.abs(Indi[0]-Indi[2])<=2){
                count++;
                Surprise--; 
              }
            }
          }
        }
        
        
      }
      System.out.println("Case #" + (i + 1) + ": " + count);
    }
    
  }
  
}