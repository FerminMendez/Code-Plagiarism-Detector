import java.io.*;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("t.txt")));
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("out.txt")));
        int num = Integer.parseInt(reader.readLine().trim());
        for (int i = 0; i < num; i++) {
            String orig = reader.readLine();
            writer.write("Case #" + (i+1) + ": ");
            String[] strs = orig.split(" +");
            int n = Integer.parseInt(strs[0]);
            int g = Integer.parseInt(strs[1]);
            int p = Integer.parseInt(strs[2]);
            int res = 0;
            for(int j = 3; j < strs.length; j++){
                int k = Integer.parseInt(strs[j]);
                if(k / 3 > p-1 || (k /3 == p-1 && k % 3 != 0)){
                    res++;
                } else {
                    if (g > 0 && ((k-p >= 0) && ((k-p)/ 2 >= p - 2 || ((k-p) / 2 == p - 1 && (k-p) % 2 != 0)))) {
                        g--;
                        res++;
                    }
                }
            }
            writer.write("" + res);
            if(i < num-1){
                writer.write('\n');
            }
        }
        writer.close();
        reader.close();
    }
}
