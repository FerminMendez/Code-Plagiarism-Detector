package com.google;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Recycle {
    public static class Pair {
        long a;
        long b;
        
        public Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (a ^ (a >>> 32));
            result = prime * result + (int) (b ^ (b >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Pair other = (Pair) obj;
            if (a != other.a)
                return false;
            if (b != other.b)
                return false;
            return true;
        }
    }
    
    public static void main(String[] args) throws IOException {
        final Scanner reader = new Scanner(new File("in.txt"));
        final FileWriter writer = new FileWriter(new File("out.txt"));
        
        final int N = reader.nextInt();
        reader.nextLine();
        
        for (int i = 0; i < N; i++) {
            final long min = reader.nextLong();
            final long max = reader.nextLong();
            writer.write(MessageFormat.format("Case #{0}: {1}", (i + 1), findCount(min, max)));
            if (i < N - 1) {
                writer.write("\n");
            }
        }
        
        writer.close();
    }

    public static int findCount(final long min, final long max) {
        Set<Pair> allPairs = new HashSet<Pair>();
        int resCount = 0;
        for (long i = min; i <= max; i++) {
            int [] num = numToArr(i);

            for (int j = 0; j < num.length - 1; j++) {
                num = shift(num);
                final Pair p = new Pair(i, fromArrToNum(num));
                if (isValid(num, i, max) && !allPairs.contains(p)) {
                    resCount++;
                    allPairs.add(p);
                }
            }
        }
        
        return resCount;
    }
    
    public static int [] shift(int [] num) {
        final int [] res = new int [num.length];
        res[0] = num[num.length - 1];

        for (int i = 1; i < res.length; i++) {
            res[i] = num[i - 1];
        }

        return res;
    }

    public static long fromArrToNum(int [] arr) {
        long a = 0;
        for (int i : arr) {
            a = a + i;
            a = a * 10;
        }

        a = a / 10;
        
        return a;
    }
    
    public static boolean isValid(int [] num, long base, long max) {
        if (num[0] == 0) return false;

        long a = fromArrToNum(num);

        return base < a && a <= max;
    }

    public static boolean consistOfUniqueDigits(int [] num) {
        final boolean [] arr = new boolean [10];

        for (int i : num) {
            if (arr[i]) return false;
            arr[i] = true;
        }

        return true;
    }

    public static int [] numToArr(final long in) {
        final List<Integer> list = new ArrayList<Integer>();
        long a = in;

        while (a > 0) {
            list.add((int) (a % 10));
            a = a / 10;
        }

        final int [] res = new int [list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[res.length - i -1] = list.get(i);
        }

        return res;
    } 
}
