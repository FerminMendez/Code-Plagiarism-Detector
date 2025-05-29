import java.io.*;
public class DancingWithTheGooglers {

	public static void main(String[] args)throws IOException {
		BufferedReader bfr = new BufferedReader(
				new InputStreamReader(System.in));
		PrintWriter pr = new PrintWriter(System.out);
		int n = Integer.parseInt(bfr.readLine());
		for (int i = 1 ;i<=n;i++){
			String input []= bfr.readLine().split(" ");
			int googlers = Integer.parseInt(input[0]);
			int surprise = Integer.parseInt(input[1]);
			int max = Integer.parseInt(input[2]);
			int happens =0;
			for (int j =0;j<googlers;j++){
				int googler = Integer.parseInt(input[j+3]);
				int score[] ={(int)(googler/3),((double)googler/3==(int)googler/3)?(int)googler/3:(int)(googler/3)+1,(int) (googler-(Math.floor(googler/3)+(((double)googler/3==(int)googler/3)?(int)googler/3:(int)(googler/3)+1)))};
				if (score[0]>=max||score[1]>=max||score[2]>=max)
					happens++;
				else if (score[0]==score[2]){
					if(score[0]+1>=max&&score[0]-1>=0)
						if (surprise>0){
						happens++;
						surprise--;
						}
				}else if (score[1]==score[2]&&score[0]-1>=0){
					if(score[1]+1>=max)
						if (surprise>0){
						happens++;
						surprise--;
						}
				}
				
			}
			pr.printf("Case #%d: %d\n", i,happens);
			pr.flush();
		}

	}

}
