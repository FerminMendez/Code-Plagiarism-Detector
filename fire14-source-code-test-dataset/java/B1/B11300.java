/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author Jason
 */
public class NumberCruncher {
    public NumberCruncher(BufferedReader reader) {
        try {
            FileWriter outFile = new FileWriter(("output.txt"));
            PrintWriter out = new PrintWriter(outFile);
        
            int cases = Integer.parseInt(reader.readLine());
            for(int i=1;i<=cases;i++) {
                String list = reader.readLine();
                String separator = " ";
                ArrayList<String> nums = new ArrayList<String>(Arrays.asList(list.split(separator)));
                int recycled = 0;
                
                //System.out.println(nums.toString());
                HashSet<String> result = new HashSet<String>();
                ArrayList<String> aChars = StringToArrayList(nums.get(0));
                
                //System.out.println("aChars: " + aChars.toString());
                //System.out.println("Value of aChars: " + ValueOfList(aChars));
                
                int A = Integer.parseInt(nums.get(0));
                int B = Integer.parseInt(nums.get(1));
                
                //System.out.println("A: " + A);
                //System.out.println("B: " + B);
                
                while (ValueOfList(aChars) < B) {
                    ArrayList<String> temp = new ArrayList<String>(aChars);
                    //System.out.println("Value of aChars: " + ValueOfList(aChars));
                    
                    for(int j=0;j<(aChars.size()-1);j++) {
                        
                        String tStr = temp.get(aChars.size()-1);
                        temp.remove(aChars.size()-1);
                        temp.add(0, tStr);
                        
                        if(ValueOfList(temp) <= B && ValueOfList(aChars) < ValueOfList(temp) && temp.size() == aChars.size()) {
                            recycled++;
                            String toAdd = ValueOfList(aChars) + "->" + ValueOfList(temp);
                            result.add(toAdd);
                            //System.out.println(ValueOfList(aChars) + "->" + ValueOfList(temp) + " IS RECYCLED!");
                            //System.out.println("IS RECYCLED!");
                        }
                    }
                    
                    aChars = Increment(aChars);
                }
                //System.out.println("Case #"+i+": " + result.size());
                out.println("Case #"+i+": " + result.size());
            }
            out.close();
        }catch(IOException e){System.out.println("Exception!");}
    }
    
    private int ValueOfList(ArrayList<String> l) {
        int sum = 0;
        int digits = l.size();
        for(String str : l) {
            digits--;
            sum += (Integer.parseInt(str) * Math.pow(10, digits));
        }
        return sum;
    }
    
    private ArrayList<String> Increment(ArrayList<String> l) {
        int v = ValueOfList(l);
        v++;
        String s = Integer.toString(v);
        return StringToArrayList(s);
    }
    
    private ArrayList<String> StringToArrayList(String str) {
        ArrayList<String> newArray = new ArrayList<String>();
        
        for(int i=0;i<str.length();i++) {
            char currentChar = str.charAt(i);
            newArray.add(Character.toString(currentChar));
        }
        return newArray;
    }
}
