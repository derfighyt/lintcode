```
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/subarray-sum
@Language: Markdown
@Datetime: 17-05-22 09:40
```

hash解法是用map记录从0开始到每个位置的累加和，如果这个数值在map里出现过，说明从出现的位置到当前位置之间的数字相加为0，对于数字为0的情况要特殊处理