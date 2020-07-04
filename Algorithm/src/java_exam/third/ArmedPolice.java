package java_exam.third;

public class ArmedPolice extends Policeman implements Employee {

    private String armyName;
    private String rank;

    public ArmedPolice(int number, String name, double salary, String armyName, String rank) {
        super(number, name, salary);
        this.armyName = armyName;
        this.rank = rank;
    }

    public String getArmyName() {
        return armyName;
    }

    public void setArmyName(String armyName) {
        this.armyName = armyName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public void Raise() {
        setSalary(getSalary() * 1.3);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\narmyName: " + getArmyName() +
                "\nrank: " + getRank();
    }
}