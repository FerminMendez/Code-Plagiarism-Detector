package com.menzus.gcj._2012.qualification.c;

import com.menzus.gcj.common.Processor;

public class CMain {

    private static String SMALL_FILE_NAME = "src/main/resources/com/menzus/gcj/_2012/qualification/c/C-small-attempt0.in.txt";

    public static void main(String[] args) throws Exception {
	Processor smallFileProcessor = new CProcessorFactory(SMALL_FILE_NAME).createProcessor();
	smallFileProcessor.process();

	System.out.println("done.");
    }
}
