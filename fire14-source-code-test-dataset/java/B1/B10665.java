
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author yilianz
 */
public class RecycleNumber{

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

            int A = inFile.nextInt();
            int B = inFile.nextInt();
            int count =0;


            //Read the total point
            for(int n = A; n<=B; n++){

            	//check all the recycle of n to see whether it satisfies the condition
            	String nS = Integer.toString(n);
            	int l = nS.length();
            	int flag = 0 ;  //check whether m repeat
            	int[] c = new int[l];
            	for (int k=0; k<l;k++) c[k]=-1;

            	if (l==1) break;
            	for(int k=0;k<l;k++){
            		String mS=nS.substring(k+1,l)+nS.substring(0,k+1);
            		int m = Integer.parseInt(mS);
            		if (k==0) c[k]=m;
            		else{
            			for(int s = 0; s<k;s++){
            				if(m==c[s]) flag=1;
            			}
            		}
            		if (m >n && m<=B && flag==0){
            			count++;
            			//System.out.println(count);
            			//System.out.println("("+n+","+m+")");
            			c[k]=m;
            			flag=0;
            		}

            	}


            }

            System.out.println("Case #"+i+": "+count);
            outFile.println("Case #"+i+": "+count);
        }

        //close the file
         inFile.close();
         outFile.close();



       }
}
