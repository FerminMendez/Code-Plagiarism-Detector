package main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;


public class MyTest {
	public int getNumOfGoogler(int S, int p, List<Integer> points) {
		if(p == 0) {
			return points.size();
		}
		int ret = 0;
		for(int point : points) {
			if(point >= 3 * p - 2) {
				ret++;
			} else if(point >= 3 * p - 4 && S > 0 && p > 1) {
				S--;
				ret++;
			}
		}
		return ret;
	}


	Map<Character, Character> map = new HashMap<Character, Character>();

	public String getTranslation(String gs) {
		String ret = "";
		for(int i=0; i<gs.length(); i++) {
			ret += map.get(gs.charAt(i));
		}
		return ret;
	}

	public void getTranslation() {
		String gs1 = "ejp mysljylc kd kxveddknmc re jsicpdrysi";
		String gs2 = "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd";
		String gs3 = "de kr kd eoya kw aej tysr re ujdr lkgc jv";

		String str1 = "our language is impossible to understand";
		String str2 = "there are twenty six factorial possibilities";
		String str3 = "so it is okay if you want to just give up";
		map.put('q', 'z');
		map.put('z', 'q');
		getTranslation(gs1, str1);
		getTranslation(gs2, str2);
		getTranslation(gs3, str3);
	}

	private void getTranslation(String gs, String str) {
		for(int i=0; i<gs.length(); i++) {
			map.put(gs.charAt(i), str.charAt(i));
		}
	}

	public int getHappyNum(List<Integer> bases) {
		for(int i=bases.get(0); ; i++) {
			boolean breakOut = false;
			for(int base : bases) {
				if(!isNumHappy(i, base)) {
					breakOut = true;
					break;
				}
			}
			if(!breakOut) {
				return i;
			}
		}
	}

	public boolean isNumHappy(int num, int base) {
		int sum = 0;
		List<String> previous = new ArrayList<String>();
		while(sum != 1) {
			sum = 0;
			String numStr = toString(num, base);
			if(previous.contains(numStr)) {
				return false;
			}
			previous.add(numStr);
			for(int i=0; i<numStr.length(); i++) {
				sum += Math.pow(numStr.charAt(i) - '0', 2);
			}
			num = sum;
		}
		return true;
	}

	public String toString(int i, int base) {
		return toString(i, base, 0);
	}

	public String toString(int i, int base, int length) {
		String ret = "";
		while(i != 0) {
			ret = i % base + ret;
			i /= base;
		}
		if(ret.length() < length) {
			ret = new String(new char[length - ret.length()]).replace("\0", "0") + ret;
		}
		return ret;
	}

	public int getTicketFair(int P, int M[], int price[]) {
		int min = Integer.MAX_VALUE;
		int teamNum = (int)Math.pow(2, P);
		int gameNum = teamNum - 1;
		int possibility = (int)Math.pow(2, gameNum);
		for(int i=0; i<possibility; i++) {
			String buy = getBinaryNum(i, gameNum);
			int sum = 0;
			if(doesTeamWork(M, buy)) {
				for(int k=0; k<gameNum; k++) {
					if(buy.charAt(k) == '1') {
						sum += price[k];
					}
				}
			}
			if(sum != 0 && sum < min) {
				min = sum;
			}
		}
		return min;
	}

	private boolean doesTeamWork(int M[], String buy) {
		for(int i=0; i<M.length; i++) {
			int index = i / 2;
			int indexPlus = (buy.length() + 1) / 2;
			int sum = 0;
			int gameNum = 0;
			while(index < buy.length()) {
				if(buy.charAt(index) == '1') {
					sum++;
				}
				gameNum++;
				index = indexPlus + i / (int)Math.pow(2, gameNum+1);
				indexPlus = indexPlus + indexPlus / 2;
			}
			if(gameNum - M[i] > sum) {
				return false;
			}
		}
		return true;
	}

	private String getBinaryNum(int i, int length) {
		String ret = Integer.toBinaryString(i);
		if(ret.length() < length) {
			return new String(new char[length - ret.length()]).replace("\0", "0") + ret;
		}
		return ret;
	}

	public class Chick {
		Chick(int b, int t, int x, int v) {
			T = t;
			B = b;
			X = x;
			V = v;
			arrive = (B - X) / (double)V <= T;
		}

		public int T;
		public int B;
		public int X;
		public int V;
		public boolean arrive;
	}

	public int getSwapNum(List<Chick> chicken, int K) {
		int ret = 0;
		for(int i=chicken.size()-1; i>=0; i--) {
			if(K == 0) {
				break;
			}
			if(!chicken.get(i).arrive) {
				ret += K;
			} else {
				K--;
			}
		}
		if(K != 0) {
			return -1;
		}
		return ret;
	}

	public class Directory {
		Directory(String n) {
			name = n;
			dirs = new ArrayList<Directory>();
		}

		Directory getChild(String name) {
			for(Directory dir : dirs) {
				if(dir.name.equals(name)) {
					return dir;
				}
			}
			return null;
		}

		public String name;
		public List<Directory> dirs;
	}

	public int getNumOfMkdir(Directory root, List<List<String>> newDirs) {
		int ret = 0;
		Directory curr, pre;
		for(List<String> newDir : newDirs) {
			curr = root;
			for(String folder : newDir) {
				pre = curr;
				curr = curr.getChild(folder);
				if(curr == null) {
					ret++;
					pre.dirs.add(new Directory(folder));
					curr = pre.getChild(folder);
				}
			}
		}
		return ret;
	}

	public List<String> getDirNames(String dir) {
		List<String> ret = new ArrayList<String>(Arrays.asList(dir.split("/")));
		ret.remove(0);
		return ret;
	}

	public String rotate(int K, char[][] position) {
		char[][] rotated = new char[position.length][position.length];
		for(int i=0; i<position.length; i++) {
			for(int j=0; j<position.length; j++) {
				rotated[j][position.length-1-i] = position[i][j];
			}
		}
		for(int j=0; j<position.length; j++) {
			int tmp = position.length - 1;
			for(int i=position.length-1; i>=0; i--) {
				if(rotated[i][j] != '.') {
					rotated[tmp][j] = rotated[i][j];
					tmp--;
				}
			}
			for(; tmp>=0; tmp--) {
				rotated[tmp][j] = '.';
			}
		}

		boolean r = checkColor('R', K, rotated);
		boolean b = checkColor('B', K, rotated);

		if(r && b) {
			return "Both";
		} else if(r) {
			return "Red";
		} else if(b) {
			return "Blue";
		} else {
			return "Neither";
		}
	}

	private boolean checkColor(char color, int K, char[][] rotated) {
		int num = 0;
		for(int i=0; i<rotated.length; i++) {
			for(int j=0; j<rotated.length; j++) {
				if(rotated[i][j] == color) {
					num++;
					if(num == K) {
						return true;
					}
				} else {
					num = 0;
				}
			}
			num = 0;
		}

		num = 0;
		for(int i=0; i<rotated.length; i++) {
			for(int j=0; j<rotated.length; j++) {
				if(rotated[j][i] == color) {
					num++;
					if(num == K) {
						return true;
					}
				} else {
					num = 0;
				}
			}
			num = 0;
		}

		num = 0;
		for(int i=0; i<rotated.length; i++) {
			for(int j=0; j<rotated.length; j++) {
				for(int k=0; k<K; k++) {
					if(i+k >=rotated.length || j+k >= rotated.length) {
						break;
					}
					if(rotated[i+k][j+k] == color) {
						num++;
						if(num == K) {
							return true;
						}
					} else {
						break;
					}
				}
				num = 0;
			}
		}

		num = 0;
		for(int i=0; i<rotated.length; i++) {
			for(int j=0; j<rotated.length; j++) {
				for(int k=0; k<K; k++) {
					if(i+k >=rotated.length || j-k < 0) {
						break;
					}
					if(rotated[i+k][j-k] == color) {
						num++;
						if(num == K) {
							return true;
						}
					} else {
						break;
					}
				}
				num = 0;
			}
		}

		return false;
	}

	public class WalkWay implements Comparable<WalkWay>{
		WalkWay(int b, int e, int w) {
			B = b;
			E = e;
			W = w;
		}

		public int B;
		public int E;
		public int W;

		@Override
		public int compareTo(WalkWay o) {
			if(W == o.W) {
				return 0;
			}
			return W < o.W ? -1 : 1;
		}
	}

	public Double getMinTimeForWalkWay(int X, int S, int R, Double t, List<WalkWay> walkWays) {
		int walkWayNum = walkWays.size();
		int tmp = 0;
		for(int i=0; i<X; i++) {
			if(tmp >= walkWayNum) {
				walkWays.add(new WalkWay(i, X, 0));
				break;
			}
			if(i < walkWays.get(tmp).B) {
				walkWays.add(new WalkWay(i, walkWays.get(tmp).B, 0));
				i = walkWays.get(tmp).E - 1;
				tmp++;
			} else if(i == walkWays.get(tmp).B) {
				i = walkWays.get(tmp).E - 1;
				tmp++;
			}
		}
		Collections.sort(walkWays);

		Double ret = new Double(0);
		for(WalkWay walkWay : walkWays) {
			if(t > 0) {
				Double ideaT = (new Double(walkWay.E) - walkWay.B) / (walkWay.W + R);
				if(t >= ideaT) {
					t -= ideaT;
					ret += ideaT;
				} else {
					Double pass = t * (walkWay.W + R);
					ret += t + (new Double(walkWay.E) - pass - walkWay.B) / (walkWay.W + S);
					t = new Double(-1);
				}
			} else {
				ret += (new Double(walkWay.E) - walkWay.B) / (walkWay.W + S);
			}
		}

		return ret;
	}

	public String getPerfertHarmony(Long L, Long H, List<Long> frequencise) {
		boolean flag = true;
		for(long i=L; i<=H; i++) {
			flag = true;
			for(Long frequency : frequencise) {
				if(i % frequency != 0 && frequency % i != 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				return "" + i;
			}
		}
		return "NO";
	}

	public Long getRocketTime(Long L, Long t, Long N, List<Long> distance) {
		Long sum = new Long(0);
		List<Long> singleDis = new ArrayList<Long>();
		for(Long dis : distance) {
			sum += dis;
		}
		Long nRound = N / distance.size();
		Long nRemain = N % distance.size();
		Long time = nRound * sum;
		for(int i=0; i<nRemain; i++) {
			time += distance.get(i);
			singleDis.add(distance.get(i));
		}
		time *= 2;

		if(t >= time || L == 0) {
			return time;
		}

		Long pass = t/2;
		Long passRound = pass / sum;
		Long passRemain = pass % sum;
		Long passRoundRemain = nRound - passRound;

		if(t != 0) {
			for(int i=0; i<distance.size(); i++) {
				if(passRemain > 0) {
					passRemain -= distance.get(i);
				} else {
					singleDis.add(distance.get(i));
				}
			}
			if(passRemain != 0) {
				singleDis.add(-passRemain);
			}
			passRoundRemain--;
		}

		Collections.sort(distance);
		Collections.sort(singleDis);

		Long minus = new Long(0);
		int singleDisIndex = singleDis.size()-1;
		for(int i=distance.size()-1; i>=0; i--) {
			while(singleDisIndex >= 0 && singleDis.get(singleDisIndex) >= distance.get(i)) {
				minus += singleDis.get(singleDisIndex);
				singleDisIndex--;
				L--;
			}
			if(L <= passRoundRemain) {
				minus += L * distance.get(i);
				break;
			} else {
				minus += passRoundRemain * distance.get(i);
				L -= passRoundRemain;
			}
		}

		return time - minus;
	}

	public char[][] tiles;
	public boolean test() {
		for(int i=0; i<tiles.length; i++) {
			for(int j=0; j<tiles[i].length; j++) {
				if(tiles[i][j] == '#') {
					if(i+1 >= tiles.length || j+1 >= tiles[i+1].length || tiles[i][j+1] != '#' || tiles[i+1][j] != '#' || tiles[i+1][j+1] != '#') {
						return false;
					}
					tiles[i][j] = '/';
					tiles[i+1][j] = '\\';
					tiles[i][j+1] = '\\';
					tiles[i+1][j+1] = '/';
				}
			}
		}
		return true;
	}

	public String test1(List<String> words, String seq) {
		int maxScore = -1;
		String maxString = "";

		for(String word : words) {
			int score = -1;
			StringBuilder wildCard = new StringBuilder(new String(new char[word.length()]).replace("\0", "_"));
			List<String> words2 = new ArrayList<String>(words);
			int words2Size = words.size();

			for(int i=0; i<seq.length(); i++) {
				Character seqChar = seq.charAt(i);
				int j=0;

				while(j<words2Size) {
					if(words2.get(j).indexOf(seqChar) != -1) {
						break;
					}
					j++;
				}

				if(j == words2Size) {
					continue;
				}

				if(word.indexOf(seqChar) == -1) {
					score++;
				} else {
					int beginIndex = 0;
					while(true) {
						beginIndex = word.indexOf(seqChar, beginIndex);
						if(beginIndex == -1) {
							break;
						}
						wildCard.setCharAt(beginIndex, seqChar);
						beginIndex++;
					}

					for(j=0; j<words2Size; j++) {
						if(!killerWordWildCard(words2.get(j), wildCard.toString(), seqChar)) {
							words2.remove(words2.get(j));
							words2Size--;
							j--;
						}
					}

					if(words2Size == 1) {
						break;
					}
				}
			}
			if(score > maxScore) {
				maxScore = score;
				maxString = word;
			}
		}
		return maxString;
	}

	private boolean killerWordWildCard(String word, String wildCard, Character notIn) {
		if(!wildCardMatch(word, wildCard)) {
			return false;
		} else if(notIn != null) {
			int begin = -1;
			while(true) {
				if(begin+1 >= word.length()) {
					break;
				}
				begin = word.indexOf(notIn, begin + 1);
				if(begin == -1) {
					break;
				}
				if(wildCard.charAt(begin) != notIn) {
					return false;
				}
			}
			//			wildCard.indexOf(notIn);
		}
		return true;
	}

	private boolean wildCardMatch(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		for(int i=0; i<str1.length(); i++) {
			if(str2.charAt(i) != '_' && str1.charAt(i) != str2.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public static Comparable<Number> max(Comparable... numbers) {
		Comparable<Number> max = numbers[0];

		for(Comparable number : numbers) {
			if(number.compareTo(max) > 0) {
				max = number;
			}
		}
		return max;
	}

	@SuppressWarnings("unchecked")
	public static Comparable<Number> min(Comparable... numbers) {
		Comparable<Number> min = numbers[0];

		for(Comparable number : numbers) {
			if(number.compareTo(min) < 0) {
				min = number;
			}
		}
		return min;
	}

	private int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private int gcd(int a, int b) {
		while(a != b) {
			if(a > b) {
				a -= b;
			} else {
				b -= a;
			}
		}
		return a;
	}

	private double sqrt(double n) {
		double d = n/2.0;
		double lst = 0.0;
		while(lst != d) {
			lst = d;
			d = (d+n/d)/2.0;
		}
		return d;
	}

	private void dfs(int row, int column, String path) {
		HashSet<String> ret = new HashSet<String>();
		HashSet<String> dic = new HashSet<String>();
		boolean[][] used = new boolean[5][5];
		char[][] boggle ={
				{'l', 'i', 'b', 'c', 'd'},
				{'x', 'n', 's', 'c', 'd'},
				{'e', 'd', 'b', 't', 'd'},
				{'l', 'a', 'b', 'c', 'd'},
				{'l', 'i', 's', 't', 'd'}};
		if(!checkRange(row) || !checkRange(column) || used[row][column]) {
			return;
		}
		path += boggle[row][column];
		used[row][column] = true;
		if(dic.contains(path) && !ret.contains(path)) {
			ret.add(path);
			System.out.println(path);
			used[row][column] = false;
			return;
		}

		dfs(row+1, column, path);
		dfs(row-1, column, path);
		dfs(row, column+1, path);
		dfs(row, column-1, path);
		used[row][column] = false;
	}

	private boolean checkRange(int i) {
		return i < 5 && i >= 0;
	}
}