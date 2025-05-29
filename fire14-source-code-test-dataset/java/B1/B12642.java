import java.util.*;
class Main {	
	static Scanner in = new Scanner(System.in);
	static Set<String> set = new HashSet<String>();
	
	public static void serie(int n, int m){
		for(int i=n;i<=m;i++){
			String a = i+"";
			int len = a.length()-1;
			for(int k=len;k>=1;k--){
				String res = a.substring(k, len+1) + a.substring(0, k);
				int val = Integer.parseInt(res);
				if((val+"").length() == (i+"").length() && val<=m && i<val){
					set.add(i+","+val);
				}
			}
		}
	}
	public static void resolve(){
		int n,m;
		set = new HashSet<String>();
		n = in.nextInt(); m = in.nextInt();
		serie(n,m);	
		
	}
	public static void main(String arg[]){
		int n;
		n = in.nextInt();
		for(int i=0;i<n;i++){
			resolve();
			System.out.println("Case #"+(i+1)+": " + set.size());
		}
	}
}

/*
4
1 9
10 40
100 500
1111 2222
*/
