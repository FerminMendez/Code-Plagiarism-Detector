import java.util.*;
public class b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String ss = sc.nextLine();
		int casenum = Integer.parseInt(ss);
		String answer = "";
		for(int i = 1;i<=casenum;i++){
			answer = answer.concat("Case #".concat(Integer.toString(i)).concat(": "));
			ss = sc.nextLine();
			String wer = recycledpair(ss);
			answer = answer.concat(wer);
			answer = answer.concat("\n");
		}
		System.out.print(answer);
	}
	
	public static String recycledpair(String a){
		int n = Integer.parseInt(a.substring(0, a.indexOf(' ')));
		int m = Integer.parseInt(a.substring(a.indexOf(' ')+1, a.length()));
		int nlength = a.substring(0, a.indexOf(' ')).length();
		int pairnum = 0;
		String rcp ="";
		for(int i=n; i<m; i++){
			LinkedList<Integer> mylist = new LinkedList<Integer>();
			String sn = Integer.toString(i);
				//a.substring(0, a.indexOf(' '));
			for(int j=1; j<sn.length(); j++){
				String newnum = sn.substring(j,sn.length()).concat(sn.substring(0,j));
				int newint = Integer.parseInt(newnum);
				if(newint>i&&newint<=m){
					if(!mylist.contains(newint)){
					pairnum++;
					mylist.add(newint);
					}
					else{
						mylist.add(newint);
					}
				}
			}
		}
		String snumreturn = Integer.toString(pairnum);
		//System.out.print(snumreturn);
		return snumreturn;
	}
}
