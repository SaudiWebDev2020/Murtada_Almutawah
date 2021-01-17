
class BST {
  public BTNode root;

  public BST() {
    this.root = null;
  }

  public void add(int value) {
    BTNode newNode = new BTNode(value);

    if (this.root == null) {
      this.root = newNode;
      return;
    } else {

      BTNode runner = this.root;

      while (runner != null) {
        if (value >= runner.value) {
          if (runner.right == null) {
            break;
          }
          runner = runner.right;
        } else {
          if (runner.left == null) {
            break;
          }
          runner = runner.left;
        }
      }
      if (value >= runner.value) {
        runner.right = newNode;
      } else {
        runner.left = newNode;
      }
    }
  }

  public void print() {
    print(this.root);
    System.out.println();
  }

  private void print(BTNode node) {
    if (node == null) {
      return;
    }

    this.print(node.left);
    System.out.printf("%d ", node.value);
    this.print(node.right);
  }

}