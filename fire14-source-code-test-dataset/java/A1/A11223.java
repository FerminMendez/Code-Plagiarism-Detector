import java.io.*;
import java.util.*;


public class Solution {
	
	public static int calc(int N, int S, int p, int[] t){
		int ret = 0;
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<t.length; i++){
			if(Math.ceil((double)t[i]/3) >= p){
				ret ++;
			}
			// surprising候補
			else{
				list.add(new Integer(t[i]));
			}
		}
		
		// surprising候補を降順にソート
		Collections.sort(list, new Comparator<Integer>(){
		      public int compare(Integer t1, Integer t2) {
		          return t2 - t1;
		        }
		      });
		
		for(Integer ii : list){
			if(S>0){
				// surprisingで+1操作できる条件
				//   - 合計値が2以上
				//   - 合計値を構成する3つの数値のうち、3つが同じ数 または 大きい方の2つが同じ数
				if(ii.intValue() >= 2 && (ii.intValue()%3 != 1)){
					// 合計値を3で割った値を切り上げて最大値とする
					if(Math.ceil((double)ii.intValue()/3) >= p-1){
						System.out.println("includes surprising " + ii.intValue() + "->" + (Math.ceil((double)ii.intValue()/3)+1) + "," + "other");
						ret ++;
						S --;
						if(S == 0){
							break;
						}
					}
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
                
                int N = Integer.parseInt(tokenOfLine[0]);
                int S = Integer.parseInt(tokenOfLine[1]);
                int p = Integer.parseInt(tokenOfLine[2]);
                
                //System.out.println("N:" + N);
                //System.out.println("S:" + S);
                //System.out.println("p:" + p);
                
                int[] t = new int[N];
                for(int i=0; i<N; i++){
                	int j=i+3;
	                t[i] = Integer.parseInt(tokenOfLine[j]);
	                //System.out.println("t[" + i + "]:" + t[i]);
                }
                
                int ret = calc(N, S, p, t);
                
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
