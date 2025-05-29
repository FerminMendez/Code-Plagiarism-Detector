import java.util.Vector;


public class MyNumbers {

	Vector<Integer> numbers;
	MyNumbers(){
		numbers = new Vector<Integer>();
	}
	
	void add(int num){
		if(!numbers.contains(num))
			numbers.add(num);
	}
	
	
}
