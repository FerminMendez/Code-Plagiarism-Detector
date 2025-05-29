import java.io.*;
import java.util.*;


public class ProblemC {

   Set<Long> recycled = new TreeSet<Long>();
    int count = 0;

    FileWriter fstream;
    BufferedWriter out;

    public static void main(String[] args) throws IOException {
        ProblemC p = new ProblemC();
        p.fstream = new FileWriter("outC.txt");
        p.out = new BufferedWriter(p.fstream);
        p.readFile("C-small-attempt0.in");
        p.out.close();
    }

    public void readFile(String filePath) {

        String[] result = null;

        try {
            FileReader input = new FileReader(filePath);
            BufferedReader bufRead = new BufferedReader(input);


            Scanner scan = new Scanner(input);

            this.count = scan.nextInt();


            for (int i = 0; i < count; i++) {
                int a = scan.nextInt();
                int b = scan.nextInt();
                out.write("Case #"+(i+1)+": "+calculate(a, b));
                if (i<count-1)
                    out.write("\n");
            }
            bufRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public int calculate(int a, int b) {
        recycled.clear();
        int count = 0;

        for (int i = a; i <= b; i++) {

            String num = String.valueOf(i);
            int d = num.length();
            for (int j = 1; j < num.length(); j++) {
                String newNum = num.substring(num.length() - j, num.length()) + num.substring(0, num.length() - j);
                if (newNum.charAt(0) != '0') {
                    int value = Integer.valueOf(newNum);
                    if ((value <= b) && (value >= a) && (value != i) && (!recycled.contains(Long.parseLong(num+newNum))) && (!recycled.contains(Long.parseLong(newNum+num))))  {
                        recycled.add(Long.parseLong(num + newNum));
                        recycled.add(Long.parseLong(num+newNum));
                        count++;
                    }

                }
            }
        }
        System.out.println(count);
        return count;
    }


}
