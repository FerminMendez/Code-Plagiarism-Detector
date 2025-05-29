package codejam2012.qualification.b;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Main {

    Logger log = LoggerFactory.getLogger(Main.class);

    private Scanner in;
    private PrintWriter out;
    private Memory memory = new Memory();

    public Main(InputStream in, OutputStream out) {
        this.in = new Scanner(in);
        this.out = new PrintWriter(out);
    }

    public void run() throws Exception {
        memory.init();
        int T = in.nextInt();
        log.debug("T: " + T);

        for (int t = 1; t <= T; ++t) {
            int N = in.nextInt();
            int S = in.nextInt();
            int P = in.nextInt();

            List<Integer> totals = new ArrayList<Integer>();

            for (int n = 1; n <= N; ++n) {
                totals.add(in.nextInt());
            }

            log.debug("N: " + N + " S: " + S + " P: " + P + " totals: " + totals);

            Round round = new Round(totals, memory);
            int result = round.run(S, P);
            log.debug("result: " + result);

            out.println(String.format("Case #%d: %d", t, result));
        }

        out.flush();
    }

    public static void main(String[] args) throws Exception {
        String path = "src/main/resources/" + args[0];
        try (FileInputStream in = new FileInputStream(path + ".in"); FileOutputStream out = new FileOutputStream(path + ".out")) {
            Main main = new Main(in, out);
            main.run();
        }
    }
}
