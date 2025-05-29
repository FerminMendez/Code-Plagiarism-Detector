package problemB;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class DancingWithTheGooglers {
	
	public static void main(String[] args) throws Exception {
		
		Writer write = new FileWriter(new File("out.txt"));
		Writer writer = new BufferedWriter(write);
		
		Scanner scan = new Scanner(new File("B-small-attempt0.in.txt"));
		
		int t = scan.nextInt();
		
		for(int i = 1; i<=t; i++) {
			int n = scan.nextInt();
			int s = scan.nextInt();
			int p = scan.nextInt();
			Score[] score = new Score[n];
			for(int j = 0; j<score.length; j++) {
				score[j] = new Score(scan.nextInt());
			}
			
			
			int count = 0;
			for(int j = 0; j<n; j++) {
				if(score[j].bestScore(p)) {
					count++;
					score[j] = null;
				}
			}
			
			int surprising = 0;
			for(int j = 0; j<n && surprising<s; j++) {
				if(score[j]!=null) {
					if(score[j].bestScoreOther(p)) {
						count++; surprising++;
					}
				}
			}
			writer.write("Case #"+i+": "+count+"\n");
		}
		
		writer.close();
		write.close();
		
	}
	
	
	private static class Score {
		int[] not;
		int[] surprising;
		
		public Score(int num) {
			not = new int[3];
			buildScores(num);
		}
		
		public boolean bestScore(int score) {
			for(int i : not) {
				if(i>=score) return true;
			}
			return false;
		}
		
		public boolean bestScoreOther(int score) {
			if(surprising==null) return false;
			for(int i : surprising) {
				if(i>=score) return true;
			}
			return false;
		}
		
		private void buildScores(int num) {
			int i = 0;
			while(i<num) {
				if(i<num) { not[0]++; i++; }
				
				if(i<num) {	not[1]++; i++; }
				
				if(i<num) { not[2]++; i++; }
			}
			
			buildSurprising();
		}

		private void buildSurprising() {
			int increment = -1;
			int decrement = -1;
			if(not[0]==not[1]) {
				if(not[0]!=10) increment = 0;
				if(not[1]!=0) decrement = 1;
			} else if (not[0]==not[2]) {
				if(not[0]!=10)increment = 0;
				if(not[0]!=0)decrement = 2;
			} else if (not[1]==not[2]) {
				if(not[0]!=10)increment = 1;
				if(not[0]!=0)decrement = 2;
			}
			
			if(increment!=-1 && decrement!=-1) {
				surprising = new int[]{not[0], not[1], not[2]};
				surprising[increment]++;
				surprising[decrement]--;
			}
		}
		
		
	}

}
