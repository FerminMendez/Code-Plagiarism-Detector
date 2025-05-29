package tr0llhoehle.cakemix.googleCodejam;

import java.text.ParseException;
import java.util.ArrayList;

import tr0llhoehle.cakemix.utility.googleCodeJam.Problem;
import tr0llhoehle.cakemix.utility.googleCodeJam.SupportedTypes;

public class DWGProblem extends Problem {

	private int numberOfSuprisingTriplets;
	private int border;
	private int[] dancerSums;

	public DWGProblem() {
		this.types = new SupportedTypes[1];
		this.types[0] = SupportedTypes.LIST_INT;
	}

	@Override
	public void addValue(Object o) throws ParseException {
		ArrayList<Integer> input = (ArrayList<Integer>) o;
		dancerSums = new int[input.get(0)];
		numberOfSuprisingTriplets = input.get(1);
		border = input.get(2);

		for (int i = 0; i < dancerSums.length; i++) {
			dancerSums[i] = input.get(i + 3);
		}

	}

	public int getNumberOfSuprisingTriplets() {
		return numberOfSuprisingTriplets;
	}

	public int getBorder() {
		return border;
	}

	public int[] getDancerSums() {
		return dancerSums;
	}
}
