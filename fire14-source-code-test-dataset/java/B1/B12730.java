package codejam;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        String input = FileUtils.readFileToString(new File("/Users/adilmezghouti/Documents/codejam/src/main/java/codejam/input.txt"));
        String[] arr = input.split("\\n");
        String[] split;
        int size = Integer.parseInt(arr[0]);
        App app = new App();

        List<String> lines = new ArrayList<String>();
        for(int i=1;i <= size;i++){
            split = arr[i].split(" ");
            lines.add("Case #" + i + ": " + app.permute(split[0], split[1]));
        }

        FileUtils.writeLines(new File("output.txt"), lines);


    }

    public int permute(String a, String b){
        if(a.length() <= 1) return 0;

        int counter = 0;
        int floor = Integer.parseInt(a);
        int ceil = Integer.parseInt(b);
        int buffer = floor;

        while(buffer < ceil){
            String str = String.valueOf(buffer);
            for(int i=0;i < str.length() - 1;i++){
                try {
                    int result = Integer.parseInt(str.substring(str.length() - 1 - i,str.length()) + str.substring(0,str.length() - i - 1));
                    if( result > buffer && result <= ceil) {
                        counter++;
                        //System.out.println(buffer + "  " + result + "  " + counter);
                    }
                }catch(Throwable t){
                    System.out.println(buffer);
                }
            }
            buffer++;
        }
        return counter;
    }
}


