import java.util.Scanner;

public class CodeJamQC {
    static Scanner keyboard=new Scanner(System.in);
    public static void main(String[] args) {
        int num=keyboard.nextInt();
        for(int x=0; x<num; x++){
            int a=keyboard.nextInt(), b=keyboard.nextInt(), output=0;
            for(int y=a; y<b; y++){
                String ys=""+y;
                int length=ys.length();
                boolean[] usados=new boolean[b-y+1];
                for(int z=0; z<length; z++){
                    int numero=Integer.parseInt(ys.substring(z)+ys.substring(0, z));
                    if(numero>y&&numero<=b&&!usados[numero-y]){
                        output++;
                        usados[numero-y]=true;
                    }
                }
            }
            System.out.println("Case #"+(x+1)+": "+output);
        }
    }
}