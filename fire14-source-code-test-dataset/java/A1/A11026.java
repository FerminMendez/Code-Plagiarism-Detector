package fixjava;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import fixjava.ParallelWorkQueue.CallableFactory;

public class ArrayUtils {

	// ------------------------------------------------------------------------------------------------

	/** Convert a 2D float array into a 2D double array */
	public static double[][] toDblArray(float[][] data) {
		double[][] copy = new double[data.length][data[0].length];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				copy[i][j] = data[i][j];
		return copy;
	}

	/** Convert a 2D double array into a 2D float array */
	public static float[][] toFltArray(double[][] data) {
		float[][] copy = new float[data.length][data[0].length];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				copy[i][j] = (float) data[i][j];
		return copy;
	}

	/** Transpose an array */
	public static double[][] transpose(double[][] data) {
		double[][] copy = new double[data[0].length][data.length];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				copy[j][i] = data[i][j];
		return copy;
	}

	/** Transpose an array */
	public static float[][] transpose(float[][] data) {
		float[][] copy = new float[data[0].length][data.length];
		for (int i = 0; i < data.length; i++)
			for (int j = 0; j < data[0].length; j++)
				copy[j][i] = data[i][j];
		return copy;
	}

	// ------------------------------------------------------------------------------------------------

	public static float[][] matMulPar(float[][] A, boolean transposeA, float[][] B, boolean transposeB, int numThreads) {
		return toFltArray(matMulPar(toDblArray(A), transposeA, toDblArray(B), transposeB, numThreads));
	}

	public static double[][] matMulPar(double[][] A, boolean transposeA, double[][] B, boolean transposeB, int numThreads) {
		final double[][] matA = transposeA ? transpose(A) : A;

		// Keep B transposed so that matrix multiplication is more able to exploit cache coherence (matrix is stored row-wise)
		final double[][] matBT = transposeB ? B : transpose(B);

		final int p = matA.length, q = matA[0].length, q2 = matBT[0].length, r = matBT.length;
		if (q != q2)
			throw new IllegalArgumentException("Array size mismatch");

		final double[][] result = new double[p][r];

		//final DecimalFormat formatPercent1dp = new DecimalFormat("0.0%");

		try {
			for (Future<Void> res : new ParallelWorkQueue<Integer, Void>(numThreads, ParallelWorkQueue.makeIntRangeIterable(p),
					new CallableFactory<Integer, Void>() {
						//IntegerMutable counter = new IntegerMutable();

						@Override
						public Callable<Void> newInstance(final Integer ii) {
							return new Callable<Void>() {
								int i = ii.intValue();
								double[][] resultLocal = result;
								int rLocal = r, qLocal = q;
								double[][] matALocal = matA, matBTLocal = matBT;

								@Override
								public Void call() {
									/**
									 * <code>
									 * TODO: try blocked matrix multiplication to see if it's faster
									 * 
									 *   for (int ib = 0; ib < p; ib += blockSize)
									 *     for (int jb = 0; jb < q; jb += blockSize)
									 *       for (int kb = 0; kb < r; kb += blockSize)
									 *         for (int i = ib, iMax = Math.min(p, ib + blockSize); i < iMax; i++)
									 *           for (int j = jb, jMax = Math.min(q, jb + blockSize); j < jMax; j++)
									 *             for (int k = kb, kMax = Math.min(p, kb + blockSize); k < kMax; k++)
									 *               prod[i][j] += matALocal[i][k] * matBTLocal[j][k];
									 *               
									 * N.B. the "+=" operation above needs to use TLS accumulators
									 */
									for (int j = 0; j < rLocal; j++) {
										float tot = 0.0f;
										for (int k = 0; k < qLocal; k++)
											tot += matALocal[i][k] * matBTLocal[j][k];
										resultLocal[i][j] = tot;
									}
									//							int count = counter.increment();
									//							if (count % 10 == 0)
									//								System.out.println(formatPercent1dp.format((count / (float) (pLocal - 1))));
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
		return result;
	}

	// ------------------------------------------------------------------------------------------------

	/** Multiply A by constant b */
	public static double[][] matMulByConst(double[][] A, double b) {
		int p = A.length, q = A[0].length;
		double[][] result = new double[p][q];
		for (int i = 0; i < p; i++)
			for (int j = 0; j < q; j++)
				result[i][j] = b * A[i][j];
		return result;
	}

	/** Multiply A by constant b */
	public static float[][] matMulByConst(float[][] A, float b) {
		int p = A.length, q = A[0].length;
		float[][] result = new float[p][q];
		for (int i = 0; i < p; i++)
			for (int j = 0; j < q; j++)
				result[i][j] = b * A[i][j];
		return result;
	}

	/** Multiply A by B transpose */
	public static float[][] matMulABT(float[][] A, float[][] BT) {
		int p = A.length, q = A[0].length, q2 = BT[0].length, r = BT.length;
		if (q != q2)
			throw new IllegalArgumentException("Array size mismatch");
		float[][] result = new float[p][r];
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < r; j++) {
				float tot = 0.0f;
				for (int k = 0; k < q; k++)
					// This is the main matrix multiplication routine, because both operands here
					// are in row-major order, so we get speedups of 3-8x due to cache coherence
					// on large matrices. (Use the parallel version for really large matrices...)
					tot += A[i][k] * BT[j][k];
				result[i][j] = tot;
			}
		}
		return result;
	}

	/** Multiply A by B transpose */
	public static double[][] matMulABT(double[][] A, double[][] BT) {
		int p = A.length, q = A[0].length, q2 = BT[0].length, r = BT.length;
		if (q != q2)
			throw new IllegalArgumentException("Array size mismatch");
		double[][] result = new double[p][r];
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < r; j++) {
				float tot = 0.0f;
				for (int k = 0; k < q; k++)
					// This is the main matrix multiplication routine, because both operands here
					// are in row-major order, so we get speedups of 3-8x due to cache coherence
					// on large matrices. (Use the parallel version for really large matrices...)
					tot += A[i][k] * BT[j][k];
				result[i][j] = tot;
			}
		}
		return result;
	}

	/** Multiply A by B */
	public static float[][] matMulAB(float[][] A, float[][] B) {
		// Transpose B so it's row-major, and multiply by BTT==B
		return matMulABT(A, transpose(B));
	}

	/** Multiply A by B */
	public static double[][] matMulAB(double[][] A, double[][] B) {
		// Transpose B so it's row-major, and multiply by BTT==B
		return matMulABT(A, transpose(B));
	}

	/** Multiply A transpose by B */
	public static float[][] matMulATB(float[][] A, float[][] B) {
		// Transpose B so it's row-major, and multiply by BTT==B
		return matMulABT(transpose(A), transpose(B));
	}

	/** Multiply A transpose by B */
	public static double[][] matMulATB(double[][] A, double[][] B) {
		// Transpose B so it's row-major, and multiply by BTT==B
		return matMulABT(transpose(A), transpose(B));
	}

	/** Multiply A transpose by B transpose */
	public static double[][] matMulATBT(double[][] A, double[][] B) {
		return matMulABT(transpose(A), B);
	}

	/** Multiply A transpose by B transpose */
	public static float[][] matMulATBT(float[][] A, float[][] B) {
		return matMulABT(transpose(A), B);
	}

	// ------------------------------------------------------------------------------------------------

	/** Select a random subset of rows in a matrix */
	public static float[][] selectRandomRowSubset(int numRows, float[][] mat) {
		int n = Math.min(numRows, mat.length);
		float[][] rows = new float[mat.length][];
		for (int i = 0; i < mat.length; i++)
			rows[i] = mat[i];
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			int j = rand.nextInt(mat.length);
			float[] tmp = rows[i];
			rows[i] = rows[j];
			rows[j] = tmp;
		}
		return Arrays.copyOf(rows, n);
	}

	// ------------------------------------------------------------------------------------------------

	/** Write a double[][] array to a file */
	public static void writeToFile(String filename, String arrayName, double[][] array) {
		try {
			System.out.println("Writing to " + filename);
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)));

			writeArray(writer, arrayName, array);

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/** Write a double[][] array to a PrintWriter */
	public static void writeArray(PrintWriter writer, String name, double[][] arr) {
		writer.println(name + "\t" + arr.length + "\t" + arr[0].length);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++)
				writer.print((j == 0 ? "" : "\t") + arr[i][j]);
			writer.println();
		}
	}

	/** Write a double[] array to a PrintWriter */
	public static void writeArray(PrintWriter writer, String name, double[] arr) {
		writer.println(name + "\t1\t" + arr.length);
		for (int i = 0; i < arr.length; i++)
			writer.print((i == 0 ? "" : "\t") + arr[i]);
		writer.println();
	}

}
