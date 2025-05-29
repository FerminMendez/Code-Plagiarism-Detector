package com.vp.fact;

import com.vp.iface.Problem;
import com.vp.impl.DancingWithGooglers;
import com.vp.impl.SpeakGooglerese;

public class SolutionFactory {
	
	public static Problem getInstance(int problem)
	{
		Problem s = null;
		
		switch(problem)
		{
			case 1: s= new SpeakGooglerese();
				   break;
			case 2: s= new DancingWithGooglers();
				  break;
		}
		
		return s;
	}

	
}
