package XueXiJiLu.InnerClass.demo01;

public class Body {//外部类

    public class Heart {//成员内部类

        public void beat() {
            System.out.println("心脏跳动：砰砰砰");
            System.out.println("我叫：" + name);
        }

    }

    //外部类的成员方法
    private String name;

    public void methodbody() {
        System.out.println("外部类的方法");
        Heart heart = new Heart();
        heart.beat();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
