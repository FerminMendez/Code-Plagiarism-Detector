/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bohmd
 */
public class Util {
    public static List<Integer> getIntList(String listString) {
        String[] listArray = listString.split(" ");
        List<Integer> list = new ArrayList<Integer>();
        for (String str : listArray) {
            list.add(Integer.parseInt(str));
        }
        return list;
    }

    public static int getInt(String string) {
        return Integer.parseInt(string);
    }

    public static List<Long> getLongList(String listString) {
        String[] listArray = listString.split(" ");
        List<Long> list = new ArrayList<Long>();
        for (String str : listArray) {
            list.add(Long.parseLong(str));
        }
        return list;
    }
}
