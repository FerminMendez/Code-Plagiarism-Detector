import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public abstract class AbstractCodeJam {

    public void solveProblems(InputStream in, PrintStream out) {
        Scanner scan = new Scanner(in);
        int nb = scan.nextInt();
        scan.nextLine();
        for (int i = 1; i <= nb; i++) {
            Problem problem = readProblem(scan);
            // problem.print();
            problem.solve();
            out.println("Case #" + i + ": " + problem.getSolution());
        }
    }

    protected abstract Problem readProblem(Scanner scan);

}
