package com.xatu.wangyi;

/**
 * @author tx_gogo ƽ���������ʵ��
 */
// �洢�������ͱ���ʵ��Comparable�ӿڣ�ʵ�ֱȽϷ���
public class AVLTree<T extends Comparable<T>> {
	private Node<T> root;

	// ����ڵ�洢����
	private static class Node<T> {
		Node<T> left;// ����
		Node<T> right;// �Һ���
		T data; // �洢����
		int height; // ����

		public Node(Node<T> left, Node<T> right, T data) {
			this.left = left;
			this.right = right;
			this.data = data;
			this.height = 0;
		}
	}

	// ���⹫���ķ������в���
	public Node<T> insert(T data) {
		return root = insert(data, root);
	}

	// ˽�з������еݹ���룬���ز���ڵ�
	private Node<T> insert(T data, Node<T> node) {
		// �ݹ���ֹ����
		if (node == null)
			return new Node<T>(null, null, data);
		// �Ƚϲ������ݺʹ�����ڵ�Ĵ�С
		int compareResult = data.compareTo(node.data);
		if (compareResult > 0) {// ����node��������
			node.right = insert(data, node.right);
			// �ص�ʱ�ж��Ƿ�ƽ��
			if (getHeight(node.right) - getHeight(node.left) == 2) {// ��ƽ�������ת
				// �ж�����Ҫ����������ת������Ҫ����һ����ת
				int compareResult02 = data.compareTo(node.right.data);
				if (compareResult02 > 0)// ����һ������(����)
					node = rotateSingleLeft(node);
				else
					// ����������ת����������������
					node = rotateDoubleLeft(node);
			}
		} else if (compareResult < 0) {// ����node��������
			node.left = insert(data, node.left);
			// �ص�ʱ�����ж��Ƿ�ƽ��
			if (getHeight(node.left) - getHeight(node.right) == 2) {// ������ת
				// �ж�����Ҫ����������ת������Ҫ����һ����ת
				int intcompareResult02 = data.compareTo(node.left.data);
				if (intcompareResult02 < 0)// ����һ������(����)
					node = rotateSingleRight(node);
				else
					// ����������ת����������������
					node = rotateDoubleRight(node);
			}
		}
		// ���¼���ýڵ������
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		return node;
	}

	// �������--��������
	private Node<T> rotateSingleLeft(Node<T> node) {
		Node<T> rightNode = node.right;
		node.right = rightNode.left;
		rightNode.left = node;
		// ��ת������������
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		rightNode.height = Math.max(node.height, getHeight(rightNode.right)) + 1;
		return rightNode;
	}

	// �������--��������
	private Node<T> rotateSingleRight(Node<T> node) {
		Node<T> leftNode = node.left;
		node.left = leftNode.right;
		leftNode.right = node;
		// ��ת������������
		node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		leftNode.height = Math.max(getHeight(leftNode.left), node.height) + 1;
		return leftNode;
	}

	// �������--������������
	private Node<T> rotateDoubleLeft(Node<T> node) {
		// �Ƚ�������
		node.right = rotateSingleRight(node.right);
		// �ټ�������
		node = rotateSingleLeft(node);
		return node;
	}

	// ����--������������
	private Node<T> rotateDoubleRight(Node<T> node) {
		// �Ƚ�������
		node.left = rotateSingleLeft(node.left);
		// �ڽ�������
		node = rotateSingleRight(node);
		return node;
	}

	// ��������
	private int getHeight(Node<T> node) {
		return node == null ? -1 : node.height;
	}

	// public �������ⲿ����ɾ������
	public Node<T> remove(T data) {
		return root = remove(data, root);
	}

	// �ݹ����ɾ�������رȽϽڵ�
	private Node<T> remove(T data, Node<T> node) {
		if (node == null) {// �����ڴ˽ڵ꣬����null.����Ҫ��������
			return null;
		}
		int compareResult = data.compareTo(node.data);
		if (compareResult == 0) {// ���ڴ˽ڵ����
			/**
			 * �ҵ��ڵ�֮����нڵ�ɾ������ �ж�node�Ƿ������������û����������ֻ��һ��������ֱ�ӽ���ɾ��
			 * �������������������Ҫ�ж�node��ƽ��ϵ��balance ���balanceΪ0����1���node��node�������������ֵ���н���
			 * �����node������������Сֵ���н��� ��������֮��ɾ���ýڵ� ɾ��֮���ж�delete�ڵ�ĸ��ڵ��Ƿ�ƽ�⣬�����ƽ����нڵ���ת
			 * ��ת֮�󷵻�delete�ڵ�ĸ��ڵ���л���
			 */
			if (node.left != null && node.right != null) { // �˽ڵ������������
				// �ж�node�ڵ��balance��Ȼ��������ݽ���ɾ���ڵ�
				int balance = getHeight(node.left) - getHeight(node.right);
				Node<T> temp = node;// ������Ҫ����ɾ����node�ڵ�
				if (balance == -1) {
					// ������������Сֵ���н���
					exChangeRightData(node, node.right);
				} else {
					// �������������ֵ���н���
					exChangeLeftData(node, node.left);
				}
				// ��ʱ�Ѿ�������ɲ��Ұѽڵ�ɾ����ɣ�����Ҫ���¼���ýڵ������
				temp.height = Math.max(getHeight(temp.left), getHeight(temp.right)) + 1;
				// ע��˴������ص���temp,Ҳ���Ǳ������Ҫɾ���Ľڵ㣬�������滻�Ľڵ�
				return temp;
			} else {
				// ��node���ӽڵ㷵�ص��ô�����ɾ����node�ڵ�
				// �˴�������һ��node.left ==null && node.right == null ����������ʱ����null
				return node.left != null ? node.left : node.right;
			}
		} else if (compareResult > 0) {// û�ҵ���Ҫɾ���Ľڵ�����ݹ����Ѱ��
			node.right = remove(data, node.right);
			// ɾ��֮��������߸���
			node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
			// �����ƽ�����������������
			if (getHeight(node.left) - getHeight(node.right) == 2) {// ������ת
				Node<T> leftSon = node.left;
				// �ж��Ƿ���Ҫ����������������һ������
				// �ж��������ǱȽ�leftSon�ڵ�������ӽڵ�����
				if (leftSon.left.height > leftSon.right.height) {
					// ����һ��
					node = rotateSingleRight(node);
				} else {
					// ������ת����������������
					node = rotateDoubleRight(node);
				}
			}
			return node;
		} else if (compareResult < 0) {// û�ҵ���Ҫɾ���Ľڵ�����ݹ����Ѱ��
			node.left = remove(data, node.left);
			// ɾ��֮��������߸���
			node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
			// �����ƽ�������������
			if (getHeight(node.left) - getHeight(node.right) == 2) {// ������ת
				Node<T> rightSon = node.right;
				// �ж��Ƿ���Ҫ����������������һ������
				// �ж��������ǱȽ�rightSon�ڵ�������ӽڵ�����
				if (rightSon.right.height > rightSon.left.height) {
					node = rotateSingleLeft(node);
				} else {
					// ������������
					node = rotateDoubleLeft(node);
				}
			}
			return node;
		}
		return null;
	}

	// �ݹ�Ѱ��right�ڵ�����ֵ
	private Node<T> exChangeLeftData(Node<T> node, Node<T> right) {
		if (right.right != null) {
			right.right = exChangeLeftData(node, right.right);
		} else {
			// ���ݽ����滻
			node.data = right.data;
			// �˴��Ѿ����滻�ڵ�ɾ��
			return right.left;
		}
		right.height = Math.max(getHeight(right.left), getHeight(right.right)) + 1;
		// �����ж�left�Ƿ�ƽ��,�����ƽ�����������������
		int isbanlance = getHeight(right.left) - getHeight(right.right);
		if (isbanlance == 2) {// ������ת
			Node<T> leftSon = node.left;
			// �ж��Ƿ���Ҫ����������������һ������
			// �ж��������ǱȽ�leftSon�ڵ�������ӽڵ�����
			if (leftSon.left.height > leftSon.right.height) {
				// ����һ��
				return node = rotateSingleRight(node);
			} else {
				// ������ת����������������
				return node = rotateDoubleRight(node);
			}
		}
		return right;
	}

	// �ݹ�Ѱ��left�ڵ����Сֵ
	private Node<T> exChangeRightData(Node<T> node, Node<T> left) {
		if (left.left != null) {
			left.left = exChangeRightData(node, left.left);
		} else {
			node.data = left.data;
			// �˴��Ѿ����滻�ڵ�ɾ��
			return left.right;
		}
		left.height = Math.max(getHeight(left.left), getHeight(left.right)) + 1;
		// �����ж�left�Ƿ�ƽ��,�����ƽ�����������������
		int isbanlance = getHeight(left.left) - getHeight(left.right);
		if (isbanlance == -2) {// ������ת
			Node<T> rightSon = node.right;
			// �ж��Ƿ���Ҫ����������������һ������
			// �ж��������ǱȽ�rightSon�ڵ�������ӽڵ�����
			if (rightSon.right.height > rightSon.left.height) {
				return node = rotateSingleLeft(node);
			} else {
				// ������������
				return node = rotateDoubleLeft(node);
			}
		}
		return left;
	}

	// ************************������� ��������С����*************************************
	public void inorderTraverse() {
		inorderTraverseData(root);
	}

	// �ݹ��������
	private void inorderTraverseData(Node<T> node) {
		if (node.left != null) {
			inorderTraverseData(node.left);
		}
		System.out.print(node.data + "��");
		if (node.right != null) {
			inorderTraverseData(node.right);
		}
	}

}
