package utils;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class Numbers {
	
	public static void main(String[] args) {
		lecture("/Users/valentinbonneaud/Downloads/C-small-attempt0.in");
	}

	public static void lecture(String name){
		
		Scanner flux = null;
		PrintWriter out;
		
		try {
			flux = new Scanner(new FileInputStream(name));
			out = new PrintWriter(new FileWriter("/Users/valentinbonneaud/Downloads/C-small-practice out.in", false));
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}
			
		int nb = flux.nextInt(); flux.nextLine();
		
		for(int i =0;i<nb;i++)
		{
			int A = flux.nextInt();
			int B = flux.nextInt();
			flux.nextLine();
			
			int nbPairRec=0;
			
			for(int n = A;n<=B;n++)
				for(int m=n;m<=B;m++)
				{
					if(new Pair(n,m).isRecycled()) nbPairRec++;
				}
			
			out.println("Case #"+(i+1)+": "+nbPairRec);
		}	
		
		flux.close();
		out.flush();
		out.close();
		
		System.out.println("Every think is done !");
		
	}
	
}

class Pair
{
	int x,y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean isRecycled()
	{
		if(x==y) return false;
		String n = x+"",m = y+"";
		
		for(int i = 1;i<n.length();i++)
		{
			String n3 = n.substring(i)+n.substring(0, i); 
			if(n3.equals(m)) return true;
		}
		
		return false;
	}
}