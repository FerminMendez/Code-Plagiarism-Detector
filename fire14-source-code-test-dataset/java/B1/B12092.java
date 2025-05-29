package qr2;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: shtratos
 * Date: 14/04/12
 * Time: 03:39
 */
public class DancingNumbers {

    public static void main(String[] args) {
        DancingNumbers dn = new DancingNumbers();

        //tp.printMapping();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            int numOfTests = Integer.valueOf(br.readLine());
            for (int i = 0; i < numOfTests; i++) {
                System.out.println("Case #" + (i + 1) + ": " + dn.getDistinct(br.readLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Test
    public void testExamples() {
        DancingNumbers dn = new DancingNumbers();

        assertEquals(0, dn.getDistinct("1 9"));
        assertEquals(3, dn.getDistinct("10 40"));
        assertEquals(156, dn.getDistinct("100 500"));
        assertEquals(287, dn.getDistinct("1111 2222"));
    }

    private int getDistinct(String s) {
        String[] parts = s.split(" ");
        int start = Integer.parseInt(parts[0]);
        int end = Integer.parseInt(parts[1]);
        HashSet<String> pairs = new HashSet<String>();
        for (int m = start + 1; m <= end; m++) {
            for (int n = start; n < m; n++) {
                String recycle = recycle(n, m);
                if (recycle != null) {
                    pairs.add(recycle);
                }
            }
        }
        return pairs.size();
    }

    private String recycle(int n, int m) {
        String ns = String.valueOf(n);
        String ms = String.valueOf(m);
        if (ms.length() != ns.length()) return null;
        if ((ns + ns).contains(ms)) {
            return n + " " + m;
        } else {
            return null;
        }
    }
}
