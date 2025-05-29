import java.util.HashSet;
import java.util.Scanner;


public class c {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new c().go();
	}

	private void go() {
		Scanner in=new Scanner(System.in);
		int numc=in.nextInt();
		for(int cnum=1;cnum<=numc;cnum++){
			int a=in.nextInt(),b=in.nextInt(),ans=0;
			for(int n=a;n<=b;n++){
				String ns=""+n;
				HashSet<Integer> temp=new HashSet<Integer>();
				for(int i=0;i<ns.length()-1;i++){
					ns=ns.substring(ns.length()-1)+ns.substring(0,ns.length()-1);
					int m=Integer.parseInt(ns);
					if(m>n&&m<=b&&!temp.contains(m)){
						ans++;
						temp.add(m);
					}
				}
			}
			System.out.printf("Case #%d: %d\n", cnum,ans);

		}
		
	}

}
