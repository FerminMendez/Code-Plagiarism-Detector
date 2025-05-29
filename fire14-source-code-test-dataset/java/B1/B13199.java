package tr0llhoehle.cakemix.utility.googleCodeJam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * {@link IOManager} is used to manage all input and output operations needed
 * for your java-solution of a Google codejam problem.
 * 
 * It uses the class/interface {@link Problem} and {@link Solver}.
 * 
 * @author Cakemix
 * 
 * @param <S>
 *            The type of your concrete Solver-implementation which solves the
 *            Problem P.
 * @param <P>
 *            The type of your concrete Problem.
 * @see Problem
 * @see Solver
 */
public class IOManager<S extends Solver<P>, P extends Problem> {

	private S solver;
	private Class<P> clazz;
	private LinkedList<P> problems;

	/**
	 * Creates a new IOManager.
	 * 
	 * @param solver
	 *            The solver-instance which is to be used for solving the
	 *            problems.
	 * @param clazz
	 *            A Class object of one exemplary concrete Problem P. This is
	 *            needed to correctly instantiate new concrete Problems.
	 */
	public IOManager(S solver, Class<P> clazz) {
		this.clazz = clazz;
		this.solver = solver;
	}

	private P createProblem() throws InstantiationException,
			IllegalAccessException {
		return clazz.newInstance();
	}

	/**
	 * Starts the IO-operations and solves the Problems contained in the file
	 * pointed to by the filePath.
	 * 
	 * @param filePath
	 *            A String describing the location of an input-file (usually
	 *            *.in)
	 * @throws IOException
	 * @throws ParseException
	 */
	public void start(String filePath) throws IOException, ParseException {
		int amountOfProblems;
		File out;
		Scanner lineScanner;
		File in = new File(filePath);
		Scanner scanner;
		FileWriter writer;

		System.out.print("Creating files... ");
		if (filePath.length() >= 3
				&& filePath.substring(filePath.length() - 3).equals(".in")) {
			filePath = filePath.substring(0, filePath.length() - 3);
		}
		filePath += ".out";

		out = new File(filePath);
		out.createNewFile();
		System.out.println("Done!");

		System.out.print("Creating file reader and writers... ");
		scanner = new Scanner(in);
		writer = new FileWriter(out);
		System.out.println("Done!");

		System.out.print("Parsing the input file... ");
		amountOfProblems = scanner.nextInt();
		scanner.nextLine();
		problems = new LinkedList<P>();
		for (int probID = 0; probID < amountOfProblems; probID++) {
			P problem = null;
			try {
				problem = createProblem();
				SupportedTypes[] probTypes = problem.getTypes();
				for (SupportedTypes t : probTypes) {
					switch (t) {
					case INT:
						lineScanner = new Scanner(scanner.nextLine());
						problem.addValue(lineScanner.nextInt());
						break;
					case DOUBLE:
						lineScanner = new Scanner(scanner.nextLine());
						problem.addValue(lineScanner.nextDouble());
						break;
					case BOOLEAN:
						lineScanner = new Scanner(scanner.nextLine());
						problem.addValue(lineScanner.nextBoolean());
						break;
					case STRING:
						problem.addValue(scanner.nextLine());
						break;
					case LIST_INT:
						lineScanner = new Scanner(scanner.nextLine());
						ArrayList<Integer> ints = new ArrayList<Integer>();
						while (lineScanner.hasNext()) {
							ints.add(lineScanner.nextInt());
						}
						problem.addValue(ints);
						break;
					case LIST_DOUBLE:
						lineScanner = new Scanner(scanner.nextLine());
						ArrayList<Double> doubles = new ArrayList<Double>();
						while (lineScanner.hasNext()) {
							doubles.add(lineScanner.nextDouble());
						}
						problem.addValue(doubles);
						break;
					case LIST_BOOLEAN:
						lineScanner = new Scanner(scanner.nextLine());
						ArrayList<Boolean> booleans = new ArrayList<Boolean>();
						while (lineScanner.hasNext()) {
							booleans.add(lineScanner.nextBoolean());
						}
						problem.addValue(booleans);
						break;
					case LIST_STRING:
						lineScanner = new Scanner(scanner.nextLine());
						ArrayList<String> strings = new ArrayList<String>();
						while (lineScanner.hasNext()) {
							strings.add(lineScanner.next());
						}
						problem.addValue(strings);
						break;
					default:
						System.err
								.print("Default case! This is not a good sign... ");
					}
				}
			} catch (IllegalAccessException e) {
				System.err.println("Couldn't instantiate the problem!");
				e.printStackTrace();
			} catch (InstantiationException e) {
				System.err.println("Couldn't instantiate the problem!");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (problem != null) {
				problems.add(problem);
			}
		}
		System.out.println("Done!");

		System.out.print("Closing the input file... ");
		scanner.close();
		System.out.println("Done!");

		System.out.print("Solving the problems... ");
		for (int i = 0; i < problems.size(); i++) {
			writer.append("Case #" + (i+1) + ": " + solver.solve(problems.get(i))
					+ System.getProperty("line.separator"));
		}
		System.out.println("Done!");

		System.out.print("Closing the writer... ");
		writer.close();
		System.out.println("Done!");

		System.out.println("Shutting down, output lies here:");
		System.out.println(filePath);
	}
}
