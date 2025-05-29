/*
 * @(#)CJ2012C.java
 * por Jorge López Palacios
 *
 * Más información y descripción del Copyright©.
 *
 */

/**
 * Clase CJ2012C
 * @author Jorge López Palacios
 * @version 1.0
 */

//***************** PACKAGES ****************************//
package codejam;
//***************** IMPORTS *****************************//
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class CJ2012C {
    //***************** CONSTANTES ****************************//
    private static final String SPATHFILEINPUT = "C:\\C-small-attempt0.in";
    private static final String SPATHFILEOUTPUT = "C:\\CJ2012C.txt";
    //***************** ATRIBUTOS *****************************//
    private static BufferedReader brBuffer;
    private static String sFileLine = "";
    private static PrintWriter pwFileOutput;
    //***************** METODOS SELECTORES ********************//

    //***************** METODOS MODIFICADORES *****************//

    //***************** CONSTRUCTORES *************************//

    //***************** MAIN **********************************//
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int iNumberCases = 0;
        int iCurrentLine = 0;

        int aiNumbers[] = new int[2];
        String asNumbers[] = new String[2];
        String sDummy = "";
        String sNNormal = "";
        //String sNBackward = "";
        int iCountRecycled = 0;
        //String sBackwardDummy = "";

        try{
            // Recogemos los datos del fichero
            brBuffer = getFileToString(SPATHFILEINPUT);

            // Recogemos el fichero de salida
            pwFileOutput = getFile();
            
            // Leemos cada línea del fichero
            while((sFileLine = brBuffer.readLine()) != null){
                // Inicializo el contador de números reciclados
                iCountRecycled = 0;

                // Recojo el número de casos
                if(iCurrentLine == 0){
                    iNumberCases = Integer.parseInt(sFileLine);
                }else{
                    // Recojo los números
                    asNumbers = sFileLine.split(" ");
                    aiNumbers = new int[asNumbers.length];

                    for(int i = 0; i <= asNumbers.length - 1; i ++){
                        aiNumbers[i] = Integer.parseInt(asNumbers[i]);
                    }

                    // Recojo todos los números de A hasta B
                    for(int n = aiNumbers[0]; n <= aiNumbers[1]; n ++){
                        // Recojo todos los números de B hasta A
                        for(int m = aiNumbers[1]; (m > n); m --){
                            // Compruebo si la combinacion (n, m) es de números reciclados
                            sNNormal = n + "";

                            for(int i = 0; (i <= sNNormal.length() - 1); i ++){
                                sDummy = sNNormal.substring((sNNormal.length() - i), sNNormal.length()) + sNNormal.substring(0, (sNNormal.length() - i));

                                if((Integer.parseInt(sDummy) == m) && ((Integer.parseInt(sDummy) + "").length() == (m + "").length())){
                                    iCountRecycled ++;
                                }
                            }
                        }
                    }
                }

                if(iCurrentLine == 0){
                    System.out.println("Numero de casos: " + iNumberCases);
                }else{
                    printToFile("Case #" + iCurrentLine + ": " + iCountRecycled);
                    //System.out.println("Case #" + iCurrentLine + ": " + iCountRecycled);
                }

                // Incrementamos el número de línea
                iCurrentLine ++;
            }
            //Cerramos el buffer del fichero
            closeInputStream(brBuffer);
        }catch (Throwable th){
            System.err.println("Error: " + th.toString());
        }
    }
    //***************** METODOS PÚBLICOS **********************//

    //***************** METODOS PRIVADOS **********************//
    /**
     * Devuelve los datos de un fichero indicado por parametro
     *
     * @param ai_sPathFile: Ruta del fichero
     * @throws IOException
     */
    private static BufferedReader getFileToString(String ai_sPathFile) throws IOException{
        // Abrimos el fichero
        FileInputStream fisFile = new FileInputStream(ai_sPathFile);

        // Recojo los datos del fichero
        DataInputStream disData = new DataInputStream(fisFile);
        brBuffer = new BufferedReader(new InputStreamReader(disData));

        return brBuffer;
    }

    /**
     * Cierra el buffer del fichero
     *
     * @param ai_bfrBuffer
     * @throws IOException
     */
    private static void closeInputStream(BufferedReader ai_bfrBuffer) throws IOException{
        if(ai_bfrBuffer != null){
            ai_bfrBuffer.close();
        }
    }

    /**
     * Recoge el fichero de salida en memoria
     *
     * @throws FileNotFoundException
     */
    private static PrintWriter getFile() throws FileNotFoundException{
	pwFileOutput = new PrintWriter(SPATHFILEOUTPUT);
	return pwFileOutput;
    }

    /**
     * Escribe en el fichero de salida
     *
     * @param ai_sText
     */
    public static void printToFile(String ai_sText){
        // Escribo en el fichero
        pwFileOutput.append(ai_sText);
        pwFileOutput.println();
        // Cierro el fichero
        pwFileOutput.flush();
    }

}//FIN DE LA CLASE