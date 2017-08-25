/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
    }
}

// 给定一个有向图，图节点的拓扑排序被定义为：
//
// 对于每条有向边A--> B，则A必须排在B之前　　
// 拓扑排序的第一个节点可以是任何在图中没有其他节点指向它的节点　　
// 找到给定图的任一拓扑排序
//
//  注意事项
//
// 你可以假设图中至少存在一种拓扑排序
//
// 样例
// 对于下列图：
//
//
//
// 这个图的拓扑排序可能是：
//
// [0, 1, 2, 3, 4, 5]
//
// 或者
//
// [0, 2, 3, 1, 5, 4]
//
// 或者
//
// ....
//
// 挑战
// 能否分别用BFS和DFS完成？
