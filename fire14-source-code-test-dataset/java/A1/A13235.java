package com.codejam2012;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new FileReader("B-small-attempt1.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("output1.txt"));
		
		int T = Integer.parseInt(sc.nextLine());
		for (int i=0; i<T; i++){
			
			String tempInput = sc.nextLine();
			String [] range = tempInput.split(" ");
			int N = Integer.parseInt(range[0]);
			int S = Integer.parseInt(range[1]);
			int p = Integer.parseInt(range[2]);
			int rem, quo, pCal, y = 0;
			int [] t = new int[N];
			for(int j=0;j<N;j++){
				t[j] = Integer.parseInt(range[j+3]);
				System.out.println(t[j]);
				quo = t[j] / 3;
				rem = t[j] % 3;
				System.out.println(t[j]+":quo:"+quo+":rem:"+rem);
				if(quo >= p || (quo == p-1 && rem !=0)){
					y++;
					System.out.println(t[j]+"Default True");
				}
				else if (quo < p-2 || (quo == p-2 && rem !=2)){
					System.out.println(t[j]+"Default False");
				}
				else if((quo == p-2 && rem == 2&& quo!=0)||(quo == p-1 && rem == 0&& quo!=0)){
					if(S>0){
						y++;
						S--;
						System.out.println(t[j]+"True");
					}
					else{
						System.out.println(t[j]+"False");
					}
				}
				else if((quo == p-2 && rem == 2&& quo==0 && p==0)||(quo == p-1 && rem == 0&& quo==0 && p==0)){
					y++;
				}
			}
			System.out.println("Case #"+(i+1)+": "+y);
			pw.write("Case #"+(i+1)+": "+y+"\n");
		}
		pw.flush();
		pw.close();
		sc.close();
	}
	
	static boolean checkP(){
		
		
		return true;
	}
	
}


