/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package speaking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

/**
 *
 * @author Marisol
 */
public class clsArchivo{
   
    private LinkedList<String> lista=new   LinkedList<String>();
    
    public  void clsArchivo(String src) {
        try {
            File file=new File(src);
            FileReader filereader = new FileReader(file);  
            BufferedReader buffer = new BufferedReader(filereader);
            String linea=buffer.readLine();
            
            lista.add(linea);
            while ((linea=buffer.readLine())!=null) {
                lista.add(linea);
            }   
        } catch (Exception e) {
            System.out.println("archivo incorrecto"); 
        }
    }
    
    public  LinkedList<Integer> progra (){
        String total = lista.get(0);//el primer elemento
        
        //Creamos un arreglo con los datos leidos
        LinkedList array = new LinkedList<Integer>();
        
        for (int i = 1; i < Integer.parseInt(total)+1; i++) {
            String linea=lista.get(i);//lectura de lineas
            String num[] = linea.split("\\s+");
            int res=0;
            int numero1 = Integer.parseInt(num[0]);
            int numero2 = Integer.parseInt(num[1]);
            
            for (int j = numero1; j < numero2; j++) {
                for (int k = j+1; k < numero2+1; k++) {
                    String uno = ""+j;
                    String dos = ""+k;
                    String pal1="";
                    if(uno.length() == dos.length()){
                        for (int l = 0; l < uno.length(); l++) {
                            String pal2= ""+uno.charAt(l);
                            if(dos.contains(pal1+pal2)==true){
                                pal1+=pal2;
                            }
                            else{
                                l=uno.length();
                            }
                        }
                        String pal4="";
                        for (int l = pal1.length(); l < dos.length(); l++) {
                            String pal3= ""+uno.charAt(l);
                            if(dos.contains(pal4+pal3)==true){
                                pal4+=pal3;
                            }
                            else{
                                l=dos.length();
                            }
                        }
                        String res1 =pal4+pal1;
                        
                        if(dos.equals(res1)==true){
                            //System.out.println(" "+ res1+ "  " +dos);
                            res++;
                        }
                    }
                }
            }
                        
            System.out.println("Case #"+ (i) +": "+res);
            array.add(res);
        }
        return array;
    }
    
}