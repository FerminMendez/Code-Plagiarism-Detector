package com.google.jam.eaque.stub;

public class Util {

	private Util() {
	}

	
	public static long[] stringsToLongs(String[] strings)
	{
		long[] res = new long[strings.length];
		
		for (int i = 0; i < strings.length; i++) {
			res[i] = Long.parseLong(strings[i]);
		}
		
		return res;
	}
}
