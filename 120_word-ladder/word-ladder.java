public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        // 构建图，求一个点到另一个点的最短路径
        if (start.equals(end)) {
            return 1;
        }
        int n = start.length();
        Map<String, Integer> map = new HashMap();
        for (String str : dict) { //初始化，start到每个单词的距离都是最大
            map.put(str, Integer.MAX_VALUE);
        }
        Queue<String> queue = new LinkedList();
        queue.add(start);
        map.put(start, 1);
        map.put(end, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            String str = queue.poll();//找到所有距离当前节点为1的节点
            int distance = map.get(str);
            for (String word : map.keySet()) {
                if (oneDistance(str, word) && map.get(word) > distance + 1) {
                    map.put(word, distance + 1);
                    queue.add(word);
                }
            }
        }

        int result = map.get(end);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public boolean oneDistance(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        if (count == 1) {
            return true;
        } else {
            return false;
        }
    }

    public String replace(String str, int p, char c) {
        return str.substring(0, p) + c + str.substring(p + 1);
    }
}
// 给出两个单词（start和end）和一个字典，找到从start到end的最短转换序列
// 比如：
// 每次只能改变一个字母。
// 变换过程中的中间单词必须在字典中出现。
//
//  注意事项
//
// 如果没有转换序列则返回0。
// 所有单词具有相同的长度。
// 所有单词都只包含小写字母。
//
// 样例
// 给出数据如下：
//
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]
// 一个最短的变换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog"，
//
// 返回它的长度 5
