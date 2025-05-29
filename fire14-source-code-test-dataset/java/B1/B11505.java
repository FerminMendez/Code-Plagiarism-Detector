package it.simone.google.code.jam2012;

import java.util.HashSet;
import java.util.Set;

public class RecycledNumber implements GoogleCodeExercise {

	int a = 0;
	int b = 0;
	Set<Couple> distinctCouple = null;
	long maxTime = 0;

	private class Couple {
		int x = 0;
		int y = 0;

		public Couple(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + x;
			result = prime * result + y;
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
			Couple other = (Couple) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (x == other.x && y == other.y)
				return true;
			if (x == other.y && y == other.x)
				return true;
			return false;
		}

		private RecycledNumber getOuterType() {
			return RecycledNumber.this;
		}

	}

	@Override
	public String execute(String line) {
		int result = 0;

		String[] data = line.split(" ");
		a = Integer.parseInt(data[0]);
		b = Integer.parseInt(data[1]);
		initialize();

		int n = a;
		//
		while (n <= b) {
			result += analize(n);
			n++;
//			if (n % 1000 == 0)
//				System.out.println(n);
		}

		System.out.println(result);
		return "" + result;
	}

	@Override
	public void initialize() {
		distinctCouple = new HashSet<Couple>();
	}

	private int analize(int number) {
		String numString = "" + number;
		initialize();
		for (int i = 1; i < numString.length(); i++) {
			int m = shift(numString, i);
			if (a <= number && number < m && m <= b) {
				Couple couple=new Couple(number,m);
				if (!distinctCouple.contains(couple))
					distinctCouple.add(couple);
			}
		}
		return distinctCouple.size();
	}

	private int shift(String numString, int posx) {

		String result = null;
		result = "" + numString.substring(posx) + numString.substring(0, posx);

		return Integer.parseInt(result.toString());
	}

}
