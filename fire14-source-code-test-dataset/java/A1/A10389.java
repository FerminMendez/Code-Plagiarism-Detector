package sholay;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * GoogleDancers
 */
public class GoogleDancers {

	public static String INPUT_FILE_NAME = "B-small-attempt0.in";
	public static String OUTPUT_FILE_NAME = "B-small-attempt0.out";

	class Player implements Comparable<Player> {

		int totalScore;
		int x;
		int y;
		int z;
		int thresholdScore;
		boolean isSurprise;
		boolean isMax;

		/**
		 * @param totalScore
		 * @param thresholdScore
		 * @param x
		 * @param y
		 * @param z
		 */
		Player(int totalScore, int thresholdScore, int x, int y, int z) {
			this.totalScore = totalScore;
			this.thresholdScore = thresholdScore;
			this.x = x;
			this.y = y;
			this.z = z;
			isSurprise = (Math.abs(x - y) >= 2d || Math.abs(y - z) >= 2d || Math
					.abs(x - z) >= 2d);
			isMax = (x >= thresholdScore) || (y >= thresholdScore)
					|| (z >= thresholdScore);
		}

		@Override
		public int compareTo(Player arg0) {
			return (isMax && !isSurprise) ? 1
					: ((isMax && isSurprise) ? 0 : -1);
		}
	}

	//
	Map<Integer, java.util.List<Player>> map = new HashMap<Integer, java.util.List<Player>>();

	/**
	 * Read the input file, decode the input and write the output file
	 * 
	 * @throws IOException
	 */
	public void solve() throws IOException {
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new FileReader(getFile(INPUT_FILE_NAME)));
			out = new PrintWriter(new FileWriter(OUTPUT_FILE_NAME));
			String line = null;
			int lineNum = 0;
			int numTestCase = 0;
			int count = 0;
			while ((line = in.readLine()) != null) {
				if (lineNum >= 0) {
					if (lineNum == 0) {
						numTestCase = Integer.parseInt(line);
					} else {
						count++;
						if (count <= numTestCase) {
							int solution = getMaxBestResult(line);
							out.write("Case #" + count + ": " + solution);
							if (count != numTestCase) {
								out.write("\n");
							}
						} else {
							break;
						}
					}
				}
				lineNum++;
			}

		} catch (Exception ex) {
			System.out.println("Program failed :" + ex.getMessage());
		} finally {
			in.close();
			out.close();
		}
	}

	/**
	 * @param line
	 * @return
	 */
	private int getMaxBestResult(String line) {
		map.clear();
		String[] lineArray = line.split(" ");
		int totalPlayers = Integer.parseInt(lineArray[0]);
		if (totalPlayers > 0) {
			int surprise = Integer.parseInt(lineArray[1]);
			int threshold = Integer.parseInt(lineArray[2]);
			for (int i = 0; i < totalPlayers; i++) {
				List<Player> players = getPossiblePlayers(surprise, threshold,
						Integer.parseInt(lineArray[3 + i]));
				map.put(i, players);
			}
			return findMaxBest(surprise, map);
		}
		return 0;
	}

	/**
	 * @param surprise
	 * @param map
	 * @return
	 */
	private int findMaxBest(int surprise, Map<Integer, List<Player>> map) {
		int maxBest = 0;
		Set<Integer> players = map.keySet();
		for (Integer player : players) {
			List<Player> possibility = map.get(player);
			Player p = getPlayer(surprise, possibility);
			if (p != null) {
				if (p.isMax) {
					maxBest++;
				}
				if (p.isSurprise) {
					surprise--;
				}
			}
		}
		return maxBest;
	}

	/**
	 * @param surprise
	 * @param possibility
	 * @return
	 */
	private Player getPlayer(int surprise, List<Player> possibility) {
		Player pp = null;
		Collections.sort(possibility,Collections.reverseOrder());
		for (Player p : possibility) {
			if (p.isMax && !p.isSurprise) {
				pp = p;
			break;
			}
		}
		if (pp == null) {
			for (Player p : possibility) {
				if (p.isMax && p.isSurprise && surprise > 0) {
					pp = p;
				break;
				}
			}
		}
		if (pp == null) {
			for (Player p : possibility) {
				if (!p.isSurprise && surprise <= 0) {
					pp = p;
				break;
				}
			}
		}
		if (pp == null) {
			for (Player p : possibility) {
				if (!p.isSurprise) {
					pp = p;
				break;
				}
			}
		}
		return pp;
	}

	/**
	 * @param surprise
	 * @param threshold
	 * @param i
	 * @return
	 */
	private List<Player> getPossiblePlayers(int surprise, int threshold,
			int totalScore) {
		List<Player> players = new ArrayList<Player>();
		//
		if ((totalScore) % 3 == 0) {
			int div = (totalScore) / 3;
			if(div>=0) {
				players.add(new Player(totalScore, threshold, div, div, div));
			}
		}
		//
		if ((totalScore - 1) % 3 == 0) {
			int div = (totalScore - 1) / 3;
			if(div>=0){
				players.add(new Player(totalScore, threshold, div, div, div + 1));
			}
		}
		//
		if ((totalScore - 2) % 3 == 0) {
			int div = (totalScore - 2) / 3;
			if(div>=0) {
				players.add(new Player(totalScore, threshold, div, div + 1, div + 1));
				players.add(new Player(totalScore, threshold, div, div, div + 2));
			}
		}
		//
		if ((totalScore - 3) % 3 == 0) {
			int div = (totalScore - 3) / 3;
			if(div>=0) {
				players.add(new Player(totalScore, threshold, div, div + 1, div + 2));
			}
		}
		//
		if ((totalScore - 4) % 3 == 0) {
			int div = (totalScore - 4) / 3;
			if(div>=0) {
				players.add(new Player(totalScore, threshold, div, div + 2, div + 2));
			}
		}
		return players;
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static File getFile(String fileName) {
		return new File(fileName);
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		GoogleDancers googleDancers = new GoogleDancers();
		googleDancers.solve();
	}

}
