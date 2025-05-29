import java.io.*;
import java.util.Scanner;

public class surprisingTriplets
{
	 public static Scanner sc;
     
	
	public static void main(String args[]) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int numCasos = sc.nextInt();
		int numConcursants;
		int surprisingTriplets;
		int p;
		int resultat;
				
		int qt = 0;
		while(qt < numCasos)
		{
			numConcursants = sc.nextInt();
			surprisingTriplets = sc.nextInt();
			p = sc.nextInt();
			resultat = totalPoints(numConcursants,surprisingTriplets,p,sc);
			System.out.println("Case #"+(qt+1)+": "+resultat);
			qt++;
		}		
	}
	
	
	public static int totalPoints(int numConcursants, int surprisingTriplets, int p, Scanner sc)
	{
		int qt = 0;
		int bons=0;
		int votacio;
		
		int minimNormal;
		int minimSurprising;
		if(p > 1){	minimSurprising = p + (p-2) + (p-2); minimNormal = p + (p-1) + (p-1);}
		else if(p == 1){ minimSurprising = 1; minimNormal = 1;}
		else{ minimSurprising = 0; minimNormal = 0;}
			
		while(qt < numConcursants)
		{
			votacio = sc.nextInt();
			if(votacio >= minimNormal)
			{
				bons++;
			}
			else
			{
				if(votacio >= minimSurprising && surprisingTriplets > 0)
				{
					bons++;
					surprisingTriplets--;
				}
			}
			qt++;
		}
		return bons; 
	}
	
}