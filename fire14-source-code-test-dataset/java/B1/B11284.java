import java.io.*;
import java.util.*;


public class Solution {
	
	public static boolean isRecycled(int n, int m){
		String strN = Integer.toString(n);
		String strM = Integer.toString(m);
		
		String tmp = strN;
		for(int i=0; i<strN.length(); i++){
			StringBuilder tmpStr = new StringBuilder();

			tmpStr.append(tmp.charAt(tmp.length()-1));
			
			for(int j=0; j<tmp.length()-1; j++){
				tmpStr.append(tmp.charAt(j));
			}
			
			tmp = tmpStr.toString();
			
			if(tmp.equals(strM)){
				//System.out.println("RecycledNumber : " + strN + ", " + strM);
				return true;
			}
		}
		
		return false;
	}
	
	public static int calc(int A, int B){
		int ret = 0;
		
		for(int i=A; i<=B; i++){
			for(int j=i+1; j<=B; j++){
				if(isRecycled(i, j)){
					ret ++;
				}
			}
		}
		
		return ret;
	}
	
	public static void main(String[] args){
        if(args.length == 0){
            System.exit(1);
        }

        try{
            FileReader fr = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fr);
            
            FileOutputStream fos = new FileOutputStream("output.out");
            OutputStreamWriter osw = new OutputStreamWriter(fos , "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            
            String tmp_str;
            
            tmp_str = br.readLine();
            
            int numOfCases = Integer.parseInt(tmp_str);
            int caseIndex = 0;

            while((tmp_str = br.readLine()) != null){
            	caseIndex++;

                StringTokenizer st = new StringTokenizer(tmp_str, " ");
                int numOfTokens = st.countTokens();
                String[] tokenOfLine = new String[numOfTokens];
                for(int i=0; i<numOfTokens; i++){
                	tokenOfLine[i] = st.nextToken();
                }
                
                int A = Integer.parseInt(tokenOfLine[0]);
                int B = Integer.parseInt(tokenOfLine[1]);
                
                int ret = calc(A, B);
                
                System.out.println("Case #" + caseIndex + ": " + ret);
                
            	if(caseIndex==numOfCases){
                	bw.write("Case #" + caseIndex + ": " + ret);
            	}else{
                	bw.write("Case #" + caseIndex + ": " + ret + "\n");
            	}
            }
            br.close();
            bw.close();
            osw.close();
            fos.close();

 
        }
        catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }

	}
}
