import java.util.Scanner;


public class Problem2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int lineNo = scan.nextInt();
		
		for(int i = 0 ; i < lineNo ; i++) {
			int googlerNo = scan.nextInt();
			int surpriseNo = scan.nextInt();
			int point = scan.nextInt();
			
//			int googlerPoint[] = new int[googlerNo];
			Googler[] googlers = new Googler[googlerNo];
			
			int maxGoogler = 0;
			for(int j = 0 ; j < googlerNo ; j++) {
				googlers[j] = new Googler();
				
				googlers[j].setPoint(scan.nextInt());
				
				if(googlers[j].maxPoint >= point)
					maxGoogler++;
				
				else if(googlers[j].canSurprise 
					&& googlers[j].maxPoint+1 == point 
					&& surpriseNo > 0) {
					
					maxGoogler++;
					surpriseNo--;					
				}
			}
			
			System.out.println("Case #" + (i+1) + ": " + maxGoogler);
			
			
		}
	}
}

class Googler {
	int point;
	
	int minPoint;
	int maxPoint;
	
	boolean canSurprise;
	
	void setPoint(int point) {
		this.point = point;
		
		if(point == 0 || point % 3 == 1) canSurprise = false;
		else canSurprise = true;
		
		minPoint = point / 3;
		maxPoint = point % 3 == 0 ? minPoint : minPoint + 1;
	}
}
 