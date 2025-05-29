package com.googlecode.codejam.model;

import java.util.Iterator;
import java.util.concurrent.Callable;


public abstract class JamCaseResolverFactory {
	
	public abstract Callable<String> newJamCaseResolver(int caseNumber, Iterator<String> lineIterator);
	
}
