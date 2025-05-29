import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Googlers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		String fichier ="C:\\result.txt";
		int compteurlignes = 0;
		int nombreCas ;
		ArrayList<String> googlers = new ArrayList<String>();
		ArrayList<String> results = new ArrayList<String>();
		//lecture du fichier texte	
		try
		{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				compteurlignes++;
				//System.out.println(ligne);
				if (compteurlignes ==1)
				{
					nombreCas = Integer.valueOf(ligne);
				}
				else
				{
					googlers.add(ligne);
					//System.out.println(ligne);
				}
				
			}
			br.close(); 
			
		
			
			
			//traitement par ligne
			ArrayList<String> nombres = new ArrayList<String>();
			for(int i = 0; i < googlers.size();i++)
			{
				 ligne = googlers.get(i);
				 
				 
				 //get numbers
				 StringTokenizer st = new StringTokenizer(ligne, " ");
				    while (st.hasMoreTokens())
				    {
				      nombres.add(st.nextToken());
				      
				    }
				    
				    int numberGooglers = Integer.parseInt(nombres.get(0));
				    int surprises = Integer.parseInt(nombres.get(1));
				    int chiffre = Integer.parseInt(nombres.get(2));
				    int value = 0;
				    
				    int totalNumber = chiffre *3;
				    
				    for(int x = 0; x < numberGooglers; x++)
				    {
				    	int totalMark = Integer.parseInt(nombres.get(x+3));
				    	
				    	if(totalNumber ==0)
				    	{
				    		value++;
				    	}
				    	else if(totalMark <= totalNumber+2 && totalMark >= totalNumber-2)
				    	{
				    		value++;
				    	}
				    	else if(totalMark == totalNumber-3 || totalMark == totalNumber-4)
				    	{
				    		if (surprises >0 && totalMark != 0)
				    		{
				    			surprises--;
				    			value++;
				    		}
				    	}
				    	else if(totalMark >= totalNumber+3) value++;
				    }
				    
				    results.add(String.valueOf(value));
				    System.out.println("result : "+value);
				    //clean arrayList
				    nombres = new ArrayList<String>();
			}
		
		
		
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		
		}
		
		
		
		
		
		//écrire dans le fichier
		try 
		{
			FileWriter fw = new FileWriter (fichier);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter fichierSortie = new PrintWriter (bw); 
			for (int w =0; w<results.size();w++)
			{
				fichierSortie.println ("Case #"+(w+1)+": "+results.get(w)); 
			}
			fichierSortie.close();
			System.out.println("Le fichier " + fichier + " a été créé!"); 
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}	

	}

}
