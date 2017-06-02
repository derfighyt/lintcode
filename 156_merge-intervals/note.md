```
@Copyright:LintCode
@Author:   derfy
@Problem:  http://www.lintcode.com/problem/merge-intervals
@Language: Markdown
@Datetime: 17-05-25 08:22
```

因为不确定输入是否有序，所以一开始就想到要排序，用Collections.sort，但是Interval类没实现接口，没法用，看答案才发现sort还有个同名方法接受额外实现的排序器，不需要破坏类结构也能排序，对java基础还是不太熟啊。