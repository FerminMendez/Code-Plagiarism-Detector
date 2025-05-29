import java.util.*;
import java.io.*;

public class DanceGooglers{
  public static void main(String[] args){
    try{
      FileReader fin = new FileReader(args[0]);
      BufferedReader txtFile = new BufferedReader(fin);
    
      //FileWriter fout = new FileWriter(args[1]);
      //BufferedWriter out = new BufferedWriter(fout);
			
      String line = null;     
      line = txtFile.readLine();
      int T = Integer.parseInt(line);
      //System.out.println(T);
      for(int i = 0; i < T; i ++){
        line = txtFile.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int[] ts = new int[N];
        for(int i1 = 0; i1 < N; i1 ++)
            ts[i1] = Integer.parseInt(st.nextToken());
            
        int[][] notSurp = new int[N][3];
        int[][] surp = new int[N][3];
        boolean[] outOfRange = new boolean[N]; 
        for(int i1 = 0; i1 < N; i1 ++){
            int num = ts[i1];
            if(num % 3 == 0){
                notSurp[i1][0] = num/3; notSurp[i1][1] = num/3; notSurp[i1][2] = num/3;
                surp[i1][0] = num/3-1; surp[i1][1] = num/3; surp[i1][2] = num/3+1;
                if(surp[i1][0] < 0 || surp[i1][2] > 10)
                    outOfRange[i1] = true; 
                else
                    outOfRange[i1] = false; 
            }
            if(num % 3 == 1){
                notSurp[i1][0] = num/3; notSurp[i1][1] = num/3; notSurp[i1][2] = num/3+1;
                surp[i1][0] = num/3-1; surp[i1][1] = num/3+1; surp[i1][2] = num/3+1;
                if(surp[i1][0] < 0 || surp[i1][2] > 10)
                    outOfRange[i1] = true; 
                else
                    outOfRange[i1] = false; 
            }
            if(num % 3 == 2){
                notSurp[i1][0] = num/3; notSurp[i1][1] = num/3+1; notSurp[i1][2] = num/3+1;
                surp[i1][0] = num/3; surp[i1][1] = num/3; surp[i1][2] = num/3+2;
                if(surp[i1][2] > 10)
                    outOfRange[i1] = true; 
                else
                    outOfRange[i1] = false; 
            }
        }//for(int i1 = 0; i1 < N; i1 ++)
        
        int result = 0;
        for(int i1 = 0; i1 < N-1; i1 ++){
            for(int i2 = i1 + 1; i2 < N; i2 ++){
                if(surp[i1][2] > surp[i2][2]){
                    int tmp = surp[i1][0];
                    surp[i1][0] = surp[i2][0];
                    surp[i2][0] = tmp;
                    
                    tmp = surp[i1][1];
                    surp[i1][1] = surp[i2][1];
                    surp[i2][1] = tmp;
                    
                    tmp = surp[i1][2];
                    surp[i1][2] = surp[i2][2];
                    surp[i2][2] = tmp;
                    
                    tmp = notSurp[i1][0];
                    notSurp[i1][0] = notSurp[i2][0];
                    notSurp[i2][0] = tmp;
                    
                    tmp = notSurp[i1][1];
                    notSurp[i1][1] = notSurp[i2][1];
                    notSurp[i2][1] = tmp;
                    
                    tmp = notSurp[i1][2];
                    notSurp[i1][2] = notSurp[i2][2];
                    notSurp[i2][2] = tmp;
                    
                    boolean tmp2 = outOfRange[i1];
                    outOfRange[i1] = outOfRange[i2];
                    outOfRange[i2] = tmp2;                    
                }
            }//for
        }//for
        
        /*for(int i1 = 0; i1 < N; i1 ++){
            System.out.println(surp[i1][0]+" "+surp[i1][1]+" "+surp[i1][2]);
            System.out.println(notSurp[i1][0]+" "+notSurp[i1][1]+" "+notSurp[i1][2]);
        }*/
        
        int k = 1;
        for(int i1 = N-1; i1 >= 0; i1 --){
            if(k <= S && surp[i1][2] >= p && notSurp[i1][2] < p && outOfRange[i1] == false){
                result ++;
                k ++;
            }
            else if(notSurp[i1][2] >= p){ 
                result ++;
            }
        }
        
        System.out.println("Case #"+Integer.toString(i+1)+": "+Integer.toString(result));
        
        
      }//for(int i = 0; i < T; i ++)
    }//try
    catch(IOException e) {
	e.printStackTrace();
    }
    
    
  }
}
