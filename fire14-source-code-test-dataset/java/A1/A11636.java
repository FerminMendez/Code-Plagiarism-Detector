package com.qual2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class qual2 {

	public static void main(String[] args) {
		cNums h = new cNums();
		FileInputStream fis;
		try {
			fis = new FileInputStream("B-small-attempt0.in");
			FileOutputStream fos = new FileOutputStream("smallB.txt");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			
			int lines = Integer.parseInt(br.readLine());
			String outp = null;
			String inp;
			
			for(int i = 0; i < lines; i++) {
				inp = br.readLine();
				String[] inpar = inp.split(" ");
				
				int lim = Integer.parseInt(inpar[2]);
				int surp = Integer.parseInt(inpar[1]);
				int numbestn = 0;
				int numpossbests = 0;
				for(int a = 3; a < inpar.length; a++) {
					int curr = Integer.parseInt(inpar[a]);
					if(h.bestn[curr] >= lim)
						numbestn++;
					else if(h.bests[curr] >= lim)
						numpossbests++;
				}
				outp = "Case #" + (i+1) + ": ";
				outp += (numbestn + Math.min(surp, numpossbests));
				outp += "\n";
				fos.write(outp.getBytes());
				
			}
			fis.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

final class cNums {
	public int[] bestn;
	public int[] bests;
	
	public cNums() {
		bestn = new int[31];
		bests = new int[31];
		FindBests();
	}
	
	private void FindBests() {
		bestn[0] = 0;
		bests[0] = 0;
		for(int i = 1; i < 31; i++) {
			int mod = i % 3;
			bestn[i] = i / 3;
			if(mod == 0)
				bests[i] = bestn[i] + 1;
			else if(mod == 1)
				bests[i] = ++bestn[i];
			else if(mod == 2)
				bests[i] = ++bestn[i] + 1;
		}
	}
}