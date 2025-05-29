import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;


public class C {

	
	
	
	public static void main(String[] args)throws Exception {
		Scanner sc = new Scanner(new File("C-small-attempt1.in"));
		PrintWriter pw = new PrintWriter(new File("outputC.out"));
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int min = sc.nextInt();
			int max = sc.nextInt();
			long conteo=0;		
			for (int j = min; j <= max; j++) {
				conteo+=contarReps(j,min,max);
			}
			pw.println("Case #"+(int)(i+1)+": "+(int)(conteo/2));
		}
		pw.close();
	}
	
	static long contarReps(int num,int min,int max){
		StringBuffer strNum = new StringBuffer(""+num);
		StringBuffer strNumO = new StringBuffer(""+num);
		HashMap<String,String> mapa = new HashMap();
		mapa.put(""+num,""+num);
		String str;
		int rev;
		long count=0;
		for (int i = 0; i < strNum.length()-1; i++) {
			strNum.append(strNum.charAt(0));
			strNum.deleteCharAt(0);
			rev = Integer.parseInt(strNum.toString());
			str = strNum.toString();
			if(mapa.get(str)==null){
				mapa.put(str, str);
				if(rev>=min && rev<=max && rev!=num)
					count++;
			}
		}
		return count;
	}
	
	static int compare(StringBuffer bf1, StringBuffer bf2){
		for (int i = 0; i < bf1.length(); i++) {
			if(bf1.charAt(i)>bf2.charAt(i)){
				return 1;
			}else if(bf1.charAt(i)<bf2.charAt(i)){
				return -1;
			}
		}
		return 0;
	}
}
