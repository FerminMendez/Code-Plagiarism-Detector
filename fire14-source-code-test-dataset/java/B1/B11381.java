import java.util.LinkedList;
import java.util.Scanner;
public class problemC
{
    static final int until = 1000;
    static LinkedList<Integer> res[] = new LinkedList[until+1];
    static Object speed[][] = new Object[until+1][];
    public static void main(String []args)
    {
        for(int i=1;i<=until;i++)
            GO(i);
        for(int i=1;i<=until;i++)
            speed[i] = res[i].toArray();
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int num=1;num<=N;num++)
        {
            int ret = 0;
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            for(int i=A;i<=B;i++)
            {
                int len = res[i].size();
                for(int j=0;j<len;j++)
                    if(((Integer)speed[i][j])<=B)
                        ret++;
            }
            System.out.println("Case #"+num+": "+ret);
        }
    }
    public static void GO(int num)
    {
        res[num] = new LinkedList<Integer>();
        String str = Integer.toString(num);
        int len = str.length();
        for(int i=0;i<len;i++)
        {
            str = str.substring(1,len)+str.charAt(0);
            int rev = new Integer(str);
            if(!res[num].contains(rev) && rev>num)
                res[num].add(rev);
        }
    }
}
