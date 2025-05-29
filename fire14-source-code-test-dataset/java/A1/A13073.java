package com.vp.common;

public class CommonUtility {
	
	public static int[] convertStringArraytoIntArray(String[] sarray) {
		if (sarray != null) {
			int intarray[] = new int[sarray.length];
			for (int i = 0; i < sarray.length; i++) {
				intarray[i] = Integer.parseInt(sarray[i]);
			}
			return intarray;
		}

		return null;
	}
	
	public static float[] convertStringArraytoFloatArray(String[] sarray) {
		if (sarray != null) {
			float floatArray[] = new float[sarray.length];
			for (int i = 0; i < sarray.length; i++) {
				floatArray[i] = Float.parseFloat(sarray[i]);
			}
			return floatArray;
		}

		return null;
	}
	
	public static double[] convertStringArraytoDoubleArray(String[] sarray) {
		if (sarray != null) {
			double darray[] = new double[sarray.length];
			for (int i = 0; i < sarray.length; i++) {
				darray[i] = Double.parseDouble(sarray[i]);
			}
			return darray;
		}

		return null;
	}
	
	public static long[] convertStringArraytoLongArray(String[] sarray) {
		if (sarray != null) {
			long longarray[] = new long[sarray.length];
			for (int i = 0; i < sarray.length; i++) {
				longarray[i] = Long.parseLong(sarray[i]);
			}
			return longarray;
		}

		return null;
	}
	
	
	public static void print(int a[])
	{
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.print(" ]");
		System.out.println("");
	}
	
	public static void printWithoutExtrLine(int a[])
	{
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.print(" ]");
	}
	
	
	public static void print(float a[])
	{
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.print(" ]");
		System.out.println("");
	}
	
	public static void print(double a[])
	{
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.print(" ]");
		System.out.println("");
	}
	

	public static void print(long a[])
	{
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.print(" ]");
		System.out.println("");
	}
	
	public static void print(String a[])
	{
		System.out.print("[ ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + ", ");
		}
		System.out.print(" ]");
		System.out.println("");
	}

}
