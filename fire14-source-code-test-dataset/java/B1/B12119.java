package es.salamanca.google;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ángel Alfonso Gómez
 */
public class Recycled {
    public static void main(String[] args) {
        BufferedReader bf;
        FileReader fl;
        FileWriter f2;
        
        try {
            fl = new FileReader("C:\\C-small-attempt2.in");
            f2 = new FileWriter("C:\\C-small-attempt2.out");
            bf = new BufferedReader(fl);
            int num = Integer.parseInt(bf.readLine());
            System.out.println(num);
            for (int i = 0; i < num; i++) {
                int cont=0;
                f2.append("Case #"+(i+1)+": ");
                System.out.print("Case #"+(i+1)+": ");
                String linea = bf.readLine();
                int num1 = Integer.parseInt(linea.substring(0, linea.indexOf(" ")));
                int num2 = Integer.parseInt(linea.substring(linea.indexOf(" ")+1));
                for (int j=num1;j<num2;j++) {
                    for(int k=j+1;k<(num2+1);k++)
                       if (Recycled(j,k)) cont++;
                }
                
                f2.append(Integer.toString(cont));
                f2.append("\r\n");
                System.out.println(cont);
            }
            f2.close();
            fl.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Speaking.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(Speaking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Boolean Recycled(int n,int m) {
        String num1 = Integer.toString(n);
        String num2 = Integer.toString(m);
        for (int i=0;i<(num1.length()-1);i++) {
            String sub = num1.substring(i+1).concat(num1.substring(0, i+1));
            if (sub.equals(num2)) {
                return true;
            }
        }
        return false;
    }
}
