import java.util.*;
public class problemB
{
    public static void main(String[]args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for(int num=1;num<=N;num++)
        {
            int cnt = scanner.nextInt();
            int suprise = scanner.nextInt();
            int reach = scanner.nextInt();
            final int not = 2*(reach>=2?(reach-2):0)+reach;
            final int sup = 2*(reach>=1?(reach-1):0)+reach;
            int res = 0;
            int points[] = new int[cnt];
            for(int i=0;i<cnt;i++)
            {
                int point = scanner.nextInt();
                if(point<not)
                    continue;
                if(sup>point)
                {
                    if(suprise>0)
                        res++;
                    suprise--;
                    continue;
                }
                res++;
            }
            System.out.println("Case #"+num+": "+res);
        }
    }
}
