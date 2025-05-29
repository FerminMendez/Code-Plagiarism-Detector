import java.util.*;

/**
 *
 * @author Jhon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt();
        int dancers, surp, p, sum;
        float aa;
        List<Integer> dancerL = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            sum = 0;
            dancerL.clear();
            dancers = Integer.parseInt(cin.next());
            surp = Integer.parseInt(cin.next());
            p = Integer.parseInt(cin.next());
            for (int j = 0; j < dancers; j++) {
                dancerL.add(Integer.parseInt(cin.next()));
            }
            for (Integer ii : dancerL) {
                aa = (float) ii / 3;
                if (p == 0) {
                    sum++;
                } else if((int) (ii / 3)!= 0){
                    if (aa == (int) (ii / 3)) {
                        if (p <= (int) (ii / 3)) {
                            sum++;
                        } else {
                            if (p == ((int) (ii / 3) + 1)) {
                                if (surp > 0) {
                                    surp--;
                                    sum++;
                                }
                            }
                        }
                    } else if (aa >= ((int) ii / 3) + 0.5) {
                        if (p <= (int) (ii / 3)) {
                            sum++;
                        } else {
                            if (p == ((int) (ii / 3) + 1)) {
                                sum++;
                            } else if (p == ((int) (ii / 3) + 2)) {
                                if (surp > 0) {
                                    surp--;
                                    sum++;
                                }
                            }
                        }
                    } else {
                        if (p <= (int) (ii / 3)) {
                            sum++;
                        } else {
                            if (p == ((int) (ii / 3) + 1)) {
                                sum++;

                            }
                        }

                    }
                }

            }
            System.out.println("Case #" + (i + 1) + ": " + sum);

        }




    }
}
