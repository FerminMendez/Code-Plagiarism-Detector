import static java.lang.Math.*;
import static java.util.Arrays.*;
import java.io.*;
import java.util.*;

public class B {
    int[][] allno=new int[31][2];
	Scanner sc;

	void solve(int caseID) {
    	int res=0;
    	int n=sc.nextInt();
    	int s=sc.nextInt();
    	int p=sc.nextInt();
    	int[] nos=new int[n];
    	for(int i=0;i<n;i++)
    	    nos[i] = sc.nextInt();
    	for(int i=0;i<n;i++)
    	{
        	if(allno[nos[i]][0]>=p)
        	  res++;
            else if(s>0 && allno[nos[i]][1]>=p)
            {
                res++;
                s--;
            }
        }
         System.out.println(""+res);
	}

	void run() {
		long time = System.currentTimeMillis();
     	update();
		sc = new Scanner(System.in);
		int caseN = sc.nextInt();
		for (int caseID = 1; caseID <= caseN; caseID++) {
			//double t = (System.currentTimeMillis() - time) * 1e-3;
			//if (!SAMPLE) System.err.printf("%03d/%03d %.3f/%.3f%n", caseID, caseN, t, t / (caseID - 1) * caseN);
			System.out.printf("Case #%d: ", caseID);
			solve(caseID);
			System.out.flush();
		}
	}

	void update()
	{
    	int rem;
    	int no;
        for(int i=1;i<=30;i++)
        {
            rem=i%3;
            no=i/3;
            switch(rem)
            {
                case 0:
                  allno[i][0]=no;
                  allno[i][1]=no+1;
                  break;
                case 1:
                  allno[i][0]=no+1;
                  allno[i][1]=no+1;
                  break;
                case 2:
                  allno[i][0]=no+1;
                  allno[i][1]=no+2;
                  break;
            }
        }
    }

	void debug(Object...os) {
		System.err.println(deepToString(os));
	}

	public static void main(String[] args) {
			try {
				System.setIn(new FileInputStream("B.in"));
				System.setOut(new PrintStream(new FileOutputStream("B.out")));
			} catch (IOException e) {
			}
		new B().run();
	}

}