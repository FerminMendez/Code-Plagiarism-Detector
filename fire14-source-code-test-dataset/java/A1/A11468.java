import java.io.*;

public class Dancing {

    public static void main (String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader (args[0]));
        FileWriter output = new FileWriter("dancingOutput.txt");
        int numTests = Integer.parseInt(input.readLine());
        for (int test = 1; test <= numTests; test++) {
            output.write("Case #" + test + ": ");
            String testCase = input.readLine();
            String[] split = testCase.split(" ");
            int[] nums = new int[split.length - 3];
            int numGooglers = Integer.parseInt(split[0]);
            int surprising = Integer.parseInt(split[1]);
            int maxScore = Integer.parseInt(split[2]);
            int firstScore = maxScore + Math.max(maxScore-1, 0)*2;
            int secondScore = maxScore + Math.max(maxScore-2, 0)*2;
            for (int i = 3; i < split.length; i++) {
                nums[i-3] = Integer.parseInt(split[i]);
            }
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= firstScore) {
                    sum++;
                } else if (surprising > 0 && nums[i] >= secondScore) {
                    sum++;
                    surprising--;
                }
            }
            output.write(sum + "\n");
        }
        output.flush();
    }

}
