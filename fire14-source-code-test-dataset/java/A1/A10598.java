package CaseSolvers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import Controller.IO;

public class WiresCase extends CaseSolver {

	private ArrayList<Short[]> lines;
	private int numOfIntersections;

	public WiresCase(int order, int numberOfLines, IO io) {
		super(order, numberOfLines, io);
	}

	@Override
	public void initializeVars() {
		lines = new ArrayList<Short[]>();
	}

	@Override
	public void addLine(String line) {
		String[] tmp = line.split(" ");
		Short[] tmp2 = { Short.parseShort(tmp[0]), Short.parseShort(tmp[1]) };
		this.lines.add(tmp2);
	}

	@Override
	public void printSolution() {
		System.err.println("Case #" + getOrder() + ": " + numOfIntersections);
	}

	@Override
	public CaseSolver process() {
		Collections.sort(lines, new Comparator<Short[]>() {
			@Override
			public int compare(Short[] o1, Short[] o2) {
				return o1[0] - o2[0];
			}
		});
		//printList();


		for (int i = 0; i < lines.size(); i++) {
			for (int j = i + 1; j < lines.size(); j++) {
				if (lines.get(i)[1] > lines.get(j)[1]) {
					numOfIntersections++;
				}
			}
		}

		return this;
	}

	private void printList() {
		for (Short[] a : lines) {
			System.err.println(Arrays.deepToString(a));
		}
	}
}