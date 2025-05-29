package com.google.cj;

public class Entry {
	public String n;
	public String m;
	
	public Entry() {
		// TODO Auto-generated constructor stub
	}

	public Entry(String n, String m) {
		super();
		this.n = n;
		this.m = m;
	}

	
	@Override
	public String toString() {
		return "Entry [n=" + n + ", m=" + m + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((m == null) ? 0 : m.hashCode());
		result = prime * result + ((n == null) ? 0 : n.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entry other = (Entry) obj;
		if (m == null) {
			if (other.m != null)
				return false;
		} else if (!m.equals(other.m))
			return false;
		if (n == null) {
			if (other.n != null)
				return false;
		} else if (!n.equals(other.n))
			return false;
		return true;
	}

	
	
}
