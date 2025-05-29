
public class testCase {

	public testCase(int n){
		T = n;
		cases = new String[T];
		count=0;
	}
	public void addCase(String s){
		if(count > T-1){
			System.out.println("STOP ! too many test cases !!");
			return;
		}
		cases[count++] = s;
	}
	
	int count;
	
	int T;
	String[] cases;
}
