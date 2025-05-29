import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemSample implements Problem {

    private int solution;

    private int A;

    @Override
    public void solve() {

        int resultat = 0;

        for (int n = A; n <= B; n++) {

            // on trouve toutes les rotations de n
            String stringN = Integer.toString(n);
            int size = stringN.length();

            Set<Integer> mySet = new HashSet<Integer>();

            for (int i = 0; i < size; i++) {
                String actuel = rotation(stringN, size, i);
                // le set contient les candidats mais pas les doublons
                mySet.add(Integer.parseInt(actuel));
            }

            // on vérifie si les rotations trouvées sont bonnes ou pas.
            for (Integer candidat : mySet) {
                if (candidat > n && candidat <= B) {
                    // si la solution est bonne alors on incrémente.
                    resultat++;
                }
            }
        }
        this.setSolution(resultat);
    }

    private String rotation(String stringN, int size, int nbRotation) {
        String res = stringN;
        return res.substring(size - nbRotation, size) + res.substring(0, size - nbRotation);
    }

    @Override
    public Object getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public List<Integer> getSums() {
        return sums;
    }

    public void setSums(List<Integer> sums) {
        this.sums = sums;
    }

    private int B;

    private List<Integer> sums = new ArrayList<Integer>();

}