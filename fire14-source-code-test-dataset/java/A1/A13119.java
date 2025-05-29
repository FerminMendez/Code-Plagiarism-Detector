package org.weiwei.googlejam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ding
 * Date: 12-4-14
 * Time: 上午11:28
 * To change this template use File | Settings | File Templates.
 */
public class DancingGroup {

    List<Dancing> dancings;
    int total;

    public DancingGroup(List<Dancing> dancings, int total) {
        this.dancings = dancings;
        this.total = total;
    }

    public static DancingGroup laodFromFile(String input) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line = reader.readLine();
        int total = Integer.parseInt(line.trim());
        List<Dancing> dancingList = new ArrayList<Dancing>();
        line = reader.readLine();
        while(line != null) {
            dancingList.add(Dancing.loadFromString(line));
            line = reader.readLine();
        }
        reader.close();
        return new DancingGroup(dancingList, total);
    }

    public void outputResult(String outputFile) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(outputFile);
        for(int i = 1; i < total+1; i++){
            if(i!=0)
                pw.write("\r\n");
            pw.write("Case #"+i+": "+dancings.get(i-1).getNumber());
        }
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        DancingGroup group = DancingGroup.laodFromFile("F:\\input.txt");
        group.outputResult("F:\\output.txt");
    }
}
