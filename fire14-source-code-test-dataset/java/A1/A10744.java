import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class DancingProblem {

    private static final String INPUT_FILE_NAME = "/home/rponnu/codebase/codejam/first_round/data/input.txt";
    private static final String OUTPUT_FILE_NAME = "/home/rponnu/codebase/codejam/first_round/data/output.txt";

    public static void main(String args[]) throws IOException {
        List<String> lines = readFile(INPUT_FILE_NAME);
        Integer noOfInputs = readInputData(lines.get(0)).get(0);
        System.out.println("No of Inputs:"+ noOfInputs);


        List<String> outputLines = new ArrayList<String>();

        for(int index=1;index<=noOfInputs.intValue();index++){
            List<Integer> inputData = readInputData(lines.get(index));
            outputLines.add("Case #"+index+": "+getNoOfBestResult(inputData));
        }
        File f = new File(OUTPUT_FILE_NAME);
        FileUtils.writeLines(f,outputLines);
    }

    private static int getNoOfBestResult(List<Integer> inputData) {
        Iterator<Integer> iterator = inputData.iterator();
        Integer noOfPlayers = iterator.next();
        Integer noOfSurprises = iterator.next();
        Integer bestResult = iterator.next();

        int noOfMaxScores = 0;
        int count= 0;
        int noOfMaxScoresWithSurprises = 0;

        int maxValueForScore = getMaxValueForScore(bestResult);
        int maxValueForScoreWithSurprises = getMaxValueForScoreWithSurprises(bestResult);

        while (iterator.hasNext()){
            int scoreSum = iterator.next();
            if(scoreSum >= maxValueForScore) {
                noOfMaxScores ++;
            } else if( (maxValueForScore != maxValueForScoreWithSurprises) &&  scoreSum >= maxValueForScoreWithSurprises){
                    noOfMaxScoresWithSurprises ++;
                }
            }

        count = noOfMaxScores;

        if (noOfMaxScoresWithSurprises >= noOfSurprises) {
            count += noOfSurprises;
        } else if (noOfMaxScoresWithSurprises < noOfSurprises){
            count += noOfMaxScoresWithSurprises;
        }

        return count;
    }

    private static int getMaxValueForScore(int bestScore){
        int maxValue = bestScore;
        if(bestScore-1 > 0) {
             maxValue += 2 *(bestScore-1);
        }
        return maxValue;
    }

    private static int getMaxValueForScoreWithSurprises(int bestScore){
        int maxVal = bestScore;
        if(bestScore -2 > 0){
            maxVal +=2 *(bestScore-2);
        }
        return maxVal;
    }



    private static List<Integer> readInputData(String line){
        List<Integer> values = new ArrayList<Integer>();
        StringTokenizer stringTokenizer = new StringTokenizer(line.trim());
        while(stringTokenizer.hasMoreElements()){
            values.add(Integer.parseInt((String) stringTokenizer.nextElement()));
        }
        return values;
    }


    private static List<String> readFile(String path) throws IOException {
        List<String> lines = FileUtils.readLines(new File(path));
        return lines;
    }
}
