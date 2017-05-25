```
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/number-of-airplanes-in-the-sky
@Language: Markdown
@Datetime: 17-05-24 03:18
```

V1： 思路是第一次遍历记录每个元素的start和end，同时统计出最大最小值。第二次遍历最大最小值的区间，计算每个点的元素数量，并用一个max来保存最大值。

V2：改成了数组实现，虽然要对两个数组做排序，但实际耗时减少了，空间开销也少了。
