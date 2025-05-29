import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Leonid
 * Date: 4/14/12
 * Time: 2:41 PM
 * Dancing With Googlers solution
 */
public class DancingWithGooglers {
    public static void main(String[] args) {
        FilesManager fileManager = FilesManager.getFilesManager();
        while (fileManager != null) {
            produceSolution(fileManager);
            fileManager = FilesManager.getFilesManager();
        }

    }

    private static void produceSolution(FilesManager filesManager) {
        FileCommunicationManager fileComManager = new FileCommunicationManager(filesManager);
        List<String> input = fileComManager.convertInputToStrings();
        List<InputInfo> parsedInput = CaseInterpreter.parseInput(input);
        List<String> output = new ArrayList<String>();

        for (int i = 0; i < parsedInput.size(); i++) {
            OutputInfo outputInfo = solve(parsedInput.get(i));
            output.add(CaseInterpreter.composeOutputLine(outputInfo, i + 1));
        }

        fileComManager.convertStringsToOutput(output);
    }

    private static OutputInfo solve(InputInfo inputInfo) {
        OutputInfo outputInfo = new OutputInfo();

        int surpriseThreshold = inputInfo.p * 3 - 4;
        int regularThreshold = inputInfo.p * 3 - 2;
        int surpriseCounter = 0;
        int regularCounter = 0;

        for (int totalResult : inputInfo.results) {
            if (totalResult >= regularThreshold) {
                regularCounter++;
            } else if (totalResult >= surpriseThreshold && totalResult!=0) {
                surpriseCounter++;
            }
        }
        outputInfo.result = regularCounter + (surpriseCounter > inputInfo.s ? inputInfo.s : surpriseCounter);

        return outputInfo;
    }

    private static class InputInfo {
        int n, s, p;
        int[] results;
    }

    private static class OutputInfo {
        int result;

        public String toString() {
            return Integer.toString(result);
        }

    }

    private static class CaseInterpreter {
        private static final int CASE_NUMBER_OF_LINES = 1;

        public static List<InputInfo> parseInput(List<String> input) {
            List<InputInfo> parsedInput = new ArrayList<InputInfo>();
            for (int i = 0; i < input.size(); i += CASE_NUMBER_OF_LINES) {
                parsedInput.add(parseCase(input.subList(i, i + CASE_NUMBER_OF_LINES)));
            }

            return parsedInput;
        }

        private static InputInfo parseCase(List<String> caseLines) {
            InputInfo inputInfo = new InputInfo();
            List<Integer> ints = strToInts(caseLines.get(0));

            inputInfo.n = ints.get(0);
            inputInfo.s = ints.get(1);
            inputInfo.p = ints.get(2);

            inputInfo.results = new int[inputInfo.n];
            for (int i = 0; i < inputInfo.n; i++) {
                inputInfo.results[i] = ints.get(i + 3);
            }

            return inputInfo;
        }

        public static String composeOutputLine(OutputInfo output, int caseNumber) {
            String outputString = "Case #" + caseNumber + ": " + output.toString();

            return outputString;
        }

        private static List<Integer> strToInts(String str) {
            List<Integer> ints = new ArrayList<Integer>();
            String[] strs = str.split(" ");
            for (String s : strs) {
                ints.add(Integer.parseInt(s));
            }
            return ints;
        }
    }

    private static class FilesManager {
        File inputFile;
        File outputFile;
        private static List<String> inputFiles;
        private static int inputFilesIt = 0;

        static {
            File f = new File(".");
            inputFiles = getInputFiles(f.list());
        }

        private static List<String> getInputFiles(String[] fileNames) {
            List<String> inputFileNames = new ArrayList<String>();

            for (String fileName : fileNames) {
                String[] splitFileName = fileName.split("\\.");
                if (splitFileName.length == 2) {
                    if (splitFileName[1].equals("IN") || splitFileName[1].equals("In") || splitFileName[1].equals("in")) {
                        inputFileNames.add(fileName);
                    }
                }
            }
            return inputFileNames;
        }

        private static String generateOutputFileName(String inputFileName) {
            String[] stlitFileName = inputFileName.split("\\.");
            return stlitFileName[0] + "-output.txt";
        }

        FilesManager(String inputFileName, String outputFileName) {
            inputFile = new File(inputFileName);
            assert (inputFile.exists());
            outputFile = new File(outputFileName);
            try {
                outputFile.createNewFile();
            } catch (IOException ex) {
                System.out.println("Exception while trying to create an output file");
            }
        }

        public static FilesManager getFilesManager() {
            if (inputFilesIt >= inputFiles.size()) {
                return null;
            }
            String inputFileName = inputFiles.get(inputFilesIt++);
            String outputFileName = generateOutputFileName(inputFileName);
            return new FilesManager(inputFileName, outputFileName);
        }


        File getInputFile() {
            return inputFile;
        }

        File getOutputFile() {
            return outputFile;
        }
    }

    private static class FileCommunicationManager {
        File inputFile;
        File outputFile;

        FileCommunicationManager(FilesManager filesManager) {
            inputFile = filesManager.getInputFile();
            outputFile = filesManager.getOutputFile();
        }

        List<String> convertInputToStrings() {
            List<String> linesList = new ArrayList<String>();

            try {
                FileReader fr = new FileReader(inputFile);
                BufferedReader bufReader = new BufferedReader(fr);
                int numOfCases = Integer.parseInt(bufReader.readLine());

                for (int i = 0; i < numOfCases; i++) {
                    linesList.add(bufReader.readLine());
                }

            } catch (IOException e) {
                System.out.println("Error reading from the file");
            }

            return linesList;
        }

        void convertStringsToOutput(List<String> linesList) {
            BufferedWriter bufWriter = null;
            try {
                bufWriter = new BufferedWriter(new FileWriter(outputFile));

                for (String line : linesList) {
                    bufWriter.write(line);
                    bufWriter.newLine();
                }

            } catch (IOException e) {
                System.out.println("Error reading from the file");
            } finally {
                //Close the BufferedWriter
                try {
                    if (bufWriter != null) {
                        bufWriter.flush();
                        bufWriter.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
