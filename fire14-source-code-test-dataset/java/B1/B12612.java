package util.graph;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class DynDjikstra {
    public static State FindShortest(Node start, Node target) {
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        Set<Node> closedSet = new HashSet<>();
        openSet.add(start);
        while (!openSet.isEmpty()) {
            Node current = openSet.poll();
            for (Edge edge : current.edges) {
                Node end = edge.target;
                if (closedSet.contains(end)) {
                    continue;
                }
                State newState = edge.travel(current.last);
                //if (end.equals(target)) {
                    //return newState;
                //}
                if (openSet.contains(end)) {
                    if (end.last.compareTo(newState)>0) {
                        end.last = newState;
                    }
                } else {
                    openSet.add(end);
                    end.last = newState;
                }
            }
            closedSet.add(current);
            if (closedSet.contains(target)) {
                return target.last;
            }
        }

        return target.last;
    }
}
