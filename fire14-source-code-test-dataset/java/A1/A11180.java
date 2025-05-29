/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancinggooglers;

import java.io.*;

/**
 *
 * @author Oscar
 */
public class DancingGooglers {
    
    public static String resolver(String[] parametros) {
        int num = Integer.parseInt(parametros[0]);
        int especial = Integer.parseInt(parametros[1]);
        int objetivo = Integer.parseInt(parametros[2]);
        if(objetivo == 0)
            return Integer.toString(num);
        int min_1 = objetivo * 3 - 2;
        int min_2 = objetivo * 3 - 4;
        if(objetivo == 1)
            min_2 = 1;
        int encontrados = 0;
        for(int i = 0; i < num; i++) {
            int actual = Integer.parseInt(parametros[3 + i]);
            if(actual >= min_1) {
                encontrados++;
                continue;
            }
            if(actual >= min_2 && especial > 0) {
                especial--;
                encontrados++;
            }
        }
        return Integer.toString(encontrados);
    }
    public static void main(String[] args) throws Exception {
        System.out.println("?");
        BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
        String tipo = lector.readLine().trim();
        BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(tipo + ".in")));
        BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tipo + ".out")));
        int casos = Integer.parseInt(entrada.readLine());
        int contador = 1;
        while(casos > 0) {
            String[] parametros = entrada.readLine().split(" ");
            salida.write("Case #" + contador + ": " + resolver(parametros) + "\n");
            contador++;
            casos--;
        }
        salida.close();
        System.out.println("Fin");
    }
}
