import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class DancingWithTheGooglers {
	
	private static final String COMIENZO = "Case #";
	private static final char ESPACIO = ' ';
 
    public static void main(String args[])
    {
       File archivo = null;
  	   FileReader fr = null;
  	   BufferedReader br = null;
  	   FileWriter fichero = null;
	   PrintWriter pw = null;
        try{         
            DancingWithTheGooglers dancingWithTheGooglers = new DancingWithTheGooglers();
            archivo = new File ("/Users/tininho/Desktop/googlecodejam/B-small-attempt0.in");
   	     	fr = new FileReader (archivo);
   	     	br = new BufferedReader(fr);
   	     	
   	        fichero = new FileWriter("/Users/tininho/Desktop/googlecodejam/B-small-attempt0.txt");
	        pw = new PrintWriter(fichero);
   	   
            String linea=br.readLine();
            int lineasTotales=Integer.parseInt(linea);
            
            for(int i=0;i<lineasTotales;i++)
            {
                linea=br.readLine();
                pw.println(COMIENZO + (i+1) + ": " + dancingWithTheGooglers.votar(linea));
            }
            fr.close();
	    	fichero.close();
 
        }catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
    
    int votar(String mensaje){
	
    	String[] votaciones = mensaje.split(" ");
    	
    	int numeroGooglers = votaciones.length;
    	int numeroPuntuacionesSorp = Integer.parseInt(votaciones[1]);
    	int puntuacionMinima = Integer.parseInt(votaciones[2]);
    	
    	int votacion = 0;
    	int resto = 0;
    	int votacionMedia = 0;
    	int resultado=0;
    	for (int i = 3; i<numeroGooglers; ++i){
    		votacion = Integer.parseInt(votaciones[i]);
    		resto = votacion % 3;
    	    votacionMedia = votacion / 3;
    		if (resto ==0){
    			if (votacionMedia>=puntuacionMinima)
    				++resultado;
    			else{
    			   if (votacionMedia>0 && votacionMedia +1 >= puntuacionMinima && numeroPuntuacionesSorp>0){
    				   ++resultado;
    				   --numeroPuntuacionesSorp;
    			   }
    			}
    		}
    		
    		else if(resto == 1){
    			if ((votacionMedia+1) >= puntuacionMinima || votacionMedia>=puntuacionMinima){
    				++resultado;
    			}
    			else{
    			   if (votacionMedia +1 >= puntuacionMinima && numeroPuntuacionesSorp>0){
    				   ++resultado;
    				   --numeroPuntuacionesSorp;
    			   }
    			}
    		}else{
    			if ((votacionMedia+1) >= puntuacionMinima || votacionMedia>=puntuacionMinima){
    				++resultado;
    			}
    			else{
    			   if (votacionMedia +2 >= puntuacionMinima && numeroPuntuacionesSorp>0){
    				   ++resultado;
    				   --numeroPuntuacionesSorp;
    			   }
    			}
    		}
    	}
    	
    	return resultado;
    }
    
}
