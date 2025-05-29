import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DancingWithTheGooglers {

	private int calc(){
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int total = in.nextInt();
		
		int totGooglers = 0;
		int totStriplets = 0;
		int totPoints = 0;
		int pointsGooglers = 0;
		
		List<int []> scores = new ArrayList<int []>();
		
		for (int i = 1; i <= total; i++) {
			int result = 0;
			
			totGooglers = in.nextInt();
			totStriplets = in.nextInt();
			totPoints = in.nextInt();
			
			for (int j = 0; j < totGooglers; j++) {
				int [] tot = new int[2];
				pointsGooglers = in.nextInt();
				int auxPointsGooglers = pointsGooglers;
				int aux = 0;
				
				for (int k = 0; k < 3; k++) {
					if(auxPointsGooglers%3==0){
						auxPointsGooglers = auxPointsGooglers/3;
						break;
					}else if(auxPointsGooglers>0){
						aux++;
						auxPointsGooglers--;
					}
				}
				
				tot = new int[]{auxPointsGooglers, auxPointsGooglers, auxPointsGooglers};
				
				if(aux==2){
					tot[0]++;
					tot[1]++;
				}else if(aux==1){
					tot[0]++;
				}
				
				scores.add(tot);
			}
			
			int auxTotStriplets = totStriplets;
			int auxResult = 0;
			for (int[] js : scores) {
				
				for (int k : js) {
					if(k>=totPoints){
						auxResult++;
					}
				}
				
				if(auxResult==0){
					if(auxTotStriplets>0){
						if(((js[1]-1)>=0 || (js[2]-1)>=0)){
							if((js[0]+1)>=totPoints){
								if(js[2]>js[1] || js[2]==js[0]){
									js[2]--;
									auxTotStriplets--;
									js[0]++;
								}else if(js[1]>js[2]){
									js[1]--;
									auxTotStriplets--;
									js[0]++;
								}
							}
						}
					}
				}
				
				auxResult = 0;
				
			}
			
			for (int[] js : scores) {
				for (int k : js) {
					if(k>=totPoints){
						result++;
						break;
					}
				}
			}
			
			scores.clear();
				
			System.out.format("Case #%d: %s\n", i, result);
		}
	}
}
