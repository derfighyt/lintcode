/*
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/hash-function
@Language: Java
@Datetime: 17-05-22 07:24
*/

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long result = 0;
        for (int i = 0; i < key.length; i++) {
            result = (result * 33 + (int)(key[i])) % HASH_SIZE ;
        }
        return (int)result;
    }
};