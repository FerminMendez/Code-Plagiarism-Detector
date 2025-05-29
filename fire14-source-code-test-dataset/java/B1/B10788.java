import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class C {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		
		for(int zz = 1; zz <= T;zz++){
			Integer A = in.nextInt();
			Integer B = in.nextInt();
			Set<String> result = new HashSet<String>();
			for(Integer i=A;i<=B;i++){
				char[] num = i.toString().toCharArray();
				for(int j= 0;j<num.length;j++){
					char x = num[num.length-1];
					for(int k= num.length-1;k>0;k--){
						num[k] = num[k-1];
					}
					num[0] = x;
					String newStr = new String(num);
					if(!newStr.startsWith("0") && !newStr.equals(i.toString())){
						Integer newNum = new Integer(new String(num));
						if(newNum>=A && newNum <=B){
							result.add(i.toString()+newStr);
							result.add(newStr+i.toString());
						}
					}
				}
			}
			System.out.format("Case #%d: %d\n", zz, result.size()/2);
		}
	}

}
