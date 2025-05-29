package com.google.jam.eaque.qualif.b;

import java.io.IOException;

import com.google.jam.eaque.stub.InputFileManager;
import com.google.jam.eaque.stub.Stub;
import com.google.jam.eaque.stub.Util;

public class Small extends Stub {

	@Override
	public String runTestCase(InputFileManager ifm)
			throws NumberFormatException, IOException {
		
		long[] numbers = Util.stringsToLongs(ifm.readAndSplit());
		long[] quotients = new long[(int) numbers[0]];
		long[] remainders = new long[(int) numbers[0]];
		long s = numbers[1];
		long p = numbers[2];
		long res = 0;
		
		for (int i = 0; i < remainders.length; i++) {
			quotients[i] = numbers[i+3] / 3;
			remainders[i] = numbers[i+3] % 3;
			
			if (quotients[i] >= p)
			{
				res++;
			}
			else if (quotients[i] == (p - 1))
			{
				if (remainders[i] != 0)
				{
					res++;
				}
				else if (quotients[i] != 0 && s > 0)
				{
					res++;
					s--;
				}
			}
			else if (quotients[i] == (p - 2) && s > 0)
			{
				if (remainders[i] == 2)
				{
					res++;
					s--;
				}
			}
		}
		
		
		
		return " " + res;
	}
}
