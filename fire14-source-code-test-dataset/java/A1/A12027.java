import java.util.Scanner;


public class Dancing {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfLines = Integer.parseInt(in.nextLine());

		for(int lineNum = 1; lineNum <= numberOfLines; lineNum++){
			int totalDancers = in.nextInt();
			int lifeLines = in.nextInt();
			int totalCutOff = in.nextInt() * 3;
			int dancersWithGoodScore = 0;
			
			for(int dancer=0; dancer < totalDancers; dancer++){
				int dancerScore = in.nextInt();
				
				if(dancerScore == 0 && totalCutOff != 0) continue;
				
				if(dancerScore - totalCutOff >= -2){
					dancersWithGoodScore++;
				}
				else if(dancerScore - totalCutOff >= -4){
					if(lifeLines > 0){
						lifeLines--;
						dancersWithGoodScore++;
					}
				}
			}
			
			System.out.println("Case #" + lineNum + ": " + dancersWithGoodScore);
		}
	}

}
