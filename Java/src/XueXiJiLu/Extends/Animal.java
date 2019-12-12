package XueXiJiLu.Extends;

public class Animal {

    private String name;
    private int month;
    private String specie;

    public Animal() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public void eat() {
        System.out.println(this.getName() + "在吃东西");
    }

}
