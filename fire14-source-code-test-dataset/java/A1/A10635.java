
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author yilianz
 */
public class DancingGoogler{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{

        // Read file
        Scanner inFile = new Scanner(new File("file.in"));
        PrintWriter outFile = new PrintWriter(new File("out.file"));

        int caseN =inFile.nextInt();


        // TODO code application logic here
        for(int i = 1; i<caseN+1; i++){

            int N = inFile.nextInt();
            int S = inFile.nextInt();
            int P = inFile.nextInt();
            int MaxP = 0;

            //Read the total point
            for(int j = 0; j<N; j++){
                int ti = inFile.nextInt();
                if (ti >= 3*P-2) {
                    MaxP++;
                }
                else if( ti >= 3*P - 4){

                	if (S>0 &&P!=1){
                		S--;
                		MaxP++;
                	}
                }
            }

            System.out.println("Case #"+i+": "+MaxP);
            outFile.println("Case #"+i+": "+MaxP);
        }

        //close the file
         inFile.close();
         outFile.close();



       }
}
