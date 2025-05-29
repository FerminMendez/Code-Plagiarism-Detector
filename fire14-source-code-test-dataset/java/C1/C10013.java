import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;


public class GCJ4 {
	
	public static int gcd(int a, int b) {
		int a0 = Math.abs(a);
		int b0 = Math.abs(b);
		int max = Math.max(a0, b0);
		int min = Math.min(a0, b0);
		if (min == 0) return max;
		int r = max % min;
		while (r != 0) {
			max = min;
			min = r;
			r = max % min;
		}
		return min;
	}
	
	GCJ4 (int h, int w, int d, char[][] matrix) {
		this.h = h;
		this.w = w;
		this.d = d;
		this.matrix = matrix;
	}
	
	static class Angle {
		public Angle(int x, int y) {
			int gcd = gcd(x,y);
			this.x = x / gcd;
			this.y = y / gcd;
		}
		
		final int x;
		final int y;
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Angle) {
				Angle other = (Angle) obj;
				//if (other.x * y == other.y * x)
				if (other.x == x && other.y == y)
					return true;
			}
			return false;
		}
		@Override
		public int hashCode() {
			return x * 31 + y;
		}
	}
	
	public int simpleResult() {

		System.out.println("d: " + d);
		int result = 0;
		Set<Angle> set = new HashSet<Angle>();
		
		calPos();
		float w0 = w - 2;
		float h0 = h - 2;
		int numW = (int) Math.ceil(d / w0);
		int numH = (int) Math.ceil(d / h0);
		for (int s=-numW; s<=numW; s++) {
			for (int t=-numH; t<=numH; t++) {
				if (s == 0 && t == 0) continue;
				float otherX = s * w0;
				if (s % 2 == 0)
					otherX += posX;
				else 
					otherX += (w0-posX);
				int dx = (int)(otherX - posX);
				float otherY = t * h0;
				if (t % 2 == 0)
					otherY += posY;
				else 
					otherY += (h0-posY);
				int dy = (int)(otherY - posY);
				if (dx*dx + dy*dy <= d*d) {
					Angle a = new Angle(dx,dy);
					System.out.print("" + dx + " " + dy + " -> " + a.x + " " + a.y);
					if (!set.contains(a)) {
						set.add(a);
						result++;
						System.out.print(" +\n");
					} else {
						System.out.print(" -\n");
					}
				}
			}
		}
		
		return result;
	}
	
	void calPos() {
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				if (matrix[i][j] == 'X') {
					posX = j-.5f;
					posY = i-.5f;
					return;
				}
			}
		}
	}
	
	float posX = -1;
	float posY = -1;
	
	float h;
	float w;
	float d;
	char[][] matrix;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.txt")));
			String firstLine = br.readLine();
			int lineNum = Integer.parseInt(firstLine);
			for (int i=0; i<lineNum; i++) {
				String line = br.readLine();
				String[] segs = line.split(" ");
				int h = Integer.parseInt(segs[0]);
				int w = Integer.parseInt(segs[1]);
				int d = Integer.parseInt(segs[2]);
				char[][] matrix = new char[h][w];
				for (int j=0; j<h; j++) {
					String l = br.readLine();
					for (int k=0; k<w; k++) {
						matrix[j][k] = l.charAt(k);
					}
				}
				
				// for small case only
				GCJ4 gcj = new GCJ4(h, w, d, matrix);
				
				bw.write("Case #" + (i+1) + ": " + gcj.simpleResult());
				if (i != (lineNum-1))
					bw.newLine();
			}
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
