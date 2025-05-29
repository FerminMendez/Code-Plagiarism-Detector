import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpeakingTongues extends JamProblem {


    Map<Character, Character> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        SpeakingTongues p = new SpeakingTongues();
        p.prepare();
        p.go();
    }


    void prepare() {
        map.put('y', 'a');
        map.put('e', 'o');
        map.put('q', 'z');

        String[] from = new String[3];
        String[] to = new String[3];

        to[0] = "ejp mysljylc kd kxveddknmc re jsicpdrysi";
        to[1] = "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd";
        to[2] = "de kr kd eoya kw aej tysr re ujdr lkgc jv";
        from[0] = "our language is impossible to understand";
        from[1] = "there are twenty six factorial possibilities";
        from[2] = "so it is okay if you want to just give up";
        for (int i = 0; i < to.length; i++) {
            char[] t = to[i].toCharArray();
            char[] f = from[i].toCharArray();
            for (int j = 0; j < f.length; j++) {
                char fc = f[j];
                char tc = t[j];
                map.put(tc, fc);
            }
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (map.containsKey(c)) {
                continue;
            }

            for (char c2 = 'a'; c2 <= 'z'; c2++) {
                if (map.containsValue(c2)) {
                    continue;
                }
                map.put(c,c2);
            }

        }

    }


    @Override
    String solveCase(JamCase jamCase) {
        StringBuilder b = new StringBuilder();
        STCase ca = (STCase) jamCase;
        char[] chars = ca.str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            b.append(map.get(c));

        }
        return b.toString();
    }

    @Override
    JamCase parseCase(List<String> file, int line) {
        STCase ca = new STCase();
        ca.lineCount = 1;
        ca.str = file.get(line);
        return ca;
    }
}

class STCase extends JamCase {
    String str;
}