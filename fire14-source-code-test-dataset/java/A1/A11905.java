package com.udit.codeJam;

import java.io.*;


public class Gogglers
{
           static DataInputStream in = new DataInputStream(new
                   BufferedInputStream(System.in));
       static BufferedReader din = new BufferedReader( new InputStreamReader(in));


    public static void main(String[] args)
    {
        int [] normal = new int[31];
        int [] surprise = new int[31];
        for(int i=0;i<31;i++){
            if(i%3 == 0){
                normal[i] = i/3;
                surprise[i] = i/3+1;
            } else {
                normal[i] = i/3 +1;
                if(i%3 ==1){
                    surprise[i] = i/3+1;
                } else {
                    surprise[i] = i/3+2;
                }
            }
        }
        surprise[0]=0;
        surprise[29] = 10;
        surprise[30] = 10;
        int T = parseInt(getLine());
        String[] arr = new String[T];
     for(int i=0;i<T;i++){
         arr[i] = getLine();
     }

        for (int i = 0; i < T; i++) {
            int count = 0;
            String[] inputs = arr[i].split(" ");
            int contestants = parseInt(inputs[0]);
            int surpriseNum = parseInt(inputs[1]);
            int scoresRequired = parseInt(inputs[2]);
            for (int j = 0; j < contestants; j++) {
                  if (scoresRequired <= normal[parseInt(inputs[j + 3])]) {
                    count++;
                } else if(surpriseNum > 0 && scoresRequired <= surprise[parseInt(inputs[j + 3])]) {
                          count++;
                     surpriseNum--;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + count);
        }

    }


    public static String getLine(){
       String input = "";
       try {
                       input = din.readLine();
               } catch (IOException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
               }
       return input;
   }

   public static void printArray(int[][] b, int m, int n) {
       for(int i = 0;i < m;i++){
           System.out.println();
               for(int j = 0;j < n;j++){
                   System.out.print((b[i][j] + " "));
               }
       }
       }

   public static int parseInt(String s){
       return Integer.parseInt(s);
   }
   public static double parseDouble(String s){
       return Double.parseDouble(s);
   }
   public static void sout(Object n){
       System.out.print(n);
       }
   public static void soutln(Object n){
       System.out.println(n);
       }
}
