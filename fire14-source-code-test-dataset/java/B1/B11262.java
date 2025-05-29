import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();
	int caseNum = 0;

	while(caseNum++<T){

	    int A = sc.nextInt();
	    int B = sc.nextInt();

	    int ans = 0;
	    for(int i=A; i<B; i++){
		for(int j=i+1; j<=B; j++){
		    String n = Integer.toString(i);
		    String m = Integer.toString(j);
		    int nlen = n.length();
		    for(int k=0; k<nlen; k++){
			n = n.substring(nlen-1,nlen)+n.substring(0,nlen-1);
			if(n.equals(m)){
			    ans++; break;
			}
		    }
		}
	    }

	    System.out.println("Case #"+caseNum+": "+ans);
	}
    }
}