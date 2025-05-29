package br.ufmg.dcc.codejam.problemas;

import java.io.FileNotFoundException;
import java.io.IOException;

import br.ufmg.dcc.codejam.util.ArquivoEscrita;
import br.ufmg.dcc.codejam.util.ArquivoLeitura;

/**
 * Solution for Problem B (Dancing With the Googlers) of Google Code Jam 2012
 * @author Marcio
 *
 */
public class ProblemB
{
	/**
	 * Number of test cases
	 */
	private int m_numTestCases;
	
	/**
	 * Input file
	 */
	private ArquivoLeitura m_inputFile;
	
	/**
	 * Output file
	 */
	private ArquivoEscrita m_outputFile;
	
	/**
	 * Constructor
	 * @param p_inputFile The input file for the problem
	 * @param p_outputFile The output file for the problem
	 */
	public ProblemB(ArquivoLeitura p_inputFile, ArquivoEscrita p_outputFile)
	{
		m_inputFile = p_inputFile;
		m_outputFile = p_outputFile;
		m_numTestCases = Integer.parseInt(p_inputFile.lerLinha());
	}
	
	/**
	 * Main method
	 * @param p_args Program arguments. Argument 0 is the input file name and argument 1 is the output file name
	 */
	public static void main(String[] p_args)
	{
		ArquivoLeitura v_inputFile = null;
		ArquivoEscrita v_outputFile = null;
		
		try
		{
			v_inputFile = new ArquivoLeitura(p_args[0]);
			v_outputFile = new ArquivoEscrita(p_args[1]);
			
			ProblemB v_problemB = new ProblemB(v_inputFile, v_outputFile);
			v_problemB.solve();
		}
		catch (FileNotFoundException v_exception)
		{
			System.out.println("File not found!");
			v_exception.printStackTrace();
		}
		catch (IOException v_exception)
		{
			System.out.println("IO error!");
			v_exception.printStackTrace();
		}
		finally
		{
			if(v_inputFile != null)
			{
				v_inputFile.fechar();
			}
			if(v_outputFile != null)
			{
				v_outputFile.fechar();
			}
		}
	}

	/**
	 * Solves the problem
	 */
	private void solve()
	{
		for(int v_numTestCase = 1; v_numTestCase <= m_numTestCases; v_numTestCase++)
		{
			solveTestCase(v_numTestCase, m_inputFile.lerLinha());
		}
	}

	/**
	 * Solves a test case
	 * @param p_numTestCase Number of the test case
	 * @param p_inputLine Input line of the test case
	 */
	private void solveTestCase(int p_numTestCase, String p_inputLine)
	{
		m_outputFile.escrever("Case #" + p_numTestCase + ": ");
		
		String[] v_data = p_inputLine.split(" ");
		
		@SuppressWarnings("unused")
		int v_numGooglers = Integer.parseInt(v_data[0]);
		int v_numSurprises = Integer.parseInt(v_data[1]);
		int v_bestResult = Integer.parseInt(v_data[2]);
		int v_answer = 0;
		
		int v_minScoreWithoutSurprises = 0; 
		int v_minScoreWithSurprises = 0; 	
		
		if(v_bestResult == 0)
		{
			v_minScoreWithoutSurprises = 0;
			v_minScoreWithSurprises = 0;
		}
		else if(v_bestResult == 1)
		{
			v_minScoreWithoutSurprises = 1;
			v_minScoreWithSurprises = 1;
		}
		else
		{
			v_minScoreWithoutSurprises = (3*v_bestResult) - 2;
			v_minScoreWithSurprises = v_minScoreWithoutSurprises - 2;
		}
		
		for(int i = 3; i < v_data.length; i++)
		{
			int v_totalPoints = Integer.parseInt(v_data[i]);
			
			if(v_totalPoints >= v_minScoreWithoutSurprises)
			{
				v_answer++;
			}
			else if(v_numSurprises > 0 && v_totalPoints >= v_minScoreWithSurprises)
			{
				v_answer++;
				v_numSurprises--;
			}
		}
		m_outputFile.escrever(String.valueOf(v_answer));
		
		if(p_numTestCase != m_numTestCases)
		{
			m_outputFile.escreverLinha("");
		}
	}
}
