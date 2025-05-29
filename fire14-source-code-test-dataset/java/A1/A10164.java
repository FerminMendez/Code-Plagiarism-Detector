package qualification.dancing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class App {
	
	public static final String INPUT_FILE_NAME = "C:\\Users\\Fred\\Desktop\\input.txt";
	
	private int T;
	
	private int numberOfGooglers;

	private int numberOfSurprises;

	private int floor;
	
	public App() {
		execute();
	}
	
	public void execute() {
		ArrayList<String> linhas = scanning(INPUT_FILE_NAME);
		ArrayList<OneCase> allCases = new ArrayList<OneCase>();
		for (int i = 0; i < T; i++) {
			int[] placar = extractParameters(linhas.get(i));
			allCases.add(new OneCase(getNumberOfGooglers(), getNumberOfSurprises(), getFloor(), placar));
		}
		for (int i = 0; i < T; i++) {
			OneCase oneCase = allCases.get(i);
			int resp = oneCase.counting(oneCase.devolveMaxTodos(oneCase.getPlacar()));
			int j = i + 1;
			System.out.println("Case #" + j + ": " + resp);
		}
	}
	
	public static void main(String[] args) {
		new App();
	}
	
	public int[] extractParameters(String linha) {
		String[] pedacos = linha.split(" ");
		setNumberOfGooglers(Integer.parseInt(pedacos[0]));
		setNumberOfSurprises(Integer.parseInt(pedacos[1]));
		setFloor(Integer.parseInt(pedacos[2]));
		int[] placar = new int[getNumberOfGooglers()];
		for (int k = 0; k < getNumberOfGooglers(); k++) {
			placar[k] = Integer.parseInt(pedacos[k + 3]);
		}
		return placar;
	}
	
	public ArrayList<String> scanning(String fileName) {
		ArrayList<String> linhas = new ArrayList<String>();
		File dominioArq = new File(fileName);
		try {
			FileReader dominioFileReader = new FileReader(dominioArq);
			BufferedReader reader = new BufferedReader(dominioFileReader);
			String linha = "";
			int count = 0; 			
			while ((linha = reader.readLine()) != null) {
				if (count == 0 && fileName.equals(INPUT_FILE_NAME)) 
					setT(Integer.parseInt(linha));
				else 
					linhas.add(new String(linha));
				count++;
			}
			reader.close();
			dominioFileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return linhas;
	}
	
	public void setT(int numberOfCases) {
		this.T = numberOfCases;
	}

	public int getNumberOfGooglers() {
		return numberOfGooglers;
	}

	public void setNumberOfGooglers(int numberOfGooglers) {
		this.numberOfGooglers = numberOfGooglers;
	}

	public int getNumberOfSurprises() {
		return numberOfSurprises;
	}

	public void setNumberOfSurprises(int numberOfSurprises) {
		this.numberOfSurprises = numberOfSurprises;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public int getT() {
		return T;
	}
	
	public class OneCase {


		int numberOfGooglers;

		int numberOfSurprises;

		int floor;

		int[] placar;

		OneCase(int N, int S, int p, int[] t) {
			this.numberOfGooglers = N;
			this.numberOfSurprises = S;
			this.floor = p;
			this.placar = t;
			//testeSanidade();
		}

		public void testeSanidade() {
			if (placar.length != numberOfGooglers)
				System.out.println("ERRO: entrada de dados.");
			else
				System.out.println("entrada de dados esta ok.");
		}

		public int[] devolveMax(int placarIndividual) {
			int[] max = new int[2];
			switch(placarIndividual % 3) {
			case 0 : {
				max[0] = (placarIndividual / 3);
				max[1] = (placarIndividual / 3) + 1;
				break;
			}
			case 1 : {
				max[0] = (placarIndividual - 1) / 3 + 1;
				max[1] = (placarIndividual - 4) / 3 + 2;
				break;
			}
			case 2 : {
				max[0] = (placarIndividual - 2) / 3 + 1;
				max[1] = (placarIndividual - 2) / 3 + 2;
				break;
			}
			default :
				break;
			}
			return max;
		}

		public HashMap<Integer,int[]> devolveMaxTodos(int[] placar) {
			HashMap<Integer,int[]> mappingMax = new HashMap<Integer,int[]>();
			for (int i = 0; i < placar.length; i++) {
				int[] max;
				switch(placar[i]) {
				case 0 : {
					max = new int[]{0,0};
					break;
				}
				case 1 : {
					max = new int[]{1,1};
					break;
				}
				case 29 : {
					max = new int[]{10,10};
					break;
				}
				case 30 : {
					max = new int[]{10,10};
					break;
				}
				default : {
					max = devolveMax(placar[i]);
					break;
				}
				}
				mappingMax.put(new Integer(i), max);
				
			}
			return mappingMax;
		}

		public void printMaxForEachGoogler(HashMap<Integer,int[]> mapping) {
			for (int i = 0; i < numberOfGooglers; i++) {
				System.out.println("googler #" + i + ": {" + mapping.get(i)[0] + ", " + mapping.get(i)[1] + "}");
			}
		}

		public int counting(HashMap<Integer,int[]> mapping) {
			int count = 0;
			int count1 = 0;
			int count2 = 0;
			for (int i = 0; i < numberOfGooglers; i++) {
				int[] individualMaximos = mapping.get(new Integer(i));
				if (isPossibleGetBetter(individualMaximos, floor))
					count2++;
				else{
					if (isSufficient(individualMaximos, floor))
						count1++;
				}
			}
			count = count1 + Math.min(count2, numberOfSurprises);
			return count;
		}

		public boolean isPossibleGetBetter(int[] maximos, int parametro) {
			boolean isPossible = false;
			if ( (parametro == Math.max(maximos[0], maximos[1])) && (maximos[0] != maximos[1]))
				isPossible = true;
			return isPossible;
		}

		public boolean isSufficient(int[] maximos, int parametro) {
			boolean sufficient = false;
			if (parametro <= Math.min(maximos[0], maximos[1]))
				sufficient = true;
			return sufficient;
		}
		
		public int[] getPlacar() {
			return placar;
		}
	}

	
}
