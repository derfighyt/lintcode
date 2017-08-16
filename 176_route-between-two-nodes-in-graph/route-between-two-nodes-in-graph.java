/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        Set<DirectedGraphNode> set = new HashSet();
        Queue<DirectedGraphNode> queue = new LinkedList();
        queue.add(s);
        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            if (node == t) {
                return true;
            }
            set.add(node);
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (!set.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }
}

// 给出一张有向图，设计一个算法判断两个点 s 与 t 之间是否存在路线。
//
// 样例
// 如下图:
//
// A----->B----->C
//  \     |
//   \    |
//    \   |
//     \  v
//      ->D----->E
// for s = B and t = E, return true
//
// for s = D and t = C, return false
