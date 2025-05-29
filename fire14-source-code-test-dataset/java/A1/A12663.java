import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


public class B {

	/**
	 * @param args
	 */
	
	public static String rest(ArrayList<String> list)
	{
		
		String n = list.get(0);
		list.remove(0);
		return n;
	};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String line;
		ArrayList<String> liste = new ArrayList<String>();
		
		
		BufferedReader buffer = null;
		try {
			buffer=new BufferedReader(new FileReader(new File(args[0])));
			
			for(int i=0; (line = buffer.readLine())!=null; i++){
				liste.add(line);
			}
		}
		catch(IOException e){
				System.out.println("IO-Fehler!");
		}	
		
		
		int anzahl = Integer.parseInt(rest(liste));



		// fuer jeden Fall methode aufrufen
		for ( int i = 0 ; i < anzahl; i++  ){
			methode(i+1, liste);
		}
	}

	// spezifische code fŸr alle aufgaben
	public static void methode(int nummer, ArrayList<String> liste)
	{
		// buffer und input machen
		// input ist ein stringarray mit meiner ersten Zeile
		// String[] input = rest(liste);
		StringBuffer ergebnisbuffer = new StringBuffer(); 
		
		String[] input = rest(liste).split(" ");
		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		
		
		for (int i=0; i < input.length; i++){
			int n = Integer.parseInt(input[i]);
			arraylist.add(n);
		}

		int googler = arraylist.get(0);

		
		int surprises = arraylist.get(1);

		
		int p = arraylist.get(2);

		
		ArrayList<Integer> ergebnisse = new ArrayList<Integer>(5);
		
		arraylist.subList(3, arraylist.size());
		
		for (int i=3; i < arraylist.size() ; i++){
			ergebnisse.add(arraylist.get(i));
		}
		
		int sum = 0;
		int newsurprises = surprises;
		
		
		for (int i=0; i < ergebnisse.size();i++){
			if(ergebnisse.get(i) == 0)
			{
				ergebnisse.remove(i);
			}
		}

		Collections.sort(ergebnisse);
		Collections.reverse(ergebnisse);
		

		
		for (int i=0; i < ergebnisse.size();i++){
			if ((ergebnisse.get(i) >= 0) && (ergebnisse.get(i)<= 30)){
				if(ergebnisse.get(i) >= ((3*p)-2)){
					sum=sum+1;
				}
				if((ergebnisse.get(i) == ((3*p)-4)) && (newsurprises >0)){
					sum=sum+1;
					newsurprises=newsurprises-1;
				}
				if((ergebnisse.get(i) == ((3*p)-3)) && (newsurprises >0)){
					sum=sum+1;
					newsurprises=newsurprises-1;
				}
			}
		}
		
		if (p == 0){
			sum = googler;
		}

		System.out.println("Case #" + nummer + ": " + sum);
	}
}