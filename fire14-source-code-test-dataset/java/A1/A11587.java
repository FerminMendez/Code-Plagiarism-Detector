package ru.sidorkevich.google.jam.qualification.b;

import java.util.List;

public class Task {
    int n;
    int s;
    int p;
    List<Integer> t;

    public Task(int n, int s, int p, List<Integer> t) {
        this.n = n;
        this.s = s;
        this.p = p;
        this.t = t;
    }

    public int getN() {
        return n;
    }

    public int getS() {
        return s;
    }

    public int getP() {
        return p;
    }

    public List<Integer> getT() {
        return t;
    }

    @Override
    public String toString() {
        return "Task{" +
                "n=" + n +
                ", s=" + s +
                ", p=" + p +
                ", t=" + t +
                '}';
    }
}
