package CodeJam2012;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class RecycledNumbers {

	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		int cases = reader.nextInt();
		reader.nextLine();

		for(int i = 1; i <= cases; i++){
			String _case = reader.nextLine();
			int pos = 0;
			int pos2 = 0;

			while(_case.charAt(pos2) != ' ')
				pos2++;
			int a = Integer.parseInt(_case.substring(pos, pos2));
			pos = pos2 + 1;
			pos2 = pos;

			while(pos2 < _case.length() && _case.charAt(pos2) != ' ')
				pos2++;
			int b = Integer.parseInt(_case.substring(pos, pos2));

			String result = "" + recycleCount3(a, b);

			System.out.println("Case #" + i + ": " + result);
		}
	}

	public static int recycleCount(int a, int b){
		int count = 0;
		HashSet<Integer> nums = new HashSet<Integer>();

		for(int i = a; i <= b; i++){
			String num = i + "";
			
			if(!nums.contains(i)){
				nums.add(i);
				if(num.length() > 1){
					String test_s = num;
					for(int j = 0; j < num.length(); j++){
						test_s = test_s.charAt(test_s.length() - 1) + test_s.substring(0, test_s.length() - 1);
						int int_s = Integer.parseInt(test_s);
						
						if(int_s >= a && int_s <= b && !nums.contains(int_s)){
							nums.add(i);
							nums.add(int_s);
							count++;
						}
					}
				}
			}
		}

		return count;
	}

	public static int recycleCount2(int a, int b){
		int count = 0;
		HashSet<Integer> nums = new HashSet<Integer>();

		for(int i = a; i <= b; i++){

			String test_s = i + "";
			int length = test_s.length();
			HashSet<Integer> temp = new HashSet<Integer>();
			
			for(int j = 0; j < length; j++){
				test_s = test_s.charAt(test_s.length() - 1) + test_s.substring(0, test_s.length() - 1);
				int int_s = Integer.parseInt(test_s);
				temp.add(int_s);
			}
			
			for(Integer in : temp){
				if(!nums.contains(in) && in.intValue() != i){
					nums.add(in);
					count++;
				}
			}
			
			nums.addAll(temp);
		}

		return count;
	}
	
	public static int recycleCount3(int a, int b){
		HashSet<HashSet<Integer>> nums = new HashSet<HashSet<Integer>>();

		for(int i = a; i <= b; i++){

			String test_s = i + "";
			int length = test_s.length();
			HashSet<Integer> temp = new HashSet<Integer>();
			
			for(int j = 0; j < length; j++){
				test_s = test_s.charAt(test_s.length() - 1) + test_s.substring(0, test_s.length() - 1);
				int int_s = Integer.parseInt(test_s);
				temp.add(int_s);
			}
			
			for(Integer in : temp){
				HashSet<Integer> tempSet = new HashSet<Integer>();
				tempSet.add(in);
				tempSet.add(i);
				if(in >= a && in <= b && in.intValue() != i && (!nums.contains(tempSet))){
					nums.add(tempSet);
				}
			}
			
		}

		return nums.size();
	}
}
