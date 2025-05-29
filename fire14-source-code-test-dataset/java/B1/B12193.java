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

        List<Integer> integers = new ArrayList<>();
        int a = Integer.parseInt(cin.nextLine());
        int[] begin = new int[a];
        int[] end = new int[a];

        int value, value2, count;
        boolean aux;
        String number;
        for (int i = 0; i < a; i++) {
            integers.clear();
            count = 0;
            begin[i] = cin.nextInt();
            end[i] = cin.nextInt();
            for (int j = begin[i]; j <= end[i]; j++) {



                if (j >= 10) {
                    if (j < 100) {
                        number = j + "";
                        value = Integer.parseInt(number.charAt(1) + "" + number.charAt(0));
                        aux = true;
                        for (Integer ii : integers) {
                            if (ii.intValue() == value) {
                                aux = false;
                                break;
                            }
                        }
                        if (aux && value != j && number.charAt(1) != '0' && begin[i] <= value && value <= end[i]) {
                            integers.add(j);
                            count++;
                        }
                    } else if (j <= 1000) {
                        number = j + "";
                        value = Integer.parseInt(number.charAt(2) + "" + number.charAt(0) + "" + number.charAt(1));
                        value2 = Integer.parseInt(number.charAt(1) + "" + number.charAt(2) + "" + number.charAt(0));
                        aux = true;
                        for (Integer ii : integers) {
                            if (ii.intValue() == value) {
                                aux = false;
                                break;
                            }
                        }
                            
                        if (aux && value != j && 100 <= value && begin[i] <= value && value <= end[i]) {
                            integers.add(j);
                           count++;
                        }
                          
                        aux = true;
                        for (Integer ii : integers) {
                            if (ii.intValue() == value2) {
                                aux = false;
                                break;
                            }
                        }
                        if (aux && value2 != j && 100 <= value2 && begin[i] <= value2 && value2 <= end[i]) {
                            integers.add(j);
                            count++;
                        }
                    }

                }
            }


            System.out.println("Case #"+(i+1)+":"+count);
        }




    }
}