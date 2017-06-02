```
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Markdown
@Datetime: 17-05-25 08:48
```

是个比较简单的小题目，陷阱在于如果从前往后归并，A需要挪动较多的元素，为了减少挪动次数最佳方案是从后往前归并。