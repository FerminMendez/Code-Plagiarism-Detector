import com.sun.org.apache.xerces.internal.impl.xs.opti.DefaultXMLDocumentHandler;
import util.graph.DynDjikstra;
import util.graph.Edge;
import util.graph.Node;
import util.graph.State;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class CrossingRoad extends JamProblem {

    public static void main(String[] args) throws IOException {
        CrossingRoad p = new CrossingRoad();
        p.go();
    }
    @Override
    String solveCase(JamCase jamCase) {
        CrossCase ca = (CrossCase) jamCase;
        CrossState crossState = new CrossState();
        crossState.time = 0;
        ca.startNode.last = crossState;
        CrossState state = (CrossState) DynDjikstra.FindShortest(ca.startNode, ca.stopNode);


        return "" + state.time;
    }

    @Override
    JamCase parseCase(List<String> file, int line) {
        String first = file.get(line++);
        int[] size = JamUtil.parseIntList(first, 2);
        CrossCase ca = new CrossCase();
        ca.n = size[0];
        ca.m = size[1];
        ca.lineCount = ca.n + 1;
        ca.map = new Crossing[ca.n][ca.m];
        Node[][][][] nodes = new Node[ca.n][ca.m][2][2];
        Node start = null;
        Node end = null;
        for (int y = 0; y < ca.n; y++) {
            String row = file.get(line++);
            int[] data = JamUtil.parseIntList(row, 3 * ca.m);
            for (int x = 0; x < ca.m; x++) {
                Crossing cr = new Crossing();
                ca.map[y][x] = cr;
                cr.minTime = Integer.MAX_VALUE;
                cr.s = data[3*x];
                cr.w = data[3*x+1];
                cr.t = data[3*x+2];
                cr.x = x;
                cr.y = y;
                Node ne = new CrossNode();

                Node se = new CrossNode();
                Node sw = new CrossNode();
                Node nw = new CrossNode();
                CrossStreetSNEdge snEdge1 = new CrossStreetSNEdge();
                snEdge1.s =cr.s;
                snEdge1.w = cr.w;
                snEdge1.t = cr.t;
                CrossStreetWEEdge weEdge = new CrossStreetWEEdge();
                weEdge.s= cr.s;
                weEdge.w=cr.w;
                weEdge.t=cr.t;

                snEdge1.biConnect(ne,se);
                snEdge1.biConnect(nw,sw);
                weEdge.biConnect(ne,nw);
                weEdge.biConnect(se,sw);

                Node[][] pack = nodes[y][x];
                pack[0][0] = nw;
                pack[0][1] = ne;
                pack[1][1] = se;
                pack[1][0] = sw;
                ((CrossNode)nw).label = "y " + y + " x " + x + " nw";
                ((CrossNode)ne).label = "y " + y + " x " + x + " ne";
                ((CrossNode)se).label = "y " + y + " x " + x + " se";
                ((CrossNode)sw).label = "y " + y + " x " + x + " sw";
                if (y==0 && x ==ca.m-1) {
                    ca.stopNode = pack[0][1];
                }

                if (y==ca.n-1 && x == 0) {
                    ca.startNode = pack[1][0];
                }

                if (y>0) {
                    CrossBlockEdge b1 = new CrossBlockEdge();
                    b1.biConnect(nodes[y][x][0][1],nodes[y-1][x][1][1]);
                    b1.biConnect(nodes[y][x][0][0],nodes[y-1][x][1][0]);
                }

                if (x>0) {
                    CrossBlockEdge b1 = new CrossBlockEdge();
                    b1.biConnect(nodes[y][x][0][0], nodes[y][x - 1][0][1]);
                    b1.biConnect(nodes[y][x][1][0],nodes[y][x-1][1][1]);
                }
            }
        }
        return ca;
    }
}

class CrossCase extends JamCase {
    int n, m;
    Crossing[][] map;
    public Node startNode;
    public Node stopNode;
}

class Crossing implements Comparable<Crossing>{
    int s, w, t, minTime,x,y;

    @Override
    public int compareTo(Crossing o) {
        return Integer.compare(minTime,o.minTime);
    }
}

class CrossState extends State {

    long time;
    @Override
    public int compareTo(Object o) {
        return Long.compare(time,((CrossState)o).time);
    }
}

class CrossBlockEdge extends Edge {
    @Override
    public State travel(State current) {
        CrossState old = (CrossState) current;
        CrossState newS = new CrossState();
        newS.time = old.time + 2;
        return newS;
    }
}

class CrossStreetSNEdge extends Edge {
    long s,w,t;
    @Override
    public State travel(State current) {
        CrossState old = (CrossState) current;
        CrossState newS = new CrossState();
        long adjusted = old.time - t;
        long period = s + w;
        long inCycle = adjusted % period;
        if (inCycle < s) {
            newS.time = old.time + 1;
            return newS;
        }
        newS.time = old.time + (period-inCycle);
        return newS;
    }
}

class CrossStreetWEEdge extends Edge {
    long s,w,t;
    @Override
    public State travel(State current) {
        CrossState old = (CrossState) current;
        CrossState newS = new CrossState();
        long adjusted = old.time - t;
        long period = s + w;
        long inCycle = adjusted % period;
        if (inCycle >= s) {
            newS.time = old.time + 1;
            return newS;
        }
        newS.time = old.time + (s-inCycle);
        return newS;
    }
}

class CrossNode extends Node {
    String label;
    CrossNode() {
        last = new CrossState();
    }

    @Override
    public String toString() {
        return label;
    }
}
