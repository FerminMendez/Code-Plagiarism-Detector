
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class RecycleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(".in")));
		int num =0;
		String line = null;
		line = br.readLine();
		int i=0;
		num = Integer.parseInt(line);
		
		while(num-->0){
			int result = 0;
			line = br.readLine();
			i++;
			String[] nums = line.split(" ");
			int min = Integer.parseInt(nums[0]);
			int max = Integer.parseInt(nums[1]);
			
			for(int t=min;t<=max;t++){
				result += countRecyles(t,min,max);
			}
			
			System.out.println("Case #"+i+": "+result/2);
			
		}
		br.close();
	}
	
	public static int countRecyles(int num,int min,int max){
		int count = 0;
		Set<Integer> result = getNums(num);
		for(int i:result){
			if(i>=min&&i<=max){
				count++;
			//	System.out.println(num+","+i);
			}
			
		}
		
		return count;
	}
	
	public static Set<Integer> getNums(int num){
		Set<Integer> list = new HashSet<Integer>();
		
		StringBuilder sb = new StringBuilder(num+"");
		for(int i=0;i<sb.length();i++){
			char last = sb.charAt(sb.length()-1);
			sb.deleteCharAt(sb.length()-1);
			sb.insert(0, last);
			if(last!='0'){
				int tmp = Integer.parseInt(sb.toString());
				if(tmp != num)
					list.add(tmp);
			}
		}
		
		return list;
	}
	

}
