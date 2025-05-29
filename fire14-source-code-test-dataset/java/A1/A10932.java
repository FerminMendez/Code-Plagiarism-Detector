package qualification.problemb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProblemB {

	private class Data {
		
		private int surpricing;
		private int minPoints;
		private List<Integer> points = new ArrayList<Integer>();
		
		public int getSurpricing() {
			return surpricing;
		}
		public void setSurpricing(int surpricing) {
			this.surpricing = surpricing;
		}
		public int getMinPoints() {
			return minPoints;
		}
		public void setMinPoints(int minPoints) {
			this.minPoints = minPoints;
		}
		public List<Integer> getPoints() {
			return points;
		}
		public void setPoints(List<Integer> points) {
			this.points = points;
		}
		
	}
	
	private List<Data> readFile(File f) {
		String nextLine = null;
		List<Data> result = null;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));

			while ((nextLine = reader.readLine()) != null) {
				if (result == null) {
					result = new ArrayList<Data>();
				} else {
					String[] line = nextLine.split(" ");
					Data d = new Data();
					d.setSurpricing(Integer.parseInt(line[1]));
					d.setMinPoints(Integer.parseInt(line[2]));
					
					List<Integer> points = new ArrayList<Integer>();
					for(int i = 0; i < Integer.parseInt(line[0]); i++) {
						d.getPoints().add(Integer.parseInt(line[i + 3]));
					}
					
					result.add(d);
				}
			}

			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}

	private List<Integer> solve(List<Data> data) {
		List<Integer> winners = new ArrayList<Integer>();
		for(Data d : data) {
			winners.add(getMaxWinnerForList(d));
		}
		
		return winners;
	}
	
	private int getMaxWinnerForList(Data data) {
		int winners = 0;
		int surpricing = 0;
		
		for(int point : data.getPoints()) {
			if(point < data.getMinPoints()) {
				continue;
			}
			
			if(point >= 3 * data.getMinPoints() - 2) {
				winners++;
			} else if(point >= 3 * data.getMinPoints() - 4) {
				surpricing++;
			}
		}
		
		winners += Math.min(data.getSurpricing(), surpricing);

		return winners;
	}
	
	private void writeToDisk(List<Integer> output) {
		File f = new File("outputBsmall.txt");
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(f));
			int counter = 1;
			for(int s : output) {
				writer.write("Case #" + counter + ": " + s + "\n");
				counter++;
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	
	public static void main(String[] args) {
		ProblemB c = new ProblemB();
		List<Data> structures = c.readFile(new File(args[0]));
		List<Integer> longs = c.solve(structures);
		c.writeToDisk(longs);
	}

	
}
