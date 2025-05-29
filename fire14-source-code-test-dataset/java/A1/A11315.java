package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DancingWithTheGooglers {
	public static void main(String[] args) {
		FileReader fin;
		try {
			fin = new FileReader(
					new File(
							"C:\\Users\\Subir Kumar Sao\\Desktop\\Sample\\A-small-attempt0.in"));

			FileWriter fr = new FileWriter(
					new File(
							"C:\\Users\\Subir Kumar Sao\\Desktop\\Sample\\A-Small-out.txt"));
			BufferedReader br = new BufferedReader(fin);
			String line = br.readLine();
			int N = Integer.parseInt(line);
			for (int i = 0; i < N; i++) {
				line = br.readLine();
				String[] nums = line.split(" ");
				int T = Integer.parseInt(nums[0]);
				int S = Integer.parseInt(nums[1]);
				int P = Integer.parseInt(nums[2]);
				List<Integer> numArray = new ArrayList<Integer>(); 
				for(int j=0;j<T;j++){
					numArray.add(Integer.parseInt(nums[3+j]));
				}
				Collections.sort(numArray);
				Collections.reverse(numArray);
				int count=0;
				for(int num :numArray){
					if(num==0 && P>0)
						continue;
					if((num/3)>=P){
						count++;
					}
					else if(((num%3)>=1) && (((num/3)+1) >= P)){
						count++;
					}
					else if(S>0){
						if((num%3==0) || (num%3==2)){
							if(((num/3)+2)>=P){
								S--;
								count++;
							}
						}
					}
				}
				fr.write("Case #"+(i+1)+": "+count+"\r\n");
				
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
