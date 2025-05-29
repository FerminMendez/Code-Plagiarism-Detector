import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class DancingWithTheGooglers {
	public static void main(String[] args){
		Scanner keyin=new Scanner(System.in);
		int T=keyin.nextInt();
		int caseCount=0;
		while ((T--)>0){
			int N=keyin.nextInt();
			int S=keyin.nextInt();
			int P=keyin.nextInt();
			int[] googler=new int[N];
			for (int i=0; i<N; i++){
				googler[i]=keyin.nextInt();
			}
			caseCount++;
			ArrayList<int[][]> googlerScore=new ArrayList<int[][]>();
			
			for (int index=0; index<googler.length; index++){
				int remainder=googler[index];
				int[] arrayInit=new int[3];
				for (int i=3; i>0; i--){
					int temp=remainder/i;
					remainder-=temp;
					arrayInit[3-i]=temp;
				}
				int[][] arrayScore=new int[2][3];
				arrayScore[0]=arrayInit;
				if (arrayInit[0]==arrayInit[1] && arrayInit[1]==arrayInit[2]){
					int[] temp={arrayInit[0]-1,arrayInit[1],arrayInit[2]+1};
					arrayScore[1]=temp;
				}
				else if (arrayInit[0]==arrayInit[1] && arrayInit[1]!=arrayInit[2]){
					int[] temp={arrayInit[0]-1,arrayInit[1]+1,arrayInit[2]};
					arrayScore[1]=temp;
				}
				else if (arrayInit[0]!=arrayInit[1] && arrayInit[1]==arrayInit[2]){
					int[] temp={arrayInit[0],arrayInit[1]-1,arrayInit[2]+1};
					arrayScore[1]=temp;
				}
				//System.out.println(Arrays.deepToString(arrayScore));
				googlerScore.add(arrayScore);
			}
			
			int result=N;
			for (int index=0; index<googlerScore.size(); index++){
				if (googlerScore.get(index)[0][2]<P){
					if (googlerScore.get(index)[1][2]<P){
						result--;
					}
					else {
						if (S>0 && googlerScore.get(index)[1][0]<0){
							S--;
							result--;
							//System.out.println("S R "+S+" "+result);
						}
						else if (S>0){
							S--;
							//System.out.println("S "+S);
						}
						else if (S<=0) {
							result--;
							//System.out.println("R "+result);
						}
					}
				}
			}
			System.out.println("Case #"+caseCount+": "+result);
		}
	}
}
