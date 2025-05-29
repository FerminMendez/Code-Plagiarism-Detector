package util.graph;

import java.util.HashSet;
import java.util.Set;

public class Node implements Comparable<Node>{
    public static int seq = 0;
    public int id = (seq++);
    public Set<Edge> edges = new HashSet<>();
    public State last;

    @Override
    public int compareTo(Node o) {

        return last.compareTo(o.last);
    }

    @Override
    public boolean equals(Object obj) {
        return id == ((Node) obj).id;
    }

    @Override
    public int hashCode() {
        return Integer.valueOf(id).hashCode();
    }
}
