import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner reader = new Scanner (System.in);
		int nCases = reader.nextInt();
		for(int i=1; i<=nCases; i++) {
			int nGoolers = reader.nextInt();
			int nSurprising = reader.nextInt();
			int p = reader.nextInt();
			int minSurprising,minNotSurprising;
			if(p>=2) {
				minSurprising = (p-2)*2 + p;
				minNotSurprising = (p-1)*2 +p;
			} else if (p==1){
				minSurprising = (p-1)*2 +p;
				minNotSurprising = (p-1)*2 +p;
			} else {
				minSurprising = 0;
				minNotSurprising = 0;
			}
			int nBestResult = 0;
			int[] scoreTriplets = new int[nGoolers];
			for(int j=0; j<nGoolers; j++) {
				scoreTriplets[j] = reader.nextInt();
				if(scoreTriplets[j] >= minNotSurprising) {
					nBestResult++;
				} else if(scoreTriplets[j] < minNotSurprising && scoreTriplets[j] >= minSurprising) {
					if(nSurprising > 0) {
						nBestResult++;
						nSurprising--;
					}
				}
			}
			System.out.println("Case #" + i + ": " + nBestResult);
		}
	}
}
