/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

/**
 *
 * @author vandit
 */
public class Pair {

    private String number1;
    private String number2;

    public Pair(String no1, String no2) {
        number1 = no1;
        number2 = no2;
    }

    @Override
    public boolean equals(Object temp1) {
        boolean ans = false;
        Pair temp = (Pair) temp1;
        if (temp.number1.equals(number1)) {
            if (temp.number2.equals(number2)) {
                ans = true;
            }
        } else if (temp.number1.equals(number2)) {
            if (temp.number2.equals(number1)) {
                ans = true;
            }

        }
        return ans;
    }
@Override
    public int hashCode() {
        return number1.length() + number2.length();
    }
}
