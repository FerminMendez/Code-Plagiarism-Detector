package de.pat.dev.y2012.qualification.c;

import java.util.*;

/**
 * @author pat.dev@alice.de
 */
public class RecycledNumber {
  private final long lower;
  private final long upper;
  private final long rotationFactor;

  public RecycledNumber(long lower, long upper) {
    this.lower = lower;
    this.upper = upper;
    int numberOfDigits = String.valueOf(lower).length();
    rotationFactor = rotationFactor(numberOfDigits);
  }

  private long rotationFactor(int numberOfDigits) {
    long factor = 1;
    for (int i = 1; i < numberOfDigits; i++) {
      factor *= 10;
    }
    return factor;
  }

  public Set<Pair> pairs() {
    Set<Pair> pairs = new HashSet<Pair>();
    for (long number = lower; number <= upper; number++) {
      Set<Long> rotations = rotations(number);
      for (Long rotation : rotations) {
        pairs.add(new Pair(number, rotation));
      }
    }
    return pairs;
  }

  public Set<Long> rotations(long number) {
    if (rotationFactor == 1) {
      return Collections.emptySet();
    }

    Set<Long> rotations = new HashSet<Long>();
    long rotation = rotate(number);
    while (rotation != number) {
      if (rotation > number && rotation <= upper) {
        rotations.add(rotation);
      }
      rotation = rotate(rotation);
    }
    return rotations;
  }

  private long rotate(long number) {
    long lastDigit = number % 10;
    return number / 10 + lastDigit * this.rotationFactor;
  }

  public static final class Pair {
    public final long m;
    public final long n;

    public Pair(long m, long n) {
      this.m = m;
      this.n = n;
    }

    @Override
    public String toString() {
      return "Pair{" +
        "m=" + m +
        ", n=" + n +
        '}';
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Pair)) return false;

      Pair pair = (Pair) o;

      if (m != pair.m) return false;
      if (n != pair.n) return false;

      return true;
    }

    @Override
    public int hashCode() {
      int result = (int) (m ^ (m >>> 32));
      result = 31 * result + (int) (n ^ (n >>> 32));
      return result;
    }
  }
}
