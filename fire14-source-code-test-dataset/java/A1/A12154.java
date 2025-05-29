import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Dance {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for(int i = 0; i<cases;i++){
			String[] s = br.readLine().split(" ");
			int NumberOfGooglers = Integer.parseInt(s[0]);
			int surprising = Integer.parseInt(s[1]);
			int best = Integer.parseInt(s[2]);
			int count = 0;
			int[] scores = new int[NumberOfGooglers];
			for(int j=0;j<NumberOfGooglers;j++){
				scores[j]=Integer.parseInt(s[j+3]);
			}
			Arrays.sort(scores);
			for(int j=scores.length-1;j>=0;j--){
				int score = scores[j];
				int remaining=0;
				while(score%3!=0){
					score--;
					remaining++;
				}
				int average= score/3;
				int r = remaining;
				if(average>=best){
					count++;
					continue;
				}
				if(remaining>0){
					average++;
					remaining -- ;
				}
				if(average>=best){
					count++;
					continue;
				}
				else if(surprising>0 && (remaining >0 || (r==0&&score>1))){
					average++;
					surprising--;
				}
				if(average>=best)
					count++;
				else 
					break;
			}
			System.out.println("Case #" + (i+1) + ": " + count);
		}
	}

}
