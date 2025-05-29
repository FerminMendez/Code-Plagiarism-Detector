//import java.io.*;
import java.util.*;

public class ProblemB {
	public static void main(String[] args) {
		/*
		try {
			System.setIn(new FileInputStream("b-example.in"));
		} catch (Exception e) {}
		*/
		new ProblemB();
	}
	
	public ProblemB() {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for (int n = 0; n < cases; n++) {
			int total = input.nextInt();
			int surprising = input.nextInt();
			int limit = input.nextInt();
			int[] score = new int[total];
			for (int i = 0; i < total; i++) {
				score[i] = input.nextInt();
			}
			int[][] triplet = new int[total][3];
			int[] tripletMax = new int[total];
			int[] tripletMin = new int[total];
			for (int i = 0; i < total; i++) {
				int tempScore = score[i];
				triplet[i][0] = tempScore / 3;
				tempScore -= triplet[i][0];
				triplet[i][1] = tempScore / 2;
				tempScore -= triplet[i][1];
				triplet[i][2] = tempScore;
				tripletMax[i] = Math.max(Math.max(triplet[i][0], triplet[i][1]), triplet[i][2]);
				tripletMin[i] = Math.min(Math.min(triplet[i][0], triplet[i][1]), triplet[i][2]);
			}
			int max = 0;
			int tempSurprising = surprising;
			List<Integer> secondPass = new ArrayList<Integer>();
			for (int i = 0; i < total; i++) {
				secondPass.add(i);
			}
			for (int i = 0; i < total; i++) {
				if (tripletMax[i] >= limit) {
					max++;
				} else if ((score[i] >= 2) && (tempSurprising > 0)) {
					if (tripletMax[i] >= (limit - 1)) {
						if ((tripletMax[i] - tripletMin[i]) == 1) {
							if ((tripletMax[i] == triplet[i][0] && tripletMax[i] == triplet[i][1] && tripletMin[i] == triplet[i][2]) ||
								(tripletMax[i] == triplet[i][0] && tripletMin[i] == triplet[i][1] && tripletMax[i] == triplet[i][2]) ||
								(tripletMin[i] == triplet[i][0] && tripletMax[i] == triplet[i][1] && tripletMax[i] == triplet[i][2])) {
								max++;
								tempSurprising--;
								secondPass.remove(secondPass.indexOf(i));
							}
						} else {
							if (triplet[i][0] == triplet[i][1] && triplet[i][1] == triplet[i][2]) {
								max++;
								tempSurprising--;
								secondPass.remove(secondPass.indexOf(i));
							}
						}
					}
				}
			}
			if (tempSurprising > 0) {
				for (int i : secondPass) {
					if (tempSurprising > 0) {
						if ((tripletMax[i] >= limit) || (score[i] >= 2)) {
							tempSurprising--;
						}
					}
				}
			}
			System.out.println("Case #" + (n+1) + ": " + max);
		}
	}
}
