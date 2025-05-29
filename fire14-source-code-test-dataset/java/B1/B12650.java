//lukewillson
import java.io.PrintStream;
import java.io.File;
import java.util.Scanner;
public class C {    

    public static void main(String[] args) throws Exception {
        new DoC();
    }
}

class DoC {

    public DoC() throws Exception {
        //long time=System.currentTimeMillis();
        System.setOut(new PrintStream(new File("C.out")));
        Scanner sc = new Scanner(new File("C-small-attempt0.in"));
        int runs = Integer.parseInt(sc.nextLine());
        int run = 0;
        while (run++ < runs) {
            System.out.print("Case #" + run + ": ");
            int min=sc.nextInt();
            int max=sc.nextInt();
            int count=0;
            for(int i=min;i<=max;++i)
            {
                for(int j=i+1;j<=max;++j)
                {
                    if(recycle(i,j))
                        count++;
                }
            }
            System.out.println(count);
        }
        //System.out.println(System.currentTimeMillis()-time);
    }
    public boolean recycle(int A,int B)
    {
        String a=""+A;
        String b=""+B;
        for(int i=0;i<b.length();++i)
        {
            String temp=b.substring(i)+b.substring(0,i);
            if(a.equals(temp))
                return true;
        }
        return false;
    }
}
