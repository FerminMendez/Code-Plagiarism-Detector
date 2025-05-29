package fixjava;

/**
 * Convenience class for declaring a method inside a method, so as to avoid code duplication without having to declare a new method
 * in the class. This also keeps functions closer to where they are applied. It's butt-ugly but it's about the best you can do in
 * Java.
 * 
 * <code>
			final HashSet<String> allNames = new HashSet<String>();
			Lambda<Set<String>, Void> addAllIfNotNull = new Lambda<Set<String>, Void>() {
				public Void apply(Set<String> newNames) {
					if (allNames != null)
						allNames.addAll(newNames);
					return null;
				}
			};
			allNames.add(cell.getName());
			addAllIfNotNull.apply(cell.getValues("Main_name"));
			addAllIfNotNull.apply(cell.getValues("Other_name"));
			addAllIfNotNull.apply(cell.getValues("Tree_node"));
			addAllIfNotNull.apply(cell.getValues("Lineage_name"));
 * </code>
 */

public interface Lambda<P, V> {
	public V apply(P param);
}
