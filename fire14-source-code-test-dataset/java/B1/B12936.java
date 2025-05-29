/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 *
 * @author kent.wangsawan
 */
public class soal2 {
    public static void main(String [] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok;
        int tc = Integer.parseInt(input.readLine());
        for(int i = 0; i<tc; i++){
            tok = new StringTokenizer(input.readLine());
            int awal = Integer.parseInt(tok.nextToken());
            int akir = Integer.parseInt(tok.nextToken());
            int count = 0;
            for(int j = awal; j<akir; j++){
                int temp = j;
                if(temp<10) continue;
                else if(temp< 100){
                    int a = temp%10;
                    temp = temp/10;
                    temp += a*10;
                    if(temp >= awal && temp <= akir && temp > j) {
                        count++;
                    }
                }
                else if(temp<1000){
                    for(int k = 0; k<2; k++){
                        int a = temp%10;
                        temp = temp/10;
                        temp += a*100;
                        if(temp >= awal && temp <= akir && temp > j) {
                            count++;
                        }
                        else if (temp == j)
                            break;
                    }
                }
                else if(temp < 10000){
                    for(int k = 0; k<3; k++){
                        int a = temp%10;
                        temp = temp/10;
                        temp += a*1000;
                        if(temp >= awal && temp <= akir && temp > j) {
                            count++;
                        }
                        else if (temp == j)
                            break;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+count);
        }
    }
}
