import java.util.ArrayList;
import java.util.LinkedList;



public class RecycledNumbers {
	public static void solve(String fname) {
		Read r = new Read();
		r.Read(fname);
int numOfTestCases=r.noOfTestCases;
int[] numbers =  r.nums;
String finalAnser="";
for(int i=0;i<numOfTestCases;i++){
	String answer="";
	int firstNum = numbers[2*i];
	int secondNum = numbers[2*i+1];
	int mid = ((secondNum-firstNum)/2)+1;
	int noOfans=0;
	for (int j = firstNum; j < secondNum; j++) {
		String numb = j+"";
//		/LinkedList<Integer> number = new LinkedList<Integer>();	
for (int k = 0; k < numb.length(); k++) {
	String first =  numb.substring(0,k);
	String last =  numb.substring(k,numb.length());
String newNumb = last+first;
int numbC = Integer.parseInt(newNumb);
if((numbC<=secondNum)&&(numbC>j)){
	noOfans++;
}

}

	
		int x=0;
//		int k=0;
//		while(!number.isEmpty()){
//			x=(int) (x+number.removeLast()*Math.pow(10, k));
//			k++;
//		}
		
		
	}
	answer = "Case #"+(i+1)+": "+noOfans;
	finalAnser = finalAnser+answer+"\n";
	
}
r.write("out", finalAnser);
System.out.println(finalAnser);	
	}
	public static void main(String[] args) {
		
	solve("test");
	}
}
