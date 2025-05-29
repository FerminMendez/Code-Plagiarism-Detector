
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.util.ArrayList;

class jamc {
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
				int num1=Integer.parseInt(split[0]);
				int num2=Integer.parseInt(split[1]);
				
				System.out.println("Case #"+(j+1)+": " + recycleCt(num1, num2));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
    }
    
    public static int recycleCt(int num1, int num2){
    	int ret=0;
    	String num1Str=String.valueOf(num1);
		String num2Str=String.valueOf(num2);
		if(num1Str.length()!=num2Str.length()){
			return 0;
		}
		for(int j=num2; j>=num1; j--)
		for(int i=num1; i<=num2; i++){
			if(i<j)
				if(isRecycled(i, j)) ret++;
		}
		return ret;
    }
  
    public static boolean isRecycled(int num1, int num2){
    	String num1Str=String.valueOf(num1);
		String num2Str=String.valueOf(num2);
		for(int i=0; i < num1Str.length(); i++){
			String tempStr=num1Str.substring(i, num1Str.length()) +num1Str.substring(0, i);
			if(tempStr.compareToIgnoreCase(num2Str)==0) return true;
		}
    	return false;
    }
    
}