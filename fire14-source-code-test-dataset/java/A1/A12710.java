package speakingInTongues;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Googlers 
{
    public static int testCount = 0;
    public static int numberOfTestCases = 0;

    
    
    String inputFilePath;
    String outputFilePath;
    
    public static HashMap<Integer, HashSet<ThreeTuple>> sumToThreeTuples = new HashMap<Integer, HashSet<ThreeTuple>>();
    
    public static int maximumNumberOfGooglersWhoCouldHaveHadABestResultOfGreaterThanOrEqualToP = 0;
    public static int numberOfGooglers = 0;
    public static int numberOfSurpringTriplets = 0;
    public static int bestResultOfAtLeastP = 0;

    public static ArrayList<Integer> pointsList = new ArrayList<Integer>();

    public Googlers(String inputFilePath)
    {
        this.inputFilePath = inputFilePath;
        makeAll();
        runTests(inputFilePath);
    }
    
    public static String produceOutput(String input)
    {
        
        String[] inputs = input.split(" ");
        for(int i = 0; i < inputs.length; i++)
        {
            String someInt = inputs[i];
            
            // The first integer will be N, the number of Googlers,
            if(i == 0)
            {
                numberOfGooglers = Integer.parseInt(someInt);
            }
            
            
            // and the second integer will be S, the number of surprising triplets of scores.
            if(i == 1)
            {
                numberOfSurpringTriplets = Integer.parseInt(someInt);
            }
            
            // The third integer will be p, as described above.
            if(i == 2)
            {
                bestResultOfAtLeastP = Integer.parseInt(someInt);
            }
            
            // Next will be N integers ti: the total points of the Googlers.
            if(i >= 3)
            {
                pointsList.add(Integer.parseInt(someInt));
            }
            
            
        }
        
        permutePossibleScoresAndDetermineIfSetContainsRightNumberOfSurprises(0, new ArrayList<ThreeTuple>());
        
        
        testCount++; 
        return "Case #" + testCount + ": " + maximumNumberOfGooglersWhoCouldHaveHadABestResultOfGreaterThanOrEqualToP;
    }
            

    
    private static void permutePossibleScoresAndDetermineIfSetContainsRightNumberOfSurprises(int personIndex, ArrayList<ThreeTuple> whatCouldHaveHappened) 
    {
        if(personIndex < pointsList.size())
        {
        
            int currentGuysScore = pointsList.get(personIndex);
            HashSet<ThreeTuple> currentGuysPossibleScore = sumToThreeTuples.get(currentGuysScore);
            for(ThreeTuple triple : currentGuysPossibleScore)
            {
                whatCouldHaveHappened.add(triple);
                permutePossibleScoresAndDetermineIfSetContainsRightNumberOfSurprises(personIndex + 1, whatCouldHaveHappened);
                whatCouldHaveHappened.remove(triple);
            }
        }
        else
        {
            int surprisingTally = 0;
            for(ThreeTuple x : whatCouldHaveHappened)
            {
                if(x.isSurprising())
                {
                    surprisingTally++;
                }
            }
            
            if(surprisingTally == numberOfSurpringTriplets)
            {
                int thisPossibilityNumberOfGooglersAtLeastP = 0;
                for(ThreeTuple x : whatCouldHaveHappened)
                {
                    
                    int y = x.getBestResult();
                    if(y >= bestResultOfAtLeastP)
                    {
                        thisPossibilityNumberOfGooglersAtLeastP++;
                    }
                }
                
                if(thisPossibilityNumberOfGooglersAtLeastP > maximumNumberOfGooglersWhoCouldHaveHadABestResultOfGreaterThanOrEqualToP)
                    maximumNumberOfGooglersWhoCouldHaveHadABestResultOfGreaterThanOrEqualToP = thisPossibilityNumberOfGooglersAtLeastP;
            }
        }
        
        
    }
    
    private void runTests(String filePath)
    {
        File file = new File(filePath);
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;


        try
        {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            dis = new DataInputStream(bis);

            boolean firstLine = true;
            while (dis.available() != 0)
            {
                String line = dis.readLine();
                if (firstLine)
                {
                    firstLine = false;
                                    
                    numberOfTestCases = Integer.parseInt(line);

                    continue;
                }
                else
                {
                    String output = produceOutput(line);
                    System.out.println(output);
                    reset();
                }
            }
        
            fis.close();
            bis.close();
            dis.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    

    public void reset()
    {
        maximumNumberOfGooglersWhoCouldHaveHadABestResultOfGreaterThanOrEqualToP = 0; 
        pointsList = new ArrayList<Integer>();
    }
    
    private void makeAll() 
    {
        for(int i = 0; i <= 10; i++)
        {
        for(int j = 0; j <= i; j++)
        {
        for(int k = 0; k <= j; k++)
        {
            // No triplet of scores contains scores that are more than 2 apart. 
            if(ThreeTuple.isIllegal(i, j, k))
                continue;
            
            ThreeTuple tuple = new ThreeTuple(i, j, k);
            int sum = i+j+k;
            if(sumToThreeTuples.get(sum) == null || sumToThreeTuples.get(sum).isEmpty())
            {
                HashSet<ThreeTuple> temp = new HashSet<ThreeTuple>();
                sumToThreeTuples.put(sum, temp);
            }
            
            HashSet<ThreeTuple> temp = sumToThreeTuples.get(sum);
            temp.add(tuple);
            sumToThreeTuples.put(sum, temp);

            
        }}}
    }
    
    public static class ThreeTuple
    {
        int x;
        int y; 
        int z;
        
        public ThreeTuple(int x, int y, int z)
        {
            this.x = x;
            this.y = y;
            this.z = z; 
        }
        
        public boolean isSurprising()
        {
            if(Math.abs(x-y) == 2
            || Math.abs(x-z) == 2
            || Math.abs(z-y) == 2)
            {
                return true;
            }
            else
                return false;
        }
        
        public static boolean isIllegal(int x, int y, int z)
        {
            
            if(Math.abs(x-y) > 2
            || Math.abs(x-z) > 2
            || Math.abs(z-y) > 2)
            {
                return true;
            }
            else
                return false;
        }
        
        public int getBestResult()
        {
            int currBiggest = x;
            if(y > currBiggest)
                currBiggest = y;
            if(z > currBiggest)
                currBiggest = z; 
            return currBiggest;
        }

        public ArrayList<Integer> getMyValues()
        {
            ArrayList<Integer> myValues = new ArrayList<Integer>();
            myValues.add(x);
            myValues.add(y);
            myValues.add(z);
            return myValues; 
        }
        
        @Override
        public boolean equals(Object obj) 
        {
            if (obj == null)
            return false;
            if (obj == this)
                return true;
            if (obj.getClass() != getClass())
                return false;

            ThreeTuple triple = (ThreeTuple) obj;
//            ArrayList<Integer> temp = triple.getMyValues();
//            if(temp.contains(x))
//                temp.re
            if(this.x == triple.x
             && this.y == triple.y
             && this.z == triple.z)
                return true;
            else
                return false;
        }

        @Override
        public int hashCode() 
        {
            return this.toString().hashCode();
        }

        @Override
        public String toString() 
        {
            return x + ", " + y + ", " + z;
        }
        
        
        
    }
    
    public static void main(String args[])
    {
        
        String filePath = "//Users//Work//NetBeansProjects//Google Code Jam 2012//src//speakingInTongues//B-small-attempt0.in";
        Googlers googlers = new Googlers(filePath);
        
        
    }

    
}

