package model;

import javax.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor {
    private double hourlySalary;

    public VisitingResearcher(String name, String address, String phoneNumber, double hourlySalary){
        super(name,address,phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher() {
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "name=" + this.getName()+ ", " +
                "address=" + this.getAddress()+", " +
                "phoneNumber=" +this.getPhoneNumber()+", " +
                "courseList=" + this.getCourseList().toString() + ", "+
                "hourlySalary=" + hourlySalary +
                '}';
    }
}
