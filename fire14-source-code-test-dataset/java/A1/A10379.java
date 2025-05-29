package bsmall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Bsmall {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int numLinhas = -1;
		Vector<String> linhas = new Vector<String>();
			
		try {
			
			BufferedReader input = new BufferedReader(new FileReader("./src/bsmall/B-small-attempt0.in"));
			
			String linha;
			
			while((linha = input.readLine()) != null){
				if(numLinhas == -1) numLinhas = Integer.parseInt(linha);
				else linhas.add(linha + " ");
			}
			
			input.close();
		
			BufferedWriter output = new BufferedWriter(new FileWriter(new File("output.txt"))); 
			
			for(int i = 0; i < numLinhas; i++){
				
				int numCase = i+1;
				
				output.write("Case #" + numCase + ": ");
				
				char[] letras = linhas.get(i).toCharArray();
				
				String tmp = null;
				
				int N = -1;
				int S = -1;
				int p = -1;
				Vector<Integer> notes = new Vector<Integer>();
				
				for(int j=0; j<letras.length; j++){
					
					if( letras[j] != ' ' ) {
						if(tmp == null) tmp = Character.toString(letras[j]);
						else tmp = tmp+Character.toString(letras[j]);
					}
					else{
						
						int num = Integer.parseInt(tmp);
						tmp = null;
						if( N == -1) N = num;
						else if ( S == -1 ) S = num;
						else if ( p == -1 ) p = num;
						else notes.add(num);
//						System.out.println(num);
						
					}
					
				}
				
//				System.out.println(N + " " + S + " " + p);
//				System.out.println(notes.get(0));
				
				Vector<Integer> bom = new Vector<Integer>();
				Vector<Integer> surprising = new Vector<Integer>();
				
				for( int k = 0; k < notes.size(); k++){
					
					if(notes.get(k) >= p*3 - 2) bom.add(notes.get(k));
					else if( notes.get(k) >= p*3 - 4 && notes.get(k) > 1) surprising.add(notes.get(k));
					
				}
				
//				System.out.println(bom.size() + " " + surprising.size());
				
				int result = bom.size() + Math.min(surprising.size(), S);
				
				output.write(String.valueOf(result));
				output.newLine();
			
			}

		

			output.close();
			
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
