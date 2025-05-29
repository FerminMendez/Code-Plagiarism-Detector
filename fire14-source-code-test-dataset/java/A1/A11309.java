import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );

		int t = input.nextInt();
		for( int i = 0; i < t; i++ ) {
			int n = input.nextInt();
			int s = input.nextInt();
			int p = input.nextInt();

			int minScore = ( p * 3 ) - 2;
			int minScoreWithS = ( p * 3 ) - 4;

			int result = 0;
			for( int j = 0; j < n; j++ ) {
				int score = input.nextInt();

				if( score >= p ) {
					if( score >= minScore ) {
						result += 1;
					} else if( score >= minScoreWithS && s > 0 ) {
						result += 1;
						--s;
					}
				}
			}

			System.out.println( "Case #" + ( i + 1 ) + ": " + result );
		}
	}

}
