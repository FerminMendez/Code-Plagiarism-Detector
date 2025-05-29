import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class RecycledNumbers {
	
	
	static int findLessThanHundred(int a, int b){
		if (a==b) return 0;
		if (b < 22) return 0;
		int retour=0;
		if (b < 100) {
			int x=11;
			if (a > 11) x=a; else x = 12;
			while(x < b){
				
		String entier = x+"";
		if (!(entier.charAt(1)+"").equals("0")){
			
		int rec = Integer.parseInt(""+entier.charAt(1)+entier.charAt(0)+"");
				
		if (rec > x && rec < b+1 ) {System.out.println(rec);retour++;}
				
		}
			x++;	
			}
			
			
		return retour;	
			
		}
		
		
		
		
		
		return 0;
	} 
	
	
	static int findLessThanThousand(int a, int b){
		
		int retour = 0;
		ArrayList<String> arr = new ArrayList<String>();
		if (a==b) return 0;
		int x = a;
		while (x < b+1){
		if (!arr.contains(x+"")){
			boolean rec1good = false;
			int rec1=0,rec2=0;
		String entier= x+"";
		if (!(""+entier.charAt(2)+"").equals("0") ){
		rec1 = Integer.parseInt(""+entier.charAt(2)+""+entier.charAt(0)+""+entier.charAt(1)+""); 
		
		if (rec1 > a && rec1 < b+1 && rec1 != x ) {;arr.add(rec1+"");arr.add(x+"");retour++;rec1good=true;}
	
		}
		if (!(""+entier.charAt(1)+"").equals("0") ){
			rec2 = Integer.parseInt(""+entier.charAt(1)+""+entier.charAt(2)+""+entier.charAt(0)+""); 
			
			if (rec2 > a && rec2 < b+1 && rec2 != rec1 && rec2 != x) {arr.add(rec2+"");retour++; if (rec1good) retour++;}
		
			}
		System.out.println("x=="+x+"rec1=="+rec1+"rec2=="+rec2+" retour=="+retour);
		}
		x++;
		}
		
		
		return retour;
	}
	
	
	
	public static void main (String args[]) throws IOException{
	
		BufferedReader in = new BufferedReader(new FileReader(new File("recycled.in")));
		PrintWriter out = new PrintWriter(new FileWriter("recycled.out"));
		
		//System.out.print(RecycledNumbers.findLessThanHundred(10,40));
		
		//System.out.println(RecycledNumbers.findLessThanThousand(100,500));
		
		String ligne="";
		
		int nbr_lignes = Integer.parseInt(in.readLine());
		
		int index = 0;
		
		while(index < nbr_lignes){
		int a,b;
		ligne=in.readLine();
		StringTokenizer tok = new StringTokenizer(ligne);
		
		a = Integer.parseInt(tok.nextToken());
		b = Integer.parseInt(tok.nextToken());	
		
		if (b<100) {
			
			if (index!=nbr_lignes-1){
				out.println("Case #"+(index+1)+": "+RecycledNumbers.findLessThanHundred(a, b));
				}
			else 
				out.print("Case #"+(index+1)+": "+RecycledNumbers.findLessThanHundred(a, b));
			
			
		}
		
		
		else if (a > 99) {
			
			if (index!=nbr_lignes-1){
				out.println("Case #"+(index+1)+": "+(RecycledNumbers.findLessThanThousand(a, b)));
				}
			else 
				out.print("Case #"+(index+1)+": "+(RecycledNumbers.findLessThanThousand(a, b)));
			
							
			}
		
		else {
			
			if (index!=nbr_lignes-1){
				out.println("Case #"+(index+1)+": "+(RecycledNumbers.findLessThanHundred(a, 99)+RecycledNumbers.findLessThanThousand(100, b)));
				}
			else 
				out.print("Case #"+(index+1)+": "+(RecycledNumbers.findLessThanHundred(a, 99)+RecycledNumbers.findLessThanThousand(100, b)));
			
			
			
			
		}
			
			index++;
		}
			
			out.close();
			
			
		}
		
		
	

}
