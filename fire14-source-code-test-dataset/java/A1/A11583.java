
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.util.ArrayList;

class jam1a {
    public static void main(String[] args) {
    	BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	    try {
			String s = bufferRead.readLine();
			int testCases=Integer.parseInt(s);
			ArrayList<String> sars = new ArrayList<String>();
			for(int i=0; i< testCases; i++){
				s = bufferRead.readLine();
				sars.add(s);				
			}
			System.out.println("\n");
			
			for(int j=0; j<sars.size(); j++){
				String [] split=sars.get(j).split(" ");
				int googlers=Integer.parseInt(split[0]);
				int surprises=Integer.parseInt(split[1]);
				int p=Integer.parseInt(split[2]);
				ArrayList<Integer> nums = new ArrayList<Integer>();
				for(int i=3; i<split.length; i++){
					nums.add(Integer.parseInt(split[i]));
				}
				System.out.println("Case #"+(j+1)+": " + atLeast(googlers, surprises,p,nums));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
    }
    
    public static int atLeast(int googlers, int surprises, int p, ArrayList<Integer> numbers){
    	if(p==0) return numbers.size();
    	int ret=0;
    	for (int i=0; i<numbers.size(); i++){
    		float tempNum=numbers.get(i);
    		if(tempNum==0 && p>0 ) continue;    		
    		float avg=(float)tempNum/3;
    		float tempRem=tempNum-p;
    		boolean okNoSuprise=false;
			if(tempRem%2==0){
				int tempVal=(int) (tempRem/2);
				if((tempVal+1)>=p) {
					okNoSuprise=true;					
				}
			}else{
				int tempForDiv=(int) (tempRem-1);
				int val1=(int) (tempForDiv/2);
				if((val1+1)>=p){
					okNoSuprise=true;
				}
			}
    		if((avg)>=p) ret++;
    		else if(okNoSuprise) ret++;
    		else if( surprises > 0){    		
    			if(tempRem%2==0){
    				int tempVal=(int) (tempRem/2);
    				if((tempVal+2)>=p) {
    					ret++;
    					surprises--;
    				}
    			}else{
    				int tempForDiv=(int) (tempRem-1);
    				int val1=(int) (tempForDiv/2);
    				int val2=val1+1;
    				if((val1+2)>=p){
    					ret++;
    					surprises--;
    				}
    			}
    		}
    	}
    	return ret;
    }
    
}