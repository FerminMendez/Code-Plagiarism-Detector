import java.util.ArrayList;
import java.util.Scanner;


public class DancingWithTheGooglers {

	public static int calculateBestResultGooglers(int N,int S,int p,ArrayList<Integer> result){
		int noofresultpossible=0,surprisingTrippletsCount=0;
		for(int i=0;i<result.size();i++){
			if((result.get(i)/3)>=p){
				noofresultpossible++;
			}else if((result.get(i)/3)+1>=p){
				if(result.get(i)%3!=0){
					noofresultpossible++;
				}else if (surprisingTrippletsCount<S && result.get(i)>=1){
					noofresultpossible++;
					surprisingTrippletsCount++;
				}
			}else if((result.get(i)/3)+2>=p){
				if(result.get(i)%3==2&&surprisingTrippletsCount<S && result.get(i)>=2){
					noofresultpossible++;
					surprisingTrippletsCount++;
				}			
			}
		}
		return noofresultpossible;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int NoOfTestCases = in.nextInt();
		int noOfGooglers,noOfSurprisingTriplets,bestResultPossibilities,totalPoints;
		StringBuilder output=new StringBuilder();
		ArrayList<Integer> result=null;
		for(int i=1;i<=NoOfTestCases;i++){
			noOfGooglers=in.nextInt();
			noOfSurprisingTriplets=in.nextInt();
			bestResultPossibilities=in.nextInt();
//			System.out.println("No of Googlers : "+noOfGooglers);
//			System.out.println("No of SurprisingTriplets : "+noOfSurprisingTriplets);
//			System.out.println("Best Result of at Least p : "+bestResultPossibilities);
//			System.out.print("Total Points :");
			result=new ArrayList<Integer>();
			for(int j=1;j<=noOfGooglers;j++){
				totalPoints=in.nextInt();
//				System.out.print(" "+totalPoints);
				result.add(totalPoints);
			}
			output.append("Case #"+i+": "+calculateBestResultGooglers(noOfGooglers, noOfSurprisingTriplets, bestResultPossibilities, result)+"\n");			
		}
		System.out.println(output);
	}

}
