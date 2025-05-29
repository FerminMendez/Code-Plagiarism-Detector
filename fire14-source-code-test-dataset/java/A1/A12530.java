import java.util.Scanner;

public class CodeB{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int tcase;
		int numGoogler, surprising, min;
		int totTriplets, surprisingUsed;
		int getMinMax;
		
		tcase=sc.nextInt();
		for(int q=1;q<=tcase;q++){
			surprisingUsed=0;
			getMinMax=0;
			numGoogler=sc.nextInt();
			surprising=sc.nextInt();
			min=sc.nextInt();
			for(int i=0;i<numGoogler;i++){
				totTriplets=sc.nextInt();
				//System.out.println((totTriplets%3)+" "+(totTriplets/3));
				if(totTriplets%3==0){
					if(totTriplets/3>=min){
						getMinMax++;
					}
					else if((totTriplets/3)!=0 && (totTriplets/3)+1>=min && surprisingUsed<surprising){
						getMinMax++;
						surprisingUsed++;
					}
				}
				else if(totTriplets%3==1 && (totTriplets/3)+1>=min){
					getMinMax++;
				}
				else if(totTriplets%3==2){
					if((totTriplets/3)+1>=min){
						getMinMax++;
					}
					else if((totTriplets/3)+2>=min && surprisingUsed<surprising){
						getMinMax++;
						surprisingUsed++;
					}
				}
			}
			System.out.println("Case #"+q+": "+getMinMax);
		}
	}
}