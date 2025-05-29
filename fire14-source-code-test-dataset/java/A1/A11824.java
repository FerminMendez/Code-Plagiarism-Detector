package com.bertramtruong.utils;

/**
 * This file contains all common 
 * @author Bertram
 */
public class BT {
    /// SETTINGS

    private static boolean debugMode = true;
    ///

    ///
    // LOGGING FUNCTIONS
    ///
    /**
     * Toggles between debug mode.
     * @param debugMode 
     */
    public static void toggleDebug(boolean debug) {
        debugMode = debug;
    }

    /**
     * Print out an debug message.
     * @param <T>
     * @param x 
     */
    public static <T> void db(T... x) {
        if (debugMode) {
            System.out.print("DEBUG: ");
            for (T b : x) {
                System.out.print(String.valueOf(b));
            }
            System.out.println();
        }
    }

    /**
     * Print out an info message.
     * @param <T>
     * @param x 
     */
    public static <T> void info(T... x) {
        System.out.print("INFO: ");
        for (T b : x) {
            System.out.print(String.valueOf(b));
        }
        System.out.println();
    }

    /**
     * Print out an error message.
     * @param <T>
     * @param x 
     */
    public static <T> void err(T... x) {
        System.out.print("ERROR: ");
        for (T b : x) {
            System.out.print(String.valueOf(b));
        }
        System.out.println();
    }
    ///
    // END LOGGING FUNCTIONS
    ///
}
