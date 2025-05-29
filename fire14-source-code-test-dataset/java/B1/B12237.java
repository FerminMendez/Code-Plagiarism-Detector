import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class recycled {
	
	static int f_recycled(String s_min,String s_max){
		  int num_recycled=0;
		  int min=Integer.parseInt(s_min);
		  int max=Integer.parseInt(s_max);
		  
		  //System.out.println("______________________________________\nNúmeros reciclados entre "+s_min+" y "+s_max);
		  
		  if (max>10){

			  int cab_max=s_max.charAt(0);
			  int cab_min, num;
			  String string_v;
			  int i, j, final_v;
			  String string_final_v;
			  
			  List<Integer> soluciones_valor=new ArrayList<Integer>();
			  boolean enc;
			  
			  int v=min;
			  while(v<=max){
				  string_v=String.valueOf(v);
				  cab_min=Character.getNumericValue(string_v.charAt(0));				  
				  for(i=1;i<string_v.length();i++){
					  num=Character.getNumericValue(string_v.charAt(i));
					  if( num <= cab_max &&   // cambio de dígitos no es mayor que max
						  num >= cab_min  ){ // cambio de dígitos no es menor que el valor original
						  string_final_v=string_v.substring(i)+string_v.substring(0, i);
						  final_v=Integer.parseInt(string_v.substring(i)+string_v.substring(0, i)); // back + front
						  if(string_v.length()==string_final_v.length()  && min<=v && v<max && v<final_v && final_v<=max){
							  
							  //System.out.println((num_recycled+1)+" - ["+v+","+final_v+"]");
							  
							  enc=false;
							  for(j=0;j<soluciones_valor.size();j++){ // evitar soluciones capicua 1212
								  if(soluciones_valor.get(j)==final_v){
									  enc=true;
								  }
							  }
							  if(!enc){
								  soluciones_valor.add(final_v);
								  num_recycled++;
							  }
						  }
					  }
				  }
				  soluciones_valor.clear();
				  v++;
			  }
		  }
		  
		  //System.out.println("RESULTADO "+num_recycled+" \n");
		  
		  return num_recycled;
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
			total=f_recycled(numbers[0],numbers[1]);
			linew="Case #"+ntest+": "+total+"\n";
			out.write(linew);
			lines_r++;
		}
		out.close();
		fr.close();
	}
}
