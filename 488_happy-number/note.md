```
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/happy-number
@Language: Markdown
@Datetime: 17-05-22 06:22
```

1. hash不光是hashmap，还有hashset，一提到hash就习惯使用map来保存，浪费空间，对set还是不熟，不常使用
2. 第一遍出错是使用递归，忘了递归的时候无法保存中间结果
3. 把题目想得太复杂了，标准答案也是用死循环
4. 不用非把代码写在要求的地方，自己建方法，类变量也没问题。