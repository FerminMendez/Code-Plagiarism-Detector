package MyAllgoritmicLib;

public class Hungary {

	int INF = 1000*1000*1000;

	int n;
	int[][] a;
	int[] xy, yx;
	boolean[] vx, vy;
	int[] minrow, mincol;

	public Hungary(int[][] a) {
		// TODO Auto-generated constructor stub
		this.a = a.clone();
	}
	
	private boolean dotry (int i) {
		if (vx[i])  return false;
		vx[i] = true;
		for (int j=0; j<n; ++j)
			if (a[i][j]-minrow[i]-mincol[j] == 0)
				vy[j] = true;
		for (int j=0; j<n; ++j)
			if (a[i][j]-minrow[i]-mincol[j] == 0 && yx[j] == -1) {
				xy[i] = j;
				yx[j] = i;
				return true;
			}
		for (int j=0; j<n; ++j)
			if (a[i][j]-minrow[i]-mincol[j] == 0 && dotry (yx[j])) {
				xy[i] = j;
				yx[j] = i;
				return true;
			}
		return false;
	}
	
	@SuppressWarnings("unused")
	private int hungary(int num) {
		mincol = new int[num];
		minrow = new int[num];
		xy = new int[num];
		yx = new int[num];
		vx = new boolean[num];
		vy = new boolean[num];

        n = num;
        for (int q = 0; q<n; q++) {
        	mincol[q] = INF;
        	minrow[q] = INF;
        }

		for (int i=0; i<n; ++i)
			for (int j=0; j<n; ++j)
				minrow[i] = Math.min(minrow[i], a[i][j]);
		for (int j=0; j<n; ++j)
			for (int i=0; i<n; ++i)
				mincol[j] = Math.min (mincol[j], a[i][j] - minrow[i]);

        for (int q = 0; q<n; q++) {
        	xy[q] = -1;
        	yx[q] = -1;
        }

		for (int c=0; c<n; ) {
	        for (int q = 0; q<n; q++) {
	        	vx[q] = false;
	        	vy[q] = false;
	        }
			int k = 0;
			for (int i=0; i<n; ++i)
				if (xy[i] == -1 && dotry (i))
					++k;
			c += k;
			if (k == 0) {
				int z = INF;
				for (int i=0; i<n; ++i)
					if (vx[i])
						for (int j=0; j<n; ++j)
							if (!vy[j])
								z = Math.min (z, a[i][j]-minrow[i]-mincol[j]);
				for (int i=0; i<n; ++i) {
					if (vx[i]) minrow[i] += z;
					if (vy[i]) mincol[i] -= z;
				}
			}
		}

		int ans = 0;
		for (int i=0; i<n; ++i)
			ans += a[i][xy[i]];
		return ans;
	}
}
