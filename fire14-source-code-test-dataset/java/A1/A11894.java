import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class testC {

    public static void main(String args[]){
     
        
    	 int arrayInt[];
       String str="";
       int numbersOfGooglers=0;
       int S=0;
       int P=0;
       int index=0;
       int count=0;
       int arrResults[];
       try{
           FileReader fr = new FileReader("2.txt");
           BufferedReader br = new BufferedReader(fr);
           int size = Integer.parseInt(br.readLine());
           for(int loop=0;loop<size;loop++){
        		 str= br.readLine();
        		 char arraychar[] = str.toCharArray();
        		// = new int[100];
        		 arrayInt = new int[100];
        		index=0;
        		count=0;
        		 String s;
        		 s="";
        		 for(int i=0;i<str.length();i++){
        			 if(arraychar[i] != ' '){
        				s+=arraychar[i]; 
        			 }else{
        				 arrayInt[index++] = Integer.parseInt(s);
        				 s="";
        			 }
        		 }
        		 arrayInt[index++] = Integer.parseInt(s);
				 s="";
        		
				 
				 numbersOfGooglers = arrayInt[0];
				 S = arrayInt[1];
				 P = arrayInt[2];
				 arrResults = new int[numbersOfGooglers];
				 index=3;
				 for(int i=0;i<numbersOfGooglers;i++){
					 arrResults[i] = arrayInt[index++];  
				 }
				 
				 int SS=S;
				 int PP=P;
				 int check=0;
				 S=SS;
				 for(int i=0;i<numbersOfGooglers;i++){
					 P=PP;
					 
					while(P<30)
					{
						if(!(P-1<0 || P-2<0)){
							 if(P*3==arrResults[i] || P+(P-1)+(P-1)==arrResults[i] || P+(P+1)+(P+1)==arrResults[i] || P+(P)+(P+1)==arrResults[i] || P+(P)+(P-1)==arrResults[i])
							 {
								 count++;
								 break;
							 }
							 else if(S>0 && ( P+(P-1)+(P+1)==arrResults[i] || P+(P+2)+(P+2)==arrResults[i] || P+(P-2)+(P-2)==arrResults[i] || P+(P-1)+(P-2)==arrResults[i] || P+(P+1)+(P+2)==arrResults[i]))
							 {
								 count++;
								 S--;
								 break;	
							 }
						}else if((P-1<0)){
							 if(P*3==arrResults[i] || P+(P+1)+(P+1)==arrResults[i] || P+(P)+(P+1)==arrResults[i] )
							 {
								 count++;
								 break;
							 }
							 else if(S>0 && (  P+(P+2)+(P+2)==arrResults[i] || P+(P+1)+(P+2)==arrResults[i]))
							 {
								 count++;
								 S--;
								 break;	
							 }
						}else if((P-2<0)){
							 if(P*3==arrResults[i] || P+(P-1)+(P-1)==arrResults[i] || P+(P+1)+(P+1)==arrResults[i] || P+(P)+(P+1)==arrResults[i] || P+(P)+(P-1)==arrResults[i])
							 {
								 count++;
								 break;
							 }
							 else if(S>0 && ( P+(P-1)+(P+1)==arrResults[i] || P+(P+2)+(P+2)==arrResults[i] || P+(P+1)+(P+2)==arrResults[i]))
							 {
								 count++;
								 S--;
								 break;	
							 }
						}
						
						
					 P++;
					} 
/*					 	
							 if(arrResults[i]/P<4){
								 if(arrResults[i]%P < 2){
									 count++;
									 break;
								 }else if(arrResults[i]%P == 2 && S>0){
									 count++;
									 S--;
									 break;
								 }
							 }
								 P++;
	*/						
						
				 }
				 System.out.println("Case #"+(loop+1)+": "+count);
				/* for(int j=0;j<numbersOfGooglers;j++)
    			 System.out.print(arrResults[j]+" ");
    		 System.out.println();*/
				 
				 
  }
       br.close();
       fr.close();
   
   }catch(IOException ex){
       ex.printStackTrace();
   }
      
}


}
