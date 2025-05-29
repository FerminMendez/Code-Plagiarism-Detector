package codejam;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QualificationB extends CodeJam {

	public static final List<Integer> grades = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32);
	
	public QualificationB(String file) throws Exception {
		super(file);
		
	}
	
	class Grade {
		int pos;
		ArrayList<Integer> list;
		boolean surprising;
		
		boolean hasHighers(byte p) {
			for (Integer i : list) {
				if (i >= p) return true;
			}
			
			return false;
		}
		
	}

	@Override
	public Object processCase(int caseNumber) throws Exception {
		String readLine = readLine();
		String[] split = readLine.split(" ");
		int g = Integer.parseInt(split[0]);
		final int s = Integer.parseInt(split[1]);
		byte p = Byte.parseByte(split[2]); //0-10
		
		ArrayList<Grade> totalGrades = new ArrayList<Grade>(g);
		
		for (int i = 0; i < g; i++) {
			final int total = Integer.parseInt(split[i+3]);
			ArrayList<ArrayList<Integer>> compute = CombinationGenerator.compute(grades, 3, 3, new CombinationValidator<Integer>() {
				@Override
				public boolean isValid(List<Integer> comb) {
					int min = 11;
					int max = -1;
					
					byte ct = 0;
					for (Integer g : comb) {
						g = g%11;
						
						ct += g;
						if (g < min) min = g;
						if (g > max) max = g;
					}
					
					return ct == total && max - min < 3;
				}
				
			});
			
			ArrayList<Grade> grades = new ArrayList<QualificationB.Grade>(compute.size());
			
			for (ArrayList<Integer> arrayList : compute) {
				
				int min = 11;
				int max = -1;
				
				ArrayList<Integer> newList = new ArrayList<Integer>(3);
				for (Integer g1 : arrayList) {
					g1 = g1%11;
					
					if (g1 < min) min = g1;
					if (g1 > max) max = g1;
					
					newList.add(g1);
					
				}

				boolean alreadyExists = false;
				for (Grade grade : grades) {
					if (grade.list.containsAll(newList) && newList.containsAll(grade.list)) {
						alreadyExists = true;
						break;
					}
				}
				
				if (!alreadyExists) {
					Grade grade = new Grade();
					grade.pos = i;
					grade.list = newList;
					//surprising
					grade.surprising = max - min > 1;
					
					grades.add(grade);
				}
				
			}
			
			totalGrades.addAll(grades);
			
			
		}
		
		ArrayList<ArrayList<Grade>> compute = CombinationGenerator.compute(totalGrades, g, g, new CombinationValidator<Grade>() {

			@Override
			public boolean isValid(List<Grade> comb) {
				int tS = 0;
				
				List<Integer> indexes = new ArrayList<Integer>(3);
				
				for (Grade grade : comb) {
					if (grade.surprising) tS++;
					
					if (indexes.contains(grade.pos)) return false;
					
					indexes.add(grade.pos);
				}
				
				return tS == s;
			}

		});
		
		
		int maxH = 0;
		for (ArrayList<Grade> arrayList3 : compute) {
			int h = 0;
			for (Grade grade : arrayList3) {
				if (grade.hasHighers(p)) h++;
			}
			if (h > maxH) maxH = h;
		}
		return maxH;
	}

	public static void main(String[] args) throws IOException,
			InterruptedException, Exception {
		
		new QualificationB("B-small-attempt0.in").start();

	}
	
	
}
