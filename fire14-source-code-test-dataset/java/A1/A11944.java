import java.util.ArrayList;
import java.util.List;

import Utils.FileHelper;


public class Gcj2012b {

	
	
	private void solve(String inputPath, String filepath) {
		
		FileHelper fHelper = new FileHelper(inputPath);
		
		String[] inputStr= new String[fHelper.getTotalSize()];
		
		List<String> rstList = new ArrayList<String>();
		
		fHelper.init(inputStr);
		
		for (String str : inputStr) {
			rstList.add(this.caculate(str));
		}
		
		rstList = format(rstList);
		
		FileHelper.writeFile(filepath, rstList);
	}
	
	
	private String caculate(String str) {
		String [] inputList = str.split(" ");
		
		int rawCnt = 0;
		int supCnt = 0;
		
		int total = Integer.parseInt(inputList[0]);
		int suprise = Integer.parseInt(inputList[1]);
		int point = Integer.parseInt(inputList[2]);
		
		int[]inputs = new int[inputList.length - 3];
		
		for(int i = 3; i< inputList.length;++i){
			inputs[i - 3] = Integer.parseInt(inputList[i]);
		}
		
		for(int v : inputs){
			int rst = v / 3;
			int remain = v % 3;
			
			if(remain == 0){
				if(rst >= point) rawCnt ++;
				else if(rst >= point - 1 && rst >=1) supCnt ++;
			}else if(remain == 2){
				if(rst >= point -1)rawCnt ++;
				else if(rst >= point -2 && rst >=1) supCnt ++;
			}else if(remain == 1){
				if(rst >= point - 1) rawCnt ++;
			}
		}
		
		
		return rawCnt + Math.min(suprise, supCnt) +"";
	}


	public static void main(String[] args) {

		Gcj2012b gcj2012b = new Gcj2012b();

		String inputPath = "C:\\Users\\xiaohfan\\Desktop\\B-small-attempt0.in";

		String filepath = "C:\\Users\\xiaohfan\\Desktop\\output.txt";
		
		gcj2012b.solve(inputPath, filepath);

	}




	public static List<String> format(List<String> rstList) {
		
		List<String> outputList = new ArrayList<String>();
		
		for(int i = 0; i < rstList.size();++i	){
			outputList.add("Case #"+ (i+1) +": "+rstList.get(i));
		}
		
		return outputList;
	}
}
