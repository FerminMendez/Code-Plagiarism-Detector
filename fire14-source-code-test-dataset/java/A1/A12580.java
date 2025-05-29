import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.IOException;
import java.util.List;

public class WaterSheds extends JamProblem {

    public static void main(String[] args) throws IOException {
        WaterSheds p = new WaterSheds();
        p.go();
    }

    Character[][] res;
    WSCase cs;
    char curr;

    @Override
    String solveCase(JamCase jamCase) {
        cs = (WSCase) jamCase;
        curr = 'a';
        res = new Character[cs.h][cs.w];
        for (int y = 0; y < cs.h; y++) {
            for (int x = 0; x < cs.w; x++) {
                res[y][x] = ' ';
            }
        }
        for (int y = 0; y < cs.h; y++) {
            for (int x = 0; x < cs.w; x++) {
                res[y][x] = update(y, x);
            }
        }
        return "\n" + JamUtil.printTable(res);  //To change body of implemented methods use File | Settings | File Templates.
    }

    private char update(int y, int x) {
        if (res[y][x] != ' ') {
            return res[y][x];
        }
        int min = cs.table[y][x];
        int dir = -1;
        if (y > 0) {
            int curr = cs.table[y - 1][x];
            if (curr < min) {
                min = curr;
                dir = 0;
            }
        }
        if (x > 0) {
            int curr = cs.table[y][x - 1];
            if (curr < min) {
                min = curr;
                dir = 1;
            }
        }
        if (x < cs.w - 1) {
            int curr = cs.table[y][x + 1];
            if (curr < min) {
                min = curr;
                dir = 2;
            }
        }
        if (y < cs.h - 1) {
            int curr = cs.table[y + 1][x];
            if (curr < min) {
                min = curr;
                dir = 3;
            }
        }
        if (dir == -1) {
            return res[y][x] = curr++;
        } else {
            switch (dir) {
                case 0:
                    return res[y][x] = update(y - 1, x);
                case 1:
                    return res[y][x] = update(y, x - 1);
                case 2:
                    return res[y][x] = update(y, x + 1);
                case 3:
                    return res[y][x] = update(y + 1, x);
                default:
                    throw new RuntimeException();
            }
        }
    }

    @Override
    JamCase parseCase(List<String> file, int line) {
        int i = line;
        String firstLine = file.get(i++);
        int[] pair = JamUtil.parseIntList(firstLine, 2);
        WSCase cas = new WSCase();
        cas.h = pair[0];
        cas.w = pair[1];
        cas.lineCount = cas.h + 1;
        cas.table = new int[cas.h][];
        for (int ih = 0; ih < cas.h; ih++) {
            cas.table[ih] = JamUtil.parseIntList(file.get(i++), cas.w);
        }
        return cas;
    }
}

class WSCase extends JamCase {
    int w, h;
    int[][] table;
}
