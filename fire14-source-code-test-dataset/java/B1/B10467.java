package mairbek.codejam;

import com.google.common.collect.Lists;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SolutionC {

    public static void main(String[] args) {


        List<Pair<Integer, Integer>> input = parseInputFile("50\n" +
                "146 982\n" +
                "10 11\n" +
                "733 764\n" +
                "144 975\n" +
                "112 999\n" +
                "109 939\n" +
                "166 931\n" +
                "101 984\n" +
                "113 949\n" +
                "100 999\n" +
                "176 968\n" +
                "186 186\n" +
                "122 985\n" +
                "156 929\n" +
                "17 35\n" +
                "953 953\n" +
                "117 952\n" +
                "158 982\n" +
                "150 993\n" +
                "140 959\n" +
                "119 945\n" +
                "149 993\n" +
                "131 970\n" +
                "153 955\n" +
                "969 976\n" +
                "185 911\n" +
                "143 960\n" +
                "141 957\n" +
                "136 933\n" +
                "170 925\n" +
                "113 979\n" +
                "100 100\n" +
                "2 4\n" +
                "178 999\n" +
                "109 915\n" +
                "110 980\n" +
                "100 999\n" +
                "151 960\n" +
                "150 992\n" +
                "117 932\n" +
                "129 936\n" +
                "180 978\n" +
                "128 937\n" +
                "185 939\n" +
                "190 933\n" +
                "25 56\n" +
                "128 971\n" +
                "202 316\n" +
                "105 970\n" +
                "167 923\n");

        System.out.println(input);

        int i = 1;
        for (Pair<Integer, Integer> range : input) {
            System.out.println("Case #" + i + ": " + findRecycled(range).size());
            i++;
        }


    }


    private static List<Pair<Integer, Integer>> parseInputFile(String content) {
        String[] split = content.split("\n");

        int num = Integer.parseInt(split[0]);
        List<Pair<Integer, Integer>> result = Lists.newArrayList();

        for (int i = 1; i <= num; i++) {
            String[] pairSplit = split[i].split(" ");
            result.add(Pair.create(Integer.parseInt(pairSplit[0]), Integer.parseInt(pairSplit[1])));
        }

        return result;
    }



    private static Set<Pair<Integer, Integer>> findRecycled(Pair<Integer, Integer> range) {
        return findRecycled(range.getFirst(), range.getSecond());
    }

    private static Set<Pair<Integer, Integer>> findRecycled(int from, int to) {
        Set<Pair<Integer, Integer>> result = new LinkedHashSet<Pair<Integer, Integer>>();

        for (int i = from; i <= to; i++) {
            for (int j = from; j <= to; j++) {
                if (i == j) {
                    continue;
                }

                int first = i;
                int second = j;

                if (first < second) {
                    second = i;
                    first = j;
                }

                if (areEqualRecycled(first, second)) {
                    result.add(Pair.create(first, second));
                }
            }
        }


        return result;
    }


    private static boolean areEqualRecycled(int one, int two) {
        String oneS = String.valueOf(one);
        String twoS = String.valueOf(two);

        return (twoS + twoS).contains(oneS);

    }
}
