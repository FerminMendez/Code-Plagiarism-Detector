import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class main {

    public static void main(String[] args) {
        // inputファイルを読み込み
        BufferedReader bufferReader = null;
        String str = "";
        try {
            bufferReader = new BufferedReader(new InputStreamReader(
                    new FileInputStream("/Users/yago/Documents/in.txt"),
                    "UTF-8"));
            // 一行ずつ読み込み
            int probs = 0;
            while ((str = bufferReader.readLine()) != null) {
                if (str.length() > 3) {
                    probs++;
                    calc(str, probs);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (bufferReader != null) {
                    bufferReader.close();
                }
            } catch (Exception e) {
            }
        }
    }

    private static void calc(String str, int probNum) {
        Integer n, s, p, Ti, ansCnt = 0;
        String[] strAry = str.split(" ");
        n = Integer.valueOf(strAry[0]);
        s = Integer.valueOf(strAry[1]);
        p = Integer.valueOf(strAry[2]);

        for (int i = 0; i < n; i++) {// 各ダンサーについて
            Ti = Integer.valueOf(strAry[3 + i]);
            if (Ti >= 3 * p - 2 && 3 * p - 2 > 0) {// p + (p - 1) * 2
                ansCnt++;
//                System.out.println("A" + " " + strAry[3 + i]);
            } else if (s != 0 && Ti >= 3 * p - 4 && 3 * p - 4 > 0) {// p + (p - 2) * 2
                ansCnt++;
                s--;
//                System.out.println("B" + " " + strAry[3 + i]);
            }
        }

        System.out.println("Case #" + probNum + ": " + ansCnt);
    }
}