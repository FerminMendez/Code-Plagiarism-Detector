import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author rama
 */
public class Codejam1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=Integer.parseInt(in.nextLine());
        for(int i=1;i<=n;++i)
            //trans(in.nextLine());
        System.out.println("Case #"+i+": "+trans(in.nextLine()));    
        //String input = reader.readLine();
    }
    
    public static int trans(String ss){
        int ans=0;
        int temp;
        int ok=0,srp=0;
        StringTokenizer tok=new StringTokenizer(ss," ");
        int n=Integer.parseInt(tok.nextToken());
        int s=Integer.parseInt(tok.nextToken());
        int p=Integer.parseInt(tok.nextToken());
        for(int i=1;i<=n;++i){
            temp=Integer.parseInt(tok.nextToken());
            int l=temp-(3*p);
            if(l>=-2)
                ++ok;
            if(l<-2&&l>=-4&&temp>=2)
                ++srp;
        }
        ans=ok+Math.min(srp,s);
        return ans;
    }
}

