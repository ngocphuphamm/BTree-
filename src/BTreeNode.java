
public class BTreeNode {
    int[] keys;
    int minimumDegree;
    BTreeNode[] children;
    int currentNumberOfKeys;
    boolean leaf;

    public BTreeNode(int minimumDegree, boolean leaf){
        this.minimumDegree = minimumDegree;
        this.leaf = leaf;
        this.keys = new int[CommonUtil.getNumberOfMaximumKey(minimumDegree)];
        this.children = new BTreeNode[CommonUtil.getNumberOfMaximumChildren(minimumDegree)];
        this.currentNumberOfKeys = 0;
    }

    public void splitChild(int childIndex, BTreeNode treeNode){
        BTreeNode newTreeNode = new BTreeNode(treeNode.minimumDegree, treeNode.leaf);
        int numberOfMaximumChildren = CommonUtil.getNumberOfMaximumChildren(minimumDegree);
        newTreeNode.currentNumberOfKeys = numberOfMaximumChildren;

        // sao chép những keys cuối từ treeNode đến newNode
        // những key còn lại sẽ ở lại với tree node cux
        // Sao chép các con trỏ con: Vòng lặp for chạy từ 0 đến t-1
        copyKeys(treeNode, newTreeNode, minimumDegree);

        // nếu tree node không phải là leafnode sẽ cần sao chép các con trỏ con từ
        // treeNode  đầy sang treeNode mới
        if(!treeNode.leaf){
            // Sao chép các con trỏ con: Vòng lặp for chạy từ 0 đến t-1
            copyChildren(treeNode, newTreeNode, minimumDegree);
        }

        // reset number of keys at treenode old
        treeNode.currentNumberOfKeys = numberOfMaximumChildren;

        //
        insertChild(childIndex, newTreeNode);
    }

    private void copyChildren(BTreeNode sourceNode, BTreeNode targetNode, int minimumDegree) {
        for (int childIndex = 0; childIndex < minimumDegree; childIndex++) {
            int index = childIndex + minimumDegree;
            targetNode.children[childIndex] = sourceNode.children[index];
        }
    }

    private void copyKeys(BTreeNode sourceNode, BTreeNode targetNode, int minimumDegree) {
        for (int keyIndex = 0; keyIndex < CommonUtil.getNumberOfMinimumKeyInANode(minimumDegree); keyIndex++) {
            int index = keyIndex + minimumDegree;
            targetNode.keys[keyIndex] = sourceNode.keys[index];
        }
    }

    private void insertChild(int childIndex, BTreeNode newTreeNode) {
        for (int j = currentNumberOfKeys; j >= childIndex + 1; j--) {
            children[j + 1] = children[j];
        }
        children[childIndex + 1] = newTreeNode;
    }


}
