package prob2;

import com.bertramtruong.utils.BT;
import com.bertramtruong.utils.DataReader;

/**
 *
 * @author Bertram
 */
public class Prob2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataReader dr = new DataReader("input.in");

        try {
            int nLines = dr.readInt();
            for (int i = 0; i < nLines; i++) {
                //BT.db("==================== case ", (i + 1), " =================");
                System.out.print("Case #" + (i + 1) + ": ");
                int nGooglers = dr.readInt();
                int nSurprising = dr.readInt();
                int bestRes = dr.readInt();

                //BT.db("nGooglers: ", nGooglers);
                //BT.db("nSurprising: ", nSurprising);
                //BT.db("bestRes: ", bestRes);

                int np = 0;
                for (int j = 0; j < nGooglers; j++) {
                    // triplets, take a number divide by 3,
                    int totalScore = dr.readInt();
                    int triplet = totalScore / 3;
                    if (triplet >= bestRes) {
                        //BT.db("bestres: ", triplet);
                        np++;
                    } else {
                        /**
                         * double remaindar = triplet % 3; // can we do it with
                         * 1? if (triplet + 1 >= bestRes) { if (remaindar == 0
                         * && nSurprising == 0) { } else { nSurprising--; np++;
                         * } }
                         *
                         * if (triplet + 2 >= bestRes) { BT.db("triplet: ",
                         * triplet); // can you do it with 1? if (triplet + 1 >=
                         * bestRes) { // good np++; } else { if (nSurprising >
                         * 0) { //BT.db("after: ", triplet + 2); nSurprising--;
                         * triplet += 2; } } }
                         *
                         * if (triplet >= bestRes) { np++; }
                         */
                        int rem = totalScore % 3;
                        if (triplet + 1 >= bestRes && rem >= 1) {
                            np++;
                        } else {
                            if (totalScore != 0) {
                                switch (rem) {
                                    case 0:
                                        if (nSurprising > 0 && triplet + 1 >= bestRes) {
                                            triplet++;
                                            nSurprising--;
                                        }
                                        break;
                                    case 1:
                                        triplet++;
                                        break;
                                    case 2:
                                        if (nSurprising > 0 && triplet + 2 >= bestRes) {
                                            triplet += 2;
                                            nSurprising--;
                                        }
                                        break;
                                }

                                if (triplet >= bestRes) {
                                    np++;
                                }
                            }
                        }
                    }
                }
                System.out.print(np);
                System.out.println();
            }
        } catch (Exception x) {
        }
    }
}
