
import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        String file = "C-small-attempt0";
        BufferedReader in = new BufferedReader(new FileReader(file + ".in"));
        FileWriter archivo = new FileWriter(file+".out");
        PrintWriter outs = new PrintWriter(archivo);
        outs.flush();
        //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(in.readLine());
        for (int i = 1; i <= n; i++) {
            HashSet<String> k = new HashSet<String>();
            StringTokenizer token = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(token.nextToken()), b = Integer.parseInt(token.nextToken());
            for (int j = a; j <= b; j++) {
                String r = String.valueOf(j);
                if (j < 100) {
                    String test1 = new StringBuilder(r).reverse().toString();

                    if (!r.equals(test1)) {
                        int comparer = Integer.parseInt(test1);

                        if (a <= comparer && comparer <= b) {
                            //System.out.println(comparer);
                            int lol = Integer.parseInt(r);
                            String container = Math.max(comparer, lol) + " - " + Math.min(comparer, lol);
                            //System.out.println(container);
                            if (!k.contains(container)) {
                                k.add(container);
                            }
                        }
                    }
                } else {
                    //System.out.println(r.length());
                    for (int c = 1; c < r.length(); c++) {

                        String test1 = r.substring(c);
                        String test2 = r.substring(0, c);
                        //System.out.println(test1+test2);
                        if (!r.equals(test1 + test2)) {
                            int comparer = Integer.parseInt(test1+test2);

                            if (a <= comparer && comparer <= b) {
                                //System.out.println(comparer);
                                int lol = Integer.parseInt(r);
                                String container = Math.max(comparer, lol) + " - " + Math.min(comparer, lol);
                                //System.out.println(container);
                                if (!k.contains(container)) {
                                    k.add(container);
                                }
                            }
                        }

                    }
                }
            }
            outs.println("Case #" + i + ": " + k.size());
        }





        outs.close();
        in.close();
        System.exit(0);

    }
}
