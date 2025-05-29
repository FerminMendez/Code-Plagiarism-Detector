/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dylan
 */
public class CodeJam {
    /*
    ArrayList<Map> maps = new ArrayList<Map>();
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String[] args) {
        new CodeJam();
    }
    
    public CodeJam()
    {
        try {
            
            maps.add(new Map('a', 'y')); 
            maps.add(new Map('b', 'h'));
            maps.add(new Map('c', 'e'));
            maps.add(new Map('d', 's'));
            maps.add(new Map('e', 'o'));
            maps.add(new Map('f', 'c'));
            maps.add(new Map('g', 'v'));
            maps.add(new Map('h', 'x'));
            maps.add(new Map('i', 'd'));
            maps.add(new Map('j', 'u'));
            maps.add(new Map('k', 'i'));
            maps.add(new Map('l', 'g'));
            maps.add(new Map('m', 'l'));
            maps.add(new Map('n', 'b'));
            maps.add(new Map('o', 'k'));
            maps.add(new Map('p', 'r'));
            maps.add(new Map('o', 'e'));
            maps.add(new Map('q', 'z'));
            maps.add(new Map('r', 't'));
            maps.add(new Map('s', 'n'));
            maps.add(new Map('t', 'w'));
            maps.add(new Map('u', 'j'));
            maps.add(new Map('v', 'p'));
            maps.add(new Map('w', 'f'));
            maps.add(new Map('x', 'm'));
            maps.add(new Map('y', 'a'));
            maps.add(new Map('z', 'q'));
            
            /*
            maps.add(new Map('y', 'a')); 
            maps.add(new Map('n', 'b'));
            maps.add(new Map('f', 'c'));
            maps.add(new Map('i', 'd'));
            maps.add(new Map('o', 'e'));
            maps.add(new Map('w', 'f'));
            maps.add(new Map('l', 'g'));
            maps.add(new Map('b', 'h'));
            maps.add(new Map('k', 'i'));
            maps.add(new Map('u', 'j'));
            maps.add(new Map('i', 'k'));
            maps.add(new Map('m', 'l'));
            maps.add(new Map('x', 'm'));
            maps.add(new Map('s', 'n'));
            maps.add(new Map('e', 'o'));
            maps.add(new Map('v', 'p'));
            maps.add(new Map('z', 'q'));
            maps.add(new Map('p', 'r'));
            maps.add(new Map('d', 's'));
            maps.add(new Map('r', 't'));
            maps.add(new Map('j', 'u'));
            maps.add(new Map('g', 'v'));
            maps.add(new Map('t', 'w'));
            maps.add(new Map('h', 'x'));
            maps.add(new Map('a', 'y'));
            maps.add(new Map('q', 'z'));
             * 
             */
/*

            File inputFile = new File("C:\\Users\\Dylan\\Downloads\\A-small-attempt3.in");
            String[] array =  readFile(inputFile);
            for(int i = 1; i < array.length + 1; i++)
                System.out.println("Case #"+i+": "+translate(array[i-1]));
                    
                    //
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    String translate(String string)
    {
        String outString = "";
        for(int i = 0; i < string.length(); i++)
        {
            char in = string.charAt(i);
            outString += findMapByIn(in);
        }
        return outString;
    }
    
    public String[] readFile(File file) throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(reader.readLine());
        String[] array = new String[n];
        for(int i = 0; i < n; i++)
        {
            array[i] = reader.readLine();
        }
        return array;
    }
    

    
    public char findMapByIn(char in)
    {
        for(Map m : maps)
        {
            if(m.in == in)
            {
                return m.out;
            }
        }
        return ' ';
    }
    
    class Map{
        public Map(char in, char out)
        {
            this.in = in;
            this.out = out;
        }
        
        public char in, out;
    }
     * 
     */
    public static void main(String[] args) {
        new CodeJam();
    }
    public CodeJam()
    {
        try{
        File inputFile = new File("C:\\Users\\Dylan\\Downloads\\B-small-attempt2.in");
            ScoreLine[] array =  readFile(inputFile);
            for(int i = 1; i < array.length + 1; i++){
                GooglerDance gd = new GooglerDance(array[i-1].suprises);
               // System.out.println(array[i-1].toString());
                System.out.println("Case #"+i+": "+gd.getNumAboveP(array[i-1].scores, array[i-1].p));
            }
                    
                    //
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ScoreLine[] readFile(File file) throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int n = Integer.parseInt(reader.readLine());
        ScoreLine[] array = new ScoreLine[n];
        for(int i = 0; i < n; i++)
        {
            String line = reader.readLine();
            String[] lineSplit = line.split(" ");
            int dancers = Integer.parseInt(lineSplit[0]);
            int suprises = Integer.parseInt(lineSplit[1]);
            int p = Integer.parseInt(lineSplit[2]);
            int[] scores = new int[dancers];
            for(int di = 0; di < dancers; di++)
            {
                scores[di] = Integer.parseInt(lineSplit[di+3]);
            }
            array[i] = new ScoreLine(p, dancers, suprises, scores, line);
        }
        return array;
    }
    
    
    class ScoreLine{
        int p;
        int dancers;
        int suprises;
        int[] scores;
        String s;
        public ScoreLine(int p, int dancers, int suprises, int[] scores, String s) {
            this.p = p;
            this.dancers = dancers;
            this.suprises = suprises;
            this.scores = scores;
            this.s = s;
        }
        
        
        @Override
        public String toString()
        {
            return s;
        }
        
    }
}
