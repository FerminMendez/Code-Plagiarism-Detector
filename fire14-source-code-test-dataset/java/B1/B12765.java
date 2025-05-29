import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (FileReader file = new FileReader("entrada.in"); Scanner scanner = new Scanner(file)) {
            int T,A,B,i,j,k=0,total=0; 
            String xs;
            T=scanner.nextInt();
            boolean matriz[][] = new boolean[1000][];
            for (i=0;i<1000;i++)
                matriz[i] = new boolean[1000];
            System.setOut(new PrintStream("salida.out"));
            for (i=1;i<=T;i++){
                for (j=0;j<1000;j++)
                    Arrays.fill(matriz[j], false);
                A=scanner.nextInt();
                B=scanner.nextInt();
                for (j=A;j<=B;j++){
                     xs=Integer.toString(j);
                     if (xs.length()==2 && xs.charAt(1)!='0'){
                         k=Integer.parseInt(xs.charAt(1)+""+xs.charAt(0));
                         if (j!=k && k<=B && k>=A)
                            matriz[j][k]=true;
                     }
                     if (xs.length()==3 && xs.charAt(2)!='0'){
                         k=Integer.parseInt(xs.charAt(2)+""+xs.charAt(0)+""+xs.charAt(1));
                         if (j!=k && k<=B && k>=A)
                            matriz[j][k]=true;
                     }
                     if (xs.length()==3 && xs.charAt(1)!='0'){
                         k=Integer.parseInt(xs.charAt(1)+""+xs.charAt(2)+""+xs.charAt(0));
                         if (j!=k && k<=B && k>=A)
                            matriz[j][k]=true;
                     }
                }
                total=conteomatriz(matriz);
                System.out.println("Case #"+i+": "+total);
            }
        }
        
    }
    public static int conteomatriz(boolean[][] m){
        int total=0,i,j;
        for (i=0;i<1000;i++){
            for (j=0;j<1000;j++){
                if (m[i][j]){
                    m[j][i]=false;
                    //System.out.println(i+" "+j);
                    total++;
                }
            }
        }
        return total;
    }
    
}
