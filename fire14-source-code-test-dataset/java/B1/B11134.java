import java.util.Scanner;

public class Problem3 {
    public static void main(String args[]){
        Scanner in= new Scanner(System.in);
        Scanner rin= new Scanner(in.nextLine());
        int T = rin.nextInt();
        for(int l=0;l<T;l++){
            rin= new Scanner(in.nextLine());
            int lower = rin.nextInt();
            int upper = rin.nextInt();
            int count=0;
            while(lower<upper){
                for(int m=lower+1;m<=upper;m++){
                    if(isRecycledPair(lower,m)){
                        count++;
                    }
                }
                lower++;
            }
            System.out.println("Case #"+(l+1)+": "+count);
        }
        
    }
    
    static String rightRotateString(String str){
        char strC[]=str.toCharArray();
        int i=0;
        char temp=strC[strC.length-1];
        for(i=strC.length-1;i>0;i--){
            strC[i]=strC[i-1];
        }
        strC[i]=temp;
        return (new String(strC));
    }
    
    static boolean isRecycledPair(int n,int m){
        String nS=Integer.toString(n);
        String mS=Integer.toString(m);
        if(nS.matches(mS))
            return true;
        for(int i=0;i<nS.length()-1;i++){
            nS=rightRotateString(nS);
            if(nS.matches(mS)){
                return true;
            }
        }
        return false;
    }
}