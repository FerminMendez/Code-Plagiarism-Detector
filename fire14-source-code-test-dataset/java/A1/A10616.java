import java.util.ArrayList;
import java.util.Scanner;


public class GooglerDancer {

	private int caseNumber;
	private int numberOfGooglers;
	private int numberOfSuprisingTriplets;
	private int minimumBestScoreP;
	private ArrayList<Integer> list;


	public GooglerDancer(int caseNumber,String data) {

		this.caseNumber=caseNumber;
		Scanner s=new Scanner(data);
		this.numberOfGooglers=s.nextInt();
		this.numberOfSuprisingTriplets=s.nextInt();
		this.minimumBestScoreP=s.nextInt();
		list=new ArrayList<Integer>();
		while(s.hasNextInt()){
			list.add(s.nextInt());
		}
	}


	public void process() {
		int count =0;
		
		if(numberOfGooglers>0){
		/////
			if(minimumBestScoreP>0){
		for(int i=0;i<numberOfGooglers;i++){
			if(list.get(i)>0)
			{
			if((Integer)(list.get(i)/minimumBestScoreP)>=3){
				count++;
			}
			else{
				if((Integer)(minimumBestScoreP-(list.get(i)-minimumBestScoreP)/2)==1){
					count++;
				}
				else{
					if((Integer)(minimumBestScoreP-(list.get(i)-minimumBestScoreP)/2)==2 && numberOfSuprisingTriplets>0){
						count++;
						numberOfSuprisingTriplets--;
					}
				}
			}
		}
		}
		////////////
			}else{
				count=numberOfGooglers;
			}
		}
		System.out.println("Case #"+caseNumber+": "+count);

	}

}
