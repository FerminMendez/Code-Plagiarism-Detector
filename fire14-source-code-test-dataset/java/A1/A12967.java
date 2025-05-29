package mgg.utils;

import java.util.List;

public class ListUtils {

	public static String pureList(List<?> list) {
		StringBuilder builder = new StringBuilder();
		for (Object elem : list) {
			builder.append(" " + elem);
		}
		return builder.substring(1).toString();
	}

}
