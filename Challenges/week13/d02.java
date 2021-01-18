class d02 {
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

    System.out.println(binarySearchTree.min());
    System.out.println(binarySearchTree.max());
    System.out.println(binarySearchTree.contains(100));
    System.out.println(binarySearchTree.size());
    System.out.println(binarySearchTree.length());

    System.out.println("********");

    BST binarySearchEmpty = new BST();

    System.out.println(binarySearchEmpty.min());
    System.out.println(binarySearchEmpty.max());
    System.out.println(binarySearchEmpty.contains(100));
    System.out.println(binarySearchEmpty.size());
    System.out.println(binarySearchEmpty.length());

  }
}