import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int t = -1, s = 0, p = 0, n = 1, cont = 0, aux = 0, aux_res = 0, num_lin = 1;
		List<Integer> ti = new ArrayList<Integer>();
		List<Integer> puntajesNoElegidos = new ArrayList<Integer>();
		try{
			  FileInputStream fstream = new FileInputStream("C:\\Users\\Joel\\Desktop\\B-small-attempt1.in");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));			  
			  FileWriter fwstream = new FileWriter("C:\\Users\\Joel\\Desktop\\out.txt");
			  BufferedWriter out = new BufferedWriter(fwstream);
				  
			  String strLine;
			  while ((strLine = br.readLine()) != null)   {
				  s = 0; 
				  p = 0; 
				  n = 1;
				  cont = 0;
				  aux_res = 0;
				  ti = new ArrayList<Integer>();
				  puntajesNoElegidos = new ArrayList<Integer>();
				  if(t == -1){
					  t = Integer.valueOf(strLine);
				  }
				  else{
					  for(String str : strLine.split(" ")){
						  switch (cont) {
							case 0:
								n = Integer.valueOf(str);
								break;
							case 1:
								s = Integer.valueOf(str);
								break;
							case 2:
								p = Integer.valueOf(str);
								break;							
							default:
								ti.add(Integer.valueOf(str));
								break;
						  }	
						  cont ++;
					  }	
					  
					  for(Integer total : ti){
						  aux = total / 3;
						  if(aux > p){
							  aux_res++;
						  }
						  else{
							  if(total % 3 == 0){
								  if(aux == p){
									  aux_res++;
								  }
								  else{
									  puntajesNoElegidos.add(total);
								  }
							  }
							  else{
								  if(aux == p || aux + 1 == p){
									  aux_res++;
								  }
								  else{
									  puntajesNoElegidos.add(total);
								  }
							  }
						  }						  						 
					  }
					  for(Integer total : puntajesNoElegidos){
						  aux = total / 3;
						  if(s == 0){
							  break;
						  }
						  else if(total % 3 == 0 && aux != 0){
							  if(aux + 1 == p){
								  aux_res++;
								  s--;
							  }							 
						  }
						  else if(total % 3 == 2){
							  if(aux + 2 == p && aux != 0){						 
								  aux_res++;
								  s--;
							  }							 
						  }
					  }
					  
					  out.write("Case #" + num_lin + ": " + aux_res);
					  out.newLine();
					  num_lin++;
				  }
			  }				 
			  in.close();
			  out.close();
		}
		catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
}

