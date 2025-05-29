package qualifiers12.b;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Dancing {

    public static Set<Triple>[] combs;

    public static class Triple {
	protected final int total;
	protected final int v1;
	protected final int v2;
	protected final int v3;

	public Triple(int total, int v1, int v2, int v3) {
	    this.total = total;
	    this.v1 = v1;
	    this.v2 = v2;
	    this.v3 = v3;
	}

	public int getMax() {
	    return max2(max2(v1, v2), v3);
	}

	private int max2(int n1, int n2) {
	    return (n1 > n2) ? n1 : n2;
	}

	public int getTotal() {
	    return v1 + v2 + v3;
	}

	public boolean isTriplet() {
	    if (v1 < 0 || v2 < 0 || v3 < 0) {
		return false;
	    }
	    if (Math.abs(v1 - v2) > 2 || Math.abs(v1 - v3) > 2 || Math.abs(v2 - v3) > 2) {
		return false;
	    }
	    return v1 + v2 + v3 == total;
	}

	public boolean isSurprising() {
	    return Math.abs(v1 - v2) == 2 || Math.abs(v1 - v3) == 2 || Math.abs(v2 - v3) == 2;
	}

	@Override
	public String toString() {
	    return total + "(" + v1 + "," + v2 + "," + v3 + ")";
	}

	@Override
	public int hashCode() {
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(v1);
	    list.add(v2);
	    list.add(v3);
	    Collections.sort(list);
	    return list.get(0) * 100 + list.get(1) * 10 + list.get(2);
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj instanceof Triple) {
		Triple that = (Triple) obj;
		if ((this.v1 == that.v1 || this.v1 == that.v2 || this.v1 == that.v3)
			&& (this.v2 == that.v1 || this.v2 == that.v2 || this.v2 == that.v3)
			&& (this.v3 == that.v1 || this.v3 == that.v2 || this.v3 == that.v3)) {
		    return true;
		} else {
		    return false;
		}
	    } else {
		return false;
	    }
	}
    }

    public static void computeCombination(int k, int total) {
	int avgPart = Math.round((total + 0.0f) / 3.0f);
	for (int i = -1; i < 2; i++) {
	    computeCombinationGiven(k, total, avgPart + i);
	}
    }

    private static void computeCombinationGiven(int k, int total, int part) {
	int missing = total - part;
	int avgPart = Math.round((missing + 0.0f) / 2.0f);

	for (int i = -1; i < 2; i++) {
	    computeWithOne(k, total, part, avgPart + i, avgPart);
	}
    }

    private static void computeWithOne(int k, int total, int part1, int part2, int lastAvg) {
	for (int i = -1; i < 2; i++) {
	    Triple triple = new Triple(total, part1, part2, lastAvg + i);
	    if (triple.isTriplet()) {
		combs[k].add(triple);
	    }
	}
    }

    public static void main(String[] args) throws IOException {

	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	String s = in.readLine();

	int cases = Integer.parseInt(s);

	for (int i = 0; i < cases; i++) {
	    s = in.readLine();
	    StringTokenizer tokenizer = new StringTokenizer(s, " ");

	    int[] totals = new int[Integer.parseInt(tokenizer.nextToken())];
	    combs = new Set[totals.length];
	    for (int k = 0; k < combs.length; k++) {
		combs[k] = new HashSet<Triple>();
	    }
	    int surprising = Integer.parseInt(tokenizer.nextToken());
	    int p = Integer.parseInt(tokenizer.nextToken());

	    int k = 0;
	    while (tokenizer.hasMoreTokens()) {
		totals[k] = Integer.parseInt(tokenizer.nextToken());
		computeCombination(k, totals[k]);
		k++;
	    }

	    // for (k = 0; k < combs.length; k++) {
	    //
	    // String tmp = "";
	    // for (Triple triple : combs[k]) {
	    // tmp += triple.toString() + " ";
	    // }
	    // System.out.println(tmp);
	    //
	    // }

	    int usedSurprising = 0;
	    for (k = 0; k < combs.length; k++) {

		if (containsSurprisingSequence(combs[k])) {
		    Triple triple = containsNonSurprisingAboveOrEqualP(combs[k], p);
		    if (triple != null) {
			combs[k].clear();
			combs[k].add(triple);
		    } else if (usedSurprising < surprising) {
			triple = containsSurprisingAboveOrEqualP(combs[k], p);
			if (triple != null) {
			    combs[k].clear();
			    combs[k].add(triple);
			    usedSurprising++;
			}
		    } else {
			Iterator<Triple> iter = combs[k].iterator();
			while (iter.hasNext()) {
			    triple = iter.next();
			    if (triple.isSurprising()) {
				continue;
			    }
			    combs[k].clear();
			    combs[k].add(triple);
			    break;
			}
		    }
		} else {
		    // choose one above P, otherwise random one
		    Triple triple = containsNonSurprisingAboveOrEqualP(combs[k], p);
		    if (triple != null) {
			combs[k].clear();
			combs[k].add(triple);
		    } else {
			Iterator<Triple> iter = combs[k].iterator();
			while (iter.hasNext()) {
			    triple = iter.next();
			    if (triple.isSurprising()) {
				continue;
			    }
			    combs[k].clear();
			    combs[k].add(triple);
			    break;
			}
		    }
		}
	    }

	    int res = 0;
	    for (k = 0; k < combs.length; k++) {
		for (Triple triple : combs[k]) {
		    if (triple.getMax() >= p) {
			res++;
		    }
		}
	    }

	    String result = "Case #" + (i + 1) + ": " + res;
	    System.out.println(result);
	}

    }

    private static boolean containsSurprisingSequence(Set<Triple> triples) {
	for (Triple triple : triples) {
	    if (triple.isSurprising()) {
		return true;
	    }
	}
	return false;
    }

    private static Triple containsSurprisingAboveOrEqualP(Set<Triple> triples, int p) {
	for (Triple triple : triples) {
	    if (triple.isSurprising()) {
		if (triple.getMax() >= p) {
		    return triple;
		}
	    }
	}
	return null;
    }

    private static Triple containsNonSurprisingAboveOrEqualP(Set<Triple> triples, int p) {
	for (Triple triple : triples) {
	    if (!triple.isSurprising()) {
		if (triple.getMax() >= p) {
		    return triple;
		}
	    }
	}
	return null;
    }
}
