import java.util.*;

public class Problem2 {
	public Problem2(){
		Scanner scan = new Scanner(System.in);
		int inputs = scan.nextInt();
		for(int i=1; i<=inputs; i++){
			int googlers = scan.nextInt();
			int sur = scan.nextInt();
			int bResult = scan.nextInt();
			int num = 0;
			int[] results = new int[googlers];
			for(int j=0; j<googlers; j++){
				results[j]=scan.nextInt();
			}
			num = calc(googlers, sur, bResult, results);
			System.out.println("Case #"+i+": "+num);
		}
	}
	
	public int calc(int g, int s, int bS, int[] r){
		int[][] score = new int[g][5];
		for(int i=0; i<g; i++){
			if(r[i]%3 == 0){
				score[i][0] = 0;
				score[i][1] = r[i]/3;
				score[i][2] = r[i]/3;
				score[i][3] = r[i]/3;
				score[i][4] = 1;
			}else{
				double h = r[i];
				h = h/3;
				if(Math.floor(h) == Math.round(h)){ //means the value is x.3333, should now add two rounded down and add one rounded up
					score[i][0] = 0;
					score[i][1] = (int)Math.floor(h);
					score[i][2] = (int)Math.floor(h);
					score[i][3] = (int)Math.ceil(h);
				}else{ //catches values with x.6666, should now add two rounded up and add one rounded down
					score[i][0] = 0;
					score[i][1] = (int)Math.floor(h);
					score[i][2] = (int)Math.ceil(h);
					score[i][3] = (int)Math.ceil(h);
					score[i][4] = 1;
				}
			}
			if(score[i][1]>=bS || score[i][2]>=bS || score[i][3]>=bS){
				score[i][0]=1;
			}
		}
		int x = 0;
			List<Integer> z = new ArrayList<Integer>();
			for(int i=0; i<g; i++){
				if(score[i][0] != 1){
					z.add(i);
					x++;
				}
			}
			int f = 0;
			for(int a:z){
				if(score[a][3] >= bS-1 && f<s && score[a][1]+score[a][2]+score[a][3]>1 && score[a][4]==1){
					f++;
				}
			}	
			x = x-f;
		return g-x;
	}
	
	public static void main(String[] args){
		new Problem2();
	}
}
