public class Dancing {
    public static int atLeast;
    public static Googler[] googlers;

    public static void main(String[] args) {
        doProblems("100\n" + "3 1 5 15 13 11\n" +
                "3 0 8 23 22 21\n" +
                "2 1 4 29 19\n" +
                "1 0 8 19\n" +
                "1 0 7 8\n" +
                "2 0 10 26 18\n" +
                "1 0 8 21\n" +
                "2 0 4 8 17\n" +
                "1 0 6 5\n" +
                "1 0 7 12\n" +
                "3 1 6 14 15 14\n" +
                "1 1 1 15\n" +
                "2 1 6 1 11\n" +
                "3 0 9 23 13 23\n" +
                "3 0 0 14 25 15\n" +
                "3 0 6 6 4 4\n" +
                "2 0 6 14 11\n" +
                "2 0 7 18 16\n" +
                "1 0 5 11\n" +
                "2 1 4 8 8\n" +
                "2 2 5 16 23\n" +
                "2 1 1 0 12\n" +
                "3 1 8 21 21 3\n" +
                "1 1 4 4\n" +
                "2 0 4 5 27\n" +
                "3 0 4 9 8 8\n" +
                "2 0 2 3 2\n" +
                "1 0 6 29\n" +
                "3 0 10 2 8 16\n" +
                "1 1 10 19\n" +
                "1 0 7 17\n" +
                "2 0 3 5 28\n" +
                "2 2 8 11 26\n" +
                "2 2 2 13 10\n" +
                "2 0 10 30 30\n" +
                "1 1 6 19\n" +
                "3 0 10 30 19 8\n" +
                "3 3 6 12 2 9\n" +
                "2 0 4 11 28\n" +
                "2 0 5 16 20\n" +
                "1 0 3 6\n" +
                "2 1 3 3 4\n" +
                "2 2 4 22 6\n" +
                "1 0 7 18\n" +
                "2 0 7 1 9\n" +
                "1 0 2 30\n" +
                "1 1 10 13\n" +
                "3 3 0 17 9 23\n" +
                "1 0 10 27\n" +
                "3 0 7 29 29 29\n" +
                "2 0 8 13 30\n" +
                "1 0 4 9\n" +
                "1 0 7 13\n" +
                "2 0 6 25 15\n" +
                "1 0 8 15\n" +
                "3 1 10 20 5 4\n" +
                "3 0 8 5 11 10\n" +
                "1 0 7 18\n" +
                "3 1 10 26 27 25\n" +
                "2 2 3 26 27\n" +
                "2 0 2 2 3\n" +
                "1 1 3 14\n" +
                "2 1 8 21 20\n" +
                "2 0 2 20 6\n" +
                "3 0 6 3 2 24\n" +
                "3 0 9 11 16 30\n" +
                "1 1 3 28\n" +
                "3 2 9 3 27 7\n" +
                "2 2 9 10 18\n" +
                "1 0 2 2\n" +
                "1 0 10 27\n" +
                "3 2 10 23 18 17\n" +
                "3 0 10 15 16 21\n" +
                "1 0 2 15\n" +
                "2 0 8 20 25\n" +
                "2 0 4 30 12\n" +
                "1 0 6 18\n" +
                "3 0 10 4 21 12\n" +
                "1 0 9 23\n" +
                "3 0 8 27 5 0\n" +
                "1 0 9 8\n" +
                "1 1 5 24\n" +
                "1 0 0 30\n" +
                "2 0 1 15 16\n" +
                "1 0 3 11\n" +
                "2 0 4 14 8\n" +
                "1 0 10 27\n" +
                "2 0 0 0 0\n" +
                "2 2 3 22 8\n" +
                "2 0 5 15 11\n" +
                "2 0 7 3 20\n" +
                "2 0 4 16 4\n" +
                "1 0 5 12\n" +
                "1 0 2 17\n" +
                "3 2 9 25 10 1\n" +
                "1 0 7 29\n" +
                "2 0 1 0 1\n" +
                "2 0 1 0 0\n" +
                "1 0 3 29\n" +
                "2 1 7 18 18\n");
    }

    private static void doProblems(String in) {
        String[] problems = in.split("\n");
        for (int count = 0; count < Integer.valueOf(problems[0]); count++) {
            doProblem(problems[count + 1], count + 1);
        }
    }

    private static void doProblem(String in, int problemNumber) {
        String[] array = in.split(" ");
        int numberOfGooglers = Integer.valueOf(array[0]);
        int surprisingGooglers = Integer.valueOf(array[1]);
        atLeast = Integer.valueOf(array[2]);
        int[] googlerTotals = new int[numberOfGooglers];
        for (int count = 0; count < numberOfGooglers; count++) {
            googlerTotals[count] = Integer.valueOf(array[count + 3]);
        }
        googlers = new Googler[numberOfGooglers];
        for (int count = 0; count < numberOfGooglers; count++) {
            googlers[count] = new Googler(googlerTotals[count]);
        }
        int finalOut = 0;
        for (int count = 0; count < googlers.length; count++) {
            if (googlers[count].canBeTotal) {

                if (!googlers[count].requiresStrange) {
                    finalOut++;
                } else if (surprisingGooglers > 0) {
                    finalOut++;
                    surprisingGooglers--;
                }


            }
        }
        System.out.println("Case #" + problemNumber + ": " + finalOut);

    }


    static class Googler {
        private int total;
        private boolean canBeTotal;
        private boolean requiresStrange;
        private boolean countMe;

        public Googler(int total) {
            this.total = total;
            canBeAtLeast();
            //System.out.println(total + " " + canBeTotal + " " + atLeast + " " + requiresStrange);
        }

        private void canBeAtLeast() {

            if (total % 3 == 0) {
                int eachSide = total / 3;
                if (eachSide >= atLeast) {
                    canBeTotal = true;

                } else if (eachSide + 1 >= atLeast) {
                    canBeTotal = true;
                    requiresStrange = true;
                }
            } else if (total % 3 == 1) {
                int doubleLong = (int) Math.ceil(total / 3f);
                if (doubleLong >= atLeast) {
                    canBeTotal = true;
                }
            } else if (total % 3 == 2) {
                int doubleLong = (int) Math.ceil(total / 3f);
                if (doubleLong >= atLeast) {
                    canBeTotal = true;
                } else if (total - doubleLong * 2 + 2 >= atLeast) {
                    canBeTotal = true;
                    requiresStrange = true;
                }
            }
            if (total < 2) {
                requiresStrange = false;
                if (total < atLeast) {
                    canBeTotal = false;
                }
            }
        }


    }

}
