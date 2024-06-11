
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
        for(int keyIndex = 0; keyIndex < numberOfMaximumChildren; keyIndex++){
            // sao chép các keys from t -> 2t - 1;
            int index = keyIndex + minimumDegree;
            newTreeNode.keys[keyIndex] = treeNode.keys[index];
        }


        // nếu tree node không phải là leafnode sẽ cần sao chép các con trỏ con từ
        // treeNode  đầy sang treeNode mới
        if(!treeNode.leaf){
            // Sao chép các con trỏ con: Vòng lặp for chạy từ 0 đến t-1
            for(int keyIndex = 0; keyIndex < minimumDegree; keyIndex++){
                // sao chép các  node from t -> 2t - 1;
                int index =  keyIndex + minimumDegree;
                newTreeNode.children[keyIndex] = treeNode.children[index];
            }
        }

        // reset number of keys at treenode old
        treeNode.currentNumberOfKeys = numberOfMaximumChildren;

        // currentNumberOfKeys số number keys của parentNode
        // keyIndex at treeNode
        for(int keyIndex = currentNumberOfKeys; keyIndex >= childIndex + 1; keyIndex--){

        }
    }

}
