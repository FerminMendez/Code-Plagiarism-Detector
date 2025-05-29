
import java.util.*;

class Main {
	
	
    public static void main( String[ ] args ) {
    	Scanner in=new Scanner(System.in);
    	int cin=in.nextInt();
    	for (int ci=1;ci<=cin;ci++){
    		int a=in.nextInt(),b=in.nextInt();
    		int ans=0;
    		for (int i=a;i<b;i++){
    			HashSet<Integer> la=new HashSet<Integer>();
    			int ttmp=1;
    			int tmp=10;
    			int tgmp=10;
    			while (tgmp<=i){
    				tgmp*=10;
    			}
    			while (i>tmp){
    				tgmp/=10;
    				int m=i%tmp*tgmp+i/tmp;
    				if (m>i&&m<=b&&i%tmp>=ttmp) {la.add(m);}
    				ttmp=tmp;
    				tmp*=10;
    			}
    			ans+=la.size();
    		}
    		System.out.println("Case #"+ci+": "+ans);
    	}
    }
}
 