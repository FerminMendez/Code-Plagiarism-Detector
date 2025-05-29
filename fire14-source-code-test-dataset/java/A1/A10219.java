package dancingwithgooglers;

import java.util.Scanner;

public class Main {

    static enum Mark {
        IMPOSSIBLE, SURPRISING, REGULAR;
    }

    static class Googler {
        
        private int total = 0;

        public Googler(int total)
        {
            this.total = total;
        }

        public Mark canGetMark(int mark)
        {
            if(mark > 10 || mark < 0) return Mark.IMPOSSIBLE;
            
            if(canGetMark(mark+1) == Mark.REGULAR) return Mark.REGULAR;

            if(mark + mark + mark == total) return Mark.REGULAR;
            if(mark > 0) if(mark + mark + mark - 1 == total) return Mark.REGULAR;
            if(mark > 0) if(mark + mark - 1 + mark - 1 == total) return Mark.REGULAR;
            if(mark < 10) if(mark + mark + mark + 1 == total) return Mark.REGULAR;
            if(mark < 10) if(mark + mark + 1 + mark + 1 == total) return Mark.REGULAR;

            if(canGetMark(mark+1) == Mark.SURPRISING) return Mark.SURPRISING;

            if(mark < 9) if(mark + mark + 1 + mark + 2 == total) return Mark.SURPRISING;
            if(mark < 9) if(mark + mark + 2 + mark + 2 == total) return Mark.SURPRISING;
            if(mark > 1) if(mark + mark - 1 + mark - 2 == total) return Mark.SURPRISING;
            if(mark > 1) if(mark + mark - 2 + mark - 2 == total) return Mark.SURPRISING;

            return Mark.IMPOSSIBLE;
        }

    }
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int testCase = 1; testCase <= T; testCase++)
        {
            int N = sc.nextInt();
            int S = sc.nextInt();
            int p = sc.nextInt();
            int result = 0;
            for(int i = 0; i < N; i++)
            {
                Googler googler = new Googler(sc.nextInt());
                Mark mark = googler.canGetMark(p);
                if(mark == Mark.REGULAR)
                {
                    result++;
                }
                else if(mark == Mark.SURPRISING && S > 0)
                {
                    result++;
                    S--;
                }
            }
            System.out.println("Case #"+testCase+": "+result);
        }
    }

}
