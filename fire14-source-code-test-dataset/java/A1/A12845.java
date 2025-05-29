/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam2012.qr;

import codejam.common.CodeHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Chen Ling
 */
public class ProblemB {

    private static String SMALL_IN_FILE_NAME = "/codejam2012/qr/B-small.in";
    private static String LARGE_IN_FILE_NAME = "/codejam2012/qr/B-large.in";
    private static String SMALL_OUT_FILE_NAME = "/codejam2012/qr/B-small.out";
    private static String LARGE_OUT_FILE_NAME = "/codejam2012/qr/B-large.out";

    public static void main(String[] args) {
        List<String> smallLines = CodeHelper.loadInputLines(SMALL_IN_FILE_NAME);
        List<String> smallOutputs = new ArrayList<String>();
        for (int i = 1; i < smallLines.size(); i++) {
            String line = smallLines.get(i);
            List<String> numbers = new ArrayList<String>();
            String[] numberArray = line.split(" ");
            for (String number : numberArray) {
                numbers.add(number);
            }
            smallOutputs.add("Case #" + i + ": " + solve(numbers));
        }
        CodeHelper.writeOutputs(SMALL_OUT_FILE_NAME, smallOutputs);
//        
//        List<String> largeLines = CodeHelper.loadInputLines(LARGE_IN_FILE_NAME);
//        List<String> largeOutputs = new ArrayList<String>();
//        for (int i = 1; i < largeLines.size(); i++) {
//            String line = largeLines.get(i);
//            List<String> numbers = new ArrayList<String>();
//            String[] numberArray = line.split(" ");
//            for (String number : numberArray) {
//                numbers.add(number);
//            }
//            largeOutputs.add("Case #" + i + ": " + solve(numbers));
//        }
//        CodeHelper.writeOutputs(LARGE_OUT_FILE_NAME, largeOutputs);
    }

    public static int solve(List<String> numbers) {
        int result = 0;
        int s = Integer.parseInt(numbers.get(1));
        int p = Integer.parseInt(numbers.get(2));
        List<Triplet> triplets = new ArrayList<Triplet>();
        for (int i = 3; i < numbers.size(); i++) {
            int t = Integer.parseInt(numbers.get(i));
            int n = t / 3;
            int a = t % 3;
            Triplet triplet = null;
            if (a == 0) {
                triplet = new Triplet(n, n, n);
            } else if (a == 1) {
                triplet = new Triplet(n, n, n + 1);
            } else {
                triplet = new Triplet(n, n + 1, n + 1);
            }
            triplets.add(triplet);
        }
        Collections.sort(triplets);
        int index = 0;
        for (Triplet triplet : triplets) {
            if (index == s) {
                break;
            }
            if (triplet.getThird() >= p) {
                continue;
            }
            if ((triplet.getThird() - triplet.getFirst()) == 0) {
                if (triplet.getFirst() == 0) {
                    continue;
                }
                triplet.setFirst(triplet.getFirst() - 1);
                triplet.setThird(triplet.getThird() + 1);
                index++;
            } else if ((triplet.getThird() - triplet.getSecond()) == 1) {
                if (triplet.getSecond() == 0) {
                    continue;
                }
                triplet.setFirst(triplet.getFirst() - 1);
                triplet.setSecond(triplet.getSecond() + 1);
                index++;
            } else if ((triplet.getThird() - triplet.getFirst()) == 1) {
                triplet.setSecond(triplet.getSecond() - 1);
                triplet.setThird(triplet.getThird() + 1);
                index++;
            }
        }
        Collections.sort(triplets);
        for (Triplet triplet : triplets) {
            if (triplet.getThird() >= p) {
                result++;
            } else {
                break;
            }
        }
        return result;
    }

    private static class Triplet implements Comparable<Triplet> {

        private int first;
        private int second;
        private int third;

        public Triplet(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        public int getThird() {
            return third;
        }

        public void setThird(int third) {
            this.third = third;
        }

        @Override
        public int compareTo(Triplet o) {
            return o.getThird() - this.getThird();
        }
    }
}
