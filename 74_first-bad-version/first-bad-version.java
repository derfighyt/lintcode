/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        //标准二分
        //原来是考察溢出。。。递归会overflow，正常二分会超时
        int start = 1, end = n;
        while (start + 1 < end) {
            if (SVNRepo.isBadVersion(start)) {
                return start;
            }
            int mid = start + (end - start) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (SVNRepo.isBadVersion(start)) {
            return start;
        } else {
            return end;
        }
    }
}
