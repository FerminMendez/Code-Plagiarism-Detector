package fixjava;

/**
 * Convenience class for declaring a method inside a method, so as to avoid code duplication without having to declare a new method
 * in the class. This also keeps functions closer to where they are applied. It's butt-ugly but it's about the best you can do in
 * Java.
 */

public interface Lambda2<P, Q, V> {
	public V apply(P param1, Q param2);
}
