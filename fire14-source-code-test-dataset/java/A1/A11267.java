import java.util.ArrayList;
import java.util.List;

public class ProblemSample implements Problem {

    private int solution;

    private int googlers;

    private int surprises;

    private int note;

    private List<Integer> sums = new ArrayList<Integer>();

    @Override
    public void solve() {

        int resultat = 0;

        for (int i = 0; i < sums.size(); i++) {

            if (note == 0) {
                // Ils ont tous eu au moins 0...
                resultat = this.googlers;
            } else if (note == 1) {
                // Tous ceux qui ont eu au moins 1 ont eu au moins la note de 1.
                if (sums.get(i) >= 1) {
                    resultat++;
                }
            } else {
                if ((sums.get(i) == 3 * note - 4 || sums.get(i) == 3 * note - 3) && sums.get(i) > note) {
                    // S'ils sont tout juste, ils ont utilisé une surprise.
                    surprises--;
                    // Et on les compte que si il restait des surprises à consommer
                    if (surprises >= 0) {
                        resultat++;
                    }
                }
                if (sums.get(i) >= 3 * note - 2 && sums.get(i) > note) {
                    // Ok sans surprise.
                    resultat++;
                }
            }
        }
        this.setSolution(resultat);
    }

    @Override
    public void print() {
        System.out.println(googlers + " " + surprises + " " + note + " " + sums.toString());
    }

    @Override
    public Object getSolution() {
        return solution;
    }

    public void setSolution(int solution) {
        this.solution = solution;
    }

    public int getGooglers() {
        return googlers;
    }

    public int getSurprises() {
        return surprises;
    }

    public int getNote() {
        return note;
    }

    public List<Integer> getSums() {
        return sums;
    }

    public void setGooglers(int googlers) {
        this.googlers = googlers;
    }

    public void setSurprises(int surprises) {
        this.surprises = surprises;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public void setSums(List<Integer> sums) {
        this.sums = sums;
    }

}