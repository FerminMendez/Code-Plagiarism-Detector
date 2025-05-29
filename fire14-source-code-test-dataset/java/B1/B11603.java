package recyclednumbers;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Helper {
	public static void main(String[] str) {
		System.out.println(rotateDigits(345, 2, true));
	}
	
	public static int rotateDigits(int number, int noOfDigitesToBeMoved, boolean toLeft){
		String str = Integer.toString(number,1);
		char[] chArr = str.toCharArray();
		Queue<Character> numQueue = new ArrayBlockingQueue<Character>(chArr.length);
		for(int i = chArr.length-1; i >= 0; i--){
			numQueue.add(chArr[i]);
		}
		
		Queue<Character> polledItems = new ArrayBlockingQueue<Character>(noOfDigitesToBeMoved);
		
		for(int i = 0; i < noOfDigitesToBeMoved; i++){
			char item = numQueue.poll();
			polledItems.add(item);
		}
		
		for(char ch : polledItems){
			char item = polledItems.poll();
			numQueue.add(item);
		}	
		StringBuffer sb = new StringBuffer();
		for(int i = numQueue.size()-1; i >= 0 ; i--){
			sb.append(numQueue.toArray()[i]);
		}
		return Integer.parseInt(sb.toString());
	}

}
