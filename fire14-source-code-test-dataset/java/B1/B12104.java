package com.renoux.gael.codejam.utils;

import java.util.ArrayList;
import java.util.List;



/**
 * Pour tests unitaires
 * 
 * @author renouxg
 */
public final class ListUtils {

    public static List<Integer> parseInts(List<String> strings) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (String s : strings) {
            list.add(Integer.valueOf(s));
        }
        return list;
    }

}
