import java.util.Scanner;

public class ArbolBinarioAVL {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AVLTree avl = new AVLTree();
        
        System.out.print("Ingrese la cantidad de números a agregar: ");
        int n = sc.nextInt();
        System.out.println("Ingrese los números uno por uno:");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            avl.insert(num);
        }
        
        System.out.println("\nÁrbol Equilibrado AVL: " + avl.isAVL());
        
        System.out.print("\nRecorrido en Preorden: ");
        avl.preorder();
        System.out.print("\nRecorrido en Inorden: ");
        avl.inorder();
        System.out.print("\nRecorrido en Postorden: ");
        avl.postorder();
        
        System.out.println("\n\nAltura del Árbol AVL: " + avl.height());
        
        System.out.print("\nNodos Hoja del Árbol: ");
        avl.leaves();
    }
}

class AVLTree {
    private Node root;

    private class Node {
        int data;
        Node left;
        Node right;
        int height;
        int balanceFactor;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    public void insert(int data) {
        this.root = insert(this.root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }

        update(node);

        return balance(node);
    }

    private void update(Node node) {
        int leftHeight = (node.left == null) ? 0 : node.left.height;
        int rightHeight = (node.right == null) ? 0 : node.right.height;

        node.height = Math.max(leftHeight, rightHeight) + 1;
        node.balanceFactor = rightHeight - leftHeight;
    }

    private Node balance(Node node) {
        if (node.balanceFactor == -2) {
            if (node.left.balanceFactor <= 0) {
                return leftLeftCase(node);
            } else {
                return leftRightCase(node);
            }
        } else if (node.balanceFactor == 2) {
            if (node.right.balanceFactor >= 0) {
                return rightRightCase(node);
            } else {
                return rightLeftCase(node);
            }
        }

        return node;
    }

    private Node leftLeftCase(Node node) {
        return rightRotation(node);
    }

    private Node leftRightCase(Node node) {
        node.left = leftRotation(node.left);
        return leftLeftCase(node);
    }

    private Node rightRightCase(Node node) {
        return leftRotation(node);
    }

    private Node rightLeftCase(Node node) {
        node.right = rightRotation(node.right);
        return rightRightCase(node);
    }

    private Node leftRotation(Node node) {
        Node newParent = node.right;
        node.right = newParent.left;
        newParent.left = node;
        update(node);
        update(newParent);
        return newParent;
    }
    
private Node rightRotation(Node node) {
    Node newParent = node.left;
    node.left = newParent.right;
    newParent.right = node;
    update(node);
    update(newParent);
    return newParent;
}

public boolean isAVL() {
    return isAVL(this.root);
}

private boolean isAVL(Node node) {
    if (node == null) {
        return true;
    }

    int balanceFactor = node.balanceFactor;
    if (balanceFactor < -1 || balanceFactor > 1) {
        return false;
    }

    return isAVL(node.left) && isAVL(node.right);
}

public void preorder() {
    preorder(this.root);
}

private void preorder(Node node) {
    if (node != null) {
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }
}

public void inorder() {
    inorder(this.root);
}

private void inorder(Node node) {
    if (node != null) {
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }
}

public void postorder() {
    postorder(this.root);
}

private void postorder(Node node) {
    if (node != null) {
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }
}

public int height() {
    return height(this.root);
}

private int height(Node node) {
    if (node == null) {
        return 0;
    }

    return node.height;
}

public void leaves() {
    leaves(this.root);
    System.out.println();
}

private void leaves(Node node) {
    if (node != null) {
        if (node.left == null && node.right == null) {
            System.out.print(node.data + " ");
        } else {
            leaves(node.left);
            leaves(node.right);
        }
    }
}
}
