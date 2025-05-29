import java.util.Scanner;


class DancingWithGooglers {

    Scanner s = new Scanner(System.in);
	
    public static void main(String args[]) {
	    DancingWithGooglers p = new DancingWithGooglers();
	    p.run();
	}
	
	void run() {
	    prepare();
	    int nCases = s.nextInt();
		for (int i=0; i<nCases; i++) {
			System.out.println("Case #"+(i+1)+": "+runOneCase());
		}
	}
	
	int[][] mTable = new int[31][2];
	
	void prepare() {
	    for (int i=1; i<=28; i++) {
		    mTable[i][0] = (i+2) / 3;
			mTable[i][1] = (i+4) / 3;
		}
		
		mTable[29][0] = 10;
		mTable[29][1] = 10;
		mTable[30][0] = 10;
		mTable[30][1] = 10;
	}
	
	int runOneCase() {
	    int N = s.nextInt();
		int S = s.nextInt();
		int P = s.nextInt();
		
		int count = 0;
		for (int i=0; i<N; i++) {
		    int score = s.nextInt();
			if (mTable[score][0] >= P) {
			    count++;
		    } else if (S>0 && mTable[score][1]>=P) {
			    count++;
				S--;
			}
		}
	    return count;
	}

}