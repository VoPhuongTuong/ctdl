package lab6;

import java.util.LinkedList;

public class MyLinkedList {
	public class Node<E> {// Generic
		private E data;
		private Node<E> next;

		public Node(E data) {
			this.data = data;
		}

		public Node(E data, Node<E> next) {
			this.data = data;
			this.next = next;
		}

		public class SinglyLinkedList<E> {
			private Node<E> head = null;
			private Node<E> tail = null;
			private int size;

			public SinglyLinkedList() {
				super();
			}

			public int size() {
				return size;
			}

			public boolean isEmpty() {
				return size == 0;
			}

			public E first() {
				if (isEmpty()) {
					return null;
				}
				return head.data;
			}

			public E last() {
				if (isEmpty()) {
					return null;
				}
				return tail.data;
			}

			public void addFirst(E e) {
				head = new Node<>(e, head);
				if (isEmpty()) {
					tail = head;
				}
				size++;
			}

			public void addLast(E e) {
				Node<E> newest = new Node<>(e);
				if (isEmpty()) {
					head = newest;
				} else {
					tail.next = newest;
				}
				tail = newest;
				size++;
			}

			public E removeFirst() {
				if (isEmpty()) {
					return null;
				}
				E removedData = head.data;
				head = head.next;
				size--;
				if (isEmpty()) {
					tail = null;
				}
				return removedData;
			}

			public E removeLast() {
				if (isEmpty()) {
					return null;
				}
				E removedData = tail.data;
				if (size == 1) {
					head = null;
					tail = null;
				} else {
					Node<E> current = head;
					while (current.next != tail) {
						current = current.next;
					}
					current.next = null;
					tail = current;
				}
				size--;
				return removedData;
			}
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(5);
		linkedList.add(6);
		linkedList.add(7);
		System.out.println("LinkedList: " + linkedList);
		System.out.println("First : " + linkedList.getFirst());
		System.out.println("Last : " + linkedList.getLast());
		linkedList.removeFirst();
		linkedList.removeLast();
		System.out.println("LinkedList: " + linkedList);
	}
}