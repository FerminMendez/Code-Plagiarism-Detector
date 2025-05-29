import java.util.*;
import java.io.*;
class Try{
	
	public static int equate(String currentNumber, String reversibleNumber){
		int count=0;
		char splitPoint = currentNumber.charAt(0);
		for (int i=0;i<reversibleNumber.length();i++){
			if (reversibleNumber.charAt(i)==splitPoint){
				//we've found our pivot
				int start = i;
				String reversedWord="";
				for (int j=0;j<reversibleNumber.length();j++){
					 reversedWord+=reversibleNumber.charAt((start+j)%reversibleNumber.length());
				}
				if (reversedWord.equals(currentNumber)){
					count=1;
					break; //test
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		Scanner file = null;
		try{
			file = new Scanner(new FileInputStream(args[0]));
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(0);
		}
		int inputSize = Integer.parseInt(file.nextLine());
		Node[] limits = new Node[inputSize];
		for (int i=0;i<inputSize;i++){
			String[] line = file.nextLine().split(" ");
			limits[i] = new Node(Integer.parseInt(line[0]),Integer.parseInt(line[1]));
		}
		int Case=1;
		for (Node Interval:limits){
			int count=0;
			int min = Interval.getMin();
			int max = Interval.getMax();
	
			for (int i=min;i<=max;i++){
				
				for (int j=min;j<=max;j++){
					if (j!=i){
						count+=equate(i+"",j+"");
					}
				}
			}
			System.out.println("Case #"+Case+": "+(count/2));
			Case++;
		}
	}
}
