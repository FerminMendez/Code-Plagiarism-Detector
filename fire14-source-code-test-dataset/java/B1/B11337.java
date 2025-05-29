import java.util.Scanner;

public class Main extends AbstractCodeJam {

    @Override
    protected Problem readProblem(Scanner scan) {
        ProblemSample pb = new ProblemSample();
        // PARAMETRES A LIRE !!!
        pb.setA(scan.nextInt());
        pb.setB(scan.nextInt());
        scan.nextLine();
        return pb;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Main().solveProblems(System.in, System.out);
    }

}
