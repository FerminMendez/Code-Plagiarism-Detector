package com.renoux.gael.codejam.utils;




/**
 * Pour tests unitaires
 * 
 * @author renouxg
 */
public final class ArrayUtils {

    public static int[] parseInts(String[] strings) {
        int[] res = new int[strings.length];
        int i = 0;
        for (String s : strings) {
            res[i++] = Integer.parseInt(s);
        }

        return res;
    }

    public static long[] parseLongs(String[] strings) {
        long[] res = new long[strings.length];
        int i = 0;
        for (String s : strings) {
            res[i++] = Long.parseLong(s);
        }

        return res;
    }
}
