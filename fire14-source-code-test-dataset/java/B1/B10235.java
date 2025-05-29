import java.net.*;
import java.io.*;
import java.lang.*;

public class RecycledNumbers {
    public static void clear(int[] arr){
    	for(int i=0; i<30; i++)
    		arr[i] = -1;		
    }
    public static boolean checkEntry(int x, int[] arr){
    	for(int i=0; i<30; i++) {
    		if(x == arr[i])
    			return true;
    	}
    	return false;	
    }
    
    
    public static void main(String[] args) throws IOException {
    
    String[] spl;
    int counter = 1;
    int count = 0;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input;
		int a,b,e = 0;
		String xform;
		int[] arr = new int[30]; int arrCounter = 0;
		clear(arr); 
		
		while((input = in.readLine()) != null){
			spl = input.split(" ");
			a = Integer.parseInt(spl[0]);
			b = Integer.parseInt(spl[1]);
			int bLength = (Integer.toString(b)).length();
			for(int i=a; i<b; i++) {
				clear(arr); arrCounter = 0;
				xform = Integer.toString(i);
				int l = xform.length();
				//System.out.println("number:" + xform + '\t' + "length:" + l);
				for(int j=1; j<l; j++) {	
					for(int k=0; k<l; k++){
						int index = (k + j) % l;
						if(xform.charAt(index) < xform.charAt(k))
							break;
						else if(xform.charAt(index) > xform.charAt(k)) {
							if( (bLength > l) || (b >= (e = Integer.parseInt(xform.substring(j) + xform.substring(0 , j)))) ) {    
								//System.out.println("number:" + xform + '\t' + Integer.parseInt(xform.substring(j) + xform.substring(0 , j)));
								if(!checkEntry(e , arr)){
									count++;
									arr[arrCounter] = e;
									arrCounter++;
								}
								break;
							}
							else
								break;
						}
						else
							continue;
					}
				}
			}
			
			System.out.println("Case #" + counter + ": " + count );
			counter++; count = 0;
		}
		
		    

}}
