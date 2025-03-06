package implementasi;

import java.util.Date;

public class TreeExit {

    private NodeExit root;

    public NodeExit getRoot() {
        return root;
    }


    public NodeExit find(int ticketNumber) {
        NodeExit current = root;
        while (current != null && current.ticketNumber != ticketNumber) {
            if (ticketNumber < current.ticketNumber) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int ticketNumber, String plat, String type, String entryTime, String exitTime, long duration, long tarif) {
        NodeExit newNode = new NodeExit(ticketNumber, plat, type, entryTime, exitTime, duration, tarif);

        if (root == null) {
            root = newNode;
        } else {
            NodeExit current = root;
            NodeExit parent;
            while (true) {
                parent = current;
                if (ticketNumber < current.ticketNumber) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }
    public boolean delete(int key) {
        NodeExit current = root;
        NodeExit parent = root;
        boolean isLeftChild = true;
        while (current.ticketNumber != key) {
            parent = current;
            if (key < current.ticketNumber) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null
                && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            NodeExit successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private NodeExit getSuccessor(NodeExit delNode) {
        NodeExit successorParent = delNode;
        NodeExit successor = delNode;
        NodeExit current = delNode.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
         public void displayTree() {
        StackExit globalStack = new StackExit();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "............................................");
        while (isRowEmpty == false) {
            StackExit localStack = new StackExit();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(' ');
            }
            while (globalStack.isEmpty() == false) {
                NodeExit temp = (NodeExit) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.ticketNumber);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null
                            || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {

                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(' ');
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println(
                "............................................");
    }
}
