package fixjava;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import fixjava.ParallelWorkQueue.CallableFactory;

public class ArrayStats {
	public final double[][] data;
	public final int n, k;

	private double[][] centered;
	private double[] mean;
	private double[][] cov;
	private double[] stddev = null;
	private double[][] corr = null;

	/** Calculate covariance matrix */
	public ArrayStats(double[][] data) {
		if (data == null || data.length < 2 || data[0].length < 2)
			throw new IllegalArgumentException("Invalid data");
		this.data = data;
		this.n = data.length;
		this.k = data[0].length;
	}

	/** Compute mean for each dimension */
	public double[] mean() {
		if (mean == null) {
			mean = new double[k];
			for (int dim = 0; dim < k; dim++) {
				double tot = 0;
				for (int pt = 0; pt < n; pt++)
					tot += data[pt][dim];
				mean[dim] = tot / n;
			}
		}
		return mean;
	}

	/** Compute stddev for each dimension */
	public double[] stddev() {
		if (stddev == null) {
			// Make sure means are computed
			mean();

			stddev = new double[k];
			for (int dim = 0; dim < k; dim++) {
				for (int pt = 0; pt < n; pt++) {
					double diff = data[pt][dim] - mean[dim];
					stddev[dim] += diff * diff;
				}
				stddev[dim] = Math.sqrt(stddev[dim] / n);
			}
		}
		return stddev;
	}

	/** Re-center data by subtracting mean from each dimension */
	public double[][] centered() {
		if (centered == null) {
			// Make sure means are computed
			mean();

			centered = new double[n][k];
			for (int pt = 0; pt < n; pt++)
				for (int dim = 0; dim < k; dim++)
					centered[pt][dim] = data[pt][dim] - mean[dim];
		}
		return centered;
	}

	/** Compute covariance matrix */
	public double[][] cov() {
		if (cov == null) {
			// Make sure centered version of data is computed
			centered();

			// Work on transposed array for cache coherence
			final double[][] centeredT = ArrayUtils.transpose(centered);

			cov = new double[k][k];

			try {
				//final DecimalFormat formatPercent1dp = new DecimalFormat("0.0%");
				for (Future<Void> res : new ParallelWorkQueue<Integer, Void>(/* numThreads = */25,
						ParallelWorkQueue.makeIntRangeIterable(k), new CallableFactory<Integer, Void>() {
							//IntegerMutable counter = new IntegerMutable();

							@Override
							public Callable<Void> newInstance(final Integer ii) {
								return new Callable<Void>() {
									int dim1 = ii.intValue();
									double[][] centeredTLocal = centeredT;
									double[][] covLocal = cov;

									@Override
									public Void call() {
										for (int dim2 = dim1; dim2 < k; dim2++) {
											double numer = 0.0;
											for (int pt = 0; pt < n; pt++)
												numer += centeredTLocal[dim1][pt] * centeredTLocal[dim2][pt];
											int denom = n - 1;
											covLocal[dim1][dim2] = covLocal[dim2][dim1] = denom == 0 ? 0 : numer / denom;
										}
										//										int count = counter.increment();
										//										if (count % 10 == 0)
										//											System.out.println(formatPercent1dp.format((count / (float) (k - 1))));
										return null;
									}
								};
							}
						}))
					// Barricade
					res.get();
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return cov;
	}

	/** Compute correlation matrix */
	public double[][] corr() {
		if (corr == null) {
			// Make sure per-dim stddevs and covariance matrix are computed
			stddev();
			cov();

			corr = new double[k][k];
			for (int dim1 = 0; dim1 < k; dim1++) {
				for (int dim2 = dim1; dim2 < k; dim2++) {
					double prod = stddev[dim1] * stddev[dim2];
					corr[dim1][dim2] = corr[dim2][dim1] = prod == 0.0 ? 0.0 : cov[dim1][dim2] / prod;
				}
			}
		}
		return corr;
	}
}
