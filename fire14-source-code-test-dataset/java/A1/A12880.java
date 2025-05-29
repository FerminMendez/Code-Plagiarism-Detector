
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author utp
 */
public class B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        //System.setIn(new FileInputStream("B.in"));
        Scanner sc = new Scanner(System.in);
        int nCasos = sc.nextInt();
        for(int caso = 1; caso <= nCasos; caso++)
        {
            int n = sc.nextInt();
            int sor = sc.nextInt();
            int p = sc.nextInt();
            int buenos = 0;
            int nSor = 0;
            for(int i = 0; i < n; i++)
            {
                int valor = sc.nextInt();
                int media = valor / 3;
                if(valor % 3 == 0 && (p == 0 || valor != 0))
                {
                    if(p <= media)
                        buenos++;
                    else if(p <= media + 1 && nSor != sor)
                    {
                        buenos++;
                        nSor++;
                    }
                }
                else if(valor % 3 == 1)
                {
                    if(p <= media + 1)
                        buenos++;
                }
                else if(valor % 3 == 2)
                {
                    if(p <= media + 1)
                        buenos++;
                    else if(p <= media + 2 && nSor != sor)
                    {
                        buenos++;
                        nSor++;
                    }
                }
            }
            System.out.println("Case #" + caso + ": " + buenos);
        }
    }
}
