package Problem2;

import java.util.ArrayList;

public class DancingGooglers {
	
	//3 1 5 15 13 11
	
	// tab[0] = numbe of dancers
	// tab[1] = number of *
	// tab[2] = threshold p

	public static int[] Assign_Stars(int allowed_stars, int[] sumratingtab, int threshold){
		
		int a= allowed_stars;
		int n=sumratingtab.length;
		int[] maxrates= new int[n];
		int i;

			if (a>0){
				for (i=0;i<n;i++){
					if ((sumratingtab[i]>0) && (sumratingtab[i] % 3 == 2) && (  ((sumratingtab[i]-2)/3 + 2)<threshold) &&  (  ((sumratingtab[i]-2)/3 +2) >= threshold)){
					
				//	if ((sumratingtab[i]>=0) && (sumratingtab[i] % 3 == 2)){
						if (a>0){
							maxrates[i]= (sumratingtab[i]-2)/3 + 2;
							System.out.println("etoile gaspillee pour :" + maxrates[i] + " reste :" +(a-1) );
							sumratingtab[i]=-1;
							a--;
						}
					}	
				}
			}

			if (a>0){
				for (i=0;i<n;i++){					
					if ((sumratingtab[i]>0) && (sumratingtab[i] % 3 == 0) && (((sumratingtab[i])/3 ) <threshold) && (((sumratingtab[i])/3+1 ) >= threshold) ){
				//	if ((sumratingtab[i]>=0) && (sumratingtab[i] % 3 == 0) ){
						if (a>0){

							maxrates[i]= sumratingtab[i]/3 + 1 ;
							System.out.println("etoile gaspillee pour :" + maxrates[i] + " reste :" +a);
							sumratingtab[i]=-1;
							a--;
						}
					}	
				}
			}
			
			if (a>0){
				for (i=0;i<n;i++){
					if ( (sumratingtab[i]>0) && (sumratingtab[i] % 3 == 0) ){ 
						if (a>0){

							maxrates[i]= ((sumratingtab[i]/3)) + 1 ;
							sumratingtab[i]=-1;
							a--;
						}
						
					}	
					if ( (sumratingtab[i]>0) && (sumratingtab[i] % 3 == 1) ){ 
						if (a>0){

							maxrates[i]= (((sumratingtab[i]-1)/3)) + 1 ;
							sumratingtab[i]=-1;
							a--;
						}	
					}
					if ( (sumratingtab[i]>0) && (sumratingtab[i] % 3 == 2) ){ 
						if (a>0){

							maxrates[i]= (((sumratingtab[i]-2)/3)) + 2 ;
							sumratingtab[i]=-1;
							a--;
						}	
					}
				}
				
			}
			

				for (i=0;i<n;i++){
					if ( (sumratingtab[i]>0) && (sumratingtab[i] % 3 == 0) ){ 
		
							maxrates[i]= ((sumratingtab[i]/3))  ;
							sumratingtab[i]=-1;
						
					}	
					if ( (sumratingtab[i]>0) && (sumratingtab[i] % 3 == 1) ){ 

							maxrates[i]= (((sumratingtab[i]-1)/3)) + 1 ;
							sumratingtab[i]=-1;
					}
					if ( (sumratingtab[i]>0) && (sumratingtab[i] % 3 == 2) ){ 
							maxrates[i]= (((sumratingtab[i]-2)/3)) + 2 ;
							sumratingtab[i]=-1;
					}
				}
		return maxrates;
	}
	
	public static int countmorethanp(int[] maxrates ,int p){
		int n=maxrates.length;
		int i;
		int count=0;
		for (i=0;i<n;i++){
			if (maxrates[i]>=p){
				count++;
			}
		}
		return count;
	}
	
//	public static void main(String[] args){
//		
//		int[] tab = {8,0};
//		// 2 1 1 8 0
//	//	6  8 
//		int[] tab2 = Assign_Stars(1, tab, 1);
//		int i=0;
//		for (i=0;i<tab2.length;i++){
//			System.out.println("tab2 : "+tab2[i]);
//		}
//		System.out.println(countmorethanp(tab2, 1));
//	}
	
	public static int result(int allowedstars , int[] tabsum,int threshold ){
	
	int[] tab2 = Assign_Stars(allowedstars, tabsum, threshold);
	
	return countmorethanp(tab2, threshold);
	}
	
	public static int StringtoResults(String s1){
		String[] arrs = s1.split(" ");
		int i=1,n=arrs.length;
		int allowedstars = Integer.parseInt(arrs[1]);
		int threshold = Integer.parseInt(arrs[2]);
		int[] arr = new int[n-3];
		for (i=3;i<n;i++){
			arr[i-3]= Integer.parseInt(arrs[i]);
		}
		return result(allowedstars,arr,threshold);
	}
	
	public static int[] Count_List(ArrayList<String> ArS){
		
		int[] Ars_res = new int[ArS.size()]; 
		int i=0;
		int n =ArS.size();
		
		for(i=0;i<n;i++){
			Ars_res[i]=StringtoResults(ArS.get(i));
		}
		return Ars_res;
		
	}
	
}
