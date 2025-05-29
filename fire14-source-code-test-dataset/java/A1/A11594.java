package Testc;


import java.util.Scanner;

public class CodeB {
  public static void main(String[] args) {
    int numT=0;
    Scanner kb=new Scanner(System.in);
    numT=kb.nextInt();
    for(int i=0;i<numT;i++){
      int gooNum=kb.nextInt();
      int surprising=kb.nextInt();
      int p=kb.nextInt();
      int scores[]=new int[gooNum];
      for(int j=0;j<gooNum;j++){
        scores[j]=kb.nextInt();
      }
      //sort
      
      for(int k=gooNum-1;k>=0;k--){
        int max=0;
        for(int l=0;l<=k;l++){
          if(scores[l]>=scores[k]&&scores[l]>=scores[max])
            max=l;
        }
        int temp=scores[max];
        scores[max]=scores[k];
        scores[k]=temp;
      }
      
      
      int indexscore=0;
      int count = 0;
      int lastscore = scores.length-1;
      int count2=0;
      if(surprising>0){
        for(int v=0;v<surprising;v++){
          if(cal_surprise(scores[indexscore],p)==true){
            count++;
          }
          indexscore++;
          if (cal_surprise(scores[lastscore], p) == true) {
            count2++;
          }
          lastscore--;

        }
        
      }
      
        //System.out.print("here")
        while(indexscore<gooNum){
          if(cal_(scores[indexscore],p)==true)
            count++;
          indexscore++;
          if (cal_surprise(scores[lastscore], p) == true) {
            count2++;
          }
          lastscore--;
        
        }
        
        //
       

      int result = 0;
      if (count > count2)
        result = count;
      else
        result=count2;
    
     System.out.println("Case #"+(i+1)+":"+" "+count);
    }
    
     
    

  }
  
  
  public static boolean cal_surprise(int sum, int p) {
    int a = 0;
    int b = 0;
    int c = 0;
    for (a = 0; a <= 10; a++) {
      for (b = 0; b <= 10; b++) {
        for (c = 0; c <= 10; c++) {
          if (a + b + c == sum && (Math.abs(a - b) == 2) && Math.abs(b - c) <= 2 && Math.abs(a - c) <= 2) {
             //System.out.println("sum:"+sum+" a="+a+" b="+b+" c="+c);
             if (a >= p || b >= p || c >= p) return true;
              else return false;
          }
        }
      }
    }
    return false;

  }
  
   public static boolean cal_(int sum, int p) {
    int a = 0;
    int b = 0;
    int c = 0;
    for (a = 0; a <= 10; a++) {
      for (b = 0; b <= 10; b++) {
        for(c = 0; c <= 10; c++) {
          if (a + b + c == sum && (Math.abs(a - b) <= 1) && Math.abs(b - c) <= 1 && Math.abs(a - c) <= 1) {
            //System.out.println("sum:"+sum+" a="+a+" b="+b+" c="+c);
            if (a >= p || b >= p || c >= p) return true;
            else return false;
            }

        }
      }
    }
   return false;
  }
}

