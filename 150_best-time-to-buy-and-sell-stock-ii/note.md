```
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/best-time-to-buy-and-sell-stock-ii
@Language: Markdown
@Datetime: 17-05-31 07:34
```

上一题只需要找一次交易，所以记录最大收益和最小值。
这次需要找到多次交易产生的最大收益，其实等于遍历时每前进一位，都判断一下是否产生了收益，产生就加到总收益里，而最小值每次都等于当前数。也就是每移动一位都尝试进行一次交易。