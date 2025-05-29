package com.google.jam.eaque.qualif.c;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import com.google.jam.eaque.stub.InputFileManager;
import com.google.jam.eaque.stub.Stub;
import com.google.jam.eaque.stub.Util;

public class StubImpl extends Stub {

	@Override
	public String runTestCase(InputFileManager ifm)
			throws NumberFormatException, IOException {
		
		long[] supremum = Util.stringsToLongs(ifm.readAndSplit());
		long res = 0;
		ArrayList<Long> rotations = null;
		
		ArrayList<String> test = new ArrayList<>();
		
		for (long i = supremum[0]; i <= supremum[1]; i++) {
			if (isUnique(i))
			{
				continue;
			}
			
			rotations = getRotations(i);
			for (Long rot : rotations) {
				if (rot > i && rot <= supremum[1])
				{
					res++;
					test.add(i + " " + rot);
				}
			}
		}
		for (int i = 0; i < test.size(); i++) {
			for (int j = i+1; j < test.size(); j++) {
				if (test.get(i).equals(test.get(j)))
				{
					System.out.println(test.get(i));
				}
			}
		}
		return " " + res;
	}
	
	private boolean isUnique(long l) {
		Byte[] ba = longToByteArray(l);
		boolean res = true;
		for (int i = 0; i < ba.length - 1; i++) {
			if (ba[i] != ba[i+1])
			{
				res = false;
				break;
			}
		}
		return res;
	}

	private Byte[] longToByteArray(long l)
	{
		ArrayList<Byte> res = new ArrayList<Byte>();
		while (l != 0)
		{
			res.add((byte) (l % 10));
			l /= 10;
		}
		Collections.reverse(res);
		return res.toArray(new Byte[0]);
	}
	
	private long byteArrayToLong(Byte[] b)
	{
		long res = 0;
		for (int k = 0; k < b.length; k++) {
			res += b[b.length - 1 - k] * (long)Math.pow(10, k);
		}
		return res;
	}
	private ArrayList<Long> getRotations(long l)
	{
		Byte[] ba = longToByteArray(l);
		Byte[] tmp = new Byte[ba.length];
		ArrayList<Long> res = new ArrayList<Long>();
		
		for (int i = 0; i < ba.length - 1; i++) {
			for (int j = 0; j < ba.length ; j++) {
				tmp[j] = ba[(ba.length - 1 + j - i) % ba.length];
			}
			if (tmp[0] != 0 && !res.contains(byteArrayToLong(tmp)))
			{
				res.add(byteArrayToLong(tmp));
			}
		}
		return res;
	}

}
