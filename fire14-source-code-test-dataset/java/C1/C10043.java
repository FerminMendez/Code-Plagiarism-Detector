package template;

//standard libraries potentially used:
//Apache commons http://http://commons.apache.org/
//Google Guava http://code.google.com/p/guava-libraries/

import java.util.ArrayList;


public class Template {

    public static void main(String[] args) {

        //test();
        //Utils.die("Done testing");

        String folder = "C:\\Users\\Paul Thomson\\Documents\\CodeJam\\HallOfMirrors\\";
        Utils.logfile = folder + "log.txt";
        String infile = folder + "data.in";
        String outfile = infile.substring(0, infile.lastIndexOf(".")) + ".out";
        ArrayList<TestCase> tcList = TestCaseIO.loadFromFile(infile);
        //ArrayList<TestCase> tcList = TestCaseIO.mockUp();

        int numThreads = 1;
        if (numThreads == 1) {
            TestCaseSolver tcSolver = new TestCaseSolver(tcList, 1);
            tcSolver.run();
        } else {
            //split into separate lists
            ArrayList<ArrayList<TestCase>> tcSubLists = new ArrayList<>();
            for (int i = 0; i < numThreads; i++) {
                tcSubLists.add(new ArrayList<TestCase>());
            }

            int i = 0;
            for (TestCase tc : tcList) {
                tcSubLists.get(i).add(tc);
                i++;
                if (i == numThreads) {
                    i = 0;
                }
            }

            //run each sublist in its own thread
            ArrayList<Thread> threadList = new ArrayList<>();
            int ref = 1;
            for (ArrayList<TestCase> tcl : tcSubLists) {
                TestCaseSolver tcs = new TestCaseSolver(tcl, ref);
                Thread h = new Thread(tcs);
                threadList.add(h);
                h.start();
                ref++;
            }

            //wait for completion
            for (Thread h : threadList) {
                try {
                    h.join();
                } catch (InterruptedException ex) {
                    Utils.die("InterruptedException waiting for threads");
                }
            }

        }

        TestCaseIO.writeSolutions(tcList, outfile);
        
        double totalTime = 0;
        for (TestCase tc : tcList) {
            totalTime += tc.getTime();
        }
        double avTime = totalTime / (double)tcList.size();
        Utils.sout("Total compute time " + String.format("%.2f", totalTime) + " secs.");
        Utils.sout("Average compute time " + String.format("%.2f", avTime) + " secs.");
        Utils.sout("Done.");
    }

    public static void test() {

    }
}
