import java.util.ArrayList;
import java.util.List;

import Utils.FileHelper;


public class Gcj2012c {
	
	

	private static String getPairCount(String str) {
		
		int A = Integer.parseInt( str.split(" ")[0] );
		int B = Integer.parseInt( str.split(" ")[1] );
		
		boolean [] used = new boolean [ B - A + 1];
		
		int size = (A +"").length();
		int rst = 0;
		
		for( int num = A ; num <= B; ++num){
			
			int curNum = num;
			
			int cnt = 0;
			for(int i = 0; i< size; ++i){
				if(curNum > B || curNum < A || used[curNum - A]);
				else{
					used[curNum - A]  = true;
					cnt ++;
				}
				
				int lastD = curNum % 10;
				curNum /= 10;
				curNum = (int) (curNum  + Math.pow(10, size - 1) * lastD);
			}
			
			rst += cnt * (cnt-1)/2;
		}
		
		return rst +"";
	}

	
	private static void solve(String inputPath, String filepath) {
		FileHelper fHelper = new FileHelper(inputPath);
		
		String[] inputStr= new String[fHelper.getTotalSize()];
		
		List<String> rstList = new ArrayList<String>();
		
		fHelper.init(inputStr);
		
		for (String str : inputStr) {
			rstList.add(getPairCount(str));
		}
		
		rstList = format(rstList);
		
		FileHelper.writeFile(filepath, rstList);
		
	}

	



	public static void main(String[] args) {


		String inputPath = "C:\\Users\\xiaohfan\\Desktop\\C-small-attempt0.in";

		String filepath = "C:\\Users\\xiaohfan\\Desktop\\output.txt";
		
		Gcj2012c.solve(inputPath, filepath);

	}



	public static List<String> format(List<String> rstList) {
		
		List<String> outputList = new ArrayList<String>();
		
		for(int i = 0; i < rstList.size();++i	){
			outputList.add("Case #"+ (i+1) +": "+rstList.get(i));
		}
		
		return outputList;
	}
}
