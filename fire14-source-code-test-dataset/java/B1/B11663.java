package recycled;
import java.io.*;
import java.util.StringTokenizer;
import java.util.HashSet;

class Solucionar{
    int buscar(String base, String techo){
        int ret = 0;
        HashSet<Integer> cjto = new HashSet<Integer>();
        
        if ((base.length() == techo.length())||(base.length()==1)){
            int tam = (int) Math.pow(10 , base.length() - 1);
            int veces = base.length() - 1;
            
            int inicio = Integer.parseInt(base);
            int fin =  Integer.parseInt(techo);
            
            for (int i=inicio;i<fin;i++){
                int original = i;
                int numero = i;
                
                for (int h=0;h<veces;h++){
                    int cabeza = numero / tam;
                    int cola = numero % tam;
                    numero = cabeza + cola*10;
                    if  (  (original >= inicio)
                           && ( numero > original)
                            && ( fin >= numero)
                         ) 
                    {   
                        int ingresar = 10000 * original + numero;
                        if (! cjto.contains(ingresar))
                        {  //System.err.println(original + " + " + numero);
                           ret++;
                           cjto.add(ingresar);
                        }
                    }
                    
                }
                
            }
            
            
            
            //System.err.print(tam);
        }
        
        return ret;
    }
}
public class Recycled{
    public static void main(String[] args) throws Exception{
        Solucionar s = new Solucionar();
        s.buscar("1111", "2222");
        
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);
        
        String linea;
        linea = br.readLine();
        int casos = Integer.parseInt(linea);
        
        for (int i=0;i<casos;i++){
            linea = br.readLine();
            StringTokenizer tk = new StringTokenizer(linea);
            String base = tk.nextToken();
            String techo = tk.nextToken();
            int ret = s.buscar(base, techo);
            System.out.println("Case #"+ (i+1) + ": " + ret );
        }
        
    }
}
