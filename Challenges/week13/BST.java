
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

  public Object min() {
    if (this.root == null) {
      return null;
    }

    BTNode runner = this.root;

    while (runner.right != null) {
      runner = runner.right;
    }
    return runner.value;
  }

  public Object max() {
    if (this.root == null) {
      return null;
    }

    BTNode runner = this.root;

    while (runner.left != null) {
      runner = runner.left;
    }
    return runner.value;
  }

  public boolean contains(int value) {
    boolean found = false;

    if (this.root == null) {
      return found;
    }

    BTNode runner = this.root;
    while (runner != null) {
      if (runner.value == value) {
        return true;
      }
      if (value >= runner.value) {
        runner = runner.right;
      } else {
        runner = runner.left;
      }

    }

    return found;
  }

  public int size() {
    return size(this.root);
  }

  private int size(BTNode node) {
    if (node == null) {
      return 0;
    }
    return size(node.left) + size(node.right) + 1;
  }

  public int length() {
    return length(this.root);
  }

  private int length(BTNode node) {
    if (node == null) {
      return 0;
    }
    return Math.max(1 + size(node.left), 1 + size(node.right));
  }
}
