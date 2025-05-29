/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package dancinggooglers;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author nasir
 */
public class Main {

    private String[] inputArray;
    private int surprising;
    private int P;
    private int maximumGooglers = 0;
    private Queue URLQueue = new LinkedList();

    public Main() {
        readConsole();
        parseInput();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
    }

    public void readConsole() {
        boolean first = true;
        int testCases = 0;
        int loop = 0;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        while (loop <= testCases) {
            String str = scanner.nextLine();
            if (first) {
                first = false;
                testCases = Integer.parseInt(str);
                inputArray = new String[testCases];
            } else {

                inputArray[index++] = str;
            }
            loop++;
        }

    }

    public void parseInput() {
        String split = "[\\s]";
        Pattern p = Pattern.compile(split);
       int k = 1;
        for (String str : inputArray) {
            String[] tokens = p.split(str);
            
            surprising = Integer.parseInt(tokens[1]);
            P = Integer.parseInt(tokens[2]);
             List<Integer> googlerList = new LinkedList<Integer>();
            for(int i=3; i<tokens.length; i++){
                googlerList.add(Integer.parseInt(tokens[i]));
            }
            Collections.sort(googlerList);
            System.out.println("sorted list "+googlerList);
            maximumGooglers = 0;
            for(int index = googlerList.size()-1; index>=0; index--){
                Integer integer = googlerList.get(index);
                Integer avg = integer/3;
                Integer j1 = avg;
                Integer j2 = avg;
                Integer j3 = avg;
                Integer remainder = integer%3;
                if(remainder == 2){
                    j1+=1;
                    j2+=1;
                    remainder = 0;
                }
                if(remainder == 1){
                    j1+=1;
                }
                
                if(j1>= P || j2>=P || j3>=P){
                    System.out.println("J1 "+j1+" J2 "+j2+" J3 "+j3);
                    maximumGooglers++;
                    continue;
                }
                if(surprising>0){
                    if(j1==j2 && j2>0 && j1+1>=P){
                        surprising--;
                        maximumGooglers++;
                    }
                }

            }
            
            System.out.println("Case #"+k+": "+maximumGooglers);
            k++;

        }
        
    }

    public class dataStructure{
        int total;
        int judge1;
        int judge2;
        int judge3;

        public int getJudge1() {
            return judge1;
        }

        public void setJudge1(int judge1) {
            this.judge1 = judge1;
        }

        public int getJudge2() {
            return judge2;
        }

        public void setJudge2(int judge2) {
            this.judge2 = judge2;
        }

        public int getJudge3() {
            return judge3;
        }

        public void setJudge3(int judge3) {
            this.judge3 = judge3;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

    }
}
