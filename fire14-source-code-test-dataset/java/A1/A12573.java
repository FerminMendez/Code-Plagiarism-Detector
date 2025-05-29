package util.graph;

public abstract class Edge implements Cloneable{
    public abstract State travel(State current);
    public Node target;
    public void connect(Node start, Node end) {
        try {
            Edge clone = (Edge) this.clone();
            start.edges.add(clone);
            clone.target=end;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public void biConnect(Node n1, Node n2) {
        connect(n1,n2);
        connect(n2,n1);
    }
}
