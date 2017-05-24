```
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/two-sum-input-array-is-sorted
@Language: Markdown
@Datetime: 17-05-22 05:44
```

遍历一次，用一个map记录每个数的位置，以及和它相加等于target的数
如果map里已经存在当前数且位置是0，说明找到答案了
这里漏掉了几种情况：
* 连续两个数相等，这时需要判断位置，如果大于0则抛弃当前数
* 当前数正好是target的一半，导致位置被0覆盖了

保存位置的时候，key换成target - nums[i]就可以避免覆盖