==**笔者只是大二的的学狗而已，所以对于编程还是处于小白阶段，如果大佬发现问题，或者觉得程序和想法有优化的，欢迎指正。**==
#### 一、 题目及运行情况：
![题目](https://img-blog.csdnimg.cn/2020012421513878.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0OTE0NjUx,size_16,color_FFFFFF,t_70)
![运行情况](https://img-blog.csdnimg.cn/20200124215545412.png)
#### 二、想法
拿到题目的第一想法是使用==二维数组==，先将结果储存，然后照着顺序输出就可。但转念一想，为何不直接找到每一行的规律，直接输出就好，省了时间可空间，而且可以更简单的完成题目。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200124223258802.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ0OTE0NjUx,size_16,color_FFFFFF,t_70)
因为字母不方便我们观察，我使用了数字来展示字符串的顺序排列。

我发现我们可以把整个排列方式分成==n + 1==组，前n组有一列竖列，一列斜列组成，总共（2 * numRows - 2）个元素因为有可能出现==不满足一组的情况==存在，所以最后一组需要考虑空指针的情况。

又可以观察出来，对于每m行，我们都需要需要输出竖列，而在==2 到 m-1行==才需要输出斜列。所以我们在读取时就需要==双层for循环==，外层控制要读取的行，内层控制我们之前分的n+1组。

对于程序，我主要着重构思内层。当读取第一行和最后一行的时候，跳过斜行的输出，还要判断最后一组元素不足时的索引越界问题，其他问题都很简单。

#### 三、源程序代码
下面是我的源码，有什么建议欢迎踊跃提出。

```java
class Solution {
    public String convert(String s, int numRows) {
        if (s.length() == 0||numRows == 1) return s;
        StringBuilder newString = new StringBuilder();
        //完整一组的数量
        int num = s.length() / (2 * numRows - 2);
        //要添加的元素编号    
        int add;   
        //外层for读取每一行
        for (int i = 1; i <= numRows; i++) {
        	//内层for读取n+1组
            for (int j = 1; j <= num + 1; j++) {
            	//计算要添加的元素序号
            	add = (2 * numRows - 2) * (j - 1) + i;                
                if (add > s.length())  break;
                //读取竖列元素
                newString.append(s.charAt(add - 1));    
                //输出斜列，跳过1和n行
                if (i != 1 && i != numRows) {
                    add = (2 * numRows - 2) * j - i + 2; 
                    //判断越界
                    if (add > s.length())  break;
                    //读取斜列元素
                    newString.append(s.charAt(add - 1));
                }
            }
        }
        return newString.toString(); 
    }
}
```

​		

