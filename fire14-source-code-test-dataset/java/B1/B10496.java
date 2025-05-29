
import java.io.*;
import java.util.*;
public class RecycledNumbers{
	public static void main(String[] args)throws Exception{
	    String file = "C-small-attempt0";
       BufferedReader br = new BufferedReader(new FileReader(file + ".in"));
       FileWriter archivo = new FileWriter(file+".out");
       PrintWriter printer = new PrintWriter(archivo);
       printer.flush();
	   int n,a,b,aux,cont,tamano,auxiliar,cont2;
	   String aux2,aux3,aux4;
	   boolean probar;
	   int []  v = new int[2000000];
	    String []  s = new String[2000000];
	   StringBuffer cadena;
	   StringTokenizer st;
	   String line;
	   line=br.readLine();
	   n=Integer.parseInt(line);
	   for(int i=0;i<n;i++){
	   	cont=0;
	   	cont2=0;
	   	line=br.readLine();
	   	st= new StringTokenizer(line);
	   a=Integer.parseInt(st.nextToken());
	   b=Integer.parseInt(st.nextToken());
	   aux=a;
	   for(int j=0;j<=(b-a);j++){
	   	v[j]=aux;
	   	s[j]=v[j]+"";
	   	aux++;
	   }
	   tamano=s[0].length();
	   probar=true;
	    for(int j=0;j<=(b-a);j++){
	    	String[] arrayletra = s[j].split("");
	    	
	    	for(int e=j+1;e<=(b-a);e++){
	             String[] arrayletra2 = s[e].split("");
	             cont=0;
	             		for(int k=1;k<=tamano;k++){
	             				for(int u=1;u<=tamano;u++){
	             					if(arrayletra[k].equals(arrayletra2[u])){
	             						cont++;
	             						arrayletra2[u]="a";
	             						break;
	             							
	             					}
	              	
	                            }
	             			}
	         if(cont==tamano){
	         	//System.out.println("se cumplio, encontro "+s[e]+" en "+s[j]);
	         	String[] arrayletra3 = s[e].split("");
	         	 aux4="";
	         	 aux3="";
	         	 for(int k=1;k<tamano+1;k++){
	         	 	aux4=s[j].substring (k, tamano); 
	         	    aux3=s[j].substring (0, k); 
	         	 	  aux4=aux4+aux3;
	         	 	  if(aux4.equals(s[e])){
	         	 	  	cont2++;
	         	 	  	break;
	         	 	  }
	         	 }
	         	
	         }
	       
	         }
	   	
	    }
	   printer.println("Case #"+(i+1)+": "+cont2);
	   }
		 br.close();
		printer.close();
        System.exit(0);	
	}
	
}
