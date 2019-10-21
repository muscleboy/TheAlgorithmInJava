package xyz.bugcoder.tree;

import java.util.*;

/**
 * Create with IDEA.
 *
 * @Package: xyz.bugcoder.tree
 * @Description: 哈夫曼编码与解码
 * @Date: 2019-10-21 19:40
 * @Author: Wyj
 */
public class HuffmanEncodeAndDecode {

    // 内部类节点，实现可排序接口
    static class Node implements Comparable<Node>{

        Byte data;
        int weight;
        Node left;
        Node right;

        public Node(Byte data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }

        // 排序
        @Override
        public int compareTo(Node o) {
            // 倒序
            return -(this.weight - o.weight);
        }
    }

    /** 
    * @Description: 创建哈夫曼树 
    * @Param: [nodes] 
    * @return: xyz.bugcoder.tree.HuffmanEncodeAndDecode.Node
    */ 
    public static Node createHuffmanTree(List<Node> nodes){
        
        while (nodes.size() > 1){
            
            // 排序
            Collections.sort(nodes);
            // 取出最大的2个，创建成2颗二叉树(只有根结点的二叉树)
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            // 合并这两科二叉树
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            // 从List中删除掉取出来的2颗二叉树
            nodes.remove(left);
            nodes.remove(right);
            // 将合并好的二叉树放入List中
            nodes.add(parent);
        }
        
        return nodes.get(0);
    }

    /** 
    * @Description: 哈夫曼压缩 
    * @Param: [bytes] 
    * @return: byte[]
    */ 
    private static byte[] huffmanZip(byte[] bytes){

        // 统计每一个byte出现的次数，并放入集合中
        List<Node> nodes = getNodes(bytes);
        // 创建哈夫曼树
        Node tree = createHuffmanTree(nodes);
        // 创建哈夫曼编码表
        Map<Byte, String> huffCodes = getCodes(tree);
        // 编码
        byte[] b = zip(bytes, huffCodes);
        return b;
    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffCodes.getClass());
        }
        int len;
        if (sb.length() % 8 == 0){
            len = sb.length()/8;
        }else {
            len = sb.length()/8 + 1;
        }
        // 存储压缩后的byte
        byte[] by = new byte[len];
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String byteStr;
            if (i + 8 > sb.length()){
                byteStr = sb.substring(i);
            }else {
                byteStr = sb.substring(i, i + 8);
            }
        }

        return by;
    }

    // 临时存储路径
    static StringBuilder sb = new StringBuilder();
    // 存储哈夫曼编码
    static Map<Byte, String> huffCodes = new HashMap<>();

    private static Map<Byte, String> getCodes(Node tree) {

        if (tree == null){

            return null;
        }
        getCodes(tree.left, "0", sb);
        getCodes(tree.right, "1", sb);

        return huffCodes;
    }

    private static void getCodes(Node node, String code, StringBuilder sb) {

        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.data == null){
            // 往左为0
            getCodes(node.left, "0", sb2);
            // 往右为1
            getCodes(node.right, "1", sb2);
        }else {
             huffCodes.put(node.data, sb2.toString());
        }
    }

    /**
    * @Description: 将byte数组转换成List<Node>
    * @Param: [bytes]
    * @return: java.util.List<xyz.bugcoder.tree.HuffmanEncodeAndDecode.Node>
    */
    private static List<Node> getNodes(byte[] bytes) {

        List<Node> nodes = new ArrayList<>();
        // 存储每个byte出现的次数
        Map<Byte, Integer> counts = new HashMap<>();
        // 统计每个byte出现的次数
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null)
                counts.put(b, 1);
            else
                counts.put(b, count + 1);
        }
        // 遍历每一个键值对，添加到List中
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }

        return nodes;
    }

    public static void main(String[] args) {

        String msg = "can you can a can as a can canner can a can.";
        byte[] bytes = msg.getBytes();
        byte[] b = huffmanZip(bytes);
        System.out.println(bytes.length);
        System.out.println(b.length);
    }

}
