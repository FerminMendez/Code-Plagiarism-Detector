import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


public class QualB {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {

		Scanner sc = new Scanner(new File("E:/inp.txt"));
		PrintWriter pr = new PrintWriter(new File("E:/out.txt"));
		int tc=sc.nextInt();
		int cnt=0;
		for(int i=1;i<=tc;i++){
			int n=sc.nextInt();
			int sup=sc.nextInt();
			int p=sc.nextInt();
			cnt=0;
			for(int j=1;j<=n;j++){
				int pt=sc.nextInt();
				if(pt==0){
					if(p==0)cnt++;
				}
				else if(pt!=0 && pt%3==0){
					int t=pt/3;
					if(p<=t){
						cnt++;
					}
					else if (sup>=1 && p-t==1){
						cnt++;
						sup--;
					}
				}
				else if(pt!=0 && pt%3!=0){
					int t=pt/3;
					if(p<=t+1){
						cnt++;
					}
					else if (sup>=1 && p-t==2){
						cnt++;
						sup--;
					}
				}
			}
			pr.printf("Case #%d: %d%n", i,cnt);
		}
		sc.close();
		pr.close();

	}
	
}
