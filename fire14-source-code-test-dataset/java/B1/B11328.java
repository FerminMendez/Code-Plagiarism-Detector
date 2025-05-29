package recycledNumbers;

import java.util.ArrayList;

public class Algorithms {

	public static OutputData getOutput(InputData inputdata) {
		// TODO Auto-generated method stub
		int [] Results = new int[inputdata.getTest_Number()];
		
		for(int i=0;i<Results.length;i++){
			Results[i] = getSingleResult(inputdata.getA()[i], inputdata.getB()[i]);
		}
		
		OutputData outputdata = new OutputData(Results);
		return outputdata;
	}

	private static int getSingleResult(int a, int b) {
		// TODO Auto-generated method stub
		int result = 0;
		for(int i=a;i<b+1;i++){
			ArrayList<Integer> number = new ArrayList<Integer>();
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			int temp = i; 
			while(temp/10>0){
				number.add(temp%10);
				temp = temp/10;
			}
			number.add(temp%10);
			
			for(int j=0;j<number.size();j++){
				numbers.clear();
				for(int k=0;k<number.size();k++){
					numbers.add(number.get(k));
				}
				ArrayList<Integer> part = new ArrayList<Integer>();
				for(int k=0;k<j;k++){
					int temp1 = numbers.remove(0);
					part.add(temp1);
				}
				numbers.addAll(part);
				
				int newint = 0;
				for(int k=0;k<numbers.size();k++){
					newint += numbers.get(k)*pow(10,k);
				}
				//System.out.println(i+" "+newint+" "+j);
				if(i<newint && newint<=b){
					System.out.println(i+" "+newint+" "+j);
					result++;
				}
			}
			//System.exit(0);
		}
		return result;
	}

	private static Integer pow(int i, int k) {
		// TODO Auto-generated method stub
		if(k==0){
			return 1;
		}else{
			return pow(i, k-1)*i;
		}
	}


}
