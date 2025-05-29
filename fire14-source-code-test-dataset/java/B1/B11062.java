package fixjava;

import java.util.ArrayList;
import java.util.List;

public class Take<T> {

	/** Return at most n items from the beginning of the Iterable. */
	public static <T> ArrayList<T> head(Iterable<T> collection, int n) {
		ArrayList<T> head = new ArrayList<T>();
		int count = n;
		if (n > 0)
			for (T item : collection) {
				head.add(item);
				if (--count == 0)
					break;
			}
		return head;
	}

	/** Return at most n items from the end of the List. */
	public static <T> ArrayList<T> tail(List<T> list, int n) {
		ArrayList<T> tail = new ArrayList<T>();
		for (int len = list.size(), i = Math.max(len - n, 0); i < len; i++)
			tail.add(list.get(i));
		return tail;
	}

}
