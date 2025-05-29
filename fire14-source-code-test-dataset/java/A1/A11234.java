import java.io.*;
import java.util.*;

class googledance {
  public static void main (String [] args) throws IOException {
	  
    BufferedReader f = new BufferedReader(new FileReader("googledance.in"));
    
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("googledance.out")));
    
    int n = Integer.parseInt(f.readLine());
    
    String[] scores = new String[n];
    int[] answers = new int[n];
    
    for(int i=0; i<n; i++){
    	scores[i] = f.readLine();
    	answers[i] = 0;
    }
    
    for(int i=0; i<n; i++){
    	
        StringTokenizer st = new StringTokenizer(scores[i]);
        
        int numgooglers = Integer.parseInt(st.nextToken());
        int numsurprises = Integer.parseInt(st.nextToken());
        int threshold = Integer.parseInt(st.nextToken());
        
        Integer[] sumscores = new Integer[numgooglers];
        int[][] breakdown = new int[numgooglers][3];
        boolean[] succeeded = new boolean[numgooglers];
        
        for(int j=0; j<numgooglers; j++){
        	
        	sumscores[j] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(sumscores, Collections.reverseOrder()); //sort DESCENDING
        
        for(int j=0; j<numgooglers; j++){
        	
        	//System.out.println();
        	
        	int psum = 0;
        	
        	for(int k=0; k<3; k++){
        		breakdown[j][k] = sumscores[j]/3;
        		psum += sumscores[j]/3;
        	}
        	
        	if (psum!=sumscores[j]){
        		int deviation = psum-sumscores[j];
        		
        		for(int k=0; k<Math.abs(deviation); k++){ //Notice that there will be AT MOST 2 deviations!
        			
        			if(deviation > 0){ //balance out the deviations as closely as possible
        				breakdown[j][k]--;
        			}
        			else{
        				breakdown[j][k]++; //good news, the breakdown is always sorted from inc->dec
        			}
        			
        		}
        		
        	}
        	
        	/*for(int k=0; k<3; k++){
        		System.out.println(breakdown[j][k]);
        	}*/
        	
        }
        
        for(int j=0; j<numgooglers; j++){
        	
        	for(int k=0; k<3; k++){
        		if(!succeeded[j] && breakdown[j][k]>= threshold){
        			answers[i]++;
        			succeeded[j] = true;
        			
        			break;
        		}
        	}
        	
        }
        
        for(int j=0; j<numgooglers; j++){
            	
           if(!succeeded[j] && numsurprises>0){
            		
        	   if((breakdown[j][0]+2-breakdown[j][1] > 2) || (breakdown[j][0]+1>10) || (breakdown[j][1]-1<0)) //greater than 2 is an impossible surprise
        		   continue;
        	   
        	   breakdown[j][1]--;
        	   breakdown[j][0]++;
        	   
        	   numsurprises--;
            }

        }
        
        for(int j=0; j<numgooglers; j++){
        	
        	for(int k=0; k<3; k++){
        		if(!succeeded[j] && breakdown[j][k] >= threshold){
        			answers[i]++;
        			succeeded[j] = true;
        			
        			break;
        		}
        	}
        	
            /*for(int k=0; k<3; k++){
        		System.out.println(breakdown[j][k]);
               }*/
        	
        }

    }
    
    for(int i=0; i<n; i++){
    	out.println("Case #" + (i+1) + ": " + answers[i]);
    }
    
    out.close();                                  
    
    System.exit(0);                             
  }
}
