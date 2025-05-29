/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package leider.ken;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 *
 * @author ken
 */
public class CommandLine {

    public static void main(String args[]) throws Exception {
        Parser parser = new DancingParser();

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        //ExecutorService executor = Executors.newFixedThreadPool(1);

        for (String file : args) {
            Map<Integer, Callable<String>> tests = parser.parse(file);

            Map<Integer, String> results = new ConcurrentSkipListMap<Integer, String>();
            List<Future<String>> futures = executor.invokeAll(createCommands(results, tests));

            for (Future<String> future : futures) {
                if (future.get() == null) {
                    System.err.println("Failed on test of " + file);
                    break;
                }
            }

            final String outputFile = changeExtension(file, ".out");
            PrintStream out = new PrintStream(new FileOutputStream(outputFile));
            for (Map.Entry<Integer, String> entry : results.entrySet()) {
                out.println(entry.getValue());
                System.out.println(tests.get(entry.getKey()) + " ===> " + entry.getValue());
            }


            System.out.println("Results in " + outputFile);
        }

        executor.shutdown();
    }
    
    public static Collection<Callable<String>> createCommands(Map<Integer, String> results, Map<Integer, Callable<String>> tests) {
        List<Callable<String>> retval = new ArrayList<Callable<String>>();
        
        for (Map.Entry<Integer, Callable<String>> entry : tests.entrySet()) {
            retval.add(new CommandLine.Command(entry.getKey(), entry.getValue(), results));            
        }
        
        return retval;
    }
    
    private static class Command implements Callable<String> {
        private final int testID;
        private final Callable<String> test;
        private final Map<Integer, String> results;

        private Command(int testID, Callable<String> test, Map<Integer, String> results) {
            this.testID = testID;
            this.test = test;
            this.results = results;
            
        }
        public String call() throws Exception {
            try {
                final String retval = test.call();
                results.put(testID, retval);
                return retval;
            } catch (Exception e) {
                System.err.println("Exception during test case " + testID);
                e.printStackTrace();
            }
            
            return null;
        }    
    }
    
    static String changeExtension(String originalName, String newExtension) {
        int lastDot = originalName.lastIndexOf(".");
        if (lastDot != -1) {
            return originalName.substring(0, lastDot) + newExtension;
        } else {
            return originalName + newExtension;
        }
    }
}
