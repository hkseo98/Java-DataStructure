package SearchTree;

public class AVLTree {

    private static class Node {
        Node left, right;
        Node parent;
        int key;
        int height = 0;
        Object value;

        public Node(int data, Node parent, Object value) {
            this.key = data;
            this.parent = parent;
            this.value = value;
        }

        @Override
        public String toString() {
            return "key: " + key + ", height: " + height + ", value: " + value + ", parent: " + (parent == null ?
                    "NULL" : parent.key) + " // ";
        }

        void setLeftChild(Node child) {
            if (child != null) {
                child.parent = this;
            }

            this.left = child;
        }

        void setRightChild(Node child) {
            if (child != null) {
                child.parent = this;
            }

            this.right = child;
        }
    }

    private Node root = null;

    public void insert(int data, Object value) {
        insert(root, data, value);
    }

    private int height(Node node) {
        return node == null ? -1 : node.height;
    }

    private void insert(Node node, int key, Object value) {
        if (root == null) {
            root = new Node(key, null, value);
            return;
        }

        if (key < node.key) {
            if (node.left != null) {
                insert(node.left, key, value);
            } else {
                node.left = new Node(key, node, value);
            }

            if (height(node.left) - height(node.right) == 2) { // 왼쪽과 오른쪽의 높이가 2이상이면 재배
                if (key < node.left.key) {
                    rotateRight(node);
                } else {
                    rotateLeftThenRight(node);
                }
            }
        } else if (key > node.key) {
            if (node.right != null) {
                insert(node.right, key, value);
            } else {
                node.right = new Node(key, node, value);
            }

            if (height(node.right) - height(node.left) == 2) { 
                if (key > node.right.key)
                    rotateLeft(node);
                else {
                    rotateRightThenLeft(node);
                }
            }
        }

        reHeight(node); // 키 초기화
    }

    private void rotateRight(Node pivot) {
        Node parent = pivot.parent;
        Node leftChild = pivot.left;
        Node rightChildOfLeftChild = leftChild.right;
        pivot.setLeftChild(rightChildOfLeftChild);
        leftChild.setRightChild(pivot);
        if (parent == null) {
            this.root = leftChild;
            leftChild.parent = null;
            return;
        }

        if (parent.left == pivot) {
            parent.setLeftChild(leftChild);
        } else {
            parent.setRightChild(leftChild);
        }

        reHeight(pivot);
        reHeight(leftChild);
    }

    private void rotateLeft(Node pivot) {
        Node parent = pivot.parent;
        Node rightChild = pivot.right;
        Node leftChildOfRightChild = rightChild.left;
        pivot.setRightChild(leftChildOfRightChild);
        rightChild.setLeftChild(pivot);
        if (parent == null) {
            this.root = rightChild;
            rightChild.parent = null;
            return;
        }

        if (parent.left == pivot) {
            parent.setLeftChild(rightChild);
        } else {
            parent.setRightChild(rightChild);
        }

        reHeight(pivot);
        reHeight(rightChild);
    }

    private void reHeight(Node node) { // 키 계
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private void rotateLeftThenRight(Node node) {
        rotateLeft(node.left);
        rotateRight(node);
    }

    private void rotateRightThenLeft(Node node) {
        rotateRight(node.right);
        rotateLeft(node);
    }

    public boolean delete(int key) {
        Node target = search(key);
        if (target == null) return false;
        target = deleteNode(target);
        balanceTree(target.parent);
        return true;
    }

    private Node deleteNode(Node target) {
        if (isLeaf(target)) { // 리프노트면 그냥 삭제
            if (isLeftChild(target)) {
                target.parent.left = null;
            } else {
                target.parent.right = null;
            }
        } else if (target.left == null ^ target.right == null) { // 하나의 자식만 있을 때 
            Node nonNullChild = target.left == null ? target.right : target.left; 
            if (isLeftChild(target)) {
                target.parent.setLeftChild(nonNullChild); // 하나 남은 자식을 붙여줌
            } else {
                target.parent.setRightChild(nonNullChild);
            }
        } else { // 자식이 둘일 때
            Node immediatePredInOrder = immediatePredInOrder(target); // 왼쪽 자식의 맨 오른쪽 자식을 타겟에 복사한 후 
            target = immediatePredInOrder;
            target = deleteNode(immediatePredInOrder); // 왼쪽 자식의 맨 오른쪽 자식을 삭제 
        }

        reHeight(target.parent);
        return target;
    }

    private Node immediatePredInOrder(Node node) { 
        Node current = node.left; 
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    private boolean isLeftChild(Node child) {
        return (child.parent.left == child);
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    private int calDifference(Node node) { // 좌우 자식의 키 차이 계산 
        int rightHeight = height(node.right);
        int leftHeight = height(node.left);
        return rightHeight - leftHeight;
    }

    private void balanceTree(Node node) {
        int difference = calDifference(node);
        Node parent = node.parent;
        if (difference == -2) {
            if (height(node.left.left) >= height(node.left.right)) {
                rotateRight(node);
            } else {
                rotateLeftThenRight(node);
            }
        } else if (difference == 2) {
            if (height(node.right.right) >= height(node.right.left)) {
                rotateLeft(node);
            } else {
                rotateRightThenLeft(node);
            }
        }

        if (parent != null) {
            balanceTree(parent);
        }

        reHeight(node);
    }

    public Node search(int key) {
        return binarySearch(root, key);
    }

    private Node binarySearch(Node node, int key) { // 재귀적으로 노드 탐색
        if (node == null) return null;

        if (key == node.key) {
            return node;
        }

        if (key < node.key && node.left != null) {
            return binarySearch(node.left, key);
        }

        if (key > node.key && node.right != null) {
            return binarySearch(node.right, key);
        }

        return null;
    }

    public void traverseInOrder() {
        System.out.println("ROOT " + root.toString());
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.toString());
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree avl = new AVLTree();
        avl.insert(1, "hi");
//        avl.traverseInOrder();
        avl.insert(2, "Wow");
//        avl.traverseInOrder();
        avl.insert(3, "zzz");
//        avl.traverseInOrder();
        avl.insert(4, "rr");
        avl.delete(1);
        avl.delete(2);
        avl.insert(7, "yoyo");
        avl.insert(9, "skr");
        avl.delete(3);
//        avl.traverseInOrder();
        avl.traverseInOrder();

    }

}