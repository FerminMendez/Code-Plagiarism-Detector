package fixjava;

import java.util.Iterator;

/**
 * Create an iterator that keeps track of the current index into the Iterable.
 * 
 * Usage:
 * 
 * <code>

	public static void main(String[] args) {
	
		// Iterate over a list:
		ArrayList<String> list = new ArrayList<String>();
		list.add("apple");
		list.add("banana");
		list.add("pear");
		for (IndexedItem<String> it : IndexedItem.iterate(list))
			System.out.println(it.getIndex() + ": " + it.getItem());
			
		// Iterate over an array:
		String[] arr = new String[] {"a", "b", "c"};
		for (IndexedItem<String> it : IndexedItem.iterate(arr))
			System.out.println(it.getIndex() + ": " + it.getItem());
	}

   </code>
 * 
 * @author (c) Luke Hutchison 2010. Covered under the BSD license.
 * 
 * @param <T>
 *            The type of the Iterable.
 */
public class IndexedItem<T> {
	private T item;
	private int index = -1;

	/** Get the current item in the iteration. */
	public T getItem() {
		return item;
	}

	/** Get the index of the current item (zero-indexed). */
	public int getIndex() {
		return index;
	}

	private static class IndexedIterator<U> implements Iterable<IndexedItem<U>>, Iterator<IndexedItem<U>> {

		private final Iterator<U> collectionIter;
		private final IndexedItem<U> currItem = new IndexedItem<U>();

		public IndexedIterator(Iterable<U> collection) {
			this.collectionIter = collection.iterator();
		}

		public IndexedIterator(final U[] array) {
			collectionIter = new Iterator<U>() {
				U[] arr = array;
				IndexedItem<U> it = currItem;

				@Override
				public boolean hasNext() {
					return it.index + 1 < arr.length;
				}

				@Override
				public U next() {
					return arr[it.index + 1];
				}

				@Override
				public void remove() {
					for (int i = it.index + 2; i < arr.length; i++)
						arr[i] = arr[i + 1];
				}
			};
		}

		@Override
		public Iterator<IndexedItem<U>> iterator() {
			return this;
		}

		@Override
		public boolean hasNext() {
			return collectionIter.hasNext();
		}

		@Override
		public IndexedItem<U> next() {
			currItem.item = collectionIter.next();
			currItem.index++;
			return currItem;
		}

		@Override
		public void remove() throws UnsupportedOperationException, IllegalStateException {
			collectionIter.remove();
			currItem.index--;
			currItem.item = null;
		}
	}

	/** Iterate over an Iterable<T> and keep track of the index */ 
	public static <T> Iterable<IndexedItem<T>> iterate(Iterable<T> collection) {
		return new IndexedIterator<T>(collection);
	}

	/** Iterate over an array T[] and keep track of the index */
	public static <T> Iterable<IndexedItem<T>> iterate(T[] array) {
		return new IndexedIterator<T>(array);
	}
}

