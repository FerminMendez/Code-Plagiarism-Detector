
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class DancingGooglers {
    public static void main(String[] args) throws FileNotFoundException {
        int T;
        //Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new File("input.in"));
        T=sc.nextInt();

        for( int i=0;i<T;i++) {
            int N = sc.nextInt();
            int S = sc.nextInt();
            int p = sc.nextInt();
            int ti[]=new int[N];
            for(int j=0;j<N;j++) {
                ti[j]=sc.nextInt();
            }
            Arrays.sort(ti);
            int count=0;
            for(int j=N-1;j>=0;j--) {
                if(ti[j]/3>=p) {
                    count++;
                }
                else if(ti[j]==0) {
                    break;
                }
                else{
                    float temp = ((float) ti[j])/3;
                    if(p-temp<.9) {
                        count++;
                    }
                    else if(p-temp==1 || p-temp<1.4) {
                        if(S>0) {
                            count++;
                            S--;
                        }
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+count);
        }
 
    }
}
