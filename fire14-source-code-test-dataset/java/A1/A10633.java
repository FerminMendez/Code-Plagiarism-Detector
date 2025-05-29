/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author sarwar
 */
public class problemB {
    
    static int diff(int a,int b,int c){
        return Math.max(Math.max(Math.abs(a-b), Math.abs(b-c)),Math.abs(c-a));
    }
    static int func(int score, int least){
        int val=0,possible=0,surprise=0;
        while(least<=30){
            if(least-1>=0 && score-least-least+1>=0){
                val = diff(least,least-1,score-least-least+1);
                if(val==0||val==1){possible++;break;}
                else if(val==2){surprise++;}
            }
            if(least-2>=0 && score-least-least+2>=0){
                val = diff(least,least-2,score-least-least+2);
                if(val==0||val==1){possible++;break;}
                else if(val==2){surprise++;}
            }
            if(score-least-least>=0){
                val = diff(least,least,score-least-least);
                if(val==0||val==1){possible++;break;}
                else if(val==2){surprise++;}
            }
            if(score-least-least-1>=0){
                val = diff(least,least+1,score-least-least-1);
                if(val==0||val==1){possible++;break;}
                else if(val==2){surprise++;}
            }
            if(score-least-least-2>=0){
                val = diff(least,least-2,score-least-least-2);
                if(val==0||val==1){possible++;break;}
                else if(val==2){surprise++;}
            }
            least++;
        } 
        if(possible==1)return 0;
        else if(surprise >= 1)return 1;
        else return 3;
    }
    
    public static void main(String args[]) throws IOException{
        //System.out.println(func(29,12));
        BufferedWriter out = new BufferedWriter(new FileWriter("D:\\output.txt"));
        Scanner sc = new Scanner(new File("D:\\input.txt"));
        int test = sc.nextInt();
        for(int i=0;i<test;i++){
            int googlers = sc.nextInt();
            int surprise = sc.nextInt();
            int least = sc.nextInt();
            //int[] score = new int[googlers];
            int fsurprise=0,fnormal=0,fimpossible=0;
            for(int j=0;j<googlers;j++){
                int val = sc.nextInt();
                //System.out.print(val + "  ");
                val = func(val,least);
                //System.out.print(val + "  ");
                if(val==0)fnormal++;
                else if(val==1)fsurprise++;
                else fimpossible++;
            }
            if(surprise>fsurprise){
                out.write("Case #" + (i+1) + ": " + String.valueOf(fnormal+fsurprise));
            }
            else{
                out.write("Case #" + (i+1) + ": " + String.valueOf(fnormal+surprise));
            }
            out.newLine();
            //System.out.println(googlers + " " + surprise + " " + least + " " + score[googlers-1]);
        }
        out.close();
    }
    
}
