
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JY
 */
public class ProblemD {

    private static int testNum;
    private static int[][] data;
    private static char[][][] map;
    private static HashSet<Double> k0;//<<
    private static HashSet<Double> k1;//<>
    private static HashSet<Double> k2;//><
    private static HashSet<Double> k3;//>>

    public static void main(String[] args) {
        input();
        int[] result = calc();
        output(testNum, result);
    }

    private static void input() {
        Scanner in = null;
        in = new Scanner(System.in);
        testNum = Integer.parseInt(in.nextLine());
        data = new int[testNum][];
        map = new char[testNum][][];
        for (int i = 0; i < testNum; i++) {
            String line = in.nextLine();
            String[] nums = line.split(" ");
            data[i] = new int[3];
            data[i][0] = Integer.parseInt(nums[0]);
            data[i][1] = Integer.parseInt(nums[1]);
            data[i][2] = Integer.parseInt(nums[2]);
            map[i] = new char[data[i][0]][];
            for (int j = 0; j < data[i][0]; j++) {
                line = in.nextLine();
                map[i][j] = line.toCharArray();
            }
        }
    }

    private static int[] calc() {
        int[] res = new int[testNum];
        for (int i = 0; i < testNum; i++) {
            int result = 0;
            int h = data[i][0];
            int w = data[i][1];
            int d = data[i][2];
            char[][] currentMap = map[i];
            int posX = 0;
            int posY = 0;
            for (int row = 0; row < h; row++) {
                for (int col = 0; col < w; col++) {
                    if (currentMap[row][col] == 'X') {
                        posY = row;
                        posX = col;
                    } else {
                        //for # in large case
                    }
                }
            }

            //for integer distance
            int H = (h - 2) * 2;
            int W = (w - 2) * 2;
            int D = d * 2;
            posX = posX * 2 - 1;
            posY = posY * 2 - 1;

            result = calSmall(H, W, D, posX, posY);
            res[i] = result;
        }
        return res;
    }

    private static int calSmall(int h, int w, int d, int posX, int posY) {
        int res = 0;
        //2iW+-x 2jH+-y
        int imin = -d / 2 / w;
        int imax = (d + 2 * posX) / 2 / w;
        int jmin = -d / 2 / h;
        int jmax = (d + 2 * posY) / 2 / h;
        int ds = d * d;
        k0 = new HashSet<Double>();//<<
        k1 = new HashSet<Double>();//<>
        k2 = new HashSet<Double>();//><
        k3 = new HashSet<Double>();//>>
        HashSet<Double> ktmp;
        int x, y;
        for (int i = imin; i <= imax; i++) {
            for (int j = jmin; j <= jmax; j++) {
                x = 2 * i * w - posX;
                y = 2 * j * h - posY;
                if (disquared(x, y, posX, posY) <= ds) {
                    double ki = k(x, y, posX, posY);
                    ktmp = kref(x, y, posX, posY);
                    if (!ktmp.contains(ki)) {
                        res++;
                        ktmp.add(ki);
                    }
                }
                x = 2 * i * w - posX;
                y = 2 * j * h + posY;
                if (disquared(x, y, posX, posY) <= ds) {
                    double ki = k(x, y, posX, posY);
                    ktmp = kref(x, y, posX, posY);
                    if (!ktmp.contains(ki)) {
                        res++;
                        ktmp.add(ki);
                    }
                }
                x = 2 * i * w + posX;
                y = 2 * j * h - posY;
                if (disquared(x, y, posX, posY) <= ds) {
                    double ki = k(x, y, posX, posY);
                    ktmp = kref(x, y, posX, posY);
                    if (!ktmp.contains(ki)) {
                        res++;
                        ktmp.add(ki);
                    }
                }
                x = 2 * i * w + posX;
                y = 2 * j * h + posY;
                if (disquared(x, y, posX, posY) <= ds) {
                    double ki = k(x, y, posX, posY);
                    ktmp = kref(x, y, posX, posY);
                    if (!ktmp.contains(ki)) {
                        if (i != 0 || j != 0) {
                            res++;
                            ktmp.add(ki);
                        }
                    }
                }
            }
        }
        return res;
    }

    private static int calLarge(char[][] map, int d) {//TODO
        int res = 0;


        return res;
    }

    private static int disquared(int p1x, int p1y, int p2x, int p2y) {
        int x = p1x > p2x ? p1x - p2x : p2x - p1x;
        int y = p1y > p2y ? p1y - p2y : p2y - p1y;
        return x * x + y * y;
    }

    private static double k(int p1x, int p1y, int p2x, int p2y) {
        if (p1x == p2x) {
            return Double.MAX_VALUE;
        }
        return 1.0 * (p2y - p1y) / (p2x - p1x);
    }

    private static HashSet<Double> kref(int x, int y, int posX, int posY) {
        if (x > posX) {
            if (y > posY) {//>>
                return k3;
            } else {//><
                return k2;
            }
        } else {//x<posX
            if (y > posY) {//<>
                return k1;
            } else {
                return k0;
            }
        }
    }

    private static void output(int testNum, int[] res) {
        for (int i = 0; i < testNum; i++) {
            System.out.printf("Case #%d: %s\n", i + 1, res[i]);
        }
    }

    private static void draw(char[][] map) {
        int h = map.length;
        int w = map[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
