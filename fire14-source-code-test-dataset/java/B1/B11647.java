package com.codejam.two12.RecyledNumbers;

public class Pair {
  private int a, b;
  
  public Pair(int a, int b){
    this.a = a;
    this.b = b;
  }

  /** {@inheritDoc}*/
  @Override
  public String toString() {
    return "(" + a + ", " + b + ")";
  }

  /** {@inheritDoc}*/
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + a;
    result = prime * result + b;
    return result;
  }

  /** {@inheritDoc}*/
  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    Pair other = (Pair) obj;
    if (a != other.a) return false;
    if (b != other.b) return false;
    return true;
  }
  
  
  
}
