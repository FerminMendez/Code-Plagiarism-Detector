package com.google.jam.eaque.stub;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.google.jam.eaque.qualif.b.Small;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		if (args.length != 2) {
			System.out.println("args length : " + args.length);
			System.exit(0);
		}

		Stub body = new Small();
		body.setOutputFileName(args[1]);

		try {
			InputFileManager ifm = new InputFileManager(args[0]);
			BufferedWriter bw = new BufferedWriter(new FileWriter(
					body.getOutputFileName()));

			long nbTestCases = ifm.readLong();

			for (long i = 0; i < nbTestCases; i++) {
				bw.write("Case #" + (i + 1) + ":" + body.runTestCase(ifm));
				bw.newLine();
			}

			ifm.close();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
