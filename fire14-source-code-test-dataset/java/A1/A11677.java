
package Qualification;
import Practice.*;
import java.util.*;
import java.io.*;

public class B {
    
    public void ejecutar() throws Exception {
        Scanner sc = new Scanner(new FileReader("/home/gomezluisj/Descargas/B.in"));
	PrintWriter pw = new PrintWriter(new FileWriter("/home/gomezluisj/Descargas/a.out"));
	int caseCnt = sc.nextInt();
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            pw.print("Case #" + (caseNum + 1) + ": ");
            int contestants=sc.nextInt();
            
            int surprising=sc.nextInt();
            int calculate=sc.nextInt();
            int res=0;
            int[][] arr=new int[contestants+1][2];
            for (int i = 0; i < contestants; i++) {
                int triplet=sc.nextInt();
                if(triplet==0)arr[i][0]=0;
                else arr[i][0]=triplet/3;
                arr[i][1]=triplet%3;               
            }
            int i=0;
            while(surprising>0&&i<contestants){
                int c=calculate-arr[i][0];
                if(c<1||c>2||arr[i][0]==0) i=i+1;
                else{
                    if((c==1&&arr[i][1]==0)||(c==2&&arr[i][1]==2)) {
                        surprising=surprising-1;
                        res=res+1;
                    }
                    i=i+1;
                }
            }
            for (int j = 0; j < contestants; j++) {
                int c=calculate-arr[j][0];
                if(c<1) res=res+1;
                if((c==1&&arr[j][1]==1)||(c==1&&arr[j][1]==2)) res=res+1;
            }
            pw.println(res);
            System.out.print(res);
        }	
        pw.flush();
        pw.close();
        sc.close();
    }
    
    
    public static void main(String[] args) throws Exception {
		new B().ejecutar();
	}
}
