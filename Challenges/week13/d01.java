
class d01 {
  public static void main(String[] args) {
    BST binarySearchTree = new BST();
    binarySearchTree.print();

    binarySearchTree.add(100);
    binarySearchTree.print();

    binarySearchTree.add(110);
    binarySearchTree.add(120);
    binarySearchTree.add(130);
    binarySearchTree.add(99);
    binarySearchTree.add(9);
    binarySearchTree.print();

  }
}