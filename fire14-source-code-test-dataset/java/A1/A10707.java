import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Scanner;


public class B {
	
	public int s = 0;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		
		for (int i = 0; i < t; i++) {
			B b = new B();
			int y = 0;
			int n = scanner.nextInt();
			b.s = scanner.nextInt();
			int p = scanner.nextInt();
			int[] points = new int[n];
			for (int j = 0; j < n; j++) {
				points[j] = scanner.nextInt();
			}
//			
//			for (int j = 0; j < n; j++) {
//				
//				if(3*p < )
//				int[] results = new int[3];
//				results[0] = p;
//				results[1] = (points[j] - p)/2;
//				results[2] = points[j] - results[0] - results[1];
//				
//				while(results[0] <= 10 && results) {
//					
//					if(b.isValid(results, p)) {
//						System.out.println(points[j] + " - " + results[0] + ", " + results[1]+ ", " + results[2]);
//						y++;
//						break;
//					}
//					results[0]++;
//					results[1]--;
//				}
//			}
//			
//			System.out.println("Case #"+(i+1)+": "+y);
//		}
//		
//
//	}
//	
//	public boolean isValid(int[] results, int p) {
//		if(Math.abs(results[0]-results[1]) < 2 && Math.abs(results[0]-results[2]) < 2) { //testo (Math.abs(results[1]-results[2]) ?
//			return true;
//		}
//		else {
//			if((Math.abs(results[0]-results[1]) <= 2 || Math.abs(results[0]-results[2]) <= 2) && s > 0) {
//				s--;
//				return true;
//			}
//		}
//		return false;
//	}
			
			
			
			Arrays.sort(points);
			for (int j = 0; j < points.length; j++) {
				
				int maxToDrop = p + 2*(p - 2);
				
				if(p <= 1) {
					maxToDrop = p;
				}
				
				
				if(points[j] < maxToDrop) {
					continue;
				}
				
				int minToPass = maxToDrop + 2;
				
				if(maxToDrop == 0) {
					minToPass = 0;
				}
				
				if(points[j] >= minToPass) {
					y++;
					continue;
				}
				
				if(b.s > 0) {
					b.s--;
					y++;
					continue;
				}

			}
			
			System.out.println("Case #"+(i+1)+": "+y);
		}
	}
	
//	public static boolean isLimitMax(int point, int p) {
//		if(point >= 3 * p) {
//			return true;
//		}
//		return false;
//	}
//	
//	public static boolean isLimitMin(int point, int p) {
//		if(point >= 4) {
//			return true;
//		}
//		return false;
//	}

}
