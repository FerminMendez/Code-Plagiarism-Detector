/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam.common;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lance Chen
 */
public class CodeHelper {

    private static String FILE_ROOT = "D:/workspace/googlecodejam/meta";

    public static List<List<String>> loadInputsExcludes(String fileName) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> lines = FileUtil.readLines(FILE_ROOT + fileName);
        int index = 0;
        for (String line : lines) {
            if (index == 0) {
                index++;
                continue;
            }
            if (index % 2 == 1) {
                index++;
                continue;
            }
            List<String> dataList = new ArrayList<String>();
            String[] dataArray = line.split("\\s+");
            for (String data : dataArray) {
                if (data.trim().length() > 0) {
                    dataList.add(data);
                }
            }
            result.add(dataList);
            index++;
        }
        return result;
    }

    public static List<List<String>> loadInputs(String fileName) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> lines = FileUtil.readLines(FILE_ROOT + fileName);
        for (String line : lines) {
            List<String> dataList = new ArrayList<String>();
            String[] dataArray = line.split("\\s+");
            for (String data : dataArray) {
                if (data.trim().length() > 0) {
                    dataList.add(data);
                }
            }
            result.add(dataList);
        }
        return result;
    }

    public static List<String> loadInputLines(String fileName) {
        return FileUtil.readLines(FILE_ROOT + fileName);
    }

    public static void writeOutputs(String fileName, List<String> lines) {
        FileUtil.writeLines(FILE_ROOT + fileName, lines);
    }
}
