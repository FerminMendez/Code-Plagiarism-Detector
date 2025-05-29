package recyclednumbers;

import inout.In;
import inout.Out;

public class Main {

    public static void main(String[] args) throws Exception {
        String[] strings = In.read("C-small-attempt1.in", 1);
        int n = 1;
        for (String s : strings) {
            long cont = 0;
            String[] split = s.split(" ");
            long min = Long.parseLong(split[0]);
            long max = Long.parseLong(split[1]);
            if ((min + "").length() > 1) {
                for (long i = min; i < max; i++) {
                    String newstr1 = "" + i;
                    ext: for (long j = i + 1; j <= max; j++) {
                        String newstr2 = "" + j;
                        for (int k = newstr1.length() - 1; k > 0; k--) {
                            String str = newstr1.substring(k) + newstr1.substring(0, k);
                            if (str.equals(newstr2)) {
                                cont++;
                                continue ext;
                            }
                        }
                    }
                }
            }
            Out.write("output.txt", n++, cont + "");
        }
    }
}
