import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Problema3 {
	static int caso=0;	
	static int valor=0;
	static String output="";
	static String thisline="";
	static String filesalida="/home/bryan/filenumbers";
	static String n1;
	static String n2;
	
	public static void analizar(String[] numbers){
		n1=numbers[0];
		n2=numbers[1];	
		valor=0;
		for(int x=Integer.parseInt(n1);x<=Integer.parseInt(n2);x++){
				runString(String.valueOf(x));		
		}	
		caso++;
		output+="Case #"+caso+": "+valor+"\n";
	}	
	
	public static void runString(String num){	
		for(int x=1;x<num.length();x++){
			String inic=num.substring(0, x);
			String from=num.substring(x, num.length());			
			if(Integer.parseInt(from+inic)>Integer.parseInt(num)){
				if(Integer.parseInt(inic+from)>=Integer.parseInt(n1)&&Integer.parseInt(inic+from)<=Integer.parseInt(n2)&&Integer.parseInt(from+inic)>=Integer.parseInt(n1)&&Integer.parseInt(from+inic)<=Integer.parseInt(n2)){
					valor++;
				}else{
					continue;
				}
			}			
		}		
	}
	
	public static void readFile(String filename){
		BufferedReader entrada;
		BufferedWriter salida;
		try {
		entrada = new BufferedReader(new FileReader(filename));
		entrada.readLine();
		while(entrada.ready()){
			String[] numbers;
			numbers=entrada.readLine().split(" ");
			analizar(numbers);			
		}
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(output);
		try {
			salida= new BufferedWriter(new FileWriter(filesalida));
			salida.write(output);
			 try {
	                if (salida != null) {
	                    salida.flush();
	                    salida.close();
	                }
			 } catch (IOException ex) {
	                ex.printStackTrace();
	            }  
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main (String args[]){
		System.out.print("file path: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		   try {
			   	 String userinput;
		         userinput = br.readLine();
		         readFile(userinput);
		      } catch (IOException ioe) {
		         System.out.println("IO error");
		         System.exit(1);
		      }   
		
	}	
}
