/**
 * Copyright Carma Systems, Inc. All rights reserved.
 */
package com.jessehutton.codejam.qualification2012;

import com.jessehutton.codejam.util.IOHandler;

import java.io.IOException;

/**
 *
 * @author Jesse Hutton <jesse.hutton@carmasys.com>
 */
public class DancingWithGooglers {

  public static void main(String[] args) throws NumberFormatException, IOException {
    String inFile = "/home/jesse/Downloads/B-small-attempt0.in";
    String outFile = "/home/jesse/Desktop/Dancing-googlers.out";

    IOHandler io = new IOHandler(new String[] {inFile, outFile}) {
      @Override
      public String formatCase(int caseNum, Object result) {
        return String.format("Case #%d: %s", caseNum, result);
      }
    };

    int T = Integer.parseInt(io.line().trim());
    for (int c = 1; c <= T; c++) {
      String[] tokens = io.line().split(" ");
      int nGoo = Integer.parseInt(tokens[0]);
      int sups = Integer.parseInt(tokens[1]);
      int p = Integer.parseInt(tokens[2]);
      int results = 0;

      for (int t = 3; t < 3 + nGoo; t++) {
        int tot = Integer.parseInt(tokens[t]);
        int fact = tot / 3;
        int rem = tot % 3;

        if (tot == 0) {
          if (p == 0) {
            results++;
          }
          continue;
        }

        if (fact >= p) {
          results++;
          continue;
        }

        int diff = p - fact;
        if (diff > 2) {
          continue;
        }

        // can arrange without using a sup
        //
        if (diff == 1 && rem >= 1) {
          results++;
          continue;
        }

        // can arrange with using a sup
        //
        if (diff == 1 && rem == 0 && sups > 0) {
          results++;
          sups--;
          continue;
        }

        // diff == 2
        //
        if (sups > 0 && rem == 2) {
          sups--;
          results++;
        }
      }
      io.recordCase(c, results);
    }
    io.finish();
  }

}
