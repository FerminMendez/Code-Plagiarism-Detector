
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Recycle {

    public static void main(String[] args) {
        if (args.length == 1) {
            String file = args[0];
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                PrintWriter pw = new PrintWriter(new FileWriter("output.out", false));
                int count = Byte.parseByte(br.readLine());
                String line;
                int i = 0;
                while ((line = br.readLine()) != null && (i++ < count)) {
                    int i2 = Integer.parseInt(line.substring(line.lastIndexOf(" ") + 1));
                    int i1 = Integer.parseInt(line.substring(0, line.lastIndexOf(" ")));
                    int s = sendMeRange(i1, i2);
                    pw.println("Case #" + i + ": " + s);
                }
                br.close();
                pw.close();
            } catch (Exception err) {
                System.out.println("An error occurred running the program\n" + err);
            }
        } else {
            System.out.println("Please use the input file as one of the parameters");
        }

    }

    public static int sendMeRange(int i1, int i2) {
        byte len = (byte) ("" + i1).length();
        if ( len == 1){
            return 0;
        }
        else{
            String arr[][] = new String[(i2-i1)+1][2];
            int counter=0;
            for (int u = i1; u <= i2; u++){
                String tag = "" + u;
                String reverse = "";
                for (int q = tag.length() - 1; q > -1; q--){
                    reverse += "" + tag.charAt(0);
                }
                if (! tag.equals(reverse)){
                    arr[counter][0] =tag;
                    arr[counter][1] =tag + tag;
                } else{
                    arr[counter][0] =tag;
                    arr[counter][1] ="NOPE";
                }
                counter++;
            }
            counter=0;
            for (int u = 0; u < arr.length; u++){
                for (int u2 = u+1; u2 < arr.length; u2++){
                    if (arr[u][1].contains("" + arr[u2][0])){
                        counter++;
                    }
                }
            }
            return counter;
        }
    }
}