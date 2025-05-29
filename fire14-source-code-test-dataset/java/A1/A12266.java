import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

public class GoogleDancers{

	public static void main(String[] args) throws Exception{
		FileReader fr = new FileReader("C:\\Projects\\Learning\\src\\B-small-attempt1.in");
		BufferedReader br = new BufferedReader(fr);
		FileWriter fw = new FileWriter("C:\\Projects\\Learning\\src\\BLarge.txt");
		int N = new Integer(br.readLine());
		for (int cases = 1; cases <= N; cases++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str); 
			int numberParticipants = Integer.parseInt(st.nextToken());
			int surprise = Integer.parseInt(st.nextToken()); 
			int goodScore = Integer.parseInt(st.nextToken());
			int a[] = new int[numberParticipants];
			for(int i=0; i< numberParticipants; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			int count = 0;
			int possibility = 0;
			int minToGetGoodScore = Math.max(((3 * goodScore) - 2), 1);
			System.out.println("minToGetGoodScore" + minToGetGoodScore);
			int surpriseRange = Math.max(((3* goodScore) - 4), 1);
			if (goodScore > 0 ) {
				for (int i = 0; i < numberParticipants; i++) {
					if (a[i] >= minToGetGoodScore) {
						count++;
						System.out.println("Count" + count);
						

					} else if (a[i] >= surpriseRange
							&& a[i] < minToGetGoodScore) {
						possibility++;
					}
				}System.out.println("Count" + count);
				count = count + Math.min(possibility, surprise);
				System.out.println("Count" + count);
			}
			else
			{
				count = numberParticipants;
			}
			fw.write("Case #" + cases + ": " + count + "\n");
			
		}
		fw.flush();
		fw.close();
	}
}
