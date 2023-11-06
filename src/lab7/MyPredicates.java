package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.Iterator;
import java.util.List;

public class MyPredicates {
	public static <T> void remove(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T obj = iterator.next();
			if (p.test(obj)) {
				iterator.remove();
			}
		}

	}

	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T obj = iterator.next();
			if (!p.test(obj)) {
				iterator.remove();
			}
		}
	}

	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		Set<T> result = new HashSet<>();
		Iterator<T> iterator = coll.iterator();
		while (iterator.hasNext()) {
			T obj = iterator.next();
			if (p.test(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		Iterator<T> iterator = coll.iterator();
		int index = 0;
		while (iterator.hasNext()) {
			T obj = iterator.next();
			if (p.test(obj)) {
				return index;
			}
			index++;
		}
		return -1;
	}

}