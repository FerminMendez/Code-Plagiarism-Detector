package codejam;

import java.io.*;

public class Dancing {
    private final int[] total_scores;
    private final int superising_count;

    public Dancing(int[] total_scores, int superising_count) {
        this.total_scores = total_scores;
        this.superising_count = superising_count;
    }

    public static void main(String[] args) throws IOException {
        InputStream is;
        if (args.length > 0) {
            is = new FileInputStream(args[0]);
        }else{
            is = System.in;
        }

        BufferedReader inputReader = new BufferedReader(new InputStreamReader(is));
        String firstLine = inputReader.readLine();
        int count_of_cases = Integer.parseInt(firstLine);

        for (int idx_of_case = 1; idx_of_case <= count_of_cases; idx_of_case++) {
            String caseLine = inputReader.readLine();
            String[] numbers = caseLine.split(" ");

            int numbers_of_googler = Integer.parseInt(numbers[0]);
            int superising_count = Integer.parseInt(numbers[1]);
            int at_least = Integer.parseInt(numbers[2]);

            int[] total_scores = new int[numbers_of_googler];
            for (int idx = 0; idx < numbers_of_googler; idx++) {
                total_scores[idx] = Integer.parseInt(numbers[3+idx]);
            }

            int count = new Dancing(total_scores, superising_count).count_of_greater_than(at_least);

            System.out.println(String.format("Case #%d: %d", idx_of_case, count));
        }

    }

    public int count_of_greater_than(int at_least) {
        int supersed_count = 0;
        int count=0;
        for (int idx = 0; idx < total_scores.length; idx++) {
            int score = total_scores[idx];

            int max_score = 0;
            int average = score / 3;
            if (average * 3 == score) {
                max_score = average;
            }else{
                max_score = average+1;
            }

            if (max_score >= at_least) {
                count++;
            }else{
                int left = score - at_least;
                if (left > 0 && supersed_count < superising_count ) {
                    if ((left / 2) * 2 == left && at_least - left / 2 == 2) {
                        supersed_count++;
                        count++;
                    }
                    if (left == 2 * at_least -3 ) {
                        supersed_count++;
                        count++;
                    }
                }
            }


        }
        return count;

    }
}
