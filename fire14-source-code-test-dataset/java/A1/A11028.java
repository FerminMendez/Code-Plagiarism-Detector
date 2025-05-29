package fixjava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CollectionUtils {

	/**
	 * @return the single value in the collection, throws an exception if there isn't exactly one item.
	 * @throws IllegalArgumentException
	 *             if there is more than one value in the set.
	 */
	public static <T> T getSingleVal(Collection<T> collection) {
		if (collection.size() != 1)
			throw new IllegalArgumentException(collection.size() + " objects in collection, expected exactly 1");
		T ret = null;
		for (T val : collection) {
			ret = val;
			break;
		}
		return ret;
	}

	/**
	 * @return the first value returned by an iterator on the collection, throws an exception if there isn't exactly one item.
	 * @throws IllegalArgumentException
	 *             if collection is empty
	 */
	public static <T> T getFirstVal(Collection<T> collection) {
		if (collection.size() == 0)
			throw new IllegalArgumentException(collection.size() + " objects in collection, expected at least 1");
		T ret = null;
		for (T val : collection) {
			ret = val;
			break;
		}
		return ret;
	}

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * Pass values in an Iterable through a function to produce an ArrayList of mapped values, one output value generated per input
	 * value. Returns null if input is null.
	 */
	public static <S, T> ArrayList<T> map(Iterable<S> values, Lambda<S, T> mapFunction) {
		if (values == null)
			return null;
		ArrayList<T> result = new ArrayList<T>();
		for (S val : values)
			result.add(mapFunction.apply(val));
		return result;
	}

	/**
	 * Pass values in an Iterable through a function to produce an ArrayList of mapped values, one output value generated per input
	 * value. Returns null if input is null.
	 */
	public static <S, T> ArrayList<T> map(S[] values, Lambda<S, T> mapFunction) {
		if (values == null)
			return null;
		ArrayList<T> result = new ArrayList<T>();
		for (S val : values)
			result.add(mapFunction.apply(val));
		return result;
	}

	/**
	 * Pass values in an Iterable through a function to produce an ArrayList of mapped values, zero or more output values generated
	 * per input value. Returns null if input is null.
	 */
	public static <S, T> ArrayList<T> mapMultiple(Iterable<S> values, Lambda<S, ? extends Collection<T>> mapFunction) {
		if (values == null)
			return null;
		ArrayList<T> result = new ArrayList<T>();
		for (S val : values)
			result.addAll(mapFunction.apply(val));
		return result;
	}

	/**
	 * Pass values in an Iterable through a function to produce a HashSet of mapped values, one output value generated per input
	 * value. Returns null if input is null.
	 */
	public static <S, T> HashSet<T> mapSet(Iterable<S> values, Lambda<S, T> mapFunction) {
		if (values == null)
			return null;
		HashSet<T> result = new HashSet<T>();
		for (S val : values)
			result.add(mapFunction.apply(val));
		return result;
	}

	/**
	 * Pass values in an Iterable through a function to produce a HashSet of mapped values, one output value generated per input
	 * value. Returns null if input is null.
	 */
	public static <S, T> HashSet<T> mapSet(S[] values, Lambda<S, T> mapFunction) {
		if (values == null)
			return null;
		HashSet<T> result = new HashSet<T>();
		for (S val : values)
			result.add(mapFunction.apply(val));
		return result;
	}

	/**
	 * Pass values in an Iterable through a function to produce a HashSet of mapped values, zero or more output values generated per
	 * input value. Returns null if input is null.
	 */
	public static <S, T> HashSet<T> mapSetMultiple(Iterable<S> values, Lambda<S, ? extends Collection<T>> mapFunction) {
		if (values == null)
			return null;
		HashSet<T> result = new HashSet<T>();
		for (S val : values)
			result.addAll(mapFunction.apply(val));
		return result;
	}

	// ---------------------------------------------------------------------------------------------------------------------

	public static <T> HashSet<T> filterSet(Iterable<T> values, Lambda<T, Boolean> filterFunction) {
		if (values == null)
			return null;
		HashSet<T> result = new HashSet<T>();
		for (T val : values)
			if (filterFunction.apply(val))
				result.add(val);
		return result;
	}

	public static <T> ArrayList<T> filter(Iterable<T> values, Lambda<T, Boolean> filterFunction) {
		if (values == null)
			return null;
		ArrayList<T> result = new ArrayList<T>();
		for (T val : values)
			if (filterFunction.apply(val))
				result.add(val);
		return result;
	}

	public static <T> HashSet<T> filterSet(T[] values, Lambda<T, Boolean> filterFunction) {
		if (values == null)
			return null;
		HashSet<T> result = new HashSet<T>();
		for (T val : values)
			if (filterFunction.apply(val))
				result.add(val);
		return result;
	}

	public static <T> ArrayList<T> filter(T[] values, Lambda<T, Boolean> filterFunction) {
		if (values == null)
			return null;
		ArrayList<T> result = new ArrayList<T>();
		for (T val : values)
			if (filterFunction.apply(val))
				result.add(val);
		return result;
	}

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * Iterate through multiple Iterables of the same element type, e.g. for (Integer i : CollectionUtils.iterateThroughAllOf(x, y,
	 * z)) { }
	 * 
	 * N.B. you will get a warning "Type safety: A generic array of type Iterable<T> is created for a Varargs parameter" (lame
	 * Java).
	 */
	@SafeVarargs
	public static <T> Iterable<T> iterateThroughAllOf(final Iterable<T>... iterables) {
		if (iterables.length == 0) {
			return (Iterable<T>) new ArrayList<T>();
		} else {
			return new Iterable<T>() {
				@Override
				public Iterator<T> iterator() {
					return new Iterator<T>() {
						Iterable<T>[] iters = iterables;
						int iterIdx = -1;
						Iterator<T> currIter = null;

						private void advanceIfNecessary() {
							if (currIter == null || (iterIdx < iters.length - 1 && !currIter.hasNext()))
								currIter = iterables[++iterIdx].iterator();
						}

						@Override
						public boolean hasNext() {
							advanceIfNecessary();
							return iterIdx < iters.length && (iterIdx < iters.length - 1 || currIter.hasNext());
						}

						@Override
						public T next() {
							advanceIfNecessary();
							if (iterIdx == iters.length)
								throw new RuntimeException("Out of elements");
							return currIter.next();
						}

						@Override
						public void remove() {
							advanceIfNecessary();
							if (iterIdx == iters.length)
								throw new RuntimeException("Out of elements");
							else
								currIter.remove();
						}
					};
				}
			};
		}
	}

	/**
	 * Iterate through multiple Arrays of the same element type, e.g. for (Integer i : CollectionUtils.iterateThroughAllOf(x, y, z))
	 * { }
	 */
	@SafeVarargs
	public static <T> Iterable<T> iterateThroughAllOf(final T[]... arrays) {
		if (arrays.length == 0) {
			return (Iterable<T>) new ArrayList<T>();
		} else {
			return new Iterable<T>() {
				@Override
				public Iterator<T> iterator() {
					return new Iterator<T>() {
						T[][] arrs = arrays;
						int arrIdx = 0, arrSubIdx = 0;

						private void advanceIfNecessary() {
							if (arrIdx < arrs.length && arrSubIdx == arrs[arrIdx].length) {
								arrIdx++;
								arrSubIdx = 0;
							}
						}

						@Override
						public boolean hasNext() {
							advanceIfNecessary();
							return arrIdx < arrs.length && (arrIdx < arrs.length - 1 || arrSubIdx < arrs[arrIdx].length);
						}

						@Override
						public T next() {
							advanceIfNecessary();
							if (arrIdx == arrs.length)
								throw new RuntimeException("Out of elements");
							return arrs[arrIdx][arrSubIdx++];
						}

						@Override
						public void remove() {
							throw new RuntimeException("Not implemented");
						}
					};
				}
			};
		}
	}

	/**
	 * Iterate through multiple Iterables of the same element type (skipping over null iterables, *not* null elements), e.g. for
	 * (Integer i : CollectionUtils.iterateThroughAllOf(x, y, z)) { }
	 * 
	 * N.B. you will get a warning "Type safety: A generic array of type Iterable<T> is created for a Varargs parameter" (lame
	 * Java).
	 */
	@SuppressWarnings("unchecked")
	public static <T> Iterable<T> iterateThroughAllOfIgnoringNulls(Iterable<T>... iterables) {
		ArrayList<Iterable<T>> filter = filter(iterables, new Lambda<Iterable<T>, Boolean>() {
			@Override
			public Boolean apply(Iterable<T> param) {
				return param != null;
			}
		});
		Iterable<T>[] nonNulls = new Iterable[filter.size()];
		filter.toArray(nonNulls);
		return iterateThroughAllOf(nonNulls);
	}

	/**
	 * Iterate through multiple arrays of the same element type (skipping over null arrays, *not* null elements), e.g. for (Integer
	 * i : CollectionUtils.iterateThroughAllOf(x, y, z)) { }
	 */
	@SuppressWarnings("unchecked")
	public static <T> Iterable<T> iterateThroughAllOfIgnoringNulls(T[]... arrays) {
		ArrayList<T[]> filter = filter(arrays, new Lambda<T[], Boolean>() {
			@Override
			public Boolean apply(T[] param) {
				return param != null;
			}
		});
		Iterable<T>[] nonNulls = new Iterable[filter.size()];
		filter.toArray(nonNulls);
		return iterateThroughAllOf(nonNulls);
	}

	//	public static void main(String[] args) {
	//		ArrayList<Integer> x = new ArrayList<Integer>();
	//		ArrayList<Integer> y = new ArrayList<Integer>();
	//		ArrayList<Integer> z = new ArrayList<Integer>();
	//		x.add(1);
	//		x.add(2);
	//		x.add(3);
	//		y.add(19);
	//		y.add(23);
	//		z.add(100);
	//		z.add(999);
	//		for (Integer i : iterateThroughAllOf(x, y, z))
	//			System.out.println(i);
	//		Integer[] a = new Integer[3];
	//		Integer[] b = new Integer[2];
	//		a[0] = 10;
	//		a[1] = 11;
	//		a[2] = 12;
	//		b[0] = 7;
	//		b[1] = 8;
	//		for (Integer i : iterateThroughAllOf(a, b))
	//			System.out.println(i);
	//	}

	/**
	 * Iterate through a varargs list of iterable objects of type T, and return all the objects in a list. Null iterables are
	 * skipped.
	 */
	@SafeVarargs
	public static <T> ArrayList<T> toListIgnoringNulls(Iterable<T>... iterables) {
		ArrayList<T> result = new ArrayList<T>();
		for (T item : iterateThroughAllOfIgnoringNulls(iterables))
			result.add(item);
		return result;
	}

	/**
	 * Iterate through a varargs list of iterable objects of type T, and return all the objects in a set (removing duplicates). Null
	 * iterables are skipped.
	 */
	@SafeVarargs
	public static <T> HashSet<T> toSetIgnoringNulls(Iterable<T>... iterables) {
		return new HashSet<T>(toListIgnoringNulls(iterables));
	}

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * Look up keys in the map, and return a collection of the corresponding values. Returns null if 'keys' is null.
	 * 
	 * @throw IllegalArgumentException if key doesn't exist in map or if a key is null, depending on params.
	 */
	public static <K, V, C extends Collection<V>> C lookup(Collection<K> keys, Map<K, V> map,
			LambdaVoid<K> applyIfKeyIsNullWithoutAddingValue, Lambda<K, V> applyIfKeyIsNullAndAddReturnedValue,
			LambdaVoid<K> applyWhenKeyDoesntExistWithoutAddingValue, Lambda<K, V> applyWhenKeyDoesntExistAndAddReturnedValue,
			C result) {
		if (keys == null)
			return null;
		for (K key : keys) {
			V val = null;
			boolean addValue = false;
			if (applyIfKeyIsNullWithoutAddingValue != null && key == null) {
				applyIfKeyIsNullWithoutAddingValue.apply(key);
			} else if (applyIfKeyIsNullAndAddReturnedValue != null && key == null) {
				val = applyIfKeyIsNullAndAddReturnedValue.apply(key);
				addValue = true;
			} else if (applyWhenKeyDoesntExistWithoutAddingValue != null && !map.containsKey(key)) {
				applyWhenKeyDoesntExistWithoutAddingValue.apply(key);
			} else if (applyWhenKeyDoesntExistAndAddReturnedValue != null && !map.containsKey(key)) {
				val = applyWhenKeyDoesntExistAndAddReturnedValue.apply(key);
				addValue = true;
			} else {
				val = map.get(key);
				addValue = true;
			}
			if (addValue)
				result.add(val);
		}
		return result;
	}

	/**
	 * Look up keys in the map, and return an ArrayList of the corresponding values. Returns null if 'keys' is null.
	 * 
	 * @throw IllegalArgumentException if key doesn't exist in map or if a key is null, depending on params.
	 */
	public static <K, V> ArrayList<V> lookup(Collection<K> keys, Map<K, V> map, boolean throwExceptionIfKeyNull,
			boolean throwExceptionIfKeyDoesntExist) {
		if (keys == null)
			return null;
		return lookup(keys, map, throwExceptionIfKeyNull ? new LambdaVoid<K>() {
			@Override
			public void apply(K key) {
				throw new IllegalArgumentException("Key is null");
			}
		} : null, null, throwExceptionIfKeyDoesntExist ? new LambdaVoid<K>() {
			@Override
			public void apply(K key) {
				throw new IllegalArgumentException("Could not find key " + key + " in map");
			}
		} : null, null, new ArrayList<V>());
	}

	/**
	 * Look up keys in the map, and return an ArrayList of the corresponding values. Performs no checking. Returns null if 'keys' is
	 * null.
	 */
	public static <K, V> ArrayList<V> lookup(Collection<K> keys, Map<K, V> map) {
		if (keys == null)
			return null;
		ArrayList<V> vals = new ArrayList<V>(keys.size());
		for (K key : keys) {
			// Simple version for speed
			V val = map.get(key);
			vals.add(val);
		}
		return vals;
	}

	/**
	 * Look up keys in the map, and return an ArrayList of the corresponding values. Applies the given function if the key doesn't
	 * exist. Returns null if 'keys' is null.
	 */
	public static <K, V> ArrayList<V> lookup(Collection<K> keys, Map<K, V> map, LambdaVoid<K> applyWhenKeyDoesntExist) {
		return lookup(keys, map, null, null, applyWhenKeyDoesntExist, null, new ArrayList<V>());
	}

	/**
	 * Look up keys in the map, and return an ArrayList of the corresponding values. Applies the given function if the key doesn't
	 * exist to produce a default value. Returns null if 'keys' is null.
	 */
	public static <K, V> ArrayList<V> lookup(Collection<K> keys, Map<K, V> map, Lambda<K, V> applyWhenKeyDoesntExistToGetDefaultVal) {
		return lookup(keys, map, null, null, null, applyWhenKeyDoesntExistToGetDefaultVal, new ArrayList<V>());
	}

	/**
	 * Look up keys in the map, and return a HashSet of the corresponding values. Returns null if 'keys' is null.
	 * 
	 * @throw IllegalArgumentException if key doesn't exist in map or if a key is null, depending on params.
	 */
	public static <K, V> HashSet<V> lookupAsSet(Collection<K> keys, Map<K, V> map, boolean throwExceptionIfKeyNull,
			boolean throwExceptionIfKeyDoesntExist) {
		if (keys == null)
			return null;
		return lookup(keys, map, throwExceptionIfKeyNull ? new LambdaVoid<K>() {
			@Override
			public void apply(K key) {
				throw new IllegalArgumentException("Key is null");
			}
		} : null, null, throwExceptionIfKeyDoesntExist ? new LambdaVoid<K>() {
			@Override
			public void apply(K key) {
				throw new IllegalArgumentException("Could not find key " + key + " in map");
			}
		} : null, null, new HashSet<V>());
	}

	/**
	 * Look up keys in the map, and return a HashSet of the corresponding values. Performs no checking. Returns null if 'keys' is
	 * null.
	 */
	public static <K, V> HashSet<V> lookupAsSet(Collection<K> keys, Map<K, V> map) {
		if (keys == null)
			return null;
		HashSet<V> vals = new HashSet<V>(keys.size());
		for (K key : keys) {
			// Simple version for speed
			V val = map.get(key);
			vals.add(val);
		}
		return vals;
	}

	/**
	 * Look up keys in the map, and return a HashSet of the corresponding values. Applies the given function if the key doesn't
	 * exist. Returns null if 'keys' is null.
	 */
	public static <K, V> HashSet<V> lookupAsSet(Collection<K> keys, Map<K, V> map, LambdaVoid<K> applyWhenKeyDoesntExist) {
		return lookup(keys, map, null, null, applyWhenKeyDoesntExist, null, new HashSet<V>());
	}

	/**
	 * Look up keys in the map, and return a HashSet of the corresponding values. Applies the given function if the key doesn't
	 * exist to produce a default value. Returns null if 'keys' is null.
	 */
	public static <K, V> HashSet<V> lookupAsSet(Collection<K> keys, Map<K, V> map,
			Lambda<K, V> applyWhenKeyDoesntExistToGetDefaultVal) {
		return lookup(keys, map, null, null, null, applyWhenKeyDoesntExistToGetDefaultVal, new HashSet<V>());
	}

	// ---------------------------------------------------------------------------------------------------------------------

	/** Take the union of all items in all passed collections/Iterables */
	public static <T> HashSet<T> union(Iterable<? extends Iterable<T>> iterables) {
		HashSet<T> result = new HashSet<T>();
		for (Iterable<T> iterable : iterables)
			for (T item : iterable)
				result.add(item);
		return result;
	}

	/** Put each item in an array into a set. c.f. makeSet(), toSetIgnoringNulls(). */
	public static <T> HashSet<T> union(T[] items) {
		HashSet<T> result = new HashSet<T>();
		for (T item : items)
			result.add(item);
		return result;
	}

	// ---------------------------------------------------------------------------------------------------------------------

	/** Varargs constructor for a typed set */
	@SafeVarargs
	public static <T> HashSet<T> makeSet(T... items) {
		HashSet<T> set = new HashSet<T>(items.length);
		for (T it : items)
			set.add(it);
		return set;
	}

	/** Varargs constructor for a typed list */
	@SafeVarargs
	public static <T> ArrayList<T> makeList(T... items) {
		ArrayList<T> list = new ArrayList<T>(items.length);
		for (T it : items)
			list.add(it);
		return list;
	}

	/** Varargs constructor for a typed list, specifying initial capacity */
	@SafeVarargs
	public static <T> ArrayList<T> makeListWithInitialCapacity(int initialCapacity, T... items) {
		ArrayList<T> list = new ArrayList<T>(Math.max(items.length, initialCapacity));
		for (T it : items)
			list.add(it);
		return list;
	}

	// ---------------------------------------------------------------------------------------------------------------------

	public static <K, V> ArrayList<Pair<K, V>> mapToListOfPairs(Map<K, V> map) {
		ArrayList<Pair<K, V>> result = new ArrayList<Pair<K, V>>();
		for (Entry<K, V> ent : map.entrySet())
			result.add(Pair.make(ent.getKey(), ent.getValue()));
		return result;
	}

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * Generate a sorted ArrayList of values from any collection. Does not sort in-place, but rather sorts a copy of the collection.
	 */
	public static <T extends Comparable<T>> ArrayList<T> sortCopy(Collection<T> vals) {
		ArrayList<T> sorted = new ArrayList<T>(vals);
		Collections.sort(sorted);
		return sorted;
	}

	/**
	 * Generate a sorted ArrayList of values from any collection, using the specified comparator. Does not sort in-place, but rather
	 * sorts a copy of the collection.
	 */
	public static <T> ArrayList<T> sortCopy(Collection<T> vals, Comparator<T> comparator) {
		ArrayList<T> sorted = new ArrayList<T>(vals);
		Collections.sort(sorted, comparator);
		return sorted;
	}

	/**
	 * Make a comparator by passing in a lambda that simply returns a comparable field for an object, e.g.
	 * 
	 * <code>
	 * CollectionUtils.sort(nodeList, CollectionUtils.makeComparator(new Lambda<Node, String>() {
	 *     public String apply(Node obj) {
	 *         return obj.getName();
	 *     }
	 * });
	 * </code>
	 * 
	 * This is not much shorter than declaring a comparator in the sort call (and has more overhead), but may be a little simpler or
	 * could reduce code duplication in the comparator.
	 * 
	 * @param <O>
	 *            The type of the objects to compare
	 * @param <F>
	 *            The type of the field to compare
	 * @param getFieldToCompare
	 *            A simple getter for the field to compare
	 * @return A comparator that can be used for sorting
	 */
	public static <O, F extends Comparable<F>> Comparator<O> makeComparator(final Lambda<O, F> getFieldToCompare) {
		return new Comparator<O>() {
			@Override
			public int compare(O o1, O o2) {
				return getFieldToCompare.apply(o1).compareTo(getFieldToCompare.apply(o2));
			}
		};
	}

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * Build a map from objects in an Iterable to an index mapping that object to its index in the Iterable. Objects must be unique
	 * (!equals()) or an exception is thrown.
	 */
	public static <T> HashMap<T, Integer> buildIndex(Iterable<T> collection) {
		HashMap<T, Integer> map = new HashMap<T, Integer>();
		for (IndexedItem<T> it : IndexedItem.iterate(collection))
			if (map.put(it.getItem(), it.getIndex()) != null)
				throw new IllegalArgumentException(
						"Duplicate object in collection, cannot uniquely map objects to indices (try buildIndexMulti()?): "
								+ it.getItem());
		return map;
	}

	/**
	 * Build a map from objects in an array to an index mapping that object to its index in the array. Objects must be unique
	 * (!equals()) or an exception is thrown.
	 */
	public static <T> HashMap<T, Integer> buildIndex(T[] arr) {
		HashMap<T, Integer> map = new HashMap<T, Integer>();
		for (IndexedItem<T> it : IndexedItem.iterate(arr))
			if (map.put(it.getItem(), it.getIndex()) != null)
				throw new IllegalArgumentException(
						"Duplicate object in collection, cannot uniquely map objects to indices (try buildIndexMulti()?): "
								+ it.getItem());
		return map;
	}

	/** Build a map from objects in a collection to a list of indices containing equal objects. */
	public static <T> MultiMapKeyToList<T, Integer> buildIndexMulti(Iterable<T> collection) {
		MultiMapKeyToList<T, Integer> map = new MultiMapKeyToList<T, Integer>();
		for (IndexedItem<T> it : IndexedItem.iterate(collection)) {
			T o = it.getItem();
			map.put(o, it.getIndex());
		}
		return map;
	}

	// ---------------------------------------------------------------------------------------------------------------------

	/**
	 * Count the number of .equal() occurrences of objects of type T in the collection, and produce histogram of the results. The
	 * histogram can be sorted in order of ascending count if desired.
	 */
	public static <T> ArrayList<Pair<T, Integer>> countEqualOccurrences(Iterable<T> collection) {
		CountedSet<T> set = new CountedSet<T>(collection);
		ArrayList<Pair<T, Integer>> result = new ArrayList<Pair<T, Integer>>();
		for (Entry<T, Integer> ent : set.iteratableWithCounts())
			result.add(Pair.make(ent.getKey(), ent.getValue()));
		return result;
	}

	/**
	 * Build a histogram of the number of unique objects that occur each number of times. Objects occur multiple times if there are
	 * multiple instances that match with .equals(). Returns a Pair<Integer, Integer> with number of occurrences of each unique
	 * object as left and number of unique objects with that number of occurrences as right.
	 */
	public static <T> ArrayList<Pair<Integer, Integer>> buildHistogramOfNumObjectsThatOccurGivenNumberOfTimesSparse(
			Iterable<T> collection) {
		// Count unique occurrences of the objects of type T
		ArrayList<Pair<T, Integer>> counts = countEqualOccurrences(collection);
		// Now count unique occurrences each of the count values to build the histogram
		ArrayList<Pair<Integer, Integer>> countCounts = countEqualOccurrences(Pair.getAllRights(counts));
		// Sort the result in order of number of occurrences (i.e. left)
		Pair.sortPairsByLeft(countCounts, true);
		return countCounts;
	}

	/**
	 * Build a histogram of the number of unique objects that occur each number of times. Objects occur multiple times if there are
	 * multiple instances that match with .equals(). Returns an array with the number of occurrences of each unique object as the
	 * index and number of unique objects with that number of occurrences as the value of the array at that index.
	 */
	public static <T> int[] buildHistogramOfNumObjectsThatOccurGivenNumberOfTimesNonSparse(Iterable<T> collection) {
		// Build histogram
		ArrayList<Pair<Integer, Integer>> histList = buildHistogramOfNumObjectsThatOccurGivenNumberOfTimesSparse(collection);
		// Desparsify into an array and return
		int maxAbscissa = histList.isEmpty() ? -1 : histList.get(histList.size() - 1).getLeft();
		int[] result = new int[maxAbscissa + 1];
		for (Pair<Integer, Integer> pair : histList)
			result[pair.getLeft()] = pair.getRight();
		return result;
	}

	// ---------------------------------------------------------------------------------------------------------------------

	/** Reverse a list */
	public static <T> ArrayList<T> reverse(List<T> list) {
		ArrayList<T> result = new ArrayList<T>(list.size());
		for (int i = list.size() - 1; i >= 0; --i)
			result.add(list.get(i));
		return result;
	}

	/**
	 * Arrayify/rectangularize a list of lists, inserting the given filler element to make the result rectangular if lists are not
	 * the same length
	 */
	public static <T> ArrayList<ArrayList<T>> rectangularize(List<? extends List<T>> input, T filler) {
		int numRows = input.size();
		int numCols = 0;
		for (int i = 0; i < numRows; i++)
			numCols = Math.max(numCols, input.get(i).size());
		ArrayList<ArrayList<T>> output = new ArrayList<ArrayList<T>>(numRows);
		for (int i = 0; i < numRows; i++) {
			ArrayList<T> outRow = new ArrayList<T>(input.get(i));
			output.add(outRow);
			while (outRow.size() < numCols)
				outRow.add(filler);
		}
		return output;
	}

	public static <S, T> MultiMapKeyToSet<T, S> invertMap(HashMap<S, T> map) {
		MultiMapKeyToSet<T, S> result = new MultiMapKeyToSet<T, S>();
		for (Entry<S, T> ent : map.entrySet())
			result.put(ent.getValue(), ent.getKey());
		return result;
	}

}
