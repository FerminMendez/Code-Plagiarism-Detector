/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

public class CodeJam {

    public ReadWriteTextFile rw = new ReadWriteTextFile();

    public int countDigits(int number) {
        int numberOfDigits = 0;
        while (number > 0) {
            number = number / 10;

            numberOfDigits++;
        }
        return numberOfDigits;
    }

    public int multiplyIndex(int count) {
        int multiplyIndex = 1;
        for (int i = 1;i < count;i++) {
            multiplyIndex *= 10;
        }

        return multiplyIndex;
    }

    public boolean isRecycled(int firstNumber, int secondNumber) {
        int firstLength = countDigits(firstNumber);
        int secondLength = countDigits(secondNumber);

        if (firstLength != secondLength) {
            return false;
        }

        int multiplyingIndex = multiplyIndex(firstLength);

        for (int i = 1; i < firstLength; i++) {
            secondNumber = secondNumber / 10 + (secondNumber % 10) * multiplyingIndex;

            if (firstNumber == secondNumber) {
              
                return true;
            }


        }

        return false;
    }

    public static void main(String[] args) {
        CodeJam codeJam = new CodeJam();

        int sampleSize = codeJam.rw.readIntLine();


        for (int i = 0; i < sampleSize; i++) {
            int c = 0;
            int firstNumber = codeJam.rw.readInt();
            int secondNumber = codeJam.rw.readInt();
            int recycledNumberCount = 0;
            for (; firstNumber < secondNumber; firstNumber++) {
                int currentFirstPair = firstNumber;
                for (int j = 1; currentFirstPair + j <= secondNumber; j++) {
                    if (codeJam.isRecycled(currentFirstPair, currentFirstPair + j))
                            recycledNumberCount++;
                }


            }
            codeJam.rw.writeNextLine(recycledNumberCount);
        }
        codeJam.rw.close();
    }
}
