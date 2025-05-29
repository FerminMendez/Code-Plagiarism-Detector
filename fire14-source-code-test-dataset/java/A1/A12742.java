import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ProblemB {
	
	static Map<Integer, Score[]> scores;
	
	public static void main(String[] args){
		
		scores = new HashMap<Integer, Score[]>();
		
		scores.put(0, new Score[]{new Score(0,0,0)});
		scores.put(1, new Score[]{new Score(0,0,1)});
		scores.put(2, new Score[]{new Score(0,0,2),new Score(0,1,1)});
		scores.put(3, new Score[]{new Score(0,1,2),new Score(1,1,1)});
		scores.put(4, new Score[]{new Score(0,2,2),new Score(1,1,2)});
		scores.put(5, new Score[]{new Score(1,1,3),new Score(1,2,2)});
		scores.put(6, new Score[]{new Score(1,2,3),new Score(2,2,2)});
		scores.put(7, new Score[]{new Score(1,3,3),new Score(2,3,3)});
		scores.put(8, new Score[]{new Score(2,2,4),new Score(2,3,3)});
		scores.put(9, new Score[]{new Score(2,3,4),new Score(3,3,3)});
		scores.put(10, new Score[]{new Score(2,4,4),new Score(3,3,4)});
		scores.put(11, new Score[]{new Score(3,3,5),new Score(3,4,4)});
		scores.put(12, new Score[]{new Score(3,4,5),new Score(4,4,4)});
		scores.put(13, new Score[]{new Score(3,5,5),new Score(4,4,5)});
		scores.put(14, new Score[]{new Score(4,4,6),new Score(4,5,5)});
		scores.put(15, new Score[]{new Score(4,5,6),new Score(5,5,5)});
		scores.put(16, new Score[]{new Score(4,6,6),new Score(5,5,6)});
		scores.put(17, new Score[]{new Score(5,5,7),new Score(5,6,6)});
		scores.put(18, new Score[]{new Score(5,6,7),new Score(6,6,6)});
		scores.put(19, new Score[]{new Score(5,7,7),new Score(6,6,7)});
		scores.put(20, new Score[]{new Score(6,6,8),new Score(6,7,7)});
		scores.put(21, new Score[]{new Score(6,7,8),new Score(7,7,7)});
		scores.put(22, new Score[]{new Score(6,8,8),new Score(7,7,8)});
		scores.put(23, new Score[]{new Score(7,7,9),new Score(7,8,8)});
		scores.put(24, new Score[]{new Score(7,8,9),new Score(8,8,8)});
		scores.put(25, new Score[]{new Score(7,9,9),new Score(8,8,9)});
		scores.put(26, new Score[]{new Score(8,8,10),new Score(8,9,9)});
		scores.put(27, new Score[]{new Score(8,9,10),new Score(9,9,9)});
		scores.put(28, new Score[]{new Score(8,10,10),new Score(9,9,10)});
		scores.put(29, new Score[]{new Score(9,10,10)});
		scores.put(30, new Score[]{new Score(10,10,10)});
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		try{
			
			String line = in.readLine();

			int numLines = Integer.parseInt(line);

			for(int i = 1; i <= numLines; i++){
				
				System.out.print("Case #" + i + ": ");
				
				line = in.readLine();
				
				String[] temp = line.split(" ");
				
				int googlers = Integer.parseInt(temp[0]);
				int specials = Integer.parseInt(temp[1]);
				int p = Integer.parseInt(temp[2]);
				
				System.out.println(maxP(3, googlers+2, 0, specials, p, 0, temp));
				
			}
		}catch(IOException e){
			
		}
	}
	
	public static int maxP(int curGoogler, int maxGoogler, int specUsed, int specTotal, int minP, int numP, String[] scoreAr){
		
		Score[] temp = scores.get(Integer.parseInt(scoreAr[curGoogler]));
		
		if(curGoogler == maxGoogler){
			if(specUsed+1 < specTotal){
				return 0;
			}else if(specUsed == specTotal){
				if(temp.length == 1){
					if(temp[0].getMax() >= minP) return numP+1;
					else return numP;
				}else{
					Score temp1 = temp[0];
					Score temp2 = temp[1];
					if(temp1.isSpecial()){
						if(temp2.getMax() >= minP) return numP+1;
						else return numP;
					}else{
						if(temp1.getMax() >= minP) return numP+1;
						else return numP;
					}
				}
			}else{
				if(temp.length == 1){
					return 0;
				}else{
					Score temp1 = temp[0];
					Score temp2 = temp[1];
					if(temp1.isSpecial()){
						if(temp1.getMax() >= minP) return numP+1;
						else return numP;
					}else{
						if(temp2.getMax() >= minP) return numP+1;
						else return numP;
					}
				}
			}
		}else{
			if(temp.length == 1){
				if(temp[0].getMax() >= minP){
					return maxP(curGoogler+1, maxGoogler, specUsed, specTotal, minP, numP+1, scoreAr);
				}else{
					return maxP(curGoogler+1, maxGoogler, specUsed, specTotal, minP, numP, scoreAr);
				}
			}else{
				Score temp1 = temp[0];
				Score temp2 = temp[1];
				
				int r1;
				if(temp1.getMax() >= minP){
					if(temp1.isSpecial()){
						if(specUsed == specTotal){
							r1 = 0;
						}else{
							r1 = maxP(curGoogler+1, maxGoogler, specUsed+1, specTotal, minP, numP+1, scoreAr);
						}
					}else{
						r1 = maxP(curGoogler+1, maxGoogler, specUsed, specTotal, minP, numP+1, scoreAr);
					}
				}else{
					if(temp1.isSpecial()){
						if(specUsed == specTotal){
							r1 = 0;
						}else{
							r1 = maxP(curGoogler+1, maxGoogler, specUsed+1, specTotal, minP, numP, scoreAr);
						}
					}else{
						r1 = maxP(curGoogler+1, maxGoogler, specUsed, specTotal, minP, numP, scoreAr);
					}
				}
				
				int r2;
				if(temp2.getMax() >= minP){
					if(temp2.isSpecial()){
						if(specUsed == specTotal){
							r2 = 0;
						}else{
							r2 = maxP(curGoogler+1, maxGoogler, specUsed+1, specTotal, minP, numP+1, scoreAr);
						}
					}else{
						r2 = maxP(curGoogler+1, maxGoogler, specUsed, specTotal, minP, numP+1, scoreAr);
					}
				}else{
					if(temp2.isSpecial()){
						if(specUsed == specTotal){
							r2 = 0;
						}else{
							r2 = maxP(curGoogler+1, maxGoogler, specUsed+1, specTotal, minP, numP, scoreAr);
						}
					}else{
						r2 = maxP(curGoogler+1, maxGoogler, specUsed, specTotal, minP, numP, scoreAr);
					}
				}
				
				if(r1 > r2){
					return r1;
				}else{
					return r2;
				}
			}
		}
	}
}

class Score {

	int score1;
	int score2;
	int score3;

	public Score(int s1, int s2, int s3){
		score1 = s1;
		score2 = s2;
		score3 = s3;
	}

	public boolean isSpecial(){
		if(Math.abs(score1-score2) == 2 || Math.abs(score1-score3) == 2 || Math.abs(score2-score3) == 2) return true;
		else return false;
	}

	public int getMax(){
		if(score1 > score2 && score1 > score3) return score1;
		else if(score2 > score3) return score2;
		else return score3;
	}

}