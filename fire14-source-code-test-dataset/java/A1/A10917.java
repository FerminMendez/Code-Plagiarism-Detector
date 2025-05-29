//package dancing_with_googler;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Solution {

	/**
	 * @param args
	 */
	public void doit() throws Exception{
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
		         FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
		Scanner s = new Scanner(new BufferedInputStream(System.in));
		int cases = s.nextInt();
		for(int i=0;i<cases;i++){
			int N = s.nextInt();//# of googler
			int S = s.nextInt();//# of suprising
			int P = s.nextInt();//expected value
			int score[] = new int[N];
			int non_surprising[] = {0,1,4,7,10,13,16,19,22,25,28};
			int surprising[] = {2,2,2,5,8,11,14,17,20,23,26};
			int count = 0;
			for(int j=0;j<N;j++){
				score[j] = s.nextInt();
				if(non_surprising[P]<=score[j]){
					count++;
				}else if(S>0&&surprising[P]<=score[j]){
					S--;count++;
				}
			}
			out.append("Case #" + (i+1) + ": " + count);
			out.append('\n');
		}
		out.flush();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		try{
			s.doit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
