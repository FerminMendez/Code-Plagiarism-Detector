package recyclednumbers.recycler;

public class Recycler {

    public int countPairs(int startValue, int endValue) {

        int count = 0;

        for (int i = startValue; i < endValue; i++) {
            for (int j = i + 1; j <= endValue; j++) {
                if (isRecycledPair(i, j)) {
                    count++;
                }
            }
        }

        return count;

    }

    public boolean isRecycledPair(int original, int target) {

        String originalString = original + "";

        for (int i = originalString.length() - 1; i > 0; i--) {
            String testString = originalString.substring(i) + originalString.substring(0, i);

            if (Integer.parseInt(testString) == target) {
                return true;
            }

        }

        return false;

    }
}
