import java.util.Scanner;

public class Main extends AbstractCodeJam {

    @Override
    protected Problem readProblem(Scanner scan) {
        ProblemSample pb = new ProblemSample();
        // PARAMETRES A LIRE !!!
        pb.setGooglers(scan.nextInt());
        pb.setSurprises(scan.nextInt());
        pb.setNote(scan.nextInt());
        for (int i = 0; i < pb.getGooglers(); i++) {
            pb.getSums().add(scan.nextInt());
        }
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
