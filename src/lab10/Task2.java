package lab10;

import java.util.Queue;
import java.util.Stack;

public class Task2 {
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E e = input.poll();
			input.offer(e);
			input.offer(e);
		}
	}

	public static <E> void mirror(Queue<E> input) {
		Stack<E> stack = new Stack<>();
		for (E element : input) {
			stack.push(element);
		}
		while (!stack.isEmpty()) {
			input.add(stack.pop());
		}
	}
}
