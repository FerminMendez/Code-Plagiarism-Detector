import java.io.File;
import java.io.IOException;
import java.util.Arrays;


public class SolutionC extends Solution {

	public SolutionC(String problemFileName) {
		super(problemFileName);
	}

	@Override
	public StringBuffer solve() {
		StringBuffer buffer = new StringBuffer();

		int array[] = {1,2,3,4,5,6,7};
		
		for (int i = 0; i < problem.count(); i++) {
			String s = problem.getCase(i);
			if(s!=null){
				RecyclePair pair = new RecyclePair(s);
				buffer.append("Case #").append(i + 1).append(": ");
				buffer.append(pair.countPair());
				buffer.append('\n');
			}
		}
		return buffer;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File dir1 = new File(".");
			String filename;
			filename = dir1.getCanonicalPath() + "\\" + args[0];
			Solution solution = new SolutionC(filename);
			StringBuffer buffer = solution.solve();
			solution.saveToFile(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	


	

}

class RecyclePair{
	private int start, stop;
	private int length;
	public RecyclePair(String s){
		String[] token = s.split(" ");
		start = Integer.parseInt(token[0]);
		stop = Integer.parseInt(token[1]);
		length = token[0].length();
	}
	
	public int countPair(){
		int cnt = 0;
		for(int n=start;n<=stop;n++){
			for(int m=n+1;m<=stop; m++ ){
				String strN = String.valueOf(n);
				String strM = String.valueOf(m);
				if(isPair(strN, strM)){
					cnt++;
				}
			}			
		}
		return cnt;
	}
	
	private boolean isPair(String n, String m){
		char[] arrN = n.toCharArray();
		char[] arrM = m.toCharArray();
		
//		System.out.print(Arrays.toString(arrN)+"-");
//		System.out.println(Arrays.toString(arrM));
		
		for (int i = 1; i <= arrN.length; i++) {
			String strM = recycleArray(arrM, i);
			if(n.equals(strM)){
				return true;
			}
		}
		
		return false;
	}
	
	private String recycleArray(char[] array, int cycle){
		int length = array.length;
		char[] outarr = new char[length];			
		System.arraycopy(array, cycle, outarr, 0, length-cycle);
		System.arraycopy(array, 0, outarr, length-cycle, cycle);		
		return new String(outarr);
	}	
}
