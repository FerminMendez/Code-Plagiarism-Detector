package gcj.quals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class T2 {
    public static void main(String[] args) {
        File fi = new File("/home/sighless/Documents/gcj/2");
        File fo = new File("/home/sighless/Documents/gcj/out");
        
        BufferedReader in = null;
        BufferedWriter out = null;
        
        try {
            in = new BufferedReader(new FileReader(fi));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        
        try {
            out = new BufferedWriter(new FileWriter(fo));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        List<String> input = new ArrayList<String>();
        try {
            int lines = Integer.parseInt(in.readLine());
        
            String line = "";
            while(lines != 0) {
                line = in.readLine();
                
                input.add(line);
                lines--;
            }
        } catch (IOException e) {}

        String[] parts;
        int googlers = 0, surprises = 0, checkScore = 0, result = 0;
        Score googlerScore = new Score();
        for(int i = 0; i < input.size(); ++i) {
            parts = input.get(i).split(" ");
            
            googlers = Integer.parseInt(parts[0]);
            surprises = Integer.parseInt(parts[1]);
            checkScore = Integer.parseInt(parts[2]);
            
            result = 0;
            for(int g = 0; g < googlers; ++g) {
                googlerScore.init(Integer.parseInt(parts[g + 3]), surprises > 0 ? true : false);
                if(googlerScore.check(checkScore)) {
                    result++;
                    if(googlerScore.isSurprise()) surprises--;
                }
            }
            
            
            try {
                out.write("Case #" + (i + 1) + ": " + result + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Score {
    int total;
    boolean surprise;
    
    public void init(int total, boolean surprise) {
        this.total = total;
        this.surprise = surprise;
    }
    
    public boolean check(int singleScore) {
        int average = total / 3;
        
        if(average >= singleScore) {surprise = false; return true;}
        
        int distance = singleScore - average; 
        switch(total - (average * 3)) {
        case 0:
            if((distance == 1) && average >= 1 && surprise) return true;
            break;
        case 1:
            if(distance == 1) {surprise = false; return true;}
            break;
        case 2:
            if(distance == 1) {surprise = false; return true;}
            if((distance == 2)  && surprise) return true;
            break;
        }
        
        return false;
    }
    
    public boolean isSurprise() {
        return surprise;
    }
}