class d04 {
  public static void main(String[] args) {
    BST binarySearchTree = new BST();

    binarySearchTree.add(100);

    binarySearchTree.add(110);
    binarySearchTree.add(120);
    binarySearchTree.add(130);
    binarySearchTree.add(99);
    binarySearchTree.add(9);
    binarySearchTree.add(9);
    binarySearchTree.print();
    System.out.println(binarySearchTree.isBalanced());
    binarySearchTree.print();

  }
}