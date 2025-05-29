package tr0llhoehle.cakemix.googleCodeJam.recycledNumbers;

import java.text.ParseException;
import java.util.ArrayList;

import tr0llhoehle.cakemix.utility.googleCodeJam.Problem;
import tr0llhoehle.cakemix.utility.googleCodeJam.SupportedTypes;

public class RNProblem extends Problem {

	private int lowerBorder;
	private int upperBorder;

	public RNProblem() {
		types = new SupportedTypes[1];
		types[0] = SupportedTypes.LIST_INT;
	}

	public void addValue(Object o) throws ParseException {
		ArrayList<Integer> temp = (ArrayList<Integer>) o;

		lowerBorder = temp.get(0);
		upperBorder = temp.get(1);

		super.addValue(o);
	}

	public int getLowerBorder() {
		return lowerBorder;
	}

	public int getUpperBorder() {
		return upperBorder;
	}
}
