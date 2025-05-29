import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class CJ2012Q {
	static ArrayList[] combs;
	static int currMax = 0;
	public static void main(String[] args) throws IOException {
		combs = new ArrayList[31];
		for(int i =0; i < combs.length;i++)
			combs[i] = new ArrayList<P3D>();
		for(int i = 0; i <= 10;i++)
			for(int j = 0;j <= 10;j++)
				for(int k =0; k <= 10;k++){
					if(Math.abs(j-k)<=2 && Math.abs(i-j) <=2 && Math.abs(k-i)<=2)
						combs[i+j+k].add(new P3D(i,j,k));
				}
		Scanner sc = new Scanner(new FileReader("B-small-attempt0.in"));
		FileWriter fw = new FileWriter("output.txt");
		int T = sc.nextInt();
		for(int i = 1; i <=T;i++){
			int N = sc.nextInt();
			int S = sc.nextInt();
			int p = sc.nextInt();
			int[] scores = new int[N];
			for(int j = 0; j < N;j++)
				scores[j] = sc.nextInt();
			recurse(new ArrayList<P3D>(),N,0,S,p,scores);
			fw.write("Case #" + i + ": "+currMax + "\n");
			currMax = 0;
			//brute force the following way:
			//Go through each of 
			
			
		}
		fw.close();
		

	}
	public static void recurse(ArrayList<P3D> acc, int N, int currN, int S, int p, int[] scores)
	{
		if(currN == N){
			int currM = 0;
			int currS = 0;
			for(int  i =0; i < acc.size();i++){
				P3D pnt = acc.get(i);
				if(pnt.x >= p || pnt.y>= p || pnt.z >= p) currM ++;
				if(Math.abs(pnt.y-pnt.z)==2 || Math.abs(pnt.x-pnt.y) ==2 || Math.abs(pnt.z-pnt.x)==2) currS ++;
			}
			if(currS != S)return;
			if(currM >= currMax)currMax = currM;
			
		}
		else {
			for(int i = 0; i < combs[scores[currN]].size();i++){
				acc.add((P3D) combs[scores[currN]].get(i));
				recurse(acc,N,currN+1,S,p,scores);
				acc.remove(acc.size()-1);
			}
		}
			
	}
		
}

class P3D{
	int x, y, z;
	public P3D(int a, int b, int c){
		this.x =a;
		this.y = b;
		this.z = c;
	}
}
