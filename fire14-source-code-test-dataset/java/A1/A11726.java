package round02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Problem B. Dancing With the Googlers
 * 
 * Problem

You're watching a show where Googlers (employees of Google) dance, and then each dancer is given a triplet of scores by three judges. Each triplet of scores consists of three integer scores from 0 to 10 inclusive. The judges have very similar standards, so it's surprising if a triplet of scores contains two scores that are 2 apart. No triplet of scores contains scores that are more than 2 apart.

For example: (8, 8, 8) and (7, 8, 7) are not surprising. (6, 7, 8) and (6, 8, 8) are surprising. (7, 6, 9) will never happen.

The total points for a Googler is the sum of the three scores in that Googler's triplet of scores. The best result for a Googler is the maximum of the three scores in that Googler's triplet of scores. Given the total points for each Googler, as well as the number of surprising triplets of scores, what is the maximum number of Googlers that could have had a best result of at least p?

For example, suppose there were 6 Googlers, and they had the following total points: 29, 20, 8, 18, 18, 21. You remember that there were 2 surprising triplets of scores, and you want to know how many Googlers could have gotten a best result of 8 or better.

With those total points, and knowing that two of the triplets were surprising, the triplets of scores could have been: 

	10 9 10
	6 6 8 (*)
	2 3 3
	6 6 6
	6 6 6
	6 7 8 (*)
	
The cases marked with a (*) are the surprising cases. This gives us 3 Googlers who got at least one score of 8 or better. There's no series of triplets of scores that would give us a higher number than 3, so the answer is 3.

Input

The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of a single line containing integers separated by single spaces. The first integer will be N, the number of Googlers, and the second integer will be S, the number of surprising triplets of scores. The third integer will be p, as described above. Next will be N integers ti: the total points of the Googlers.
Output

For each test case, output one line containing "Case #x: y", where x is the case number (starting from 1) and y is the maximum number of Googlers who could have had a best result of greater than or equal to p.
Limits

1 ¡Â T ¡Â 100.
0 ¡Â S ¡Â N.
0 ¡Â p ¡Â 10.
0 ¡Â ti ¡Â 30.
At least S of the ti values will be between 2 and 28, inclusive.
Small dataset

1 ¡Â N ¡Â 3.
Large dataset

1 ¡Â N ¡Â 100.

ample

Input
  	
Output
 
4
3 1 5 15 13 11
3 0 8 23 22 21
2 1 1 8 0
6 2 8 29 20 8 18 18 21

Case #1: 3
Case #2: 2
Case #3: 1
Case #4: 3

 * @author chmin
 *
 */
public class DancingWithGooglers {

	static class ScoreHolder {
		int s1, s2, s3;
		int remainder ;
		boolean passed = false;
		ScoreHolder (int total){
			s1 = s2 = s3 = total /3 ;
			remainder = total % 3;
		}
		private String asString(int v1, int v2, int v3){
			return "" + v1 + " " + v2 + " " + v3;
		}
		public String [] toScores(int p, boolean allowSuprising ) {
			ArrayList<String> list = new ArrayList<>();
			int v1 = s1;
			int v2 = s2;
			int v3 = s3;
			
			if ( remainder == 0){
				if ( v1 >= p )
					list.add(asString(v1, v2, v3));
				
				if ( v1 + 1 >= p && v3 > 0 && allowSuprising )
					list.add(asString(v1+1, v2, v3-1));
			}
			if ( remainder == 1 ){
				if ( (v1+1) >= p ) list.add ( asString(v1+1, v2, v3));
			} else if ( remainder == 2 ){
				if ( v3+1 >= p ) {
					list.add(asString(v1, v2+1, v3+1));
				}
				if ( v3+2 >= p && allowSuprising )
					list.add( asString(v1, v2, v3+2));
			}
			
			String [] result = new String [list.size()];
			list.toArray(result);
			return result;
		}
	}
	
	static List<ScoreHolder []> readFile ( InputStream in) throws IOException{
		ArrayList<ScoreHolder []> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		Scanner scanner = new Scanner(in);
		int T = scanner.nextInt();
		
		for ( int i = 0 ;i < T ; i++){
			int N = scanner.nextInt(); // the number of googlers
			int S = scanner.nextInt(); // the number of surprising triplets of scores
			int P = scanner.nextInt(); // min score
//			System.out.print ("N(" + N + 
//					"), S(" + S +
//					"), p(" + P +
//					") ");
			ScoreHolder [] sh = new ScoreHolder[N];
			for( int k = 0 ; k < N ; k++){
				sh[k] = new ScoreHolder(scanner.nextInt());
			}
			
			int cnt = 0;
			
			for ( int k = 0 ; k < sh.length ; k++){
				if ( sh[k].toScores(P, false).length > 0 ){
					cnt ++ ;
					sh[k].passed = true;
				}
			}
			
			if ( S > 0 ){
				int cntS = S;
				String [] vals = null;
				for( int k = 0 ; k < sh.length ; k ++ ){
					if ( sh[k].passed ) continue;
					vals = sh[k].toScores(P, true);
					if ( vals.length > 0 ){
						cnt ++ ;
						cntS -- ;
					}
					if ( cntS == 0)break;
				}
			}
//			System.out.println("CASE #" + (i+1) + ": " + cnt );
			sb.append("Case #" + (i+1) + ": " + cnt + System.getProperty("line.separator"));
			list.add(sh);
		}
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("R2-small.out"));
		bw.write(sb.toString());
		bw.close();
		return list;
	}
	private static void dump(String[] vals) {
		for (int j = 0; j < vals.length; j++) {
			System.out.print(" => " + vals[j]);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			List<ScoreHolder []> lines = readFile(
					DancingWithGooglers.class.getResourceAsStream("R2-small.in") );
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
