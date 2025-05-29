import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MaxDancers {

	public static void main(String[] args)throws IOException {

		String fichierentree= "/home/marwen/Téléchargements/B-small-attempt0.in";
		String fichiersortie= "/home/marwen/Bureau/output.in";

		BufferedWriter	 wr= new BufferedWriter(new FileWriter(fichiersortie));
		DataInputStream	 rd= new DataInputStream(new FileInputStream(fichierentree));		
		
		//Reading number of cases
		String ligne = rd.readLine();
		int cases = Integer.valueOf(ligne);
		
		int k;
		for (k=1;k<=cases;k++) 
		{
			//Reading ligne by ligne
			ligne = rd.readLine();
			ligne=ligne+" ";
			
			// Reading length of the table and filling in it with numbers
			
			int taille = Integer.valueOf(ligne.substring(0, ligne.indexOf(" ")));
			int [] T1= new int [3+taille];
			T1[0]=taille;
			int i,val;
			for (i=1;i<3+taille;i++)
			{
				 ligne=ligne+" ";
				 ligne = ligne.substring(ligne.indexOf(" ") + 1);
				 val = Integer.valueOf(ligne.substring(0, ligne.indexOf(" ")));
				 T1[i]=val;
			}
			
			// End of Reading table from ligne
			
			//Solving the problem for each Line
			
			int s,p,nb,l;
			s=T1[1];
			p=T1[2];
			nb=0;
			l=T1.length;
			for(i=3;i<l;i++)
			{
				if (T1[i]>=p)
				{
				if (T1[i]>=3*p-2) {nb++;}
				else {if ((T1[i]>=3*p-3)||(T1[i]>=3*p-4)){if (s>0){nb++;s--;}}}
				}
			}
			
			//Writing into the output file before moving to the next Line
			wr.write("Case #"+k+": "+nb);
			wr.newLine();
		}	
		
	wr.close();
	rd.close();
	}
}
