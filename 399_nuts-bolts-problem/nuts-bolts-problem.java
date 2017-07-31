/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        int n = nuts.length;
        int left = 0;
        while (left < n) {
            while (left < n && compare.cmp(nuts[left], bolts[left]) == 0) {
                left++;
            }
            int right = left + 1;
            while (right < n && compare.cmp(nuts[left], bolts[right]) != 0) {
                right++;
            }
            if (right < n) {
                swap(bolts, left++, right);
            }
        }
    }

    public void swap(String[] bolts, int i, int j) {
        String tmp = bolts[i];
        bolts[i] = bolts[j];
        bolts[j] = tmp;
    }
};

// 给定一组 n 个不同大小的 nuts 和 n 个不同大小的 bolts。nuts 和 bolts 一一匹配。
// 不允许将 nut 之间互相比较，也不允许将 bolt 之间互相比较。也就是说，只许将 nut 与 bolt 进行比较，
// 或将 bolt 与 nut 进行比较。请比较 nut 与 bolt 的大小。
//
// 样例
// 给出 nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC']
// 你的程序应该找出bolts和nuts的匹配。
// 一组可能的返回结果是：
// nuts = ['ab','bc','dd','gg'], bolts = ['AB','BC','DD','GG']
// 我们将给你一个匹配的比较函数，如果我们给你另外的比较函数，可能返回的结果是：
// nuts = ['ab','bc','dd','gg'], bolts = ['BC','AB','DD','GG']
//
// 因此的结果完全取决于比较函数，而不是字符串本身。
// 因为你必须使用比较函数来进行排序。
// 各自的排序当中nuts和bolts的顺序是无关紧要的，只要他们一一匹配就可以。
