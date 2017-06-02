```
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix
@Language: Markdown
@Datetime: 17-06-02 02:59
```

先对行做二分，然后对列做二分
因为数组整体有序，所以也可以抽象成一维数组做一次二分即可。