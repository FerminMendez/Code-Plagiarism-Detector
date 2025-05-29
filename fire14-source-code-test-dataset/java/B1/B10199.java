import java.util.*;
import java.lang.*;
import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class main {

	/**
	 * @param args
	 */
	public static String lireString() // lecture d'une chaine
	{
		String ligne_lue = null;
		try {
			InputStreamReader lecteur = new InputStreamReader(System.in);
			BufferedReader entree = new BufferedReader(lecteur);
			ligne_lue = entree.readLine();
		} catch (IOException err) {
			System.exit(0);
		}
		return ligne_lue;
	}
	
	public static Scanner s =new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Input");
	
	String filename = "C:\\A-small-attempt1.in";
	String ligne = "";
	int nbrLigne = 0, i=0, j=0,rech=0;
	char cchar=' ';
	File f = new File(filename);
	if (f.exists()) {
		System.out.println("File exists");
	} else {
		System.out.println("File does not exist");
	}
	
String aa="ejpmyslckdxvnribtahwfougqz ";
String bb="ourlangeismpbtdhwyxfckjvzq ";
String  g="";

	try {
		FileInputStream fStream = new FileInputStream(filename);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				fStream));
		if (in.ready()) {
			ligne = in.readLine();
			nbrLigne = Integer.parseInt(ligne);
			String res[]=new String[nbrLigne];
			for (j = 0; j < nbrLigne; j++) {
				ligne = in.readLine();
				
				for (i = 0; i < ligne.length(); i++) {
						g+=bb.charAt(aa.indexOf(ligne.charAt(i)));
					}
				System.out.println("Case #"+(j+1)+": "+g);
				g="";
			}
		}
	}catch (IOException e) {
		System.out.println("File input error");
	}
	}
}
