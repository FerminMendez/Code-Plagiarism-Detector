
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author UDDAMA
 */
public class recyclePair {

    private ArrayList<String> numholder = new ArrayList<String>();

    public void numrecylce(String chars) {
        for (int i = 0; i < chars.length() - 1; i++) {
            this.numholder.add(chars.substring(i + 1) + chars.substring(0, i + 1));
        }
    }

    public void cleanArray() {

        for (int i = 0; i < numholder.size(); i++) {
            String temp = numholder.get(i);
            for (int j = i + 1; j < numholder.size(); j++) {
                if (temp.equalsIgnoreCase(numholder.get(j))) {
                    numholder.remove(j);
                }
            }
        }
    }

    public int recycleCount(String A, String B) {

        int count = 0;
        for (int i = Integer.parseInt(A); i < Integer.parseInt(B); i++) {
            this.numholder.clear();
            this.numrecylce(String.valueOf(i));
            this.cleanArray();

            for (int j = 0; j < numholder.size(); j++) {

                if (Integer.parseInt(numholder.get(j)) > i && Integer.parseInt(numholder.get(j)) <= Integer.parseInt(B)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = is.readLine();
        recyclePair rp = new recyclePair();

        int cases = Integer.parseInt(inputLine);

        for (int i = 0; i < cases; i++) {

            inputLine = is.readLine();
            String[] AB = inputLine.split(" ");

            System.out.println("Case #" + (i + 1) + ": " + rp.recycleCount(AB[0], AB[1]));


        }
    }
}