package XueXiJiLu.InnerClass.demo06;

public class Hero {

    private String name;//英雄的名称
    private Skill skill;//英雄的法术名称

    public Hero() {
    }

    public Hero(String name, Skill skill) {
        this.name = name;
        this.skill = skill;
    }

    public void attact(){
        System.out.println("我叫"+name+"开始释放技能：");
        skill.use();
        System.out.println("技能释放完毕");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
