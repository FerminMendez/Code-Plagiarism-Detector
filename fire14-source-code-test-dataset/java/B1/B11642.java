/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package coba;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Unggul
 */
public class Recycle {

    int count;
    ArrayList<String> inputList1 = new ArrayList<String>();
    ArrayList<String> inputList2= new ArrayList<String>();
    ArrayList<String> outputList = new ArrayList<String>();
    
    public Recycle(){                
    }
    
    public String cycle(String input){
        char[] temp = new char[input.length()];        
        temp[0] = input.charAt(input.length()-1);
        for(int i=0;i<input.length()-1;i++){
            temp[i+1] = input.charAt(i);
        }        
        return new String(temp);
    }
    
    public boolean isRecycle(String a, String b){
        String temp = b;
        if(a.length()!=b.length())
            return false;        
        for(int i=0;i<a.length();i++){            
            if(temp.equals(a))
                return true;
            temp = cycle(temp);
            if(temp.equals(b))
                return false;
        }            
        return false;
    }        
    
    public int countRecycle(String a, String b){
        int total = 0;
        int count = 0;
        int valA = StringToInt(a);
        int valB = StringToInt(b);
        String tempA = a;
        String tempB = add(tempA);
        
        for(int i=valA;i<valB;i++){
            for(int j=i+1;j<=valB;j++){
                if(isRecycle(tempA, tempB))
                    total++;
                    
                tempB = add(tempB);
            }
            tempA = add(tempA);            
            tempB = add(tempA);
        }
//        System.out.println(total);
        return total;
    }
    
    public ArrayList<String> countRecycle(ArrayList<String> a, ArrayList<String> b){
        ArrayList<String> tempList = new ArrayList<String>();
        String tempA;
        String tempB;
        int temp;
        for(int i=0;i<count;i++){
            tempA = a.get(i);
            tempB = b.get(i);
            
            temp = countRecycle(tempA, tempB);
            tempList.add(""+temp);            
        }        
        return tempList;
    }
    
    
    
    public String add(String a){
        int i = StringToInt(a);
        i++;
        return new String("" + i);
    }
    
     public int StringToInt(String s){        
        int temp = 0;
        for(int i=0;i<s.length();i++){            
            temp += CharToInt(s.charAt(i));
            temp = temp * 10;
        }
        temp = temp/10;
        return temp;        
    }
     
    public int CharToInt(char c){        
        int temp = 0;
        switch (c) {
            case '0' : temp = 0; break;                
            case '1' : temp = 1; break;                
            case '2' : temp = 2; break;                
            case '3' : temp = 3; break;                
            case '4' : temp = 4; break;                
            case '5' : temp = 5; break;                
            case '6' : temp = 6; break;                
            case '7' : temp = 7; break;                
            case '8' : temp = 8; break;                
            case '9' : temp = 9; break;                                        
        }
        return temp;
    }     
    
    public void getInput(File file) throws FileNotFoundException, IOException{
        // Open the file that is the first
        // command line parameter
        FileInputStream fstream = new FileInputStream(file);
        // Get the object of DataInputStream
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));        
        String strLine;
        
        strLine = br.readLine();
        count = StringToInt(strLine);//get count
        
        for (int i = 0; i < count; i++) {//get list of string
            strLine = br.readLine();
            String[] temp = strLine.split(" ");
            inputList1.add(temp[0]);
            inputList2.add(temp[1]);
        }
        
        in.close();        
    } 
    
    public void writeOutput() throws IOException{        
        FileWriter fstream = new FileWriter("output2.txt");        
        BufferedWriter out = new BufferedWriter(fstream);                    
        for(int i=0;i<count;i++){
            int x = i+1;
            //System.out.println(x);
            out.write("Case #" + x + ": " + outputList.get(i) + "\n");
        }
        
        out.close();
    }
    
    public void Solve(File file) throws FileNotFoundException, IOException{
        this.getInput(file);//get input
        outputList = this.countRecycle(inputList1, inputList2);
        this.writeOutput();
    }
    
    public static void main(String args[]) throws FileNotFoundException, IOException {
        Recycle r = new Recycle();
        String path = "input.txt";//change this!!
        File f = new File(path);
        r.Solve(f);
    }
    
}
