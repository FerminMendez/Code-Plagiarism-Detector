

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class DancingWithGooglers {

    public static void main(String[] args) {
        
       try {
            BufferedReader lector = new BufferedReader(new FileReader(args[0]));
            int iterations = Integer.parseInt(lector.readLine());


            int numOfGooglers = 0;
            int surprisingScores = 0;
            int requestedPunctuation = 0;
            int googlersWithPunct= 0;
            int googlerPunctuation = 0;
            int mediumPunctuation = 0;
            int restPuntuaction = 0;
            
            String linea = null;
            String[] values = null;

            for (int idx=1; idx <= iterations; idx++) {
                //Obtenemos la línea actual o caso a trata
                linea = lector.readLine();

                //Obtenemos los valores de la línea actual
                values = linea.split("\\s");

                //Obtenemos el número de bailadores
                numOfGooglers = Integer.parseInt(values[0]);
                //Obtenemos el número de puntuaciones sorprendentes
                surprisingScores = Integer.parseInt(values[1]);
                //Obtenemos la puntuación máxima
                requestedPunctuation = Integer.parseInt(values[2]);
                    
                //Para este caso ponemos los resultados a 0
                googlersWithPunct = 0;
                
                //Hacemos el tratamiento específico para cada bailador
                for (int i=0; i<numOfGooglers ; i++)
                {
                    //Obtenemos la puntuación actual del concursante
                    googlerPunctuation = Integer.parseInt(values[i+3]);
                    
                    if (googlerPunctuation >= requestedPunctuation) {
                        //Determinamos si el concursante puede haber obtenido la nota mínima
                        mediumPunctuation = googlerPunctuation / 3;
                        restPuntuaction = googlerPunctuation % 3;

                        //Si la media de puntuación es igual o mayor a la puntuación máxima ya sabemos que ese concursante lo cumple
                        if (mediumPunctuation >= requestedPunctuation) {
                            googlersWithPunct++;
                        }
                        else {

                            if (surprisingScores == 0) {
                                //Si no puede haber resultados sorprendentes

                                if (restPuntuaction != 0 && (mediumPunctuation + 1 == requestedPunctuation)) {
                                    googlersWithPunct++;
                                }
                            }
                            else {
                                //Si aun puede haber sorprendentes
                                if (restPuntuaction == 1 && (mediumPunctuation + 1 == requestedPunctuation)) {
                                    googlersWithPunct++;
                                }
                                else if (restPuntuaction == 2 && (mediumPunctuation + 2 >= requestedPunctuation)) {
                                    googlersWithPunct++;
                                    surprisingScores--;
                                }
                                else if (restPuntuaction == 0 && (mediumPunctuation + 1 >= requestedPunctuation)) {
                                    googlersWithPunct++;
                                    surprisingScores--;
                                }
                            }
                        }
                    }
                }

                System.out.printf("Case #%d: %s\n", idx, googlersWithPunct);
                
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error:: Juego de pruebas no pasado por línea de comandos");
        }
        catch (IOException ex) {
            System.out.println("Error:: Se ha producido un error en el procesamiento del archivo");
        }
    }

}
