import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class B {

	int ref;
	
	int[] scores = new int[3];
	
	int max1=0;
	
	int max2=0;
	
		
	public B(int ref, int suma) {
		super();
		this.ref = ref;
		scores[0] = suma/3;
		suma-=scores[0];
		scores[1] = suma/2;
		scores[2] = suma-scores[1];
		max1 = scores[2]>=ref?1:0;	
		if (suma>=2 && suma <= 28)
			max2 = (scores[2]+1)>=ref?1:0;
		else
			max2=-1;
		//System.out.println(Arrays.toString(scores));
		/*if(ref==scores[0])
			max2--;
		if(scores[1]>=ref)
			max2++;
		if((scores[2]+1)>=ref)
			max2++;
		int tmpMax = 0;
		if(ref==scores[0])
			tmpMax--;
		if(scores[1]+1>=ref)
			tmpMax++;
		if((scores[2])>=ref)
			tmpMax++;
		if(tmpMax>max2)
			max2=tmpMax;
			*/		
	}



	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("inputb.in"));
		PrintWriter pw = new PrintWriter(new File("outputb.out"));
		int cases = sc.nextInt();
		for (int i = 0; i < cases; i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int ref = sc.nextInt();
			B[] scores = new B[n];
			boolean[] excep = new boolean[n];
			for (int j = 0; j < n; j++) {
				scores[j] = new B(ref,sc.nextInt());
			}
			for (int j = 0; j < s; j++) {
				int max = -10;
				int index = -1;
				for (int k = 0; k < excep.length; k++) {
					if(excep[k])
						continue;
					if(scores[k].max2-scores[k].max1 > max){
						max = scores[k].max2-scores[k].max1;
						index = k;
					}
				}
				excep[index]=true;
			}
			int res=0;
			for (int j = 0; j < excep.length; j++) {
				if(excep[j])
					res+=scores[j].max2;
				else
					res+=scores[j].max1;
			}
			//System.out.println(Arrays.toString(excep));
			pw.println("Case #"+(int)(i+1)+": "+res);
			
		}
		pw.close();
	}
	
	
}
