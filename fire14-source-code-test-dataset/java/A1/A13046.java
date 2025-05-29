import java.awt.datatransfer.StringSelection;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Дмитрий
 * Date: 14.04.12
 * Time: 16:41
 * To change this template use File | Settings | File Templates.
 */
public class Problem{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new FileOutputStream("result.txt"));


        int cc = in.nextInt();
        in.nextLine();
        for(int zz=1;zz<=cc;++zz){
            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();

            int res = 0;

            for(int i=0;i<n;++i){
                int t = in.nextInt();
                if (p==0)
                    res++;
                else if (p==1) {
                    if(t>0)
                        res++;
                }
                else {
                    int p1,p2;
                    p1 = p-1;
                    p2 = p-2;
                    if (p+p1+p1<=t){
                        res++;
                    } else if (s>0 && p+p2+p2<=t){
                        res++;
                        --s;
                    }
                }
            }

            out.println("Case #"+zz+": "+res);
        }
        out.close();
    }
}
