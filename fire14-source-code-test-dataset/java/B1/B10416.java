package com.google.codjam.problems;

public class sample {
    public static void main(String[] args) {
        int n = 20;
        String nS=n+"";
       
        
        int currentM=1;
        int maxMov=nS.length();
        String tempS = nS.substring(0,currentM);
        String finalS= nS.substring(currentM,maxMov)+tempS;
        System.out.println(finalS);
    }
    
}
