import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Dancing_improved {
	
	static int f_Superan_limites(String params){
		  int superan_limite=0;
		  String[] parametros=params.split(" ");
		  
		  int n_participantes= Integer.parseInt(parametros[0]);
		  int n_sorprendidos= Integer.parseInt(parametros[1]);
		  int nota_limite= Integer.parseInt(parametros[2]);
		  
		  int suma_notas, resto, nota_juego;
		  for(int i=3;i<parametros.length;i++){ // Recorro las sumas de los participantes
			  
			  suma_notas=Integer.parseInt(parametros[i]);
			  resto=suma_notas%3;
			  
			  if(resto==0){ // el resto es el número triplicado!
				  nota_juego=suma_notas/3;
				  if(nota_juego>=nota_limite){
					  superan_limite++;
				  }else if(nota_juego-1>=0 && n_sorprendidos>0 && ((nota_juego+1)>=nota_limite || (nota_juego+2)>=nota_limite)){ // no supera el límite pero podría hacerlo si quedan sorprendidos
					  n_sorprendidos--;
					  superan_limite++;
				  }
			  }else if((suma_notas+1)%3==0){ // Tendré que jugar con el valor en +-1
				  nota_juego=(suma_notas+1)/3;
				  if(nota_juego-1>=0 && nota_juego>=nota_limite){
					  superan_limite++;
				  }else if(nota_juego-1>=0 && n_sorprendidos>0 && (nota_juego+1)>=nota_limite){
					  n_sorprendidos--;
					  superan_limite++;
				  }
			  }else if((suma_notas+2)%3==0){ // Tendré que jugar con el valor en +-2
				  nota_juego=(suma_notas+2)/3;
				  if(nota_juego-1>=0 && nota_juego>=nota_limite){
					  superan_limite++;
				  }		  
			  }			  
		  }
		  return superan_limite;
	}
	
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader(args[0]);
		BufferedReader bf = new BufferedReader(fr);
		int ntest=0;
		
		FileWriter fstream = new FileWriter("out.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		
		String lines = bf.readLine();
		String liner, linew;
		int lines_r=0;
		String[] numbers;
		int total;
		
		while((liner = bf.readLine())!=null && lines_r<=Integer.parseInt(lines)) {
			ntest++;
			numbers=liner.split(" ");
			total=f_Superan_limites(liner);
			linew="Case #"+ntest+": "+total+"\n";
			out.write(linew);
			lines_r++;
		}
		out.close();
		fr.close();
	}
}
