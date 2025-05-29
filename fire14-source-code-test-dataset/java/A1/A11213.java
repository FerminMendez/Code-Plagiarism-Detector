import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class IOGoogleCodeJam{
	public static ArrayList<String> fileInput(String fileName){
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<String> inputs= new ArrayList<String>();
		int lines;
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			file= new File (fileName);
			fr = new FileReader (file);
			br = new BufferedReader(fr);
			// Lectura del fichero
			while(br.ready()){
				inputs.add(br.readLine());
			}
		}catch(Exception e){
			e.printStackTrace();
	         }finally{
	         // En el finally cerramos el fichero, para asegurarnos
	         // que se cierra tanto si todo va bien como si salta 
	         // una excepcion.
	         try{                    
	            if( null != fr ){   
	               fr.close();     
	            }                  
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
		}
		return inputs;
	}
	
	public static void resultsOutput(ArrayList<String> args, int argsPerLine){
		int numArg=0;
		int maxNumber= args.size()/argsPerLine;
		for(int caseNumber=1;caseNumber<=maxNumber;caseNumber++){
			System.out.print("Case #"+caseNumber+": ");
			for(int i=1;i<=argsPerLine;i++){
				System.out.print(args.get(numArg)+" ");
				numArg++;
			}
			System.out.println();
		}
	}
}

