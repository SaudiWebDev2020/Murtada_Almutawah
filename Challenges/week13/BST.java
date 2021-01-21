
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

  public int height() {
    return height(this.root);
  }

  private int height(BTNode node) {
    if (node == null) {
      return 0;
    }
    return 1 + Math.max(height(node.left), height(node.right));
  }

  public boolean isBalanced() {
    return isBalanced(this.root);
  }

  private boolean isBalanced(BTNode node) {
    if (node == null) {
      return true;
    } else {
      int rHeight = height(node.right);
      int lHeight = height(node.left);
      if (Math.abs(rHeight - lHeight) > 1) {
        System.out.println(node.value + " isn't balanced");
        return false;
      } else {
        System.out.println(node.value + " is balanced");
        return isBalanced(node.right) && isBalanced(node.left);
      }
    }

  }

  private void lRotate(BTNode node) {
    System.out.println(node.value + " shall be on right" + node.right.value + "  should be on top");

    return;
  }

  // balance & full & complacence
}
