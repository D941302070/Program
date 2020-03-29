package study.InnerClass.demo06;

public class DemoMain {

    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("艾希");

        hero.setSkill(new SkillImpl());
        hero.attact();
        System.out.println("==========");

        //使用匿名内部类
        Skill skill = new Skill() {
            @Override
            public void use() {
                System.out.println("匿名内部类的技能");
            }
        };
        hero.setSkill(skill);
        hero.attact();

        System.out.println("============");

        //使用匿名内部类和匿名对象
        hero.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("最简便的写法");
            }
        });
        hero.attact();
    }

}
