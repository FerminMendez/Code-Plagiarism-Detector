import java.util.Scanner;
import java.io.File;

public class Main{
    public static void main(String[] args) throws Exception{
        Scanner s = new Scanner(new File("C-small-attempt0.in"));
        int test = Integer.parseInt(s.nextLine());
        for(int i=1; i<=test; i++){
            int a = s.nextInt();
            int b = s.nextInt();
            int pairs = 0;
            for(int n=a; n<b; n++){
                for(int m=n+1; m<=b; m++){
                    boolean rotation = isRotation(String.valueOf(n), String.valueOf(m));
                    if(rotation)
                        pairs++;
                }
            }
            System.out.println("Case #"+i+": "+pairs);
        }
    }
    
    static boolean isRotation(String s1,String s2) {
        return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
    }
}
