package study.Object;



public class demo02_equals{

    public static void main(String[] args) {
        /*
        person类默认继承了Object类，默认可以使用Object类中的equals方法
        boolean equals(Object obj)指示其他摸个对象是否与此对象“相等”
        equal方法源码:
            public boolean equals(Object obj ){
                return (this == obj);
            }
            参数：
                Object obj：可以传递任意对象
                == 比较运算符返回布尔值
                基本数据类型：比较的是值
                引用数据类型：标胶两个对象的地址值
         */
        Person p1 = new Person("迪丽热巴",18);
        Person p2 = new Person("古力娜扎",19);
        System.out.println("p1"+p1);
        System.out.println("p2"+p2);
        p1 = p2;//把p2的地址值赋值给1
        boolean b = p1.equals(p2);
        System.out.println(b);

    }

}

