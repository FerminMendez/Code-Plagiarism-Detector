/*
 * Copyright 2012 Bill Bejeck
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package comp;

import java.io.*;

/**
 * User: Bill Bejeck
 * Date: 4/13/12
 * Time: 9:36 PM
 */
public class Recycled {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(new File(args[1]))));
        int numCases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numCases; i++) {
            String[] pair = reader.readLine().split(" ");
            int numberOne = Integer.parseInt(pair[0]);
            int numberTwo = Integer.parseInt(pair[1]);
            int count = getRecycled(numberOne, numberTwo);
            String result = String.format("Case #%d: %d", (i + 1), count);
            System.out.println(result);
            writer.println(result);
        }
        writer.flush();
        writer.close();
        reader.close();


    }

    private static int getRecycled(int n, int max) {
        int recycleCount = 0;
        for (int i = 0; i < max; i++) {
            String nSt = Integer.toString(n);
            int newMax = (n + 1);
            for (int k = 0; k < max && newMax <= max; k++) {
                String maxString = Integer.toString(newMax);
                for (int j = nSt.length() - 1; j >= 0; j--) {
                    String end = nSt.substring(j);
                    String start = nSt.substring(0, nSt.indexOf(end, j));
                    if (maxString.startsWith(end) && maxString.endsWith(start)) {
                        if (maxString.equals(end + start)) {
                            recycleCount++;
                        }
                    }

                }
                newMax++;
            }
            n++;
        }
        return recycleCount;
    }
}
