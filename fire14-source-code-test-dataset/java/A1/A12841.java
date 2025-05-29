
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Wilmer
 */
public class main {
    int numeroCasos;

    public void leerArchivo(File archivo) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader (archivo);
        BufferedReader br = new BufferedReader(fr);

        String linea = br.readLine();
        numeroCasos = Integer.parseInt(linea.trim());

        String[] datos = null;
        int resultado = 0;
        int googlers=0;
        int numeroDeSorpresas = 0;        
        int objetivo = 0;

        int puntajeActual=0;
        int validos = 0;
        int validoSorpresa = 0;
        int noValidoSorpresa = 0;
        int sorpresasPorEncontrar=0;

        for(int i=1; i<=numeroCasos; i++){

            linea = br.readLine();
            datos = linea.split(" ");

            googlers = Integer.parseInt(datos[0]);
            numeroDeSorpresas = Integer.parseInt(datos[1]);
            objetivo = Integer.parseInt(datos[2]);

            puntajeActual=0;
            validos = 0;
            validoSorpresa = 0;
            noValidoSorpresa = 0;
            sorpresasPorEncontrar=0;

            
            for(int j = 3; j<googlers+3; j++){
                
                puntajeActual = Integer.parseInt(datos[j]);
                
                if( puntajeActual >= ((objetivo*3)-2) ){
                    validos++; 
                }else{
                    if( puntajeActual < ((objetivo*3)-2) && puntajeActual >= ((objetivo*3)-4) && puntajeActual>1){
                        validoSorpresa++; 
                    }else{
                        if(puntajeActual>1){
                            noValidoSorpresa++;
                        }
                    }
                }
            }

            //System.out.println(validos+"*"+validoSorpresa+"*"+noValidoSorpresa+"*-*"+numeroDeSorpresas);
            
            //sorpresasPorEncontrar = sorpresasPorEncontrar - noValidoSorpresa;

            if(validoSorpresa > numeroDeSorpresas && numeroDeSorpresas>=0){
                validoSorpresa = numeroDeSorpresas;
            }

            resultado = validos + validoSorpresa;
            
            System.out.println("Case #"+i+": "+resultado);

        }
    }


    public static void main(String[] args) throws FileNotFoundException, IOException{

        File archivo = new File("B-small-attempt0.in");
        main m = new main();
        m.leerArchivo(archivo);
    }

}
