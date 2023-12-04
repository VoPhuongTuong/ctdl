package lab11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	public BNode<E> getRoot() {
		return root;
	}

	public void setRoot(BNode<E> root) {
		this.root = root;
	}

	public void add(E e) {
		root = addRecursive(root, e);
	}

	private BNode<E> addRecursive(BNode<E> current, E e) {
		if (current == null) {
			return new BNode<>(e);
		}

		int compareResult = e.compareTo(current.getData());
		if (compareResult < 0) {
			current.setLeft(addRecursive(current.getLeft(), e));
		} else if (compareResult > 0) {
			current.setRight(addRecursive(current.getRight(), e));
		}

		return current;
	}

	public void add(Collection<E> col) {
		for (E e : col) {
			add(e);
		}
	}

	// compute the depth of a node in BST
	public int depth(E node) {

		return depthRecursive(root, node, 0);
	}

	private int depthRecursive(BNode<E> current, E node, int depth) {
		if (current == null) {
			return -1;
		}

		int compareResult = node.compareTo(current.getData());
		if (compareResult == 0) {
			return depth;
		} else if (compareResult < 0) {
			return depthRecursive(current.getLeft(), node, depth + 1);
		} else {
			return depthRecursive(current.getRight(), node, depth + 1);
		}
	}

	public int height() {
		return heightRe(root);
	}

	public int heightRe(BNode<E> a) {
		if (a == null) {
			return 0;
		}
		int heightLeft = heightRe(a.getLeft());
		int heightRight = heightRe(a.getRight());
		return Math.max(heightLeft, heightRight) + 1;
	}

	public int size() {
		return sizeRe(root);
	}

	public int sizeRe(BNode<E> a) {
		if (a == null) {
			return 0;
		}
		int sizeLeft = sizeRe(a.getLeft());
		int sizeRight = sizeRe(a.getRight());
		return sizeLeft + sizeRight + 1;
	}

	public boolean contains(E e) {
		return containsRecursive(root, e);
	}

	private boolean containsRecursive(BNode<E> current, E e) {
		if (current == null) {
			return false;
		}

		int compareResult = e.compareTo(current.getData());
		if (compareResult == 0) {
			return true;
		} else if (compareResult < 0) {
			return containsRecursive(current.getLeft(), e);
		} else {
			return containsRecursive(current.getRight(), e);
		}
	}

	public E findMin() {
		if (root == null) {
			return null;

		}
		BNode<E> re = root;
		while (re.getLeft() != null) {
			re = re.getLeft();
		}
		return re.getData();
	}

	public E findMax() {
		if (root == null) {
			return null;

		}
		BNode<E> re = root;
		while (re.getRight() != null) {
			re = re.getRight();
		}
		return re.getData();
	}

	public boolean remove(E e) {
		BNode<E>[] result = new BNode[1];
		root = removeRe(root, e, result);
		return result[0] != null;
	}

	public BNode<E> removeRe(BNode<E> a, E e, BNode<E>[] re) {
		if (a == null) {
			re[0] = null;
			return null;
		}
		int check = e.compareTo(a.getData());
		if (check < 0) {
			a.setLeft(removeRe(a.getLeft(), e, re));
		} else if (check > 0) {
			a.setRight(removeRe(a.getRight(), e, re));
		} else {
			re[0] = a;
			if (a.getLeft() == null && a.getRight() == null) {
				return null;
			} else if (a.getLeft() == null) {
				return a.getRight();
			} else if (a.getRight() == null) {
				return a.getLeft();
			} else {
				BNode<E> successor = a.getRight();
				BNode<E> parent = a;
				while (successor.getLeft() != null) {
					parent = successor;
					successor = successor.getLeft();
				}
				a.setData(successor.getData());
				if (parent == a) {
					parent.setRight(successor.getRight());
				} else {
					parent.setLeft(successor.getRight());
				}
			}
		}
		return a;
	}

	public List<E> descendants(E data) {
		List<E> desList = new ArrayList<>();
		BNode<E> node = findNode(root, data);
		if (node != null) {
			collectDescendants(node, desList);
		}
		return desList;
	}

	private void collectDescendants(BNode<E> node, List<E> descendantsList) {
		if (node != null) {
			descendantsList.add(node.getData());
			if (node.getLeft() != null) {
				collectDescendants(node.getLeft(), descendantsList);
			}
			if (node.getRight() != null) {
				collectDescendants(node.getRight(), descendantsList);
			}
		}
	}

	private BNode<E> findNode(BNode<E> a, E e) {
		if (a == null) {
			return null;
		}
		int check = e.compareTo(a.getData());
		if (check == 0) {
			return a;
		} else if (check < 0) {
			return findNode(a.getLeft(), e);
		} else {
			return findNode(a.getRight(), e);
		}
	}

	public List<E> ancestors(E data) {
		List<E> ancestorsList = new ArrayList<>();
		findAnces(root, data, ancestorsList);
		return ancestorsList;
	}

	private boolean findAnces(BNode<E> a, E e, List<E> ances) {
		if (a == null) {
			return false;
		}
		if (a.getData().equals(e)) {
			return true;
		}
		if (findAnces(a.getLeft(), e, ances) || findAnces(a.getRight(), e, ances)) {
			ances.add(a.getData());
			return true;
		}
		return false;
	}

	public void inoder() {
		inoderRe(root);
	}

	private void inoderRe(BNode<E> node) {
		if (node != null) {
			inoderRe(node.getLeft());
			System.out.print(node.getData() + " ");
			inoderRe(node.getRight());
		}
	}

	public void preorder() {
		preorderRe(root);
	}

	private void preorderRe(BNode<E> node) {
		if (node != null) {
			System.out.print(node.getData() + " ");
			preorderRe(node.getLeft());
			preorderRe(node.getRight());
		}
	}

	public void postorder() {
		postorderRe(root);
	}

	private void postorderRe(BNode<E> node) {
		if (node != null) {
			postorderRe(node.getLeft());
			postorderRe(node.getRight());
			System.out.print(node.getData() + " ");
		}
	}
}