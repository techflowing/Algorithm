package win.techflowing.tree.huffman;


import java.util.Comparator;
import java.util.List;

/**
 * 哈夫曼树
 * 主要思想：
 * (1)对List集合中所有节点进行排序
 * (2)找出List集合中权值最小的两个节点
 * (3)以权值最小的两个节点作为子节点创建新节点
 * (4)从List集合中删除权值最小的两个节点，将新节点添加到List集合中
 */
public class HuffmanTree {

    /**
     * 构造哈夫曼树
     *
     * @param nodes 节点集合
     * @return 构造出来的哈夫曼树的根节点
     */
    private Node createTree(List<Node> nodes) {
        // 只要nodes数组中还有2个以上的节点
        while (nodes.size() > 1) {
            nodes.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o2.weight - o1.weight;
                }
            });
            // 获取权值最小的两个节点
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            // 生成新节点，新节点的权值为两个子节点的权值之和
            Node parent = new Node<>(null, left.weight + right.weight);
            // 让新节点作为权值最小的两个节点的父节点
            parent.leftChild = left;
            parent.rightChild = right;
            // 删除权值最小的两个节点
            nodes.remove(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            // 将新生成的父节点添加到集合中
            nodes.add(parent);
        }
        // 返回nodes集合中唯一的节点，也就是根节点
        return nodes.get(0);
    }

    /**
     * 哈夫曼树节点
     */
    public class Node<T> {
        T data;
        int weight;
        Node leftChild;
        Node rightChild;

        public Node(T data, int weight) {
            this.data = data;
            this.weight = weight;
        }
    }
}
