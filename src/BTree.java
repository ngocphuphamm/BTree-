public class BTree {
    BTreeNode root;
    int minimumDegree;

    public BTree(int minimumDegree){
        this.root = null;
        this.minimumDegree = minimumDegree;
    }

    public void insert(int key){
        if(root == null) {
            initNode(key);
            return;
        }
        insertNode(key);
    }

    private void insertNode(int key){
        boolean isMaximumKeys = root.currentNumberOfKeys == CommonUtil.getNumberOfMaximumKey(minimumDegree);

        if(isMaximumKeys){
            boolean noneIsLeafNode = false;
            BTreeNode bTreeNode = new BTreeNode(key, noneIsLeafNode);
            bTreeNode.children[0] = root;
            bTreeNode.splitChild(0, root);
        }
    }

    private void initNode(int key) {
        boolean isLeafNode = true;
        root = new BTreeNode(minimumDegree, isLeafNode);
        root.keys[0] = key;
        root.currentNumberOfKeys = 1;
    }



}
