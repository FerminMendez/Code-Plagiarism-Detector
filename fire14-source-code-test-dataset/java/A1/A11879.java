
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class QB {
    public static void main(String[] args){
        try{
            Scanner sc = new Scanner(new File("B-small-attempt3.in"));    
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.out"))); 

            int t = sc.nextInt();
            for(int i=0;i<t;i++){
                int n = sc.nextInt();
                int s = sc.nextInt();
                int p = sc.nextInt();
                int[] scores = new int[n];
                for(int j=0;j<n;j++) scores[j] = sc.nextInt();
                Arrays.sort(scores);
                int r = 0;
                for(int j=n-1;j>=0;j--){
                    int k = scores[j]%3;
                    int m = scores[j]/3;
                    if(scores[j]==0) s = 0;
                    if(k==0){
                        if(m>=p) r += 1;
                        else if ((m+1>=p)&&(s>0)){
                            r += 1;
                            s -= 1;
                        }
                        else break;
                    }else if(k==1){
                        if(m+1>=p) r += 1;
                        else break;
                    }else{
                        if(m+1>=p) r += 1;
                        else if ((m+2>=p)&&(s>0)){
                            r += 1;
                            s -= 1;
                        }
                        else break;
                    }
                }
                bw.write("Case #"+String.valueOf(i+1)+": ");
                bw.write(String.valueOf(r));
                bw.newLine();
                bw.flush();
            }
            bw.close();

        } catch (Exception ex) {
            Logger.getLogger(QA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
