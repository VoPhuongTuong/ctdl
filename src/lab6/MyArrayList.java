package lab6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];

	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	public void growSize() {
		if (size == elements.length) {
			int newCapacity = elements.length;
			E[] newElement = (E[]) new Object[newCapacity];
			System.arraycopy(elements, 0, newElement, 0, newCapacity);
		}
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			return elements[i];

		}
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			elements[i] = e;
			return elements[i];

		}
	}

	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		} else {
			elements[size++] = e;

		}
		return true;
	}

	public void add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (size == elements.length) {
			growSize();
		}
		System.arraycopy(elements, i, elements, i + 1, size - 1);
		elements[i] = e;
		size++;

	}

	public E remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		E removed = elements[i];
		System.arraycopy(elements, i + 1, elements, i, size - i - 1);
		elements[--size] = null;

		return removed;

	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			elements[i] = null;
		}
		size = 0;
	}

	public int lastIndexOf(Object o) {
		if (o == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (o.equals(elements[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	public E[] toArray() {
		return Arrays.copyOf(elements, size);
	}

	public MyArrayList<E> clone() {
		MyArrayList<E> cloneList = new MyArrayList<>(elements.length);
		System.arraycopy(elements, 0, cloneList.elements, 0, size);
		cloneList.size = size;
		return cloneList;
	}

	public boolean contains(E o) {
		return indexOf(o) >= 0;
	}

	public int indexOf(E o) {
		if (o == null) {
			for (int i = size - 1; i >= 0; i--) {
				if (elements[i] == null) {
					return i;
				}
			}
		} else {
			for (int i = size - 1; i >= 0; i--) {
				if (o.equals(elements[i])) {
					return i;
				}
			}
		}
		return -1;
	}

	public boolean removes(E e) {
		int index = indexOf(e);
		if (index >= 0) {
			remove(index);
			return true;
		}
		return false;
	}

	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}

	public static void main(String[] args) {
		MyArrayList<Integer> list = new MyArrayList<Integer>();
		list.add(5);
		list.add(6);
		list.add(8);
		System.out.println("Size:" + list.size);
		System.out.println("empty:" + list.isEmpty());
		System.out.println("index1:" + list.get(1));
		list.set(1, 10);
		System.out.println("set:" + list.get(1));
		list.add(1, 11);
		System.out.println("add:" + list.get(1));
		list.remove(1);
		System.out.println("remove:" + list.get(1));
		System.out.println("lastIndexOf:" + list.lastIndexOf(8));
		System.out.println(Arrays.toString(list.toArray()));
		list.clone();
		System.out.println(Arrays.toString(list.toArray()));
		System.out.println("indexOf:" + list.indexOf(8));
		System.out.println("contain:" + list.contains(8));
		System.out.println("removes:" + list.removes(8));
System.out.println();
	}

}
