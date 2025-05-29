import java.util.Scanner;
import java.util.TreeMap;


public class RecycledNumbers {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		//Read in the T int -- Test Cases
		int T = Integer.parseInt(sc.nextLine());
		for (int t = 1; t <= T; t++) {
			int num = 0;
			//START OF CODE
			int a = sc.nextInt();
			int b = sc.nextInt();
			int focus = a;
			
			for (int i = 0; focus < b; i++) {
				String f = focus + "";
				boolean distinct = true;
				/*all:for (int j = 0; j < f.length(); j++) {
					for (int j2 = j+1; j2 < f.length(); j2++) {
						if(f.charAt(j) == f.charAt(j2)){
							distinct = false;
							break all;
						}
					}
				}
				distinct = true;*/
				if(distinct){
					for (int j = 0; j < f.length() - 1; j++) {
						f = f.charAt(f.length()-1) + f.substring(0,f.length()-1);
						int fs = Integer.parseInt(f);
						if(fs <= b && f.charAt(0) != '0' && fs > focus){
							//System.out.println(focus+ " "+ f);
							num++;
						}
					}	
				}
				
				focus++;
			}
			//END OF CODE
			//OUTPUT
			System.out.format("Case #%d: %d\n", t, num);
		}
	}
}
