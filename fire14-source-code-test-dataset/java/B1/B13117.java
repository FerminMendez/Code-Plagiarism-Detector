
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Problem C
 *
 * @author thomas
 */
public class RecycledNumbers {

    public static void main(String[] args) {
        String linea;
        try {
            FileReader fis = new FileReader("C-small-attempt0.in");
            BufferedReader buffer = new BufferedReader(fis);
            linea = buffer.readLine();
            int T = Integer.parseInt(linea.trim());
            int A, B;
            String[] aux;
            for (int caso = 1; caso <= T; caso++) {
                linea = buffer.readLine();
                aux = linea.split(" ");
                A = Integer.parseInt(aux[0]);
                B = Integer.parseInt(aux[1]);
                procesar(caso, A, B);
            }
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void procesar(int caso, int A, int B) {
//        System.out.println("Case #" + caso + ": " + A + " " + B);
        int numPair = 0;
        for (int N = A; N <= B; N++) {
            numPair += pairOf(N, B);
        }
        System.out.println("Case #" + caso + ": " + numPair);
    }

    public static void main_p(String[] args) {
//        pairOf(12345);
//        pairOf(101);
    }
    
    public static int pairOf(int N, int B) {
        ArrayList<Integer> pares = new ArrayList<Integer>();
        String sN = N + "";
        //Si es un solo digito no hay par
        if (sN.length() <= 1) {
            return 0;
        }

        //Evaluamos si el numero tiene los digitos iguales
        //En este caso el par es el mismo numero
        //Y como los pares no pueden ser iguales se descarta este caso
        
        boolean sameDigit = true;
        for (int i = 1; i < sN.length() && sameDigit; i++) {
            sameDigit = sN.charAt(i - 1) == sN.charAt(i);
        }
        if (sameDigit) {
            return 0;
        }


        //Comenzamos a buscar los pares
        String N1, N2;
        int split = 1;
        int M, numPair = 0;
        while (split < sN.length()) {
            N1 = sN.substring(0, split);
            N2 = sN.substring(split);
            M = Integer.parseInt(N2 + N1);
            //Si empieza en cero, ya los digitos no concuerdan
            //O Si M es mayor que B se sale del rango
            //O si N>=M no cumple con la restriccion A ≤ n < m ≤ B 
            if ((N2.indexOf("0") == 0) || (M > B) || (N>=M)) {
                split++;
                continue;
            }
            if(!pares.contains(M)){
                pares.add(M);
            }else{
                split++;
                continue;
            }
            numPair++;
            debug(sN + " => " + M + "[" + N1 + "-" + N2 + "]");

            split++;
        }
        return numPair;
    }

    public static void debug(Object obj) {
//        System.out.println(obj);
    }
}
