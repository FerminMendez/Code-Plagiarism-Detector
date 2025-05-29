import java.util.Scanner;

/**
 *
 * @author Yasura
 */
public class B {

    public static void main(String[] args) {
        Scanner scanInt= new Scanner(System.in);
        int noOfCases = scanInt.nextInt();
        int N,S,p,t,max;
        for(int i=0;i<noOfCases;i++){
            N=scanInt.nextInt();
            S=scanInt.nextInt();
            p=scanInt.nextInt();
            max=0;
            for(int j=0;j<N;j++){
                t=scanInt.nextInt();
                if(t%3==0){
                    if(t/3>p-1){
                        max++;
                    }
                    else if((t/3==p-1)&&S!=0&&t>2){
                        max++;
                        S--;
                    }
                }
                else if(t%3==1 && (t+2)/3>p-1){
                    max++;
                }
                else if (t%3==2){
                    if((t+1)/3>p-1){
                        max++;
                    }
                    else if ((t+1)/3==p-1&&S!=0){
                        max++;
                        S--;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+max);
        }
    }
}
