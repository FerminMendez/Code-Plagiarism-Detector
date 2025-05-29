import java.util.Scanner;


public class Solution {
	
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		for (int count = 1; count <= size; count++){
			int dancerNum = s.nextInt();
			int surpNum = s.nextInt();
			int score = s.nextInt();
			int[] dancerScore = new int[dancerNum];
			char[] marks = new char[dancerNum];
			for (int i = 0; i < dancerNum; i++){
				dancerScore[i] = s.nextInt();
			}
			
			int highB = score * 3 - 2;
			int lowB = (score - 1) * 3 - 1;
			int output = 0;
			int sup  = surpNum;
			int markIdx = 0;
			if (score < 2)
			{
				for (Integer i : dancerScore){
					if (i >= score)
					{
						marks[markIdx] = '+';
						output++;
					}else{
						marks[markIdx] = '-';
					}
					markIdx++;
				}
				
			}
			else
			{
				for (Integer i : dancerScore){
					if (i >= highB){
						output++;
						marks[markIdx] = '+';
					}else if (i< highB && i >= lowB && sup > 0){
						//if (){
						output++;
						sup--;
						marks[markIdx] = '*';
//						}else{
//							
//							marks[markIdx] = '-';
//						}
					}
					else{
						marks[markIdx] = '-';
					}
					markIdx++;
				}
			}
//			System.out.print("Case #"+count+": " + dancerNum + " " + surpNum + " "+ score + "		");
//			for (Integer i: dancerScore)
//			{
//				System.out.print(i+"	");
//			}
			System.out.println("Case #"+count+": "+output);
//			for (Character mark: marks)
//			{
//				System.out.print(mark+"	");
//			}
//			System.out.println();
		}
		
	}

}
