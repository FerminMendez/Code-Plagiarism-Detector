/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Recycled;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pablo Quiñones
 */
public class Recycled {

    public static int min;
    public static int max;
    public static int times = 0;
    public static Map<String, List<String>> mapa = new HashMap<String, List<String>>();
    //public static 

    public static void VerificarMap() {

        List<String> repetidos = new ArrayList<String>();
        //List<String> reps = new ArrayList<String>();
        for (int i = min; i <= max; i++) {
            for (String s : mapa.get((i + ""))) {
                System.out.println((i + "") + "..num: " + s);
                String copia = Integer.parseInt(s) + "";
                if (Integer.parseInt(s) >= min && Integer.parseInt(s) <= max && !repetidos.contains(s) && copia.length() == (i + "").length() ) {
                    System.out.println("S.." + s);
                    times++;
                    repetidos.add(i + "");
                    
                }
            }
        }

    }


    public static void Reciclados(String x, List<String> numeros) {

        String copia = x;
        int tam = x.length();
        String mod = "";
        
        for(int i=0; i<x.length(); i++)
                mod += "1";
        
        
        if (x.length() > 2) {
            for (int i = 1; i < x.length(); i++) {
                //System.out.println(copia+"..pedazo1: "+copia.substring(copia.length()-i));
                //System.out.println(copia+"..pedazo2: "+copia.replace(copia.substring(copia.length()-i), ""));
                String cadena = x.substring(tam - i) + x.substring(0,tam-(i));
                //System.out.println(x+"..char_ " + cadena);
                if(Integer.parseInt(cadena) % Integer.parseInt(mod) != 0 && !cadena.equals(x))
                        numeros.add(cadena);

            }
        } else {
            if (x.length() == 2) {
                String st = (x.charAt(1) + "") + (x.charAt(0) + "");
                //System.out.println("char_ " + st);
                if (Integer.parseInt(st) % 11 != 0) {
                    numeros.add(st);
                }
            }
        }



    }

    public static void CalcularNumerosReciclados() {

        times = 0;
        List<String> numeros = new ArrayList<String>();
        for (int i = min; i <= max; i++) {
            //permuteNumber("", i + "",i+"",numeros);  
            Reciclados(i + "", numeros);
            mapa.put(i + "", new ArrayList<String>(numeros));

            numeros.clear();
        }


    }

    public static void main(String[] args) {

        try {
            String file1 = "C:\\Users\\Pablo\\Desktop\\CodeJamFiles\\C-small-attempt0.in";


            FileInputStream fstream = new FileInputStream(file1);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();

            File file = new File("C:\\Users\\Pablo\\Desktop\\CodeJamFiles\\write2C.in");
            Writer output = new BufferedWriter(new FileWriter(file));


            int cases = Integer.parseInt(strLine);

            int total = cases + 1;
            boolean tiene;
            while (cases > 0) {

                String[] linea = br.readLine().split(" ");
                min = Integer.parseInt(linea[0]);
                System.out.println("min: " + min);
                max = Integer.parseInt(linea[1]);
                CalcularNumerosReciclados();
                VerificarMap();
                
                
                System.out.println("Times: " + times);
                output.write("Case #"+(total-cases)+": "+times+"\n");
                cases--;
                mapa.clear();
                times = 0;
            }
            
            output.close();

        } catch (Exception e) {
        }



    }
}
