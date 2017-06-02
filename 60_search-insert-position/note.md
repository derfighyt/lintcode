```
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/search-insert-position
@Language: Markdown
@Datetime: 17-05-27 08:46
```

如果用小于做循环条件，指针不会溢出，但是最后要判断指针重合时元素大小，改成用小于等于作条件，指针会溢出，但是最后只需要返回end+1即可