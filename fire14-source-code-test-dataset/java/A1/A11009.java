package org.marcus905.gcj2012;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class DancingWithTheGooglers {

	public static void main(String[] args){
		try {
			
			BufferedInputStream	bis = new BufferedInputStream(new FileInputStream(new File("/home/marcus905/Desktop/in")));
			
			Scanner sc = new Scanner(bis);
			PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream(new File("/home/marcus905/Desktop/out"))));
			int len = Integer.parseInt(sc.next().trim());
			sc.nextLine();
			int[] results = new int[len];
						
			for(int i = 0; i < len; i++){
				
				int googlers = 0, surprisingscoresets = 0, thresholdgrade = 0, currentgoogler = 0;
				int[] scores = new int[3];
				googlers = sc.nextInt();
				surprisingscoresets = sc.nextInt();
				thresholdgrade = sc.nextInt();
				
				for(int j = 0; j < googlers; j++){
					currentgoogler = sc.nextInt();
					if ((currentgoogler/3==thresholdgrade-2 && surprisingscoresets > 0
							&& currentgoogler % 3 == 2) ||
							(currentgoogler/3==thresholdgrade-1 && surprisingscoresets > 0
							&& currentgoogler % 3 == 0)
							&& (currentgoogler > 1 && currentgoogler < 29)){
						surprisingscoresets--;
						/*
						int averagegrade = currentgoogler/3;
						for(int k = 0; k<3; k++)
							scores[k]=averagegrade;
						currentgoogler-=3*averagegrade;
						switch(currentgoogler){
						case 2:scores[0]+=2; currentgoogler=0; break;
						case 1:scores[1]+=1; currentgoogler=0;
						case 0:scores[2]+=1; scores[0]-=1; currentgoogler=0;
						}
						*/
						results[i]++;
					}
					else if (currentgoogler/3==thresholdgrade-1 && currentgoogler % 3 > 0
							|| currentgoogler/3>=thresholdgrade){
						results[i]++;
					}
					
				}
				
				
				
				
				
			}
			
			int k = 1;
			for(int j: results){
				pw.print("Case #"+k+": "+j+"\n");
				k++;
			}
			pw.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
