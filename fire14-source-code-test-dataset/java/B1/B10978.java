/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.*;
/**
 *
 * @author vichugof
 */
public class CodeJam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String delimiter = " ";
        String[] cadenaNumero;
        
        try {
           
            archivo = new File ("C://C-small-attempt2.in");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            String linea;
            int numeroCasos = 0;
            
            linea=br.readLine();
            numeroCasos = Integer.parseInt(linea);
           
            int A=0;
            int B=0;
            int cantidadDigitosN = 0;
            int cantidadDigitosM = 0;
            
            String digitoDerecha = "";
            String digitoIzquierda = "";
            
            int numComparar = 0;
            int cantidadNumReciclabe = 0;
                    
            CodeJam objCodeJam = new CodeJam();
                     
            for(int idxCasos =0; idxCasos<numeroCasos; idxCasos++)
            {
                linea           = br.readLine();
                cadenaNumero    = linea.split(delimiter);

                A = Integer.parseInt(cadenaNumero[0]);
                B = Integer.parseInt(cadenaNumero[1]);
                
                cantidadNumReciclabe = 0;

                if(B > A)
                {
                    for(int idexN=A; idexN<B; idexN++)
                    {
                        for(int idexM=idexN+1; idexM<=B; idexM++)
                        {
                            cantidadDigitosN = objCodeJam.obtenerCantidadDigitos(idexN);

                            for(int idxCambioDigito = 0; idxCambioDigito<cantidadDigitosN-1; idxCambioDigito++)
                            {
                                digitoDerecha   = ""+objCodeJam.obtenerCantidadDigitosDerecha(idexN, idxCambioDigito);
                                digitoIzquierda = ""+objCodeJam.obtenerCantidadDigitosIzquierda(idexN, idxCambioDigito);

                                numComparar = Integer.parseInt(digitoDerecha+""+digitoIzquierda);

                                if(numComparar == idexM)
                                {
                                     //System.out.print(idexN+" : "+idexM+" - "+numComparar+" : "+idexM+" / ");
                                    cantidadNumReciclabe++;
                                    idxCambioDigito = cantidadDigitosN;
                                }
                            }
                        }
                    }
                }
                System.out.println("Case #"+(int)(idxCasos+1)+": "+cantidadNumReciclabe);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            }catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
    }
    
    public CodeJam()
    {
    }
    
    
    public int obtenerCantidadDigitos(int num)
    {
        int iCantidad = 0;
        int iTemp = num;

        while (iTemp>0)
        {    
            iTemp = iTemp/10;
            iCantidad++;
        }
        return iCantidad;
    }
    
    public int obtenerCantidadDigitosDerecha(int num, int numeroDigitos)
    {
        int cantidadCien    = 10;
        int numero          = num;
        
        for(int idxCien=0; idxCien<numeroDigitos; idxCien++)
        {
            cantidadCien = cantidadCien*10;
        }
        
        return numero%cantidadCien;
    }
    
     public int obtenerCantidadDigitosIzquierda(int num, int numeroDigitos)
     {
        int cantidadCien    = 10;
        int numero          = num;
        
        for(int idxCien=0; idxCien<numeroDigitos; idxCien++)
        {
            cantidadCien = cantidadCien*10;
        }

        return numero/cantidadCien;
     }
}