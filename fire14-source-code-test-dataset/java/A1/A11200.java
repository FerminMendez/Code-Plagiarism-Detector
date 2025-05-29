import java.util.*;

public class Main{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);

	int T = sc.nextInt();
	int caseNum = 0;

	while(caseNum++<T){

	    int n = sc.nextInt();
	    int s = sc.nextInt();
	    int p = sc.nextInt();
	    int[] t = new int[n];
	    for(int i=0; i<n; i++){
		t[i] = sc.nextInt();
	    }
	    int[][] triplet = new int[n][3];
	    for(int i=0; i<n; i++){
		triplet[i][0] = t[i]/3;
		triplet[i][1] = t[i]/3;
		triplet[i][2] = t[i]/3;
		int tmp = 0;
		for(int j=t[i]%3; j>0; j--){
		    triplet[i][tmp++]++;
		}
	    }

	    int ans = 0;
	    for(int i=0; i<n; i++){
		if(triplet[i][0]>=p && triplet[i][0]!=triplet[i][1]){
		    ans++; triplet[i][0] = -1;
		}
		else if(triplet[i][0]!=triplet[i][1]){
		    triplet[i][0] = -1;
		}
		else if(triplet[i][0]>=p){
		    ans++; triplet[i][0] = -1;
		}
		else if(triplet[i][1]>0){
		    triplet[i][0]++; triplet[i][1]--;
		}
	    }

	    int count = 0;
	    for(int i=0; i<n; i++){
		if(triplet[i][0]>=p){count++;}
	    }
	    if(count>=s){ans += s;}
	    else {ans += count;}

	    System.out.println("Case #"+caseNum+": "+ans);
	}
    }
}
