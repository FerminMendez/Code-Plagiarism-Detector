/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package google_jamp_c;
import java.io.*;
import java.util.*;
/**
 *
 * @author sabri
 */

public class Google_jamp_c {

    /**
     * @param args the command line arguments
     */
public static int recycled (int A, int B){
                int m = 0, c=0;
                String tmp = "", subB = "", subE = "", recycled = "";
                for (int n = A; n<B;n++)
                {
                        tmp = String.valueOf(n);
                        for (int j=0;j<tmp.length();j++)
                        {
                            subB = tmp.substring(0,j);
                            subE = tmp.substring(j);
                            recycled = subE+subB;
                            m = Integer.parseInt(recycled);
                            if ((m>n) && (m<=B)) 
                             {c++;}
                        }
                }
                return c;
        }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String ligne = "";
        int nbrLigne = 0,res,a,b;
        StringTokenizer st1;
        FileInputStream fStream = new FileInputStream("A-small-attempt.in");
		BufferedReader in = new BufferedReader(new InputStreamReader(fStream));
                if (in.ready()) {
			ligne = in.readLine();
			nbrLigne = Integer.parseInt(ligne);
      			for (int j = 0; j < nbrLigne; j++) {
				ligne = in.readLine();
                                st1=new StringTokenizer(ligne," ");
                                 a=Integer.parseInt(st1.nextToken());
                                  b=Integer.parseInt(st1.nextToken());
				System.out.print("Case #"+(j+1)+": ");
                                res=recycled(a,b);
                                System.out.print(res);
                          System.out.println("");
			}
		}
    }
}
