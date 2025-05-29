package cw.codejam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Dance_B {
	List<Bcase> cases = new ArrayList<>();
	
	private static class Bcase{
		int targetScore, surprises;
		List<Integer> totals = new ArrayList<>();
		int answer;
	}

	public static void main(String[] args) {
		Dance_B dance = new Dance_B();

		File infile = new File(args[0]);
		File outfile = new File(infile.getParent(), "b.out.txt");

		dance.parse(infile);
		dance.solve();
		dance.output(outfile);
	}

	/**
	 * Pop the highest sorted totals. Utilize surprise scores to achieve max spread for max results  
	 */
	void solve() {
		for(Bcase bcase : cases){
			//e.g.: desire 8, score=8 7 7
			int minBaseline = Math.max(bcase.targetScore * 3 - 2, 0);
			
			//e.g.: desire 8, score = 8 6 6
			int minSurpriseBaseline = Math.max(bcase.targetScore * 3 - 4, 0);
			
			//sort and build stack
			Collections.sort(bcase.totals);
			Stack<Integer> stack = new Stack<>();
			for(int i: bcase.totals){
				stack.push(i);
			}
			
			while(!stack.isEmpty()){
				//highest total on the stack
				int aScore = stack.pop();
				
				//special case for 0 total. A 0 total means each vote is 0
				if(aScore == 0 ){
					if(bcase.targetScore == 0){
						bcase.answer++;
					}
				} else if(aScore >= minBaseline){
					//done, easy spread
					bcase.answer++;
				} else if (bcase.surprises > 0){
					//attempt to use a surprise score
					if(aScore >= minSurpriseBaseline){
						bcase.surprises--;
						bcase.answer++;
					}
				}
			}
		}
	}

	void parse(File infile) {
		try (Scanner scanner = new Scanner(infile)) {
			int numCases = Integer.parseInt(scanner.nextLine());
			for (int i = 0; i < numCases; i++) {
				Bcase bcase = new Bcase(); 
				final int n = scanner.nextInt();
				bcase.surprises = scanner.nextInt();
				bcase.targetScore = scanner.nextInt();
				
				for(int x=0; x<n; x++){
					bcase.totals.add(scanner.nextInt());
				}
				cases.add(bcase);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void output(File outfile) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outfile))) {
			int i=1;
			for(Bcase bcase : cases){
				bw.write(String.format("Case #%d: %d\n", i++, bcase.answer));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
