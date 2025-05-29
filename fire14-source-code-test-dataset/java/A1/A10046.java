package code.jam.quali;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class Line {
	int n;
	int s;
	int p;
	ArrayList<Integer> res;

	public Line(int n, int s, int p, ArrayList<Integer> res) {
		super();
		this.n = n;
		this.s = s;
		this.p = p;
		this.res = res;
	}

}

public class Dancing {

	private static final String file = "B-small-attempt0.in";
	private ArrayList<Line> lines;
	private Integer count;

	public static void main(String[] args) throws Exception {
		Dancing g = new Dancing();

		g.readFile();
		g.calculate();

	}

	private void calculate() {

		int i = 1;
		for (Line line : lines) {
			int result = 0;
			int sLim = 0;
			int nsLim = 0;
			if (line.p > 1) {
				nsLim = (3 * line.p) - 2;
				sLim = (3 * line.p) - 4;
			}
			else if (line.p == 1)
			{
				nsLim = 1;
				sLim = 1;
			}

			Integer tp = null;
			Iterator<Integer> it = line.res.iterator();
			while (it.hasNext()) {
				tp = it.next();
				if (tp >= nsLim) {
					result++;
					it.remove();
				}
			}

			it = line.res.iterator();
			while (it.hasNext() && line.s > 0) {
				tp = it.next();
				if (tp >= sLim) {
					result++;
					line.s--;
					it.remove();
				}
			}
			System.out.println("Case #" + i + ": " + result);
			i++;
		}
	}

	private void readFile() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(
					"D:/Martin/Downloads/" + file)));
			String sline = null;
			sline = br.readLine();
			count = Integer.valueOf(sline.trim());
			lines = new ArrayList<Line>();
			while ((sline = br.readLine()) != null) {
				String[] sp = sline.split(" ");
				ArrayList<Integer> r = new ArrayList<>();
				for (int i = 3; i < sp.length; i++)
					r.add(Integer.valueOf(sp[i]));

				Line line = new Line(Integer.valueOf(sp[0]),
						Integer.valueOf(sp[1]), Integer.valueOf(sp[2]), r);
				lines.add(line);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
