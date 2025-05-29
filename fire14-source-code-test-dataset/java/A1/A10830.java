package codejam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class GooglersDance {
    public static void main(String[] args) throws IOException {
        String fileName = "B-small-attempt0";
        Queue<String> queue = file("input/"+fileName+".in");
        
        File outputFile = new File("result/"+fileName+".out");
        if(!outputFile.exists())
            outputFile.createNewFile();
        FileOutputStream output = new FileOutputStream(outputFile);
        
        int TestCases = Integer.parseInt(queue.poll());
        
        for(int i=0; i < TestCases; i++) {
            output.write(("Case #"+(i+1)+": ").getBytes());
            int[] input = parseLine(queue.poll());
            
            int cGoogler = input[0];
            int cSurprise = input[1];
            int p = input[2];
            
            int count = 0;
            for(int j=0; j < cGoogler; j++) {
                int score = input[3+j];
                /* legitimate score */
                if((score+2)/3 >= p) {
                   count++;
                   continue;
                }
                
                /* try surprising result */
                if(cSurprise > 0 && (score+4)/3 >= p && score > 1) {
                   count++;
                   cSurprise--;
                   continue;
                }
            }
            
            output.write(Integer.toString(count).getBytes());
            output.write('\n');
        }
    }
   
    public static int[] parseLine(String line) {
        String[] array = line.split("\\s");
        int[] result = new int[array.length];
        
        for(int i=0; i < result.length; i++)
            result[i] = Integer.parseInt(array[i]);
        
        return result;
    }
    /* given a file name ... fetches the file from war folder */
    public static byte[] getFile(String fileName) throws IOException {
        FileInputStream in = new FileInputStream(fileName);
        int size = in.available();
        byte[] imageBytes = new byte[size];

        /* read the whole image into array */
        int read = 0;
        while(read < size)
              read += in.read(imageBytes, read, size-read);
        
        return imageBytes;
    }
    
    /* mimic php functions */
    public static Queue<String> file(String filename) throws IOException {
        byte[] fileBytes = getFile(filename);
        Queue<String> queue = new LinkedList();
        
        StringBuilder builder = new StringBuilder();
        for(int i=0; i < fileBytes.length; i++) {
            if(fileBytes[i] == '\n') {
               queue.add(builder.toString());
               builder.delete(0, builder.length());
               continue;
            } if(fileBytes[i] == '\r')
               continue;
            builder.append((char)fileBytes[i]);
        }
        
        return queue;
    }
}
