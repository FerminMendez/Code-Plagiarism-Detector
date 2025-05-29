package de.johanneslauber.codejam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import de.johanneslauber.codejam.model.ICase;
import de.johanneslauber.codejam.model.IProblem;

/**
 * provids the cases for a problem
 * 
 * @author Johannes Lauber - joh.lauber@googlemail.com
 * 
 */
public class CaseProvider {

	private int numberOfCases;
	private List<ICase> listOfCases;

	/**
	 * Read the file line by line and write it to a list of cases
	 * 
	 * @author Johannes Lauber - joh.lauber@googlemail.com
	 * @param fileName
	 * @throws IOException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void importFile(String fileName, Class caseClass)
			throws IOException, InstantiationException, IllegalAccessException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				new DataInputStream(new FileInputStream(fileName))));

		// Read File Line By Line
		String stringLine = reader.readLine();
		setNumberOfCases(Integer.valueOf(stringLine));

		List<ICase> listOfCases = new ArrayList<ICase>();
		ICase currentCase = createEmptyCase(caseClass);

		int i = 1;
		while ((stringLine = reader.readLine()) != null) {

			if (i <= currentCase.getNumberOfAttributes()) {
				currentCase.setLine(i, stringLine);
				i++;
			} else {
				listOfCases.add(currentCase);
				currentCase = createEmptyCase(caseClass);
				i = 1;
				currentCase.setLine(i, stringLine);
				i++;
			}
		}
		// don't forget to add the last case
		listOfCases.add(currentCase);

		reader.close();

		this.listOfCases = listOfCases;
	}

	/**
	 * 
	 * @author Johannes Lauber - joh.lauber@googlemail.com
	 * @param caseClass
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	private ICase createEmptyCase(Class<ICase> caseClass)
			throws InstantiationException, IllegalAccessException {
		ICase currentCase = caseClass.newInstance();
		return currentCase;
	}

	/**
	 * 
	 * @author Johannes Lauber - joh.lauber@googlemail.com
	 * @param forName
	 */
	public void solveCases(Class<?> forName) {

		try {
			IProblem problem = (IProblem) forName.newInstance();
			problem.setListOfCases(listOfCases);
			problem.solveCases();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Setter & Getter
	public int getNumberOfCases() {
		return numberOfCases;
	}

	public void setNumberOfCases(int numberOfCases) {
		this.numberOfCases = numberOfCases;
	}

	public List<ICase> getListOfCases() {
		return listOfCases;
	}

	public void setListOfCases(List<ICase> listOfCases) {
		this.listOfCases = listOfCases;
	}

}
