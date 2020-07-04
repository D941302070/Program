package java_exam.third;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Policeman {
    private int policeNumber;
    private String name;
    private double salary;
    private Date date;

    public Policeman(int policeNumber, String name, double salary) {
        this.policeNumber = policeNumber;
        this.name = name;
        this.salary = salary;
        date = new Date();
    }

    public int getPoliceNumber() {
        return policeNumber;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getDate() {
        return date;
    }

    public void setPoliceNumber(int number) {
        this.policeNumber = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        //SimpleDateFormat格式化Date格式输出，空参默认当前所在时区
        SimpleDateFormat sdf = new SimpleDateFormat();

        return "policeNumber: " + policeNumber +
                "\nname: " + name +
                "\nsalary: " + salary +
                "\ndate: " + sdf.format(date);
    }
}
