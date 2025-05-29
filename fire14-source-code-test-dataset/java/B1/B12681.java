import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class main {

	/**
	 * @param args
	 * @throws Exception 
	 */

	public static int[] flag;
	public static ArrayList[] array;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Input in = new Input("small.txt");
		
		File file = new File("out.txt");
		FileWriter filewriter = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(filewriter);
		PrintWriter pw = new PrintWriter(bw);
		
		int n = in.getInt();
		
		for(int i = 0; i < n ; i ++){
			int result = 0;
			int num = i + 1 ;
			int a = in.getInt();
			int b = in.getInt();	
			int d = Integer.toString(a).length();
			array = new ArrayList[b+1];
			for(int j = a ; j <= b; j++){
				array[j] = new ArrayList();
			}
			for(int j = a ; j <=b ; j++){
				String s = Integer.toString(j) + Integer.toString(j);
				result += solve(s,d,a,b,j);				
			}
			
			String ans = "Case #" +num +": "+result; 
			pw.println(ans);
			System.out.println(ans);
		}
		pw.close();
		bw.close();
		filewriter.close();
	}
	
	public static int solve(String s , int d,int a , int b,int j){
		int result = 0;
		int original = j;
		
		for(int i = 0 ; i < d ; i++){
			String sub = s.substring(i+1, i+1+d);
			int subint = Integer.parseInt(sub);
			
			if(subint >= a && subint <=b && subint !=original){
				if(subint<original){
					int flag = 0;
					for(int k  = 0 ; k < array[subint].size(); k++){
						if(Integer.parseInt(array[subint].get(k).toString())==original){
							flag++;
							break;
						}
					}
					if(flag ==0){
						array[subint].add(original);
						result++;
					}
				}else{
					int flag = 0;
					for(int k  = 0 ; k < array[original].size(); k++){
						if(Integer.parseInt(array[original].get(k).toString())==subint){
							flag++;
							break;
						}
					}
					if(flag ==0){
						array[original].add(subint);
						result++;
					}
				}
			}
			
		}
		return result;
	}

}
