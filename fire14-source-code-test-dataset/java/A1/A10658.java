package utils;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Dancing {
	
	public static void main(String[] args) {
		lecture("/Users/valentinbonneaud/Downloads/B-small-attempt0.in");
//		lecture("/Users/valentinbonneaud/Desktop/test.txt");
	}

	public static void lecture(String name){
		
		Scanner flux = null;
		PrintWriter out;
		
		try {
			flux = new Scanner(new FileInputStream(name));
			out = new PrintWriter(new FileWriter("/Users/valentinbonneaud/Downloads/B-small-practice out.in", false));
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}
			
		int nb = flux.nextInt();
		
		for(int i =0;i<nb;i++)
		{
			int n = flux.nextInt();
			int s = flux.nextInt();
			Scores.s = s;
			int p = flux.nextInt();
			
			Scores[] tab = new Scores[n];
			for(int j = 0;j<n;j++)
			{
				tab[j]=new Scores(flux.nextInt());
			}
			
			int nbGre=0;
			
			for(int j=0;j<tab.length;j++)
				if(tab[j].isGreater(p)) nbGre++;
			
			out.println("Case #"+(i+1)+": "+nbGre);
			
		}	
		
		flux.close();
		out.flush();
		out.close();
		
		System.out.println("Every think is done !");
		
	}
	
}

class Scores
{
	static int s;
	ArrayList<Score> tab;
	
	public Scores(int x)
	{
		tab = new ArrayList<Score>();
		tab.add(new Score(x));
		
		int[] score = tab.get(0).getVec();
		Score test;
		
		test=new Score(score[0]+1,score[1],score[2]-1);
		if(!test.isIncorrect())
			tab.add(test);
		
		test=new Score(score[0],score[1]+1,score[2]-1);
		if(!test.isIncorrect())
			tab.add(test);
		
		test=new Score(score[0]-1,score[1],score[2]+1);
		if(!test.isIncorrect())
			tab.add(test);
		
		test=new Score(score[0]-1,score[1]+1,score[2]);
		if(!test.isIncorrect())
			tab.add(test);
		
		test=new Score(score[0]+1,score[1]-1,score[2]);
		if(!test.isIncorrect())
			tab.add(test);
		
		test=new Score(score[0],score[1]-1,score[2]+1);
		if(!test.isIncorrect())
			tab.add(test);
	}
	
	public boolean isGreater(int p)
	{
		boolean trueWithSurprising = false;
		for(int i = 0;i<tab.size();i++)
			if(tab.get(i).isGreater(p))
			{
				if(!tab.get(i).isSurprising()) {return true;}
				else
					trueWithSurprising=true;
			}
		
		if(s>0 && trueWithSurprising)
		{
			s--;
			return true;
		}
		
		return false;
	}
}

class Score
{
	int[] vec;
	boolean surprising;
	
	public Score(int x,int y,int z)
	{
		vec = new int[3];
		vec[0]=x;
		vec[1]=y;
		vec[2]=z;
	}
	public Score(int x)
	{
		vec = new int[3];
		int reste = x;
		vec[0] = (int)(Math.floor(reste/3.));
		reste-=vec[0];
		vec[1] = (int)(Math.floor(reste/2.));
		reste-=vec[1];
		vec[2] = reste;
		
		while(true)
		{
			if(isIncorrect()){
				
				//We looking for the max and the min
				System.out.println("Incorrect ! "+vec[0]+" "+vec[1]+" "+vec[2]);
				Arrays.sort(vec);
				vec[0]+=1;
				vec[2]-=1;
				continue;
			}
			else
				break;
		}
		surprising=isSurprising();
	}
	
	public int[] getVec() {
		return vec;
	}
	
	public boolean isGreater(int p)
	{
		return ((vec[0]>=p)||(vec[1]>=p)||(vec[2]>=p));
	}
	
	public boolean isSurprising(){
		if(Math.abs(vec[0]-vec[1]) >= 2)
			return true;
		if(Math.abs(vec[1]-vec[2]) >= 2)
			return true;
		if(Math.abs(vec[0]-vec[2]) >= 2)
			return true;
		
		return false;
	}
	
	public boolean isIncorrect(){
		if(vec[0]<0 || vec[1]<0 || vec[2]<0)
			return true;
		
		if(Math.abs(vec[0]-vec[1]) >= 3)
			return true;
		if(Math.abs(vec[1]-vec[2]) >= 3)
			return true;
		if(Math.abs(vec[0]-vec[2]) >= 3)
			return true;
		
		return false;
	}
}