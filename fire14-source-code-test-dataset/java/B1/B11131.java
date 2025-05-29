package com.codegem.zaidansari;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class ProblemA {

    public static Map<Character, Character> mappedCharacters = new TreeMap<Character, Character>();
    public static Set<Character> validCharacters = new HashSet<Character>();

    static {
        int startIndex = 97, endIndex = 122;
        // Fill mapped with all required mapping character with only keys populated
        for (int index = startIndex; index <= endIndex; index++) {
            validCharacters.add(Character.valueOf((char) index));
        }

        Map<String, String> sampleEntriesMap = new HashMap<String, String>();
        // Put Given Mapping in Map
        sampleEntriesMap.put("a", "y");
        sampleEntriesMap.put("o", "e");
        sampleEntriesMap.put("z", "q");
        sampleEntriesMap.put("ejp mysljylc kd kxveddknmc re jsicpdrysi", "our language is impossible to understand");
        sampleEntriesMap.put("rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd", "there are twenty six factorial possibilities");
        sampleEntriesMap.put("de kr kd eoya kw aej tysr re ujdr lkgc jv", "so it is okay if you want to just give up");
        loadMap(sampleEntriesMap);
    }

    private static void loadMap(Map<String, String> sampleEntriesMap) {
        Set<Character> populatedCharacters = new HashSet<Character>();

        for (String key : sampleEntriesMap.keySet()) {
            String value = sampleEntriesMap.get(key);
            if (key.length() != value.length()) { throw new RuntimeException("Size of input :" + key + ", and output don't match:" + value); }
            // Read each character from key and if it's not present in mappedCharacters try to fill that
            char[] inputCharacterArray = key.toCharArray();
            char inputCharacter;
            for (int index = 0; index < inputCharacterArray.length; index++) {
                inputCharacter = inputCharacterArray[index];
                if (validCharacters.contains(inputCharacter) && !mappedCharacters.containsKey(inputCharacter)) {
                    mappedCharacters.put(inputCharacter, value.charAt(index));
                    populatedCharacters.add(inputCharacter);
                }
            }
        }

        // Find any missing entry there can be only Zero or one entry missing in population if more than that than it means sample input are not
        // enough
        Set<Character> missingKeys = new HashSet<Character>(validCharacters);
        Set<Character> missingValues = new HashSet<Character>(validCharacters);
        missingKeys.removeAll(populatedCharacters);
        missingValues.removeAll(mappedCharacters.values());
        if (missingKeys.size() > 1) throw new RuntimeException("More than one keys are unresolved using provided samples...");
        if (missingKeys.size() == 1) {
            Character missingKey = missingKeys.iterator().next();
            Character missingValue = missingValues.iterator().next();
            mappedCharacters.put(missingKey, missingValue);
        }
    }

    public static String getEnglishText(String googlereseText) {
        StringBuilder englishText = new StringBuilder(googlereseText);
        Character currentCharacter;
        for (int index = 0; index < englishText.length(); index++) {
            currentCharacter = englishText.charAt(index);
            if (validCharacters.contains(currentCharacter)) {
                englishText.setCharAt(index, mappedCharacters.get(currentCharacter));
            }
        }
        return englishText.toString();
    }

    public static void main(String[] args) {
        File file = new File("/Users/zaansari/Desktop/CodeGem2012/InputFiles/ProblemA.txt");
        List<String> inputData = CodeGemUtil.getInputValues(file);
        int noOfInputs = Integer.parseInt(inputData.get(0));
        inputData.remove(0);

        List<String> outputData = new ArrayList<String>();
        for (int index = 0; index < noOfInputs; index++) {
            outputData.add(ProblemA.getEnglishText(inputData.get(index)));
        }
        boolean createdOutputFile = CodeGemUtil.createOutputFile(outputData, "ProblemA_Output.txt");
        if (createdOutputFile) {
            System.out.println("Successfully created output file");
        } else {
            System.out.println("Failed to create output file");
        }
    }
}
