public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        //树有唯一的父节点，所以除根节点外所有节点入度为1，但无向图没有入度
        //图必有环？如果所有节点都连通，无环就是树，有环就是图，否则有孤立节点就是图
        int[] degree = new int[n];
        int[] nodes = new int[n];
        int color = 0;
    }
}

// 给出 n 个节点，标号分别从 0 到 n - 1 并且给出一个 无向 边的列表 (给出每条边的两个顶点),
// 写一个函数去判断这张｀无向｀图是否是一棵树
//
//  注意事项
//
// 你可以假设我们不会给出重复的边在边的列表当中. 无向边　[0, 1] 和 [1, 0]　是同一条边，
// 因此他们不会同时出现在我们给你的边的列表当中。
// 样例
// 给出n = 5 并且 edges = [[0, 1], [0, 2], [0, 3], [1, 4]], 返回 true.
//
// 给出n = 5 并且 edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], 返回 false.
