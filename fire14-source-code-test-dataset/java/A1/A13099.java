import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class b {
	public static void main(String[] args){
		new b().go();
	}

	private void go() {
		Scanner in=new Scanner(System.in);
		int numc=in.nextInt();
		for(int cnum=1;cnum<=numc;cnum++){
			int n=in.nextInt(),s=in.nextInt(),p=in.nextInt();
			ArrayList<Integer>a=new ArrayList<Integer>();
			for(int i=0;i<n;i++)a.add(in.nextInt());
			Collections.sort(a,Collections.reverseOrder());
			int count=0;
			for(int i:a){
				if((i+2)/3>=p&&i>=p)count++;
				else if(s>0&&(i+4)/3>=p&&i>=p){
					count++;
					s--;
				}
			}
			System.out.printf("Case #%d: %d\n", cnum,count);
		}
	}

}