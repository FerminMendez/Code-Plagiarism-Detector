/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

/**
 *
 * @author eblanco
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JFileChooser;

public class RecycledNumbers {

    public static String DatosArchivo[] = new String[10000];

    public static int[] convertStringArraytoIntArray(String[] sarray) throws Exception {
        if (sarray != null) {
            int intarray[] = new int[sarray.length];
            for (int i = 0; i < sarray.length; i++) {
                intarray[i] = Integer.parseInt(sarray[i]);
            }
            return intarray;
        }
        return null;
    }

    public static boolean CargarArchivo(String arch) throws FileNotFoundException, IOException {
        FileInputStream arch1;
        DataInputStream arch2;
        String linea;
        int i = 0;

        if (arch == null) {
            //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
            int rc = fc.showDialog(null, "Select a File");
            if (rc == JFileChooser.APPROVE_OPTION) {
                arch = fc.getSelectedFile().getAbsolutePath();
            } else {
                System.out.println("No hay nombre de archivo..Yo!");
                return false;
            }
        }
        arch1 = new FileInputStream(arch);
        arch2 = new DataInputStream(arch1);
        do {
            linea = arch2.readLine();
            DatosArchivo[i++] = linea;
            /* if (linea != null) {
            System.out.println(linea);
            }*/
        } while (linea != null);
        arch1.close();
        return true;
    }

    public static boolean GuardaArchivo(String arch, String[] Datos) throws FileNotFoundException, IOException {
        FileOutputStream out1;
        DataOutputStream out2;
        int i;
        out1 = new FileOutputStream(arch);
        out2 = new DataOutputStream(out1);

        for (i = 0; i < Datos.length; i++) {
            if (Datos[i] != null) {
                out2.writeBytes(Datos[i] + "\n");
            }
        }
        out2.close();
        return true;
    }

    public static void echo(Object msg) {
        System.out.println(msg);
    }

    public static void main(String[] args) throws IOException, Exception {
        String[] res = new String[10000], num = new String[2];
        int i, j, k, ilong;
        int ele = 1;
       ArrayList al = new ArrayList();
        String FName = "C-small-attempt0",  istr, irev, linea;
        if (CargarArchivo("C:\\eblanco\\Desa\\CodeJam\\Code Jam\\test\\" + FName + ".in")) {
            for (j = 1; j <= Integer.parseInt(DatosArchivo[0]); j++) {
                linea = DatosArchivo[ele++];
                num = linea.split(" ");
                   al.clear();
                // echo("A: "+num[0]+" B: "+num[1]);
                for (i = Integer.parseInt(num[0]); i <= Integer.parseInt(num[1]); i++) {
                    istr = Integer.toString(i);
                    ilong = istr.length();
                 
                    for (k = 1; k < ilong; k++) {
                        if (ilong > k) {
                            irev = istr.substring(istr.length() - k, istr.length()) + istr.substring(0, istr.length() - k);
                            //echo("caso: " + j + ": isrt: " + istr + " irev: " + irev);
                            if ((Integer.parseInt(irev) > Integer.parseInt(num[0])) && (Integer.parseInt(irev) > Integer.parseInt(istr)) && (Integer.parseInt(irev) <= Integer.parseInt(num[1]))) {
                                al.add("(" + istr + "," + irev + ")");
                            }
                        }
                    }
                }
                HashSet hs = new HashSet();
                hs.addAll(al);
                al.clear();
                al.addAll(hs);
                res[j] = "Case #" + j + ": " + al.size();
                echo(res[j]);
                LeerArchivo.GuardaArchivo("C:\\eblanco\\Desa\\CodeJam\\Code Jam\\test\\" + FName + ".out", res);
            }
        }
    }
}
