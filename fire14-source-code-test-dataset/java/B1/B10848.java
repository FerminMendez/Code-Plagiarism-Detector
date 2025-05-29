package codejam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class RecycledNumbers {
    public static void main(String[] args) throws IOException {
        String fileName = "C-small-attempt1";
        Queue<String> queue = file("input/"+fileName+".in");
        
        File outputFile = new File("result/"+fileName+".out");
        if(!outputFile.exists())
            outputFile.createNewFile();
        FileOutputStream output = new FileOutputStream(outputFile);
        
        int TestCases = Integer.parseInt(queue.poll());
        
        for(int i=0; i < TestCases; i++) {
            output.write(("Case #"+(i+1)+": ").getBytes());
            int[] input = parseLine(queue.poll());
            int A = input[0];
            int B = input[1];
            
            int base = (int)Math.log10(A);
            int count = 0;
    
            if(base > 0) {
                  int zeros = (int)Math.pow(10, base);
                  for(int n=A; n <= B; n++) {
                      int m = n;
                      for(int k=0; k < base; k++) {
                          m = m/10 + (m%10)*zeros;
 
                          if(n < m && m <= B)
                             count++;
                      }
                  }
              }
            
            output.write(Integer.toString(count).getBytes());
            output.write('\n');
        }
    }
   
    public static int recycleRoutine(int n, int m, int digits) {
         int count = 0;
         int base = (int)Math.pow(10, digits-1);
         for(int i=0; i < digits; i++) {
             n = n/10 + (n%10)*base;
             for(int j=0; j < digits; j++) {
                 m = m/10 + (m%10)*base;
                 
                 if(m >= n)
                    count++;
             }
         }
         
         return count;
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
