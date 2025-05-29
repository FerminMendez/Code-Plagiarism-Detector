package com.renoux.gael.codejam.utils;



/**
 * Pour tests unitaires
 * 
 * @author renouxg
 */
public final class StringUtils {

    public static String multiply(String text, int nb) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nb; i++) {
            builder.append(text);
        }
        return builder.toString();
    }


}
