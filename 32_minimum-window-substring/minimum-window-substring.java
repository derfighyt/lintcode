public class Solution {
    /*
     * @param : A string
     * @param : A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here
        int n = source.length();
        int m = target.length();
        Map<Character, Integer> bMap = new HashMap();
        for (char c : target.toCharArray()) {//统计target中字符
            if (!bMap.containsKey(c)) {
                bMap.put(c, 0);
            }
            bMap.put(c, bMap.get(c) + 1);
        }

        Map<Character, Integer> aMap = new HashMap();
        int minLength = Integer.MAX_VALUE; //满足条件的子串的最小长度
        int count = 0; //在target里的字母计数
        int start = 0; //起始位置
        int end = 0; //结束位置
        String result = "";
        for (int i = 0; i < n; i++) {//统计source中字符
            char c = source.charAt(i);
            if (bMap.containsKey(c)) { //字母出现在target里
                if (!aMap.containsKey(c)) {
                    aMap.put(c, 0);
                }
                aMap.put(c, aMap.get(c) + 1);
                if (aMap.get(c) <= bMap.get(c)) {//计数
                    count++;
                }
                if (count == m) {//target的字母已经全部找到了,开始定位起始位置
                    int j = start;
                    while (j < i) {
                        c = source.charAt(j);
                        if (aMap.containsKey(c)) {
                            if (aMap.get(c) == bMap.get(c)) {
                                break;
                            } else {
                                aMap.put(c, aMap.get(c) - 1);
                                start = j + 1;
                            }
                        }
                        j++;
                    }
                    if (i - j + 1 < minLength) {
                        minLength = i - j + 1;
                        result = source.substring(j, i + 1);
                    }
                }
            }
        }
        return result;
    }
};
// 给定一个字符串source和一个目标字符串target，在字符串source中找到包括所有目标字符串字母的子串。
//
//  注意事项
//
// 如果在source中没有这样的子串，返回""，如果有多个这样的子串，返回起始位置最小的子串。
//
// 说明
// 在答案的子串中的字母在目标字符串中是否需要具有相同的顺序？
//
// ——不需要。
//
// 样例
// 给出source = "ADOBECODEBANC"，target = "ABC" 满足要求的解  "BANC"
//
// 挑战
// 要求时间复杂度为O(n)
