import java.util.HashSet;
import java.util.Scanner;


public class Dance {

    private int[] mTotalScores;
    private int mMaxSurprise;
    private int mP;
    private int mAnswer;
    
    public Dance(int[] totalScores, int maxSurprise, int p) {
        mTotalScores = totalScores;
        mMaxSurprise = maxSurprise;
        mP = p;
        recurse(0, 0, 0);
    }
    
    public int getAnswer() {
        return mAnswer;
    }
    
    private void recurse(int index, int surprises, int qualified) {
        if (surprises > mMaxSurprise) return;
        if (index >= mTotalScores.length) {
            if (qualified > mAnswer) {
                mAnswer = qualified;
            }
            return;
        }
        
        Pair[] pos = scoreVariations(mTotalScores[index]);
        for (int i = 0; i < pos.length; i++) {
            int localSurprises = surprises;
            int localQualified = qualified;
            if (pos[i].surprise) localSurprises++;
            if (pos[i].max >= mP) localQualified++;
            recurse(index + 1, localSurprises, localQualified);
        }
    }
    
    // Get possible score variations
    public static Pair[] scoreVariations(int score) {
        HashSet<Pair> set = new HashSet<Pair>();
        
        int fStart = score / 3;
        int fEnd = Math.min(10, fStart + 3);
        
        for (int i = fStart; i <= fEnd; i++) {
            int sStart = i;
            int sEnd = Math.min(10, i + 2);
            for (int j = sStart; j <= sEnd; j++) {
                int k = score - i - j;
                
                if (Math.abs(i - k) > 2 || Math.abs(j - k) > 2 || k > 10 || k < 0) {
                    // Invalid case
                    continue;
                }
                
                boolean surprise = Math.abs(i - k) == 2 || Math.abs(j - k) == 2 || Math.abs(i - j) == 2;
                int max = Math.max(i, Math.max(j, k));
                set.add(new Pair(max, surprise));
            }
        }
        
        return set.toArray(new Pair[0]);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        
        for (int i = 0; i < num; i++) {
            int num2 = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();
            int[] scores = new int[num2];
            for (int j = 0; j < num2; j++) {
                scores[j] = in.nextInt();
            }
            Dance d = new Dance(scores, s, p);
            System.out.println("Case #" + (i + 1) + ": " + d.getAnswer());
        }
    }

}
