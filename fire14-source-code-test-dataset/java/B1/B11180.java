import java.util.Scanner;

public class Recycled{

    private Scanner input;

    public Recycled(){
        input = new Scanner(System.in);
    }

    public void run(){
        int T = input.nextInt();
        for(int i = 1; i<=T; i++){
            int A = input.nextInt();
            int B = input.nextInt();
            System.out.printf("Case #%d: %d\n",i,results(A,B));
        }
    }

    public int results(int A, int B){
        if(A == B)
            return 0;
        int result = 0;
        for(int m = B; m > A; m--){
            String mString = String.valueOf(m);
            for(int n = m-1; n >= A; n--){
                String nString = String.valueOf(n);
                for(int i = 1; i<nString.length(); i++){
                    String temp = nString.substring(i).concat(nString.substring(0,i));
                    if(mString.equals(temp)){
                        result++;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        Recycled object = new Recycled();
        object.run();
    }

}
