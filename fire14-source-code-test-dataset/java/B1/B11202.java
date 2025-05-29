
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.Integer;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class RecycledNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.in"));
        //Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();

        for( int i=0;i<T;i++) {
            int count =0;
            int A = sc.nextInt();
            int B = sc.nextInt();
            int n = A;
            for(n=A;n<B;n++) {
                int l = Integer.toString(n).length();
                int n2=n;
                int n5=1;
               TreeSet<Integer> L = new TreeSet<Integer>();
                for(int j=1;j<l;j++){
                    n5=n5*10;
                }
                for(int j=1;j<l;j++) {
                    int n3=n2/10;
                    int n4=n2%10;
                    n2=n5*n4+n3;
                   
                    if(n2>n && n2<=B) {
                        if(!L.contains(n2)) {
                            L.add(n2);
                            count ++;
                        }
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+count);
        }
    }
}
