package tr0llhoehle.cakemix.googleCodeJam.recycledNumbers;

import java.io.IOException;
import java.text.ParseException;

import tr0llhoehle.cakemix.utility.googleCodeJam.IOManager;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length >= 1) {
			IOManager<RNSolver, RNProblem> io = new IOManager<RNSolver, RNProblem>(
					new RNSolver(),
					(Class<RNProblem>) new RNProblem().getClass());
			try {
				io.start(args[0]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
